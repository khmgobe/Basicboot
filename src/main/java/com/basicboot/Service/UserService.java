package com.basicboot.Service;

import com.basicboot.entity.Users;
import com.basicboot.exception.DataNotFoundException;
import com.basicboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Users create(String username, String email, String password) {
        Users users = new Users();
        Users userBuilder = Users.builder()
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();
        userRepository.save(userBuilder);
        return userBuilder;
    }

    public Users getUser(String username) {
        Optional<Users> users = userRepository.findByUsername(username);
        if (users.isPresent()) {
            return users.get();
        }  else {
            throw new DataNotFoundException("user not found!");
        }
/**       return users.orElseThrow(() -> new DataNotFoundException("user not found!")); **/
    }
}
