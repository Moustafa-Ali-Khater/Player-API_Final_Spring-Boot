package com.spring.playerapi.service;

import com.spring.playerapi.dao.PlayerDAO;
import com.spring.playerapi.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private PlayerDAO playerDao;

    @Autowired
    public PlayerService(PlayerDAO playerDAO) {
        this.playerDao = playerDAO;
    }

    public Player getPlayerByName(String playername) {
        return playerDao.findByName(playername);
    }

    public List<Player> allPlayers() {
        // begain
        return playerDao.findAll();
        // commit
    }

    public void savePlayer(Player player) {
        playerDao.save(player);
    }

    public Player showPlayer(int id) {
        return playerDao.findById(id).get();
    }

    public void deletePlayer(int id) {
        playerDao.deleteById(id);

    }
}
