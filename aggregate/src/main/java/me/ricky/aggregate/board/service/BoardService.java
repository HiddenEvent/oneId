package me.ricky.aggregate.board.service;


import lombok.RequiredArgsConstructor;
import me.ricky.aggregate.board.domain.Board;
import me.ricky.aggregate.board.facade.dto.BoardDTO;
import me.ricky.aggregate.board.store.BoardStore;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
	private final BoardStore boardStore;


    public Board registerBoard(BoardDTO.Register reqDto) {
        return boardStore.register(reqDto);
    }

    public Page<Board> searchAllBoard(BoardDTO.Search reqDto) {
        return boardStore.searchAllBoard(reqDto);
    }

    public Board searchBoard(String id) {
        return boardStore.findById(id).orElse(null);
    }

    public Board modify(String id, BoardDTO.Modify reqDto) {
        return boardStore.modify(id, reqDto);
    }

    public Board searchBoardWithMember(String id) {

        return boardStore.findByIdWithUser(id);
    }
}
