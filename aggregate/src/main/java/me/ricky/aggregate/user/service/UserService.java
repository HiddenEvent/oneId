package me.ricky.aggregate.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.ricky.aggregate.user.domain.User;
import me.ricky.aggregate.user.facade.dto.UserRequest;
import me.ricky.aggregate.user.store.UserStore;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserStore userStore;

    public User findById(String id) {
        return userStore.findById(id);
    }

    public Page<User> searchPage(UserRequest.Search reqDto) {
        return userStore.searchPage(reqDto);
    }

    public User registerUser(UserRequest.Register reqDto) {
        User domain = User.genRegisterDomain(reqDto);
        return userStore.save(domain);
    }
}
