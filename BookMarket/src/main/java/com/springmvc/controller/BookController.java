package com.springmvc.controller;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        bookService.setNewBook(book);
        return "redirect:/books";
    }
    
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("addTitle", "신규 도서 등록");
    }
}

