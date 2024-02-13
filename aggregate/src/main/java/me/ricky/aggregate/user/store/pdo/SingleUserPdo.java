package me.ricky.aggregate.user.store.pdo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.ricky.aggregate.user.domain.User;
import me.ricky.aggregate.user.store.jpo.UserJpo;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class SingleUserPdo {
    private UserJpo userJpo;
    private UserRepresentation oneIdUser;

    public SingleUserPdo(UserJpo userJpo) {
        this.userJpo = userJpo;
    }

    public static List<User> toUsers(List<SingleUserPdo> singleUserPdos) {
        return singleUserPdos.stream()
                .map(SingleUserPdo::toUser)
                .toList();
    }

    public User toUser() {
        User domain = userJpo.toDomain();
        if (oneIdUser != null) {
            domain.setSub(oneIdUser.getId());
            domain.setEmail(oneIdUser.getEmail());
            domain.setName(oneIdUser.getLastName());
        }
        return domain;
    }
}
