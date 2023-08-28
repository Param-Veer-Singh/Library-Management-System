package com.librarymanagement.libraryManagement.Repository;

import com.librarymanagement.libraryManagement.Enums.Genres;
import com.librarymanagement.libraryManagement.Models.Book;
import com.librarymanagement.libraryManagement.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
