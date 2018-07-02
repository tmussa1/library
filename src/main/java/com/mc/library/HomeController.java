package com.mc.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/")
    public String showHomepage(){
        return "index";
    }
    @RequestMapping("/addbook")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping("/savebook")
    public String saveBook(@ModelAttribute Book book, Model model){
        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "listbooks";
    }

    @RequestMapping("/listbooks")
    public String listBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "listbooks";
    }

}
