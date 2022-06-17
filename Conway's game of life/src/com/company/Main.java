package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] game_grid;
        game_grid = init();    // add rows and columns as parameters
        setRandomVal(game_grid);
        print(game_grid);
        continueGame(game_grid);
    }

    public static int[][] init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input desired number of rows in the grid.");
        int row = scanner.nextInt();
        System.out.println("Input desired number of columns in the grid");
        int column = scanner.nextInt();
        if (row < 50 || column < 50) {
            System.out.println("The Grid must have atleast 50 rows and 50 columns.");
            System.out.println("Please rerun the app.");
            System.exit(-1);
            return null;
        } else {
            int[][] game_grid = new int[row][column];
            game_grid[0][0] = 1;
            game_grid[1][0] = 1;
            game_grid[2][0] = 1;
            game_grid[3][0] = 1;
            return game_grid;
        }
    }

    public static void print(int[][] game_grid) {
        // printing takes place
        for (int i = 0; i <= game_grid.length - 1; i++) {
            System.out.println(Arrays.toString(game_grid[i]));
        }
    }

    public static void update(int[][] game_grid) {
        int total;
        for (int i = 0; i < game_grid.length - 1; i++) {
            for (int j = 0; j < game_grid[i].length - 1; j++) {
                if (i == 0 && j == 0) {
                    total = game_grid[i][j + 1] + game_grid[i + 1][j] + game_grid[i + 1][j + 1];

                } else if (i == 0  && j < game_grid[i].length - 1) {
                    total = game_grid[i][j - 1] + game_grid[i][j + 1] + game_grid[i + 1][j - 1] + game_grid[i + 1][j] + game_grid[i + 1][j + 1];

                } else if (i == 0 && j == game_grid[i].length - 1) {
                    total = game_grid[i][j - 1] + game_grid[i + 1][j - 1] + game_grid[i + 1][j];

                } else if (0 < i && i < game_grid.length - 1 && j == game_grid[i].length - 1) {
                    total = game_grid[i][j - 1] + game_grid[i - 1][j] + game_grid[i + 1][j - 1] + game_grid[i + 1][j - 1] + game_grid[i + 1][j];

                } else if (i == game_grid.length - 1 && j == game_grid[i].length - 1) {
                    total = (game_grid[i][j - 1] + game_grid[i - 1][j] + game_grid[i - 1][j - 1]);

                } else if (i == game_grid.length - 1 && 0 < j && j < game_grid[i].length - 1) {
                    total = (game_grid[i][j - 1] + game_grid[i][j + 1] + game_grid[i - 1][j + 1] + game_grid[i - 1][j] + game_grid[i - 1][j - 1]);

                } else if (i == game_grid.length - 1 && j == 0) {
                    total = (game_grid[i][j + 1] + game_grid[i - 1][j + 1] + game_grid[i - 1][j]);

                } else if (0 < i && i < game_grid.length - 1 && j == 0) {
                    total = (game_grid[i][j + 1] + game_grid[i - 1][j + 1] + game_grid[i - 1][j] + game_grid[i + 1][j] + game_grid[i + 1][j + 1]);

                } else {
                    total = (game_grid[i][j - 1] + game_grid[i][j + 1] + game_grid[i - 1][j] + game_grid[i - 1][j + 1]
                            + game_grid[i + 1][j - 1] + game_grid[i + 1][j] + game_grid[i + 1][j + 1] + game_grid[i - 1][j - 1]);
                }

                if (game_grid[i][j] == 1) {
                    if (total < 2) { // underpopulation
                        game_grid[i][j] = 0;
                    } else if (total > 3) { //dies
                        game_grid[i][j] = 0;
                    }
                } else if (game_grid[i][j] == 0) {
                    if (total == 3) { // baby is born
                        game_grid[i][j] = 1;
                    }
                }
            }
        }
        print(game_grid);
    }

    public static void continueGame(int[][] game_grid){
        Scanner scanner1 = new Scanner(System.in);
        int entre=0;
        while (entre == 0){
            System.out.println("\nEnter 1 then press on enter to continue the game.");
            entre = scanner1.nextInt();
            if(entre==1) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                update(game_grid);
            }
            entre =0;
        }
    }

    public static void LoadValues(){

    }

    public static void setRandomVal(int[][] game_grid) {
        int a = 0;
        int b = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 'true' if you want random values to be set in the grid, if you don't want to then type 'false'.");
        boolean check = scanner.nextBoolean();
        if (check == true) {
            int i = game_grid.length - 1;
            if (game_grid.length > game_grid[i].length) {
                a = game_grid[i].length - 1;
                b = game_grid.length - 1;
            } else {
                a = game_grid.length;
                b = game_grid[i].length;
            }
            int max0 = a;
            int min0 = 0;
            int range0 = max0 - min0 + 1;
            // generate random numbers within 1 to 10
            // set random number of elements in random row
            int randnumb0 = (int) (Math.random() * range0) + min0;
            for (int j = 0; j < game_grid[i].length; j++) {
                for (int k = 0; k < randnumb0 - 1; k++) {
                    int randnumb1 = (int) (Math.random() * (game_grid.length - 1)) + min0;
                    game_grid[randnumb1][j] = 1;
                }
            }
        }
    }

    /*
    public static void MessageDesign(int[][] game_grid) {

    }

    public static void CannonDesign(){

    } */

}