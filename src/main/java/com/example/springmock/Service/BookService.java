package com.example.springmock.Service;


import com.example.springmock.DTO.BookResponseDto;
import com.example.springmock.DTO.BookrequestDto;
import com.example.springmock.Exception.BookNotFoundException;
import com.example.springmock.Model.Book;
import com.example.springmock.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public BookResponseDto addBook(BookrequestDto bookrequestDto) {

        Book book = new Book();
        book.setName(bookrequestDto.getName());
        book.setAuthor_name(bookrequestDto.getAuthorName());
        book.setPages(bookrequestDto.getPages());

        Book savedBook = bookRepository.save(book);


//        prepapre response dto

        BookResponseDto responseDto = new BookResponseDto();
        responseDto.setName(savedBook.getName());
        responseDto.setPages(savedBook.getPages());
        responseDto.setAuthorName(savedBook.getAuthor_name());

        return responseDto;
    }

    public BookResponseDto getTheBook(int id) {

        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isEmpty()){
            throw new BookNotFoundException("Book doesn't exists");
        }


        Book book = optionalBook.get();

        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setAuthorName(book.getAuthor_name());
        bookResponseDto.setName(book.getName());
        bookResponseDto.setPages(book.getPages());

        return bookResponseDto;

    }

    public List<Book> findTotalBooksByAuthor(String authorName,int year) {

        List<Book> allbooks = bookRepository.findByAuthor_name(authorName);

        List<Book> ansList = new ArrayList<>();

        for(Book book : allbooks){
            if(book.getPublish().getPublishingYear() == year){
                ansList.add(book);
            }
        }

        return ansList;
    }
}
