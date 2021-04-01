package com.backend.beatgame.Controller;

import com.backend.beatgame.Model.Games;
import com.backend.beatgame.Service.GamesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("beatgame")
public class GamesController {
    private final GamesRepository gamesDAO;

    public GamesController(GamesRepository gamesDAO) {
        this.gamesDAO = gamesDAO;
    }

    @PostMapping
    public ResponseEntity<?> saveGame(@RequestBody Games gameBody){
        return new ResponseEntity<>(gamesDAO.save(gameBody), HttpStatus.OK);
    }

    @GetMapping()
    public List<Games> findAllGames(){
        return gamesDAO.findAll();
    }

    @GetMapping(path="/{name}")
    public Games findGame(@PathVariable String name){
        return gamesDAO.findOne(name);
    }

    @GetMapping(path="/{name}")
    public Games findGames(@PathVariable String name){ return gamesDAO.findById(name)}

}
