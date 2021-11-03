package com.library.backend.Implementation;

import com.library.backend.Entity.confirmationToken;
import com.library.backend.Repository.confirmationTokenRepository;
import com.library.backend.Service.confirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class confirmationTokenImpl implements confirmationTokenService {
    private final confirmationTokenRepository confirmationTokenRepository;


    @Override
    public void saveConfirmationToken(confirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    @Override
    public Optional<confirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    @Override
    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}
