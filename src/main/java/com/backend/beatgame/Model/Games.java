package com.backend.beatgame.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Games implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameGame;

    private Integer hoursPlayed;

    private Integer progress;


    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(Integer hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }
}
