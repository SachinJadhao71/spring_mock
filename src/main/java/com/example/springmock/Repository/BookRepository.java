package com.example.springmock.Repository;

import com.example.springmock.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    public List<Book> findByAuthor_name(String authorname);
}
