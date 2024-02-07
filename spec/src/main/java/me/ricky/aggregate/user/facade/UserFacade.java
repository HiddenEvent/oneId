package me.ricky.aggregate.user.facade;


import me.ricky.aggregate.common.dto.OffsetElementList;
import me.ricky.aggregate.user.domain.User;
import me.ricky.aggregate.user.facade.dto.UserSearchQdo;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public interface UserFacade {
    User findById(String id);
    OffsetElementList<User> findAll(UserSearchQdo userSearchQdo);
}
