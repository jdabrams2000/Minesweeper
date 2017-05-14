import java.lang.Math;

public class Board extends Cell{
  private int rows;                 //number of rows
  private int cols;                 //number of columns
  private int mines;                //number of mines
  
  public Board(int r, int c, int m){
    rows = r;
    cols = c;
    mines = m;
  }
  
  public int getCells(){           //returns number of Cells
    return rows*cols;
  }
  
  public Cell[][] setBoard(){     //Board is a 2D array of Cells
    Cell[][] board = new Cell[rows][cols];
    for(int r=0; r<rows;r++){                 //for each row
      for(int c=0; c<cols; c++){           //for each column
        board[r][c]=new Cell(r, c);
      }
    }
    
    //placing mines
    int numMines = mines;
    Cell selectedCell;
    while(numMines>0){
      selectedCell= board[(int)(rows*Math.random())][(int)(cols*Math.random())];
      if (selectedCell.getContent()!=-1){
        numMines--;
        selectedCell.setContent(-1);
      }
    }
    
    //setting up numbers of cells
    int adjacentCells=0;
    for(int r = 0; r<rows; r++){
      for(int c = 0; c<cols; c++){
        if(board[r][c].getContent()!=-1){
          //cell in top-left corner
          if(r==0&&c==0){
            if(board[0][1].getContent()==-1){
              adjacentCells++;
            }
            if(board[1][0].getContent()==-1){
              adjacentCells++;
            }
            if(board[1][1].getContent()==-1){
              adjacentCells++;
            }
            board[r][c].setContent(adjacentCells);
            adjacentCells=0;
          }
          
          //cell in top-right corner
          else if(r==0&&c==cols-1){
            if(board[0][c-1].getContent()==-1){
              adjacentCells++;
            }
            if(board[1][c].getContent()==-1){
              adjacentCells++;
            }
            if(board[1][c-1].getContent()==-1){
              adjacentCells++;
            }
            board[r][c].setContent(adjacentCells);
            adjacentCells=0;
          }
          //cells in top row besides corners
          else if(r==0&&c<cols-1){
            if(board[0][c-1].getContent()==-1){
              adjacentCells++;
            }
            if(board[0][c+1].getContent()==-1){
              adjacentCells++;
            }
            if(board[1][c-1].getContent()==-1){
              adjacentCells++;
            }
            if(board[1][c].getContent()==-1){
              adjacentCells++;
            }
            if(board[1][c+1].getContent()==-1){
              adjacentCells++;
            }
            board[r][c].setContent(adjacentCells);
            adjacentCells=0;
          }
          //cell in bottom-left corner
          else if(r==rows-1&&c==0){
            if(board[r-1][0].getContent()==-1){
              adjacentCells++;
            }
            if(board[r][1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r-1][1].getContent()==-1){
              adjacentCells++;
            }
            board[r][c].setContent(adjacentCells);
            adjacentCells=0;
          }
          //cell in bottom-right corner
          else if(r==rows-1&&c==cols-1){
            if(board[r-1][c-1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r-1][c].getContent()==-1){
              adjacentCells++;
            }
            if(board[r][c-1].getContent()==-1){
              adjacentCells++;
            }
            board[r][c].setContent(adjacentCells);
            adjacentCells=0;
          }
          //cells in bottom row
          else if(r==rows-1){
            if(board[r][c-1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r-1][c-1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r-1][c].getContent()==-1){
              adjacentCells++;
            }
            if(board[r-1][c+1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r][c+1].getContent()==-1){
              adjacentCells++;
            }
            board[r][c].setContent(adjacentCells);
            adjacentCells=0;
          }
          //cells in left column
          else if(c==0){
            if(board[r-1][c].getContent()==-1){
              adjacentCells++;
            }
            if(board[r-1][c+1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r][c+1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r+1][c+1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r][c+1].getContent()==-1){
              adjacentCells++;
            }
            board[r][c].setContent(adjacentCells);
            adjacentCells=0;
          }
          //cells in right column
          else if(c==cols-1){
            if(board[r-1][c].getContent()==-1){
              adjacentCells++;
            }
            if(board[r-1][c-1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r][c-1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r+1][c-1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r+1][c].getContent()==-1){
              adjacentCells++;
            }
            board[r][c].setContent(adjacentCells);
            adjacentCells=0;
          }
          //all other cells
          else {
            if(board[r-1][c].getContent()==-1){
              adjacentCells++;
            }
            if(board[r-1][c+1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r][c+1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r+1][c+1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r+1][c].getContent()==-1){
              adjacentCells++;
            }
            if(board[r+1][c-1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r][c-1].getContent()==-1){
              adjacentCells++;
            }
            if(board[r-1][c-1].getContent()==-1){
              adjacentCells++;
            }
            board[r][c].setContent(adjacentCells);
            adjacentCells=0;
          }
        }
      }
    }
    return board;
  }
}