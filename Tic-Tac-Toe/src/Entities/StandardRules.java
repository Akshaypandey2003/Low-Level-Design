package Entities;

import Enum.Symbol;

public class StandardRules implements Rules {


     @Override
     public boolean isValidMove(Board board,int row, int col) {

        int size = board.getSize();
        return row >= 0 && row < size && col >= 0 && col < size && board.isCellEmpty(row, col);
    }
    @Override
    public boolean checkWin(Board board, Player player) {
        Symbol symbol = player.getSymbol();
        int size = board.getSize();

        // Check rows and columns
        for (int i = 0; i < size; i++) {
            if (checkRow(board, i, symbol) || checkColumn(board, i, symbol)) {
                return true;
            }
        }

        // Check diagonals
        return checkDiagonal(board, symbol);
    }

    private boolean checkRow(Board board, int row, Symbol symbol) {
        for (int col = 0; col < board.getSize(); col++) {
            if (board.getCell(row, col) != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(Board board, int col, Symbol symbol) {
        for (int row = 0; row < board.getSize(); row++) {
            if (board.getCell(row, col) != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(Board board, Symbol symbol) {
        boolean leftToRight = true;
        boolean rightToLeft = true;

        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCell(i, i) != symbol) {
                leftToRight = false;
            }
            if (board.getCell(i, board.getSize() - 1 - i) != symbol) {
                rightToLeft = false;
            }
        }
        return leftToRight || rightToLeft;
    }
    
}
