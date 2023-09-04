package com.deepak.full_stack_springboot.dao;

import com.deepak.full_stack_springboot.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findBookByTitleContaining(@RequestParam("title") String title, Pageable pageable);
    Page<Book> findBookByCategory(@RequestParam("category") String category, Pageable pageable);
    Page<Book> findBookByAuthorContaining(@RequestParam("author") String author, Pageable pageable);

}
