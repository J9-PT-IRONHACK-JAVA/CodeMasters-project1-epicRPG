package com.ironhack;

import java.io.IOException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        var team1 = new ArrayList<Character>();
        var team2 = new ArrayList<Character>();

        Banners.logo();
        Menu.run(team1, team2);
    }
}
