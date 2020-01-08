/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_game;

import java.util.Scanner;



/**
 *
 * @author Lenovo
 */
public class main {

    /**
     * @param args the command line arguments
     */


    Game game;
    int graid_col, grid_row, depth;
    char opponent, computer;

    //	constructor
    public main() {

        // TODO Auto-generated constructor stub
        Scanner scan_input = new Scanner(System.in);

        //	insert the number of board rows
        System.out.print("Insert the number of the game board rows: ");
        grid_row = scan_input.nextInt();

        //	insert the number of board columns
        System.out.print("Insert the number of the game board columns: ");
        graid_col = scan_input.nextInt();

        //	insert the level of the game
        System.out.print("Insert the level of the game: ");
        depth = scan_input.nextInt();

        opponent = 'o';
        computer = '*';

        game = new Game(grid_row, graid_col, opponent, computer, depth);

    }

    private void opponentTurn() {

        Scanner scan_input = new Scanner(System.in);

        Position grid = new Position();
        while (true) {
            
            System.out.print("Enter the row: ");
            grid.row = scan_input.nextInt();
            System.out.println();

            if ((grid.row > 0) && (grid.row <= grid_row)) {
                break;
            }
        }
        while (true) {

            System.out.print("Enter the column: ");
            grid.col = scan_input.nextInt();
            System.out.println();

            if ((grid.col > 0) && (grid.col <= graid_col)) {
                break;
            }
        }

        if (game.grid_gam[grid.row - 1][grid.col - 1].marked ) {
            System.out.println("Already marked .. try a gain");
            opponentTurn();
        } else {

        Position position= new Position();
        while (true) {
            
            System.out.print("Enter row: ");
            position.row = scan_input.nextInt();
            System.out.println();

            if ((position.row > 0) && (position.row <= grid_row)) {
                break;
            }
        }
        while (true) {

            System.out.print("Enter column: ");
            position.col = scan_input.nextInt();
            System.out.println();

            if ((position.col > 0) && (position.col <= graid_col)) {
                break;
            }
        }

        if (game.grid_gam[position.row - 1][position.col - 1].win != '_') {
            System.out.println("Already filled .. try again");
            opponentTurn();
        } else {
            if(game.grid_gam[grid.row-1][grid.col-1].grid[position.row - 1][position.col - 1]=='_')
                game.insert_game_value(opponent,grid.row-1 ,grid.col-1, position.row - 1, position.col - 1);
            else
                System.out.println("Already filled .. try again");
        }
        }

    }

    public void start_playing() {

        System.out.println(game);
        while (true) {
            opponentTurn();
            //to call utility 
            int utility =0 ;
            if (utility == 1000) {
                System.out.println(game);
                System.out.println("\nOppenent win");
                break;
            }
            if (utility == -1000) {
                System.out.println(game);
                System.out.println("Computer win");
                break;
            }
            if (game.finish(game.grid_gam)) {
                System.out.println(game);
                System.out.println("The End .. Nice try");
                break;
            }
            game.computer_position();
            //call utility
            

            System.out.println(game);

            if (utility == 1000) {
                System.out.println("Oppenent win");
                break;
            }
            if (utility == -1000) {
                System.out.println("Computer win");
                break;
            }
            if (game.finish(game.grid_gam)) {
                System.out.println("The End .. Nice try");
                break;
            }
        }

    }

    // main code 
    public static void main(String[] args) {
        main main_game = new main();
        main_game.start_playing();
    }

}
