package com.example.accessing_data_rest.services;

import com.example.accessing_data_rest.model.Game;
import com.example.accessing_data_rest.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getGames() {
        // TODO Assignment 7b: Implement the method for obtaining all games from the
        //      GameRepository (using finaAll) and returning it as a list
        // here we make an empty list so we can collect all games from the repository
        List<Game> games = new ArrayList<>();
        // here we loop through everything from findAll and put each game into the list
        gameRepository.findAll().forEach(games::add);
        // here we send the finished list back to the controller
        return games;
    }

    // DONE Assignment 7b: create a game in the repository and return the result
    public Game createGame(Game game) {
        // here we save the new game in the database and get the saved version back
        return gameRepository.save(game);
    }

    // TODO Assignment 7c: make sure that the game is created with the owner
    //      who must be in the repository already, and also with the owner as first player

}
