package com.library.backend.Implementation;

import com.library.backend.Entity.registrationRequest;
import com.library.backend.Service.registrationService;
import org.springframework.stereotype.Service;

@Service
public class registrationImpl implements registrationService {
    @Override
    public String register(registrationRequest request) {
        return "it works";
    }
}
