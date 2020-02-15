/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import tictactoegame.model.TicTacToeModel;
import tictactoegame.view.Gameboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Yvette
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TicTacToeControllerTest {

    TicTacToeController control;
    TicTacToeModel model;
    Gameboard board;

    public TicTacToeControllerTest() {
    }
    
    @BeforeAll
    public void setUp() {
        board = new Gameboard();
        control = new TicTacToeController(board);
        model = new TicTacToeModel();
    }

    @AfterAll
    public void tearDown() {
    }

    /**
     * Test of validate method, of class TicTacToeController.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        int input = 0;
        control.validate(input, board);
    }

    /**
     * Test of isSpotAvailable method, of class TicTacToeController.
     */
    @Test
    public void testIsSpotAvailable() {
        System.out.println("isSpotAvailable");
        int position = 1;
        boolean expResult = true;
        boolean result = control.isSpotAvailable(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of play method, of class TicTacToeController.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        int x = 0;
        int y = 0;
        control.play(x, y);
    }

    /**
     * Test of computerPlayer method, of class TicTacToeController.
     */
    @Test
    public void testComputerPlayer() {
        System.out.println("computerPlayer");
        control.computerPlayer();

    }

    /**
     * Test of checkWinner method, of class TicTacToeController.
     */
    @Test
    public void testCheckWinner() {
        System.out.println("checkWinner");
        int playerId = 0;
        String playerCharacter = "Computer";
        control.checkWinner(playerId, playerCharacter);
    }

    /**
     * Test of isBoardFull method, of class TicTacToeController.
     */
    @Test
    public void testIsBoardFull() {
        System.out.println("isBoardFull");
        int playerId = 0;
        boolean expResult = false;
        boolean result = control.isBoardFull();
        assertEquals(expResult, result);
    }

    /**
     * Test of restart method, of class TicTacToeController.
     */
    @Test
    public void testRestart() {
        System.out.println("restart");
        String restart = "";
        boolean expResult = false;
        boolean result = control.restart(restart);
        assertEquals(expResult, result);
    }
    
}
