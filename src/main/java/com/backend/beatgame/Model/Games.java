package com.backend.beatgame.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Games implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameGame;

    private Integer hoursPlayed;

    private Integer progress;

    private boolean favorites;
}
