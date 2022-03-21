package dev.aquashdw.community.service;

import dev.aquashdw.community.entity.UserEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import dev.aquashdw.community.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommunityUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CommunityUserDetailsService(
            @Autowired UserRepository userRepository,
            @Autowired PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        final UserEntity testUserEntity = new UserEntity();
        testUserEntity.setUsername("entity_user");
        testUserEntity.setPassword(passwordEncoder.encode("test1pass"));
        this.userRepository.save(testUserEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity userEntity = userRepository.findByUsername(username);
        return new User(username, userEntity.getPassword(), new ArrayList<>());
    }
}
