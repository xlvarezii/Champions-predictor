package com.aixa.champions.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity public class Prediction {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
@ManyToOne(optional=false,fetch=FetchType.EAGER) public Match match;
@Column(nullable=false) public String author;
@Column(nullable=false) public String result;
public int homeScore; public int awayScore; public LocalDateTime createdAt=LocalDateTime.now();
public Prediction(){} public Prediction(Match match,String author,String result,int homeScore,int awayScore){this.match=match;this.author=author;this.result=result;this.homeScore=homeScore;this.awayScore=awayScore;}
}
