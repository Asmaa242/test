/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_game;

/**
 *
 * @author Lenovo
 */
public class Grid {

    char[][] grid;
    boolean marked;
    char win;

    public Grid() {
        win = '_';
        marked = false;
        grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '_';
            }
        }
    }

    boolean finished() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '_') {
                    return false;
                }
            }
        }
        marked = true;
        return true;
    }

}
