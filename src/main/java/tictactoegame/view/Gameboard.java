/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.view;

import tictactoegame.controller.TicTacToeController;
import tictactoegame.controller.TicTacToeController.InnerTicTacController;

import java.util.Scanner;


/**
 *
 * @author Yvette
 */
public class Gameboard implements InnerTicTacController{
    
    TicTacToeController controller;
    Scanner scan = new Scanner(System.in);
    /**
     * Constructor
     */
    public Gameboard()
    {
        controller=new TicTacToeController(this);
//        requestInput();
        
    }
    
    /**
     * This method prints the board
     * @param board 
     */
    public void printBoard(String[][] board)
    {
        System.out.println("----+---+----");
        for(int i=0; i<3; i++)
        {
            System.out.print("| ");
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n----+---+----");
        }
    }
    
    /**
     * This method requests input from the Human player
     */
    public void requestInput()
    {
        System.out.println("Enter your position from 1 - 9");
        int placement = scan.nextInt();
        boolean isValid = controller.validate(placement, this);
        if (!isValid){
            requestInput();
        }
        boolean isSpotAvailable = controller.isSpotAvailable(placement);
        if(!isSpotAvailable) {
            requestInput();
        } else {
            int[] coords = controller.getCoordinates(placement);
            controller.play(coords[0], coords[1]);
            int playerId = controller.getPlayer();
            boolean winnerFound = controller.checkWinner(playerId, controller.getPlayerCharacter(playerId));
            if (winnerFound) {
                restart();
            } else if (controller.isBoardFull() && controller.isTie()) {
                restart();
            } else {
//                controller.computerPlayer();
                requestInput();
            }
        }

    }
    
    public void restart()
    {
        System.out.println("Game Over!!! Restart? Type Y for YES or N for NO");
        String restart;
        scan = new Scanner(System.in);
        restart = scan.next();
        if(controller.restart(restart))
        {
            requestInput();
        }
        else
        {
            System.out.println("Thanks for playing");
        }
    }
    
    @Override
    public void onBoardReady(String[][]  board) {
        printBoard(board);
    }

    
    @Override
    public boolean onBadInput(int player) {
        System.out.println("The input was incorrect!!!Choose (1 - 9)");
        // requestInput();
        return false;
    }
    
    @Override
    public boolean onWinnerEmerged(int player, String[][] board) {
        printBoard(board);
        if(player==1)
        {
            System.out.println("Congratulations!! You won!");
        }
        else
        {
            System.out.println("Computer won!");
        }
//        restart();
        return true;
    }

    @Override
    public void onSpaceTaken(int player) {
    
//        System.out.println("This spot is taken!! Try a different spot");
        if(player==1)
        {
            requestInput();
        }
        else
        {
            controller.computerPlayer();
        }
    }

    @Override
    public void onNextPlayer(int nextPlayer, String[][] board) {
    
        if(nextPlayer==1)
        {
            System.out.println("****YOUR TURN****");
        }
        else
        {
            controller.computerPlayer();
            System.out.println("****COMPUTER'S TURN****");
        }
        printBoard(board);
    }

    @Override
    public boolean onTie(String[][] board) {
        printBoard(board);
        System.out.println("It's a tie, no winner");
//        restart();
        return true;
    }

}