package me.ricky.aggregate.board.store.pdo;


import me.ricky.aggregate.board.store.jpo.BoardJpo;
import me.ricky.aggregate.user.store.jpo.UserJpo;
import me.ricky.aggregate.user.store.pdo.SingleUserPdo;

public class BoardWithUserPdo extends SingleUserPdo {
	private BoardJpo boardJpo;

    public BoardWithUserPdo(UserJpo userJpo, BoardJpo boardJpo) {
        super(userJpo);
        this.boardJpo = boardJpo;
    }


}
