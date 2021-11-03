package com.library.backend.Service;

import org.springframework.stereotype.Service;

@Service
public interface emailService {
    void send(String to, String email);
}
