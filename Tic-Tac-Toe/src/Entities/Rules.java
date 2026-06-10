package Entities;

public interface Rules {
    public boolean checkWin(Board board, Player player) ;
    public boolean isValidMove(Board board,int row, int col);
}