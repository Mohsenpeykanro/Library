package com.library.backend.Service;

import com.library.backend.Entity.userEntity;
import com.library.backend.Repository.userRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class userService {

    private final userRepository userRepository;
    @Autowired
    public userService(com.library.backend.Repository.userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<userEntity> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(userEntity user) {
        Optional<userEntity> userOptional =
                userRepository.finduserEntityByEmail(user.getEmail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException(
                    "user with id" + userId + "does not exists");
        }
        userRepository.deleteById(userId);

    }

    @Transactional
    public void updateUser(Integer userId, String name, String email) {
        userEntity user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                        "User With Id " + userId + " Does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(user.getName(), name)){
            user.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)){
            Optional<userEntity> userEntityOptional = userRepository.finduserEntityByEmail(email);
            if (userEntityOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            user.setEmail(email);
        }
    }
}
