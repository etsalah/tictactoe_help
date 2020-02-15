/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.model;

/**
 *
 * @author Yvette
 */
public class TicTacToeModel {
    
    private String[][] board;

    
    
    //constructor
    public TicTacToeModel()
    {
        String boardGame[][]={{" "," ", " "},
            {" "," ", " "},
            {" "," ", " "}};
        board=boardGame;
    }
    
    /**
     * This method gets the board
     * @return 
     */
    public String[][] getBoard()
    {
        return board;
    }
    
    /**
     * This method sets the board
     * @param x
     * @param y
     * @param symbol
     */
    public void setBoard(int x, int y, String symbol)
    {
        board[x][y]=symbol;
    }
    
    /**
     * This method resets the board for the next playing session
     */
    public void resetBoard()
    {
        String boardGame[][]={{" "," ", " "},
            {" "," ", " "},
            {" "," ", " "}};
        board=boardGame;
    }
    
    
    
}
