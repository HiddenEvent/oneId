package me.ricky.aggregate.board.store;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import me.ricky.aggregate.board.domain.Board;
import me.ricky.aggregate.board.facade.dto.BoardDTO;
import me.ricky.aggregate.board.store.jpo.BoardJpo;
import me.ricky.aggregate.board.store.pdo.BoardWithUserPdo;
import me.ricky.aggregate.board.store.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardStore {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    private final BoardRepository boardRepository;

    public Board register(BoardDTO.Register req) {
        Board domain = Board.register(req);
        return boardRepository.save(BoardJpo.domainToJpo(domain)).toDomain();
    }

    public Page<Board> searchAllBoard(BoardDTO.Search reqDto) {
//                query.select(Projections.fields(
//                        BoardDTO.Response.class
//                        , boardJpo.id
//                        , boardJpo.title
//                        , boardJpo.content
//                        , boardJpo.delYn
//                        , boardJpo.useYn
//                        , boardJpo.notiAt
//                        , boardJpo.recommendCnt
//                ))
//                .from(boardJpo);
//
//        PageRequest pageable = RetrieveClauseBuilder.setOffsetLimit(query, reqDto);
//        List<BoardDTO.Response> resultList = query.fetch();
//        long total = query.fetchCount();
//        return new PageImpl<>(resultList, pageable, total);
        return null;
    }

    public Optional<Board> findById(String id) {

        return boardRepository.findById(id).map(BoardJpo::toDomain);
    }

    public Board modify(String id, BoardDTO.Modify reqDto) {
        BoardJpo boardJpo = boardRepository.findById(id).orElse(null);
        if (boardJpo == null) throw new RuntimeException("게시판 데이터를 찾을 수 없습니다.");
        boardJpo.modify(reqDto);
        return boardRepository.save(boardJpo).toDomain();
    }

    public Board findByIdWithUser(String id) {
//        BoardWithUserPdo boardWithUserPdo = queryFactory
//                .select(Projections.constructor(
//                        BoardWithUserPdo.class
//                        , userJpo
//                        , boardJpo
//                ));
        return null;
    }
}
