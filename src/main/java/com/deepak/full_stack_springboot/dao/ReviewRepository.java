package com.deepak.full_stack_springboot.dao;

import com.deepak.full_stack_springboot.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findReviewByBookId(@RequestParam("book_id") Long bookId,
                                    Pageable pageable);

}
