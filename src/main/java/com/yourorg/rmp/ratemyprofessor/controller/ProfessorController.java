package com.yourorg.rmp.ratemyprofessor.controller;

import com.yourorg.rmp.ratemyprofessor.model.Professor;
import com.yourorg.rmp.ratemyprofessor.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
@CrossOrigin(origins = "*") // allows requests from any domain (for development)
public class ProfessorController {
    
    @Autowired
    private ProfessorRepository professorRepository;

    // Get all professors
    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    // Add a new professor
    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }
}