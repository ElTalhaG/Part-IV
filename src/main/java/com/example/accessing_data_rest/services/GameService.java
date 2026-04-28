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
        // Implementation: first we make an empty list so the iterator can be turned into a real list
        List<Game> games = new ArrayList<>();
        // Implementation: after that each game from findAll is added into the list one by one
        gameRepository.findAll().forEach(games::add);
        // Implementation: at the end the finished list goes back to the controller
        return games;
    }

    // DONE Assignment 7b: create a game in the repository and return the result
    public Game createGame(Game game) {
        // Implementation: this saves the new game in the database and returns the saved copy
        return gameRepository.save(game);
    }

    // TODO Assignment 7c: make sure that the game is created with the owner
    //      who must be in the repository already, and also with the owner as first player

}
