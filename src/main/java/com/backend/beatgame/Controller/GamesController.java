package com.backend.beatgame.Controller;

import com.backend.beatgame.Model.GameListException;
import com.backend.beatgame.Model.Games;
import com.backend.beatgame.Model.Response;
import com.backend.beatgame.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("beatgame")
public class GamesController {

    @Autowired
    private GameService gameService;

    private Response newResponse = new Response();

    //Gravar jogo
    @PostMapping
    public ResponseEntity<?> saveGame(@RequestBody Games gameBody) throws Exception {
        return new ResponseEntity<>(gameService.saveGame(gameBody), HttpStatus.CREATED);
    }

    //Buscar todos
    @GetMapping()
    public ResponseEntity<?> findAllGames() {
        try {
            return new ResponseEntity<>(gameService.getListGames(), HttpStatus.OK);
        }catch(GameListException e){
            newResponse.setResult(e.getMessage());
            return new ResponseEntity<>(newResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Filtrar um jogo
    @GetMapping(path = "/{nameGame}")
    public ResponseEntity<?> findGameByName(@PathVariable String nameGame) {
        try{
            return new ResponseEntity<>(gameService.getGame(nameGame), HttpStatus.OK);
        }catch (GameListException e){
            newResponse.setResult(e.getMessage());
            return new ResponseEntity<>(newResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Deletar um jogo
    @DeleteMapping(path = "delete/{nameGame}/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable String nameGame, @PathVariable Long id) throws GameListException {
        try {
            return new ResponseEntity<>(gameService.deleteGame(nameGame, id), HttpStatus.OK);
        }catch (GameListException e){
            throw new GameListException("Nenhum jogo encontrado no banco de dados");
        }
    }

    //Editar algum campo
    @PutMapping(path = "update/{nameGame}")
    public String updateGame(@RequestBody Games game){
        gameService.updateGame(game);
        return "Atualizado";
    }

    //favoritar Jogos
    @GetMapping(path = "/favorites")
    public ResponseEntity<?> getFavoritesGames() throws GameListException {
        try {
            return new ResponseEntity<>(gameService.getFavoritesGames(), HttpStatus.OK);
        }catch(GameListException e){
            newResponse.setResult(e.getMessage());
            return new ResponseEntity<>(newResponse, HttpStatus.OK);
        }
    }
}
