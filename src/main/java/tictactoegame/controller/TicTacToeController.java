/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.controller;

import tictactoegame.model.TicTacToeModel;
import tictactoegame.view.Gameboard;

import java.util.Random;

/**
 *
 * @author Yvette
 */
public class TicTacToeController {
    TicTacToeModel model;
    Gameboard view;
    private int player=1;
    Random ram;
    
    
    /**
     * This is a constructor
     * @param board
     */
    public TicTacToeController(Gameboard board)
    {
        model=new TicTacToeModel();
        view=board;
        board.onBoardReady(model.getBoard());
        ram=new Random();
    }
    
    public interface InnerTicTacController
    {
        /**
         * called when the board is ready to play
         * @param board
         */
        void onBoardReady(String[][] board);
        
        /**
         * called if a player result is a winner
         * @param player won on the game 
         * @param board
         */
        boolean onWinnerEmerged(int player, String[][] board);
        
        /**
         * called a selected position already has a value
         * The player who just attempted to play needs to play a different spot
         * @param player 
         */
        void onSpaceTaken(int player);
        
        /**
         * called when the next player is about to play
         * @param nextPlayer 
         * @param board 
         */
        void onNextPlayer(int nextPlayer, String[][] board);
        
        /**
         * called when there is a bad input
         * @param player 
         */
        boolean onBadInput(int player);
        
        /**
         * called when all possible spots are filled
         * There is no winner
         * @param board
         */
        boolean onTie(String[][] board);
        
    }
    
    /**
     * This method validates user input
     * @param input
     * @param board 
     */
    public void validate(int input, Gameboard board)
    {
        if(input<=0 || input>9)
        {
            board.onBadInput(0);
        }
        else
        {
            isSpotAvailable(input);
        }
    }
    
    /**
     * This method checks if there is available spot to play in
     * @param position
     * @return 
     */
    public boolean isSpotAvailable(int position)
    {
        // check if it's invalid input first here
        if (!view.onBadInput(position)) {
            return false;
        }

        position=position-1;
        int x=position/3;
        int y=(position%3);

        if(model.getBoard()[x][y].trim().equals(""))
        {
            play(x,y);
            return true; 
        }
        else
        {
            view.onSpaceTaken(player);
            return false;
        }
    }
    
    /**
     * This method allows the player to play
     * @param x
     * @param y 
     */
    public void play(int x, int y)
    {
        String value=player==1?"X":"O";
        model.setBoard(x, y, value);
        checkWinner(player,value);
    }
    
    /**
     * This method allows the Computer to randomly choose a spot
     */
    public void computerPlayer()
    {
        int comp=ram.nextInt(9)+1;
        isSpotAvailable(comp);
    }
    
    /**
     * This method is called when checking for the winner
     * @param playerId
     * @param playerCharacter 
     */
    public void checkWinner(int playerId, String playerCharacter)
    {
        String[][] board = model.getBoard();
        if(board[0][0].equals(playerCharacter)&&board[0][1].equals(playerCharacter)&&board[0][2].equals(playerCharacter))
        {
            if (this.view.onWinnerEmerged(playerId, board)) {
                this.view.restart();
            }
        }
        else if(board[1][0].equals(playerCharacter)&&board[1][1].equals(playerCharacter)&&board[1][2].equals(playerCharacter))
        {
            if (this.view.onWinnerEmerged(playerId, board)) {
                this.view.restart();
            }
        }
        else if(board[2][0].equals(playerCharacter)&&board[2][1].equals(playerCharacter)&&board[2][2].equals(playerCharacter))
        {
            if (this.view.onWinnerEmerged(playerId, board)) {
                this.view.restart();
            }
        }
        else if(board[0][0].equals(playerCharacter)&&board[1][0].equals(playerCharacter)&&board[2][0].equals(playerCharacter)) {
            if (this.view.onWinnerEmerged(playerId, board)){
                this.view.restart();
            }
        }
        else if(board[0][1].equals(playerCharacter)&&board[1][1].equals(playerCharacter)&&board[2][1].equals(playerCharacter))
        {
            if (this.view.onWinnerEmerged(playerId, board)) {
                this.view.restart();
            }
        }
        else if(board[0][2].equals(playerCharacter)&&board[1][2].equals(playerCharacter)&&board[2][2].equals(playerCharacter))
        {
            if (this.view.onWinnerEmerged(playerId, board)) {
                this.view.restart();
            }
        }
        else if(board[0][0].equals(playerCharacter)&&board[1][1].equals(playerCharacter)&&board[2][2].equals(playerCharacter))
        {
            if (this.view.onWinnerEmerged(playerId, board)) {
                this.view.restart();
            }
        }
        else if(board[2][0].equals(playerCharacter)&&board[1][1].equals(playerCharacter)&&board[0][2].equals(playerCharacter))
        {
            if (this.view.onWinnerEmerged(playerId, board)) {
                this.view.restart();
            }
        }
        else
        {
            if(isBoardFull(playerId)) {
                this.view.onTie(board);
                this.view.restart();
            }
            else
            {
                player=playerId==1?2:1;
                this.view.onNextPlayer(player, board);
            }
        }
    }
    
    
    /**
     * This method checks if the board is full
     * @param playerId
     * @return 
     */
    public boolean isBoardFull(int playerId)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(model.getBoard()[i][j].trim().isEmpty())
                {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * This method is called when the player wants to play again
     * @param restart
     * @return 
     */
    public boolean restart(String restart)
    {
        if(restart.equalsIgnoreCase("Y"))
        {
            model.resetBoard();
            return true;
        }
        else
        {
            return false;
        }
    }
        
}
