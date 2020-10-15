package org.wecancodeit.librarydemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.librarydemo.models.Book;
import org.wecancodeit.librarydemo.repositories.BookRepository;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class BookController {

    @Resource
    private BookRepository bookRepo;

    @RequestMapping("/books")
    public String displayBooks(Model model){
        model.addAttribute("books", bookRepo.findAll());
        return "booksView";
    }

    @RequestMapping("/books/{id}")
    public String displaySingleBook(@PathVariable long id, Model model){
        Optional<Book> retrievedBook = bookRepo.findById(id);
        Book foundBook = retrievedBook.get();
        model.addAttribute("book", foundBook);
        return "bookView";
    }
}
