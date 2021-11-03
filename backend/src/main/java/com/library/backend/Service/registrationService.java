package com.library.backend.Service;

import com.library.backend.Entity.registrationRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface registrationService {
    String register(registrationRequest request);

    @Transactional
    String confirmToken(String token);
}
