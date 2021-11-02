package com.library.backend.Service;

import com.library.backend.Entity.registrationRequest;
import org.springframework.stereotype.Service;

@Service
public interface registrationService {
    String register(registrationRequest request);
}
