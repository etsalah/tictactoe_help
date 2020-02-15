/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;
import tictactoegame.view.Gameboard;

/**
 *
 * @author Yvette
 */
public class TicTacToeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Gameboard view = new Gameboard();
        view.requestInput();
        
    }
    
}
