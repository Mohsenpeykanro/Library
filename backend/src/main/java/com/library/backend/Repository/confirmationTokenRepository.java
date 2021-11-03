package com.library.backend.Repository;

import com.library.backend.Entity.confirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface confirmationTokenRepository extends JpaRepository<confirmationToken, Integer> {
    Optional<confirmationToken> findByToken(String token);

    @Transactional
    @Modifying
    @Query("update confirmationToken c "+"set c.confirmedAt = ?2 " + "where c.token = ?1")
    int updateConfirmedAt(String token, LocalDateTime confirmedAt);

}
