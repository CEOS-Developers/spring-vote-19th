package ceos.vote.user.application;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ceos.vote.common.exception.ExceptionCode;
import ceos.vote.user.domain.repository.UserRepository;
import ceos.vote.user.exception.AlreadyExistException;
import ceos.vote.user.presentation.dto.request.UserCreateRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long createUser(UserCreateRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            throw new AlreadyExistException(ExceptionCode.ALREADY_EXIST_USERNAME_EXCEPTION);
        }
        if (userRepository.existsByEmail(request.email())) {
            throw new AlreadyExistException(ExceptionCode.ALREADY_EXIST_EMAIL_EXCEPTION);
        }
        return userRepository.save(request.toEntity(passwordEncoder)).getId();
    }
}
