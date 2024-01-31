package me.ricky.aggregate.board.store.repository;

import me.ricky.aggregate.board.store.jpo.BoardJpo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<BoardJpo, String>{

}
