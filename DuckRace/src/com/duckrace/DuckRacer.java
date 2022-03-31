package com.duckrace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DuckRacer implements Serializable {
    // fields
    private int id;
    private String name;
    //    private int wins; -- not needed as we can use length property of Reward[]
    private Collection<Reward> rewards = new ArrayList<>();

    // constructors
    public DuckRacer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // business methods
    public void win(Reward reward) {
        rewards.add(reward);
    }

    // accessor methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return rewards.size();
    }

    /*
     * CAUTION: we are returning a DIRECT REFERENCE to this "sensitive data"
     * as is we can change this list without calling WIN method
     * FIXED: by using copyOf() we made this List "Read Only"
     */
    public List<Reward> getRewards() {
        // return (List<Reward>) rewards; -- UNSAFE
        return List.copyOf(rewards);
    }

    // toString()
    public String toString() {
        return "DuckRacer: " +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", rewards= " + getRewards() +
                ", number of wins= " + getWins() +
                '.';
    }
}