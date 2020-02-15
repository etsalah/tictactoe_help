/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 *
 * @author Yvette
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TicTacToeModelTest {
    TicTacToeModel model;

    public TicTacToeModelTest() {
    }

    @BeforeAll
    public void setUp() {
        model=new TicTacToeModel();
    }

    /**
     * Test of setBoard method, of class TicTacToeModel.
     */
    @Test
    public void testSetBoard() {
        System.out.println("set Board");
        int x = 1;
        int y=0;
        String ch="x";
        model.setBoard(x,y,ch);
    }

    /**
     * Test of getBoard method, of class TicTacToeModel.
     */
    @Test
    public void testGetBoard() {
       System.out.println("get Board");
       model.getBoard();
    }

    /**
     * Test of resetBoard method, of class TicTacToeModel.
     */
    @Test
    public void testResetBoard() {
        System.out.println("reset Board");
        model.resetBoard();
    }
}
