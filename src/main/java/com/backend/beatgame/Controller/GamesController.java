package com.backend.beatgame.Controller;

import com.backend.beatgame.Model.Games;
import com.backend.beatgame.Model.Response;
import com.backend.beatgame.Service.GameService;
import com.backend.beatgame.Service.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("beatgame")
public class GamesController {

    @Autowired
    private GameService gameService;

    //Gravar jogo
    @PostMapping
    public ResponseEntity<?> saveGame(@RequestBody Games gameBody) throws Exception {
        return new ResponseEntity<>(gameService.saveGame(gameBody), HttpStatus.CREATED);
    }

    //Buscar todos
    @GetMapping()
    public List<Games> findAllGames() {
        return (List<Games>) gameService.getListGames();
    }

    //Filtrar um jogo
    @GetMapping(path = "/{nameGame}")
    public Games findGameByName(@PathVariable String nameGame) {
        return gameService.getGame(nameGame);
    }

    //Deletar um jogo
    @DeleteMapping(path = "delete/{nameGame}")
    public ResponseEntity<?> deleteGame(@PathVariable String nameGame) throws Exception {
        try {
            return new ResponseEntity<>(gameService.deleteGame(nameGame), HttpStatus.OK);
        }catch (Exception e){
            throw new Exception(e);
        }
    }
}
