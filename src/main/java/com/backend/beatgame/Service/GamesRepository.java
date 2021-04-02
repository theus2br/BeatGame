package com.backend.beatgame.Service;

import com.backend.beatgame.Model.Games;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends CrudRepository<Games, Long> {
    List<Games> findListGameBynameGameOrderByNameGame(String nameGame);

    Games findGamesBynameGameAndId(String nameGame, Long id);

    List<Games> findAllByFavoritesIsTrue();

    List<Games> findAllByOrderByNameGame();
}
