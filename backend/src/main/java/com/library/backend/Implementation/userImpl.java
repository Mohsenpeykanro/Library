package com.library.backend.Implementation;

import com.library.backend.Entity.confirmationToken;
import com.library.backend.Entity.user;
import com.library.backend.Repository.userRepository;
import com.library.backend.Service.confirmationTokenService;
import com.library.backend.Service.userService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class userImpl implements userService, UserDetailsService {

    // Repository
    private final userRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final confirmationTokenService confirmationTokenService;
    // Show All User
    @Override
    public List<user> getUsers() {
        return userRepository.findAll();
    }

    // Add New User
    @Override
    public void addNewUser(user user) {
        Optional<com.library.backend.Entity.user> userOptional =
                userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }

    //Delete User
    @Override
    public void deleteUser(Integer userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "user with id" + userId + "does not exists");
        }
        userRepository.deleteById(userId);
    }

    //Update Book
    @Override
    public void updateUser(Integer userId, String name, String email) {
        user user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "User With Id " + userId + " Does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(user.getFirstName(), name)) {
            user.setFirstName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
            Optional<com.library.backend.Entity.user> userEntityOptional = userRepository.findByEmail(email);
            if (userEntityOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            user.setEmail(email);
        }
    }

    @Override
    public String signUpUser(user user) {
        boolean userExists = userRepository
                .findByEmail(user.getEmail())
                .isPresent();

        if (userExists){
            throw new IllegalStateException("email is already taken");
        }

        String encodedPass =  bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        userRepository.save(user);
        String token = UUID.randomUUID().toString();

        // TODO: Send Confirmation Token
        confirmationToken confirmationToken =
                new confirmationToken(
                        token,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(15),
                        user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        // TODO: Send Email
        return token;
    }

    @Override
    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("user with email " + email +" not found"));
    }
}
























