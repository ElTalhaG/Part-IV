package com.example.accessing_data_rest.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="user_table") // this is important! "user" is a keyword in H2 and not an identifier
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    private String name;

    // TODO this class needs to be extended with references to Player and
    //      the other way round (similar to the reference from Game to Player
    //      and the other way round.
    // here we keep the list of player entries that belong to this user
    @OneToMany(mappedBy = "user")
    // here we store all the player objects for the user in one place
    private List<Player> players;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // here we return the list so the backend can read which games the user joined
    public List<Player> getPlayers() {
        return players;
    }

    // here we save a whole list of player entries on the user
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

}
