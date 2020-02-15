/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


/**
 *
 * @author Yvette
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GameboardTest {
    Gameboard board = new Gameboard();
//    TicTacToeController control= new TicTacToeController(board);

    public GameboardTest() {
    }
    
    @BeforeAll
    public void setUp() {
        //System.out.println("setUp() method is first called");
        board = new Gameboard();
    }

//    @AfterAll
//    public void tearDown() {
//    }

    /**
     * Test of printBoard method, of class Gameboard.
     */
    @Test
    public void testPrintBoard() {
        System.out.println("Print Board");
        String boardGame[][]={{" "," ", " "},
                {" "," ", " "},
                {" "," ", " "}};
        board.printBoard(boardGame);
    }

    /**
     * Test of requestInput method, of class Gameboard.
     */
//    @Test
//    public void testRequestInput() {
//        System.out.println("Request Input");
//        board.requestInput();
//    }

    /**
     * Test of restart method, of class Gameboard.
     */
    @Test
    public void testRestart() {
        System.out.println("Restart");
        board.restart();
        System.out.println("N");
    }
}
