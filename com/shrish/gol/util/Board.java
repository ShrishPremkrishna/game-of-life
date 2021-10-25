package com.shrish.gol.util;

public class Board
{
  private int live = 1;
  private int dead = 0;
  private int[][] array;
  private int size;

  public Board(int[][] startBoard)
  {
    this.array = startBoard;
    this.size = this.array.length;
  }
 
  public void printBoard()
  {
    for(int i=0; i<size; i++)
    {
      for(int j=0; j<size; j++)
      {
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }
  }

  public void next()
  {
    int[][] liveNeighbors = computeLiveNeighbors();
    this.array = computeNextBoard(liveNeighbors);
  }

  public int[][] computeLiveNeighbors() 
  {
    int[][] liveNeighborsArray = new int[size][size];
    for(int i=0; i<size; i++)
    {
      for(int j=0; j<size; j++)
      {
        // Count Live Neighbors
        int liveNeighbors = 0;

        // North array[i-1][j]
        if(i != 0 && array[i-1][j] == 1)
        {
          liveNeighbors++;
        }
        // South array[i+1][j]
        if(i != this.size-1 && array[i+1][j] == 1)
        {
          liveNeighbors++;
        }
        // East array[i][j+1]
        if(j != this.size-1 && array[i][j+1] == 1)
        {
          liveNeighbors++;
        }
        // West array[i][j-1]
        if(j != 0 && array[i][j-1] == 1)
        {
          liveNeighbors++;
        }
        // North-East array[i-1][j+1]
        if(j != this.size-1 && i != 0 &&array[i-1][j+1] == 1)
        {
          liveNeighbors++;
        }
        // North-West array[i-1][j-1]
        if(j != 0 && i != 0 && array[i-1][j-1] == 1)
        {
          liveNeighbors++;
        }
        // South-East array[i+1][j+1]
        if(j != this.size-1 && i != this.size-1 && array[i+1][j+1] == 1)
        {
          liveNeighbors++;
        }
        // South-West array[i+1][j-1]
        if(i != this.size-1 && j != 0 && array[i+1][j-1] == 1)
        {
          liveNeighbors++;
        }
        liveNeighborsArray[i][j] = liveNeighbors;
      }
    }
    return liveNeighborsArray;
  }
  
  public int[][] computeNextBoard(int[][] neighborsArray)
  {
    int[][] liveArray = new int[size][size];
    for(int i=0; i<size; i++)
    {
      for(int j=0; j<size; j++)
      {
        int current = this.array[i][j];
        if(current == 1)
        {
          // if current cell is live  
          if(neighborsArray[i][j] == 2 || neighborsArray[i][j] == 3 )
          {
            liveArray[i][j] = 1;
          }
        }
        else
        {
          // if current cell is dead
          if(neighborsArray[i][j] == 3)
          {
            liveArray[i][j] = 1;
          }
        }
      }
    }
    return liveArray;
  }
}

