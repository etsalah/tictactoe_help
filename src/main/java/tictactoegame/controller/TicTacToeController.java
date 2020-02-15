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
    public boolean validate(int input, Gameboard board)
    {
        if( input <= 0 || input > 9)
        {
            board.onBadInput(0);
            return false;
        }
        return true;
    }

    public int[] getCoordinates(int position) {
        int[] coord = new int[2];
        coord[0] = (position-1)/3;
        coord[1] = (position-1)%3;
        return coord;
    }
    /**
     * This method checks if there is available spot to play in
     * @param position
     * @return 
     */
    public boolean isSpotAvailable(int position)
    {
        // check if it's invalid input first here
        int[] coords = getCoordinates(position);
        if (model.getBoard()[coords[0]][coords[1]].trim().equals("")) {
            System.out.println("Spot is available");
            return true;
        }
        return false;
    }

    public int getPlayer() {
        return player;
    }

    public String getPlayerCharacter(int player) {
        return player==1?"X":"O";
    }

    public boolean PlayerIsComputer() {
        return player != 1;
    }

    /**
     * This method allows the player to play
     * @param x
     * @param y 
     */
    public void play(int x, int y)
    {
        String value=getPlayerCharacter(player);
        model.setBoard(x, y, value);
    }
    
    /**
     * This method allows the Computer to randomly choose a spot
     */
    public void computerPlayer()
    {
        int comp=ram.nextInt(9)+1;
        if (!isSpotAvailable(comp)) {
            computerPlayer();
        } else {
            int[] coords = getCoordinates(comp);
            play(coords[0], coords[1]);
        }
    }

    public boolean isTie() {
        return this.view.onTie(model.getBoard());
    }

    /**
     * This method is called when checking for the winner
     * @param playerId
     * @param playerCharacter 
     */
    public boolean checkWinner(int playerId, String playerCharacter)
    {
        String[][] board = model.getBoard();
        if(board[0][0].equals(playerCharacter)&&board[0][1].equals(playerCharacter)&&board[0][2].equals(playerCharacter))
        {
            return this.view.onWinnerEmerged(playerId, board);
        }
        else if(board[1][0].equals(playerCharacter)&&board[1][1].equals(playerCharacter)&&board[1][2].equals(playerCharacter))
        {
            return this.view.onWinnerEmerged(playerId, board);
        }
        else if(board[2][0].equals(playerCharacter)&&board[2][1].equals(playerCharacter)&&board[2][2].equals(playerCharacter))
        {
            return this.view.onWinnerEmerged(playerId, board);
        }
        else if(board[0][0].equals(playerCharacter)&&board[1][0].equals(playerCharacter)&&board[2][0].equals(playerCharacter)) {
            return this.view.onWinnerEmerged(playerId, board);
        }
        else if(board[0][1].equals(playerCharacter)&&board[1][1].equals(playerCharacter)&&board[2][1].equals(playerCharacter))
        {
            return this.view.onWinnerEmerged(playerId, board);
        }
        else if(board[0][2].equals(playerCharacter)&&board[1][2].equals(playerCharacter)&&board[2][2].equals(playerCharacter))
        {
            return this.view.onWinnerEmerged(playerId, board);
        }
        else if(board[0][0].equals(playerCharacter)&&board[1][1].equals(playerCharacter)&&board[2][2].equals(playerCharacter))
        {
            return this.view.onWinnerEmerged(playerId, board);
        }
        else if(board[2][0].equals(playerCharacter)&&board[1][1].equals(playerCharacter)&&board[0][2].equals(playerCharacter))
        {
            return this.view.onWinnerEmerged(playerId, board);
        }
        else
        {
            player=player==1?2:1;
            this.view.onNextPlayer(player, board);

            player=1;
            return false;
        }
    }

    /**
     * This method checks if the board is full
     * @return 
     */
    public boolean isBoardFull()
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
