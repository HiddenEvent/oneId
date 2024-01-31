package me.ricky.aggregate.user.store.pdo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.ricky.aggregate.user.store.jpo.UserJpo;

@NoArgsConstructor
@AllArgsConstructor
public class SingleUserPdo {
    private UserJpo userJpo;
    private OneIdUser oneIdUser;

    public SingleUserPdo(UserJpo userJpo) {
        this.userJpo = userJpo;
    }
}
