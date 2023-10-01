package com.spring.playerapi.controller;

import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myapi")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/person")
    public Player getplayer(@RequestParam String name) {
        return playerService.getPlayerByName(name);
    }

    @GetMapping("/players")
    public List<Player> gePlayers() {
        return playerService.allPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getplayerById(@PathVariable("id") int id) {
        Player p = playerService.showPlayer(id);
        if(p == null) {
            throw new RuntimeException("Player Not Found " + "ID: " + id);
        }
        return p;
    }

	/*@GetMapping("/players")
	public Player getplayerId(@RequestParam int id) {
		Player p = playerService.showPlayer(id);
		if(p == null) {
			throw new StudentException("Player Not Found " + "ID: " + id);
		}
		return p;
	}*/

	/*@PostMapping("/saveplayer")
	public Player saveplayer(@RequestBody Player player) {
		playerService.savePlayer(player);
		return player;
	}*/

    @PostMapping("/saveplayer")
    public String saveplayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return "Add successfully!";
    }

    @PutMapping("/update")
    public String updateplayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return "Update successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteplayer(@PathVariable ("id") int id) {
        playerService.deletePlayer(id);
    }

    /*@DeleteMapping("/delete/{id}")
    public String deleteplayer(@PathVariable ("id") int id) {
        int r = playerService.deletePlayer(id);
        //System.out.println(r);
        if (r == 0) {
            throw new RuntimeException("Player Not Found " + "ID: " + id);
        }
        return "Deleted successfully!";
    }*/

	/*@DeleteMapping("/delete")
	public void removeplayer(@RequestParam int id) {
		playerService.deletePlayer(id);
	}*/
}
