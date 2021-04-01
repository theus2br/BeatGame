package com.backend.beatgame.Service;

import com.backend.beatgame.Model.Games;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GamesRepository extends CrudRepository<Games, Long> {
     List<Games> findByGame(String name);
}
