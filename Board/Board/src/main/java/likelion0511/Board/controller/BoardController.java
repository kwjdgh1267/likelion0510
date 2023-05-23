package likelion0511.Board.controller;

import likelion0511.Board.dto.BoardDto;
import likelion0511.Board.entity.BoardEntity;
import likelion0511.Board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

//    @GetMapping("/board/save")
//    public String saveForm(){
//        return "save";
//    }

    @PostMapping("/board/save")
    public void save(@RequestBody BoardDto boardDto){
        boardService.save(boardDto);
    }
    @GetMapping("/board/")
    public List<BoardDto> findAll(){
        return boardService.findAll();
    }
    @GetMapping("/board/{id}")
    public BoardDto findById(@PathVariable("id") Long id){
        boardService.updateHits(id);
        return boardService.findById(id);
    }
    @DeleteMapping("/board/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        boardService.delete(id);
    }
//    @GetMapping("/update/{id}")
//    public String updateForm(@PathVariable Long id, Model model){
//        BoardDto boardDto = boardService.findById(id);
//        model.addAttribute("boardUpdate",boardDto);
//        return "update";
//    }
    @PostMapping("/board/update")
    public void update(@RequestBody BoardDto boardDto){
        boardService.update(boardDto);
    }
}
