package com.backend.beatgame.Service;

import com.backend.beatgame.Model.Games;
import com.backend.beatgame.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GamesRepository gamesRepository;

    //Salvar jogo
    public Response saveGame(Games gameBody) throws Exception {
        Response newResponse = new Response();
        try {
            gamesRepository.save(gameBody);
            newResponse.setResult("Jogo " + gameBody.getNameGame() + " cadastrado com sucesso!");
        } catch (Exception e) {
            throw new Exception(e);
        }
        return newResponse;
    }

    //Buscar Game
    public Games getGame(String nameGame) {
        return gamesRepository.findGameBynameGame(nameGame);
    }

    //Listar todos os jogos
    public List<Games> getListGames() {
        return (List<Games>) gamesRepository.findAll();
    }

    //Apagar jogo
    public Response deleteGame(String nameGame) throws Exception {
        gamesRepository.delete(gamesRepository.findGameBynameGame(nameGame));
        Response newResponse = new Response();
        newResponse.setResult("Jogo " + nameGame + " deletado com sucesso!");
        return newResponse;
    }
}
