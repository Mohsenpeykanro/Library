package com.library.backend.Service;

import com.library.backend.Entity.userEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface userService {

    public List<userEntity> getUsers();
    public void addNewUser(userEntity user);
    public void deleteUser(Integer userId);
    @Transactional
    public void updateUser(Integer userId, String name, String email);
}
