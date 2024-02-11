package me.ricky.aggregate.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.ricky.aggregate.common.dto.OffsetElementList;
import me.ricky.aggregate.user.domain.User;
import me.ricky.aggregate.user.facade.dto.LoginQdo;
import me.ricky.aggregate.user.facade.dto.UserRequest;
import me.ricky.aggregate.user.facade.dto.UserSearchQdo;
import me.ricky.aggregate.user.store.UserStore;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserStore userStore;

    public User findById(String id) {
        return userStore.findById(id);
    }

    public User registerUser(UserRequest.Register reqDto) {
        return userStore.save(reqDto);
    }

    public boolean existsByUsername(String email) {
        return userStore.existsByUsername(email);
    }

    public AccessTokenResponse signin(LoginQdo loginQdo) {

        return userStore.signIn(loginQdo);
    }

    public OffsetElementList<User> search(UserSearchQdo qdo) {

        return userStore.search(qdo);
    }
}
