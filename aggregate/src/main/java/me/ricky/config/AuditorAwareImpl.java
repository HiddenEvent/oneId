package me.ricky.config;


import me.ricky.aggregate.user.store.jpo.UserJpo;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.lang.reflect.Member;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<UserJpo> {
    @Override
    public Optional<UserJpo> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null == authentication || authentication.getPrincipal() instanceof String) {
            return Optional.empty();
        }
//        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
//        Member member = principal.getMember();
//        return Optional.of(MemberJpo.domainToJpo(member));
        return Optional.of(null);
    }
}