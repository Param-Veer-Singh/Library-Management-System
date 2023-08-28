package com.librarymanagement.libraryManagement.Repository;

import com.librarymanagement.libraryManagement.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
