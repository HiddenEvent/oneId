package me.ricky.aggregate.user.store;

import com.querydsl.core.types.dsl.BooleanExpression;
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
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserStore {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    private final UserRepository userRepository;
    private final OneIdProxy oneIdProxy;

    public User findById(String id) {
        Optional<UserJpo> optionalUserJpo = userRepository.findById(id);
        return optionalUserJpo.map(UserJpo::toDomain).orElse(null);
    }

    public User save(UserRequest.Register req) {
        OneIdCdo oneIdCdo = new OneIdCdo(req);
        UserRepresentation oneIdUser = oneIdProxy.createUser(oneIdCdo);

        UserJpo userJpo = UserJpo.register(req, oneIdUser);
        userRepository.save(userJpo);

        SingleUserPdo singleUserPdo = new SingleUserPdo(userJpo, oneIdUser);
        return singleUserPdo.toDomain();
    }

    public boolean existsCheckpointUser(String sub) {
        return userRepository.existsBySub(sub);
    }

    public Page<User> searchPage(UserRequest.Search reqDto) {
//        queryFactory.select()
//                .from(userJpo)
//                .where(
//                        likeSearchText(reqDto)
//                )
//                .orderBy(userJpo.id.desc());
//
//        PageRequest pageable = RetrieveClauseBuilder.setOffsetLimit(queryFactory, reqDto);
//        List<UserResponse> resultList = queryFactory.from().fetch();
//        long total = query.fetchCount();
//        return new PageImpl<>(resultList, pageable, total);
        return null;
    }

    public BooleanExpression likeSearchText(UserRequest.Search reqDto) {
        /* 재정의
        if (StringUtils.isEmpty(reqDto.getSearchText())) {
            return null;
        }

        return member.nm.like("%"+reqDto.getSearchText()+"%")
                .or(member.prsnId.like("%"+reqDto.getSearchText()+"%"))
                .or(member.emplNum.like("%"+reqDto.getSearchText()+"%")); */
        return null;
    }

    public boolean existsByUsername(String email) {
        return oneIdProxy.existsByUsername(email);
    }

    public AccessTokenResponse signIn(LoginQdo loginQdo) {
        return oneIdProxy.signIn(loginQdo);
    }
}
