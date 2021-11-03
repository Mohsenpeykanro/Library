package com.library.backend.Service;

import com.library.backend.Entity.user;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface userService {

    List<user> getUsers();
    void addNewUser(user user);
    void deleteUser(Integer userId);
    @Transactional
    void updateUser(Integer userId,
                    String name,
                    String email);

    String signUpUser(user user);
    int enableUser(String email);

}
