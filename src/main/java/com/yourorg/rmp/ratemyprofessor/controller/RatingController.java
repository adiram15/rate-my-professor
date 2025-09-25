package com.yourorg.rmp.ratemyprofessor.controller;

import com.yourorg.rmp.ratemyprofessor.model.Rating;
import com.yourorg.rmp.ratemyprofessor.repository.RatingRepository;
import com.yourorg.rmp.ratemyprofessor.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
@CrossOrigin(origins = "*")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    // Get all ratings for a professor by professor id
    @GetMapping("/professor/{professorId}")
    public List<Rating> getRatingsByProfessor(@PathVariable Long professorId) {
        return ratingRepository.findByProfessorId(professorId);
    }

    // Add a new rating for a professor
    @PostMapping("/professor/{professorId}")
    public Rating createRating(@PathVariable Long professorId, @RequestBody Rating rating) {
        return professorRepository.findById(professorId).map(professor -> {
            rating.setProfessor(professor);
            return ratingRepository.save(rating);
        }).orElseThrow(() -> new RuntimeException("Professor not found with id " + professorId));
    }
}