package likelion0511.Board.service;

import likelion0511.Board.dto.BoardDto;
import likelion0511.Board.entity.BoardEntity;
import likelion0511.Board.repository.BoardRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public void save(BoardDto boardDto){
        BoardEntity entity = BoardEntity.toSaveEntity(boardDto);
        boardRepository.save(entity);
    }
    @Transactional
    public List<BoardDto> findAll(){
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        for (BoardEntity boardentity: boardEntities) {
            boardDtoList.add(BoardDto.toBoardDTO(boardentity));
        }
        return boardDtoList;
    }
    public BoardDto findById(Long id){
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        if(optionalBoardEntity.isPresent()){
            BoardEntity boardEntity = optionalBoardEntity.get();
            return BoardDto.toBoardDTO(boardEntity);
        }else return null;
    }
    @Transactional
    public void delete(Long id){
        boardRepository.deleteById(id);
    }
    @Transactional
    public void updateHits(Long id){
        boardRepository.updateHits(id);
    }
    @Transactional
    public BoardDto update(BoardDto boardDto){
        BoardEntity boardEntity = BoardEntity.toUpdateEntity(boardDto);
        boardRepository.save(boardEntity);
        return findById(boardDto.getId());
    }
}
