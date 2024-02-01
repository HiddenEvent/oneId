package me.ricky.config;

import me.ricky.aggregate.user.store.jpo.UserJpo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(
        basePackages = {"me.ricky.aggregate.*.store.repository"}
)
public class JpaAuditConfig {

    @Bean
    public AuditorAware<UserJpo> auditorProvider() {
        return new AuditorAwareImpl();
    }
}