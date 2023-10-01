package com.spring.playerapi.dao;

import com.spring.playerapi.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


//@RepositoryRestResource(path = "team")
public interface PlayerDAO extends JpaRepository <Player, Integer> {

    Player findByName(@RequestParam String name);
    //Player findByNameContaining(@RequestParam String name);
    //List<Player> findByNameContaining(@RequestParam String name);
}