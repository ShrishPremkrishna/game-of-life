package com.shrish.gol;

import com.shrish.gol.util.Board;
import java.util.Scanner;

public class GameOfLife
{
  public static void main (String args[]){
    // Initial state of board
    int[][] initial = {{0, 0, 0, 0, 0}, 
                        {0, 0, 1, 0, 0}, 
                        {0, 1, 1, 1, 0}, 
                        {0, 0, 1, 0, 0}, 
                        {0, 0, 0, 0, 0}};
    // Creating a new board
    Board myBoard = new Board(initial);
    // Printing myBoard
    myBoard.printBoard();
    // Creating Scanner input
    Scanner input = new Scanner(System.in);

    // Starting loop
    while(true){
      System.out.println("Continue? [y]es or [n]o");
      String userContinue = input.nextLine();
      if(userContinue.equals("y"))
      {
        myBoard.next();
        myBoard.printBoard();
      }
      else
      {
        System.out.println("Ending Shrish's Game Of Life, \nThanks for playing!");
        break;
      }
    }
  }
}
  



