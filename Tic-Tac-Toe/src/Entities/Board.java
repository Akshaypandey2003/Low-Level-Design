package Entities;

import java.util.Arrays;

import Enum.Symbol;

public class Board {
    
    private Symbol board[][];
    private int size;
    private int movesCount;

    public Board(int size) {
        this.size = size;
        this.board = new Symbol[size][size];
        this.movesCount = 0;
        for(Symbol []row : board)
        {
            Arrays.fill(row, Symbol.EMPTY);
        }
    }

    public int getSize() {
        return size;
    }
    
    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == Symbol.EMPTY;
    }

   

    public void makeMove(int row, int col, Symbol symbol) {
            board[row][col] = symbol;
            movesCount++;
    }

    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull(){
        return movesCount == size*size;
    }

    public int getMovesCount(){
        return movesCount;
    }

    public Symbol getCell(int row, int col) {
        return board[row][col];
    }

    public void resetBoard() {
       for(Symbol []row : board)
        {
            Arrays.fill(row, Symbol.EMPTY);
        }
        movesCount = 0;
    }


}
