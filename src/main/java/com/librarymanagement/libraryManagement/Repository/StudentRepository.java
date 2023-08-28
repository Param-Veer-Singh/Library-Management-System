package com.librarymanagement.libraryManagement.Repository;

import com.librarymanagement.libraryManagement.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
