package com.librarymanagement.libraryManagement.Repository;

import com.librarymanagement.libraryManagement.Models.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<LibraryCard, Integer> {
}
