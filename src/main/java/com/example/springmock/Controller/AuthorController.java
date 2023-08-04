package com.example.springmock.Controller;

import com.example.springmock.DTO.AuthorRequestDto;
import com.example.springmock.DTO.AuthorResponseDto;
import com.example.springmock.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {


    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        AuthorResponseDto responseDto = authorService.addAuthor(authorRequestDto);
        return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
    }

}
