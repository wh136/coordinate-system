package com.wh136.xyz.dao;

import com.wh136.xyz.domain.Location;
import com.wh136.xyz.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BookRepository extends JpaRepository<Book, String> {

    @Modifying
    @Transactional
    @Query(value = "insert into book(BOOK_NAME) values (?1)", nativeQuery = true)
    void setbookname(String bookname);
}
