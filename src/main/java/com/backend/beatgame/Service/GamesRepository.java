package com.backend.beatgame.Service;

import com.backend.beatgame.Model.Games;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GamesRepository extends CrudRepository<Games, Long> {
    Games findGameBynameGame(String nameGame);

}
