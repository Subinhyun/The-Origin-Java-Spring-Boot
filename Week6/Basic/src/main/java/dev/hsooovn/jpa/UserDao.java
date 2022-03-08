package dev.hsooovn.jpa;

import dev.hsooovn.jpa.entity.UserEntity;
import dev.hsooovn.jpa.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    private final UserRepository userRepository;

    public UserDao(
            @Autowired UserRepository userRepository
    ){
        this.userRepository = userRepository;
    }

    public void createUser(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDto.getUserId());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setName(userDto.getName());
        this.userRepository.save(userEntity);
    }

    public UserEntity readUser(int id){
        Optional<UserEntity> userEntity = this.userRepository.findById((long) id);
        if(userEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return userEntity.get();
    }

    public Iterator<UserEntity> readUserAll() {
        return this.userRepository.findAll().iterator();
    }

    public void updateUser(int id, UserDto userDto){
        Optional<UserEntity> targetEntity = this.userRepository.findById(Long.valueOf(id));
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        UserEntity userEntity = targetEntity.get();
        userEntity.setUserId(userDto.getUserId() == null ? userEntity.getUserId() : userDto.getUserId());
        userEntity.setPassword(userDto.getPassword() == null ? userEntity.getPassword() : userDto.getPassword());
        userEntity.setName(userDto.getName() == null ? userDto.getName() : userDto.getName());
        this.userRepository.save(userEntity);
    }

    public void deleteUser(int id){
        Optional<UserEntity> targetEntity = this.userRepository.findById((long) id);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.userRepository.delete(targetEntity.get());
    }
}
