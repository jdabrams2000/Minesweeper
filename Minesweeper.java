//Minesweeper created by Ruben Burgos, Jacob Abrams, Helen Luo Pd 1

import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class Minesweeper {
  //shows how many safe tiles are left
  public static int safeTileCount (Cell[][] board) {
    int safe = 0;
    for (int i = 0; i < board.length; i++) {
      for (int k = 0; k < board[0].length; k++) {
        if (board[i][k].getContent() != 0) {
          safe = safe + 1;
      }
    }
  }
    return safe;
  }
  
  public static void main (String[] args) {
    Scanner sm = new Scanner (System.in);
    int rows = 0;
    int columns = 0;
    //User enters rows and columns wanted in their minesweeper game.
    while (rows <= 0) {
      System.out.print("Enter the amount of rows");
      rows = sm.nextInt();
    }
    while (columns <= 0) {
      System.out.print("Enter the amount of columns");
      columns = sm.nextInt();
    }
    Board board = new Board(rows,columns,(int)(0.15*rows*columns));
    Cell[][] map = board.setBoard(); //sets variables
    String[][] bord = new String[rows][columns];
    for(int q = 0; q < bord.length; q++){
        for(int j = 0; j < bord[0].length; j++){
           bord[q][j] = "X";
        }
    }
    boolean win = false;
    boolean gameOver = false;
    int safeTileCount = safeTileCount(map);
    while (win == false && gameOver == false) {//the game starts here
      System.out.print("Now you need to select a cell in the board. First enter the row number.");
      int r = sm.nextInt() - 1;
      System.out.print("Enter the column number.");
      int c = sm.nextInt() - 1;
      if(r < rows && r >= 0 && c < columns && c >= 0){ //checks if entered values are actual spaces on board.
        System.out.print(map[r][c].getContent() +"\t");
        System.out.print("\n");
        bord[r][c] = "" + map[r][c].getContent();
        if (map[r][c].getContent() == -1) {
          gameOver = true;
        }
        else {
          safeTileCount--;
        }
        if (safeTileCount == 0) {
          win = true; 
        }
      }
      else{
        System.out.println("Enter a valid space!");
      }
//Shows the current board.
      JFrame game = new JFrame("Minesweeper");
      game.setSize(500,500);
      game.setVisible(true);
      TextField safespot = new TextField("There are " + safeTileCount + " safe spots left ! Your current Minesweeper board:");
      game.add(safespot, BorderLayout.NORTH);
      JPanel spaces = new JPanel(new GridLayout(rows, columns));
      for (int m = 0; m < bord.length; m++) {
        for (int n = 0; n < bord[0].length; n++) {
          TextField space = new TextField(bord[m][n]);
          spaces.add(space);
        }
      }
      game.add(spaces);
  //displays game end message
      if (gameOver == true) {
        System.out.println("You lost");
      }
      if (win == true) {
        System.out.println("You won");
      }
    }
//closes Scanner
    sm.close();
  }
}
