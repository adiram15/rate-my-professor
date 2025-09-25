package com.yourorg.rmp.ratemyprofessor.model;

import jakarta.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;

    @Column(length = 1000)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Rating() {}

    public Rating(int score, String comment, Professor professor) {
        this.score = score;
        this.comment = comment;
        this.professor = professor;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }
}