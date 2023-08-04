package com.example.springmock.Service;

import com.example.springmock.DTO.AuthorRequestDto;
import com.example.springmock.DTO.AuthorResponseDto;
import com.example.springmock.Model.Author;
import com.example.springmock.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {

        Author author = new Author();

        author.setAge(authorRequestDto.getAge());
        author.setName(authorRequestDto.getName());
        author.setGender(authorRequestDto.getGender());
        author.setRating(authorRequestDto.getRating());

        Author savedAuthor = authorRepository.save(author);

//        prepare response dto

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();

        authorResponseDto.setAge(savedAuthor.getAge());
        authorResponseDto.setGender(savedAuthor.getGender());
        authorResponseDto.setRating(savedAuthor.getRating());
        authorResponseDto.setName(savedAuthor.getName());

        return authorResponseDto;


    }
}
