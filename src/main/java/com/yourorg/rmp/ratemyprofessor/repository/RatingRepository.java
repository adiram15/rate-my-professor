package com.yourorg.rmp.ratemyprofessor.repository;

import com.yourorg.rmp.ratemyprofessor.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByProfessorId(Long professorId);
}