package dev.hsooovn.jpa.repository;

import dev.hsooovn.jpa.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
