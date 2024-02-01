package me.ricky.aggregate.user.facade;


import me.ricky.aggregate.user.domain.User;
import org.springframework.security.access.prepost.PreAuthorize;
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public interface UserFacade {
    //@PreAuthorize("hasAuthority('ROLE_USER')")
    User findById(String id);
}
