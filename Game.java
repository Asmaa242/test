/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_game;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Game {


    Grid[][] grid_gam;
    Position lastPosition;
    char opponent, computer;
    int depth;

    public Game(int row, int col, char opp, char comp, int dep) {
        lastPosition = new Position();
        grid_gam = new Grid[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid_gam[i][j] = new Grid();
            }
        };
        opponent = opp;
        computer = comp;
        depth = dep;
    }

    public Game(char x, Game game, Position BG, Position SG) {
        this.insert_game_value(x, BG.row, BG.col, SG.row, SG.col);

    }

    public ArrayList<Game> getAllPossibleMoves(char player) {
        ArrayList<Game> Possible_Child = new ArrayList<>();
        if (!this.grid_gam[lastPosition.row][lastPosition.col].marked) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (this.grid_gam[lastPosition.row][lastPosition.col].grid[r][c] == '_') {
                        Possible_Child.add(new Game(player, this, lastPosition, new Position(r, c)));
                    }
                }
            }
        } 
 
        return Possible_Child;
    }

    //	Insert the new move into the game board
    public void insert_game_value(char value, int gx, int gy, int x, int y) {

        if (grid_gam[gx][gy].grid[x][y] == '_') {
            grid_gam[gx][gy].grid[x][y] = value;
            grid_gam[gx][gy].finished();
            lastPosition.row = x;
            lastPosition.col = y;
        }
    }

    // Return True if the game board filled
    public boolean finish(Grid[][] b) {
        for (Grid[] b1 : b) {
            for (int j = 0; j < b[0].length; j++) {
                if (!b1[j].marked) {
                    return false;
                }
            }
        }
        return true;
    }

    void computer_position() {
        int best_utility = +100000;
        Position computer_p = new Position();
        computer_p.row = -1;
        computer_p.col = -1;
   

        System.out.println("The best utility is: " + best_utility);
        System.out.println("best row " + (computer_p.row + 1));
        System.out.println("best col " + (computer_p.col + 1));

     
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Grid[] game_board1 : grid_gam) {
            for (int j = 0; j < grid_gam[0].length; j++) {
                for (int k = 0; k < grid_gam[0][0].grid.length; k++) {
                    for (int h = 0; h < grid_gam[0][0].grid[0].length; h++) {
                        sb.append(game_board1[k].grid[j][h]);
                        sb.append("|");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append("\t||\t");
                }
                // sb.deleteCharAt(sb.length()-1);
                sb.delete(sb.length() - 4, sb.length() - 1);
                sb.append('\n');
            }
            sb.delete(sb.length() - 2, sb.length() - 1);
            sb.append("\n-------------------------------------------\n");
        }
        return sb.toString();
    }

}
