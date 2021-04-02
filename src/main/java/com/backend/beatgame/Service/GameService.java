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
    public Response getGame(String nameGame) {
        List<Games> listGames = gamesRepository.findListGameBynameGameOrderByNameGame(nameGame);
        Response getResponse = new Response();
        if(listGames.isEmpty()){
            getResponse.setResult("Nenhum jogo encontrado!");
            return getResponse;
        }else{
            getResponse.setListResult(listGames);
            return getResponse;
        }
    }

    //Listar todos os jogos
    public List<Games> getListGames() {
        return gamesRepository.findAllByOrderByNameGame();
    }

    //Apagar jogo
    public Response deleteGame(String nameGame, Long id) throws Exception {
        gamesRepository.delete(gamesRepository.findGamesBynameGameAndId(nameGame, id));
        Response newResponse = new Response();
        newResponse.setResult("Jogo " + nameGame + " deletado com sucesso!");
        return newResponse;
    }

    //Atualizar jogo
    public String updateGame(Games game){
        gamesRepository.save(game);
        return "Sucesso";
    }

    //Listar favoritos
    public List<Games> getFavoritesGames(){ return (List<Games>) gamesRepository.findAllByFavoritesIsTrue();}
}
