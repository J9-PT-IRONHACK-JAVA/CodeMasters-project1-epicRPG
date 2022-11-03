package com.ironhack;

import java.io.IOException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        var team1 = new ArrayList<Character>();
        var team2 = new ArrayList<Character>();

        Banners.logo();
        Menu.run(team1, team2);
        Banners.swords();
        System.out.println("Team 1:");
        for (Character player : team1) {
            System.out.println(player.getName());
        }
        System.out.println("\nTeam 2:");
        for (Character player : team2) {
            System.out.println(player.getName());
        }
        //FIGHT CLASS
    }
}
