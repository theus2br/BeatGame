package com.backend.beatgame.Service;

import com.backend.beatgame.Model.GameListException;
import com.backend.beatgame.Model.Games;
import com.backend.beatgame.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GamesRepository gamesRepository;

    Response newResponse = new Response();

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
    public List<Games> getGame(String nameGame) throws GameListException {
        List<Games> listGames = gamesRepository.findListGameBynameGameOrderByNameGame(nameGame);
        if(listGames.isEmpty())
            throw new GameListException("Nenhum jogo encontrado com este nome!");
        else return listGames;
    }

    //Listar todos os jogos
    public List<Games> getListGames() throws GameListException{
        List<Games> listGames = gamesRepository.findAllByOrderByNameGame();
        if(listGames.isEmpty())
            throw new GameListException("Nenhum jogo encontrado!");
        else return listGames;
    }

    //Apagar jogo
    public Response deleteGame(String nameGame, Long id) throws GameListException {
        gamesRepository.delete(gamesRepository.findGamesBynameGameAndId(nameGame, id));
        newResponse.setResult("Jogo " + nameGame + " deletado com sucesso!");
        return newResponse;
    }

    //Atualizar jogo
    public String updateGame(Games game){
        gamesRepository.save(game);
        return "Sucesso";
    }

    //Listar favoritos
    public List<Games> getFavoritesGames() throws GameListException{
        List<Games> listGames = gamesRepository.findAllByFavoritesIsTrue();
        if(listGames.isEmpty())
            throw new GameListException("Nenhum jogo nos favoritos");
        else return listGames;
    }
}
