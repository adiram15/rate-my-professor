package com.yourorg.rmp.ratemyprofessor.repository;

import com.yourorg.rmp.ratemyprofessor.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> { }