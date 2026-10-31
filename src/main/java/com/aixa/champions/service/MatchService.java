package com.aixa.champions.service;
import com.aixa.champions.model.Match;import com.aixa.champions.repository.MatchRepository;
import org.springframework.stereotype.Service;import org.springframework.boot.CommandLineRunner;import java.time.LocalDateTime;import java.util.List;
@Service public class MatchService implements CommandLineRunner {
private final MatchRepository repo;public MatchService(MatchRepository repo){this.repo=repo;}
// API simulada: representa la respuesta JSON de un proveedor externo, sin dependencia de red.
public List<Match> fetchSimulatedApi(){return List.of(
new Match("demo-01","Real Madrid","Manchester City","Octavos",LocalDateTime.of(2027,2,16,20,0)),
new Match("demo-02","Bayern Munich","Arsenal","Octavos",LocalDateTime.of(2027,2,17,20,0)),
new Match("demo-03","Barcelona","Inter Milan","Octavos",LocalDateTime.of(2027,2,18,20,0)),
new Match("demo-04","Paris Saint-Germain","Liverpool","Octavos",LocalDateTime.of(2027,2,19,20,0)),
new Match("demo-05","Chelsea","Juventus","Octavos",LocalDateTime.of(2027,2,23,20,0)),
new Match("demo-06","Borussia Dortmund","Atletico Madrid","Octavos",LocalDateTime.of(2027,2,24,20,0)) );}
@Override public void run(String...args){for(Match m:fetchSimulatedApi())if(!repo.existsByExternalId(m.externalId))repo.save(m);}
public List<Match> all(){return repo.findAll();}
}
