package com.aixa.champions.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="matches",uniqueConstraints=@UniqueConstraint(columnNames="externalId")) public class Match {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
@Column(nullable=false,unique=true) public String externalId;
public String homeTeam; public String awayTeam; public String stage; public LocalDateTime kickoff;
public Match(){} public Match(String externalId,String homeTeam,String awayTeam,String stage,LocalDateTime kickoff){this.externalId=externalId;this.homeTeam=homeTeam;this.awayTeam=awayTeam;this.stage=stage;this.kickoff=kickoff;}
}
