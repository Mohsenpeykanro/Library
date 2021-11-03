package com.library.backend.Service;

import com.library.backend.Entity.confirmationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface confirmationTokenService {
    void saveConfirmationToken(confirmationToken token);
    Optional<confirmationToken> getToken(String token);
    int setConfirmedAt(String token);

}
