package com.example.springmock.Controller;

import com.example.springmock.DTO.BookResponseDto;
import com.example.springmock.DTO.BookrequestDto;
import com.example.springmock.Model.Book;
import com.example.springmock.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody BookrequestDto bookrequestDto){
        BookResponseDto responseDto = bookService.addBook(bookrequestDto);

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get")
    public ResponseEntity getTheBook(@RequestParam("Id") int id){
        try {
            BookResponseDto responseDto = bookService.getTheBook(id);
            return new ResponseEntity(responseDto,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find_total")
    public ResponseEntity findTotalBooksByAuthor(@RequestParam("name") String authorName,@RequestParam("year") int year){
        List<Book> books = bookService.findTotalBooksByAuthor(authorName,year);

        return new ResponseEntity(books,HttpStatus.ACCEPTED);
    }
}
