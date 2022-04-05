package dev.aquashdw.community.repository;

import dev.aquashdw.community.entity.AreaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AreaRepository extends CrudRepository<AreaEntity, Long> {
    @Query(value = "SELECT (6371 * acos(cos(radians(latitude)) * cos(radians(latitude)) " +
            "* cos(radians(longitude) - radians(longitude)) " +
            "+ sin(radians(latitude)) * sin(radians(latitude)))) " +
            "AS distance from AreaEntity area ORDER BY distance")
    Optional<AreaEntity> getNearByLocation(
            @Param("latitude") Double latitude,
            @Param("longitude") Double longitude);
}
