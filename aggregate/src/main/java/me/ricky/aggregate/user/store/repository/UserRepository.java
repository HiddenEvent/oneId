package me.ricky.aggregate.user.store.repository;

import me.ricky.aggregate.user.store.jpo.UserJpo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserJpo, String> {
    boolean existsBySub(String sub);
}
