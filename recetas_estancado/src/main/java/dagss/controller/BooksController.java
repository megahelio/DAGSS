package dagss.controller;

import dagss.persistence.model.Book;
import dagss.persistence.service.BookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {


    @Autowired
    BookService bookService;

    @GetMapping("/aaa")
    public String homePage(Model model) {
        return "home";
    }
    @GetMapping("")
    public List<Book> list(){
        System.out.println("LIST BOOK");
        return bookService.listAllBook();
    }
}
