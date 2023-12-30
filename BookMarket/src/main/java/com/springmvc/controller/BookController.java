package com.springmvc.controller;

import com.springmvc.domain.Book;
import com.springmvc.exception.BookIdException;
import com.springmvc.exception.CategoryException;
import com.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired // 클래스의 프로퍼티(멤버 변수)에 선언
    private BookService bookService;

    @GetMapping
    public String requestBookList(Model model){
        List<Book> list = bookService.getAllBookList(); // 웹 요청을 처리할 메서드
        model.addAttribute("bookList", list); // 모델 속성 bookList에 저장된 도서 목록을 저장
        return "books"; // book을 반환하므로 books.jsp가 있어야함.

    }

    /*@RequestMapping(value="/all")
    public String requestAllBookList(Model model){
        List<Book> list = bookService.getAllBookList(); // 웹 요청을 처리할 메서드
        model.addAttribute("bookList", list); // 모델 속성 bookList에 저장된 도서 목록을 저장
        return "books"; // book을 반환하므로 book.jsp가 있어야함.

    }*/
    @GetMapping("/all")
    public ModelAndView requestAllBookList( ){
        ModelAndView modelAndView = new ModelAndView();

        List<Book> list = bookService.getAllBookList(); // 웹 요청을 처리할 메서드
        modelAndView.addObject("bookList", list);
        modelAndView.setViewName("books");
        return modelAndView; // book을 반환하므로 book.jsp가 있어야함.

    }

    @GetMapping("/{category}")
    public String requestBooksByCategory (@PathVariable("category") String bookCategory,
                                          Model model){
        List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);

        if (booksByCategory == null || booksByCategory.isEmpty()){
            throw new CategoryException();
        }
        model.addAttribute("bookList" , booksByCategory);
        return "books";
    }

    @GetMapping("/filter/{bookFilter}")
    public String requestBooksByFilter(@MatrixVariable(pathVar = "bookFilter")Map<String, List<String>> bookFilter, Model model){
        Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
        model.addAttribute("bookList",booksByFilter);
        return "books";
    }

    @GetMapping("/book")
    public String requestBookById(@RequestParam("id") String bookId , Model model){

        Book bookById = bookService.getBookById(bookId);
        model.addAttribute("book" , bookById);
        return "book";
    }

    @GetMapping("/add")
    public String requestAddBookForm(@ModelAttribute("NewBook") Book book){
        return "addBook";
    }

    @PostMapping("/add")
    public String submitAddBookForm(@ModelAttribute("NewBook") Book book){
        MultipartFile bookImage = book.getBookImage();

        String saveName = bookImage.getOriginalFilename();
        File saveFile = new File("D:\\lck_data\\int_spr\\upload",saveName);

        if (bookImage != null && !bookImage.isEmpty()){
            try {
                bookImage.transferTo(saveFile);
            }catch (Exception e){
                throw new RuntimeException("도서 이미지 업로드가 실패하였습니다.",e);
            }
        }

        bookService.setNewBook(book);
        return "redirect:/books";
    }
    
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("addTitle", "신규 도서 등록");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setAllowedFields("bookId","name","unitPrice","author","description","publisher",
                                "category", "unitInStock","totalPages","releaseDate","condition","bookImage");
    }

    // 예외처리 컨트롤러
    @ExceptionHandler(value = {BookIdException.class})
    public ModelAndView handleError(HttpServletRequest req , BookIdException exception){

        ModelAndView mav = new ModelAndView(); // 인스턴스 생성

        mav.addObject("invalidBookId",exception.getBookId()); // 모델 속성 invalidBookId 에서 요청한 도서 아이디값을 저장한다.
        mav.addObject("exception",exception); // 모델 속성 exception에서 예외처리 클래스 BookIdException 을 저장한다.
        mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString()); // 모델 속성 url에서 요청 url과 요청 쿼리문을 저장한다.
        mav.setViewName("errorBook"); // 뷰 이름으로 errorBook 을 설정하여 errorBook.jsp 파일을 출력한다.
        return mav; // mav 인스턴스 반환

    }
}

