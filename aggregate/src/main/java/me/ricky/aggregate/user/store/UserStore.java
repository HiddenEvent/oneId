package me.ricky.aggregate.user.store;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import me.ricky.aggregate.user.domain.User;
import me.ricky.aggregate.user.facade.dto.LoginQdo;
import me.ricky.aggregate.user.facade.dto.OneIdCdo;
import me.ricky.aggregate.user.facade.dto.UserRequest;
import me.ricky.aggregate.user.store.jpo.UserJpo;
import me.ricky.aggregate.user.store.pdo.SingleUserPdo;
import me.ricky.aggregate.user.store.repository.UserRepository;
import me.ricky.proxy.OneIdProxy;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserStore {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    private final UserRepository userRepository;
    private final OneIdProxy oneIdProxy;

//    public User findById(String id) {
//        Optional<UserJpo> optionalUserJpo = userRepository.findById(id);
//        return optionalUserJpo.map(UserJpo::toDomain).orElse(null);
//    }

    public User findById(String id) {
        Optional<UserJpo> optionalUserJpo = userRepository.findById(id);
        if (optionalUserJpo.isEmpty()) throw new RuntimeException("User not found");

        UserJpo userJpo = optionalUserJpo.get();
        UserRepresentation oneIdUser = oneIdProxy.findBySub(userJpo.getSub());
        SingleUserPdo singleUserPdo = new SingleUserPdo(userJpo, oneIdUser);
        return singleUserPdo.toDomain();
    }


    public User save(UserRequest.Register req) {
        OneIdCdo oneIdCdo = new OneIdCdo(req);
        UserRepresentation oneIdUser = oneIdProxy.createUser(oneIdCdo);
        UserJpo savedUser = userRepository.save(UserJpo.register(req, oneIdUser));

        SingleUserPdo singleUserPdo = new SingleUserPdo(savedUser, oneIdUser);
        return singleUserPdo.toDomain();
    }

    public boolean existsCheckpointUser(String sub) {
        return userRepository.existsBySub(sub);
    }
    public boolean existsByUsername(String email) {
        return oneIdProxy.existsByUsername(email);
    }
    public AccessTokenResponse signIn(LoginQdo loginQdo) {
        return oneIdProxy.signIn(loginQdo);
    }
}
