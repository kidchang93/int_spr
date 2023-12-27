package kr.co.chunjae.controller;

import kr.co.chunjae.dto.BoardDTO;
import kr.co.chunjae.dto.PageDTO;
import kr.co.chunjae.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

  // @RequiredArgsConstructor 는 생성자를 주입하고 final로 선언된
  // 변수에 강한 연결이 된다.
  private final BoardService boardService;


  // saveForm을 먼저 보여주기 위해 GetMapping 사용
  @GetMapping("/save")
  public String saveForm(){
    return "save";
  }

  // form 입력 완료 후 submit 시 PostMapping 사용해서 데이터 받고 출력할 화면 설정
  @PostMapping("/save")
  public String save(@ModelAttribute BoardDTO boardDTO) {
    int saveResult = boardService.save(boardDTO);
    if (saveResult > 0) {
      return "redirect:/board/paging";  // 결과값이 0보다 클 때 (행이 0개 이상 추가될 때 redirect로 URL 연결
    } else {
      return "save";
    }
  }

  // 전체 목록 보기
  @GetMapping("/")
  public String findAll(Model model){
    List<BoardDTO> boardDTOList = boardService.findAll();
    model.addAttribute("boardList" , boardDTOList);
    return "list";
  }
  // 게시물 상세보기
  @GetMapping
  public String findById(@RequestParam("id") Long id,
                         @RequestParam(value = "page",required = false, defaultValue = "1") int page,
                         Model model){

    // 상세보기 시 조회수 카운트 기능 추가
    boardService.updateHits(id);

    // 상세보기시 해당 id값을 parameter 값으로 받아오고 DB 에서 찾아온다.
    BoardDTO boardDTO = boardService.findById(id);
    model.addAttribute("board",boardDTO);
    model.addAttribute("page", page);
    return "detail";
  }
  // 게시물 삭제기능
  @GetMapping("/delete")
  public String delete(@RequestParam("id") Long id){
    boardService.delete(id);
    return "redirect:/board/";
  }

  // 게시물 수정하기 폼
  @GetMapping("/update")
  public String updateForm(@RequestParam("id") Long id , Model model){
    BoardDTO boardDTO = boardService.findById(id);
    model.addAttribute("board",boardDTO);
    return "update";
  }
  // 게시물 수정하기 기능 구현
  @PostMapping("/update")
  public String update(@ModelAttribute BoardDTO boardDTO , Model model){
    boardService.update(boardDTO);
    BoardDTO dto = boardService.findById(boardDTO.getId());
    model.addAttribute("board",dto);
    return "detail"; // 이렇게되면 수정하면 조회수가 증가하지 않는다.
  }

  // 게시물 페이징 기능
  // /board/paging?page=2
  // 처음 페이지 요청은 1페이지를 보여줌
  @GetMapping("/paging")
  public String paging(@RequestParam(
                        value = "page", // HTTP 요청에서 'page'라는 이름의 파라미터를 읽어온다
                        required = false ,  // 파라미터가 필수가 아니라는 뜻
                        defaultValue = "1") int page , // 파라미터가 없거나 비어있을 경우 ( 기본값은 1로 설정 ) 하고 int page 파라미터에 매핑한다.
                        Model model){
    System.out.println("page = " + page);
    // 해당 페이지에서 보여줄 글 목록
    // 페이징 작업을 위한 DB 사용으로 service 호출
    List<BoardDTO> pagingList = boardService.pageList(page);
    // 목록이 제대로 출력되는지 확인할 것
    // log로 확인 가능하긴함
    System.out.println("pagingList = " + pagingList);

    PageDTO pageDTO = boardService.pagingParam(page);
    model.addAttribute("boardList" , pagingList);
    model.addAttribute("paging", pageDTO);

    // 목록 표시하기위해 return 에 paging 이라는 페이지로 이동
    return "paging";
  }
}
