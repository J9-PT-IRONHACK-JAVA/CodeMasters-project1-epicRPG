package com.ironhack;

import java.io.IOException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        var team1 = new ArrayList<Character>();
        var team2 = new ArrayList<Character>();
        var graveYard = new ArrayList<Character>();

        EpicUtils.clearConsole();
        Banners.logo();
        System.out.println("Press ENTER to start...");
        System.in.read();
        Menu.run(team1, team2, graveYard);
    }
}
