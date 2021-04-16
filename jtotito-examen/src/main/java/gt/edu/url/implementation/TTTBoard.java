package gt.edu.url.implementation;

import gt.edu.url.adapter.Board;
import gt.edu.url.adapter.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TTTBoard implements Board<Integer> {
    private static final int NUM_SQUARES = 9;
    private TTTPiece[] position;
    private TTTPiece turn;

    public TTTBoard(TTTPiece[] position, TTTPiece turn) {
        // TODO implement constructor
        this.position = position;
        this.turn = turn;
        // throw new UnsupportedOperationException("To be implemented");
    }

    public TTTBoard() {
        position = new TTTPiece[NUM_SQUARES];
        Arrays.fill(position, TTTPiece.E);
        turn = TTTPiece.X;
    }

    @Override
    public Piece getTurn() {
        return turn;
    }

    @Override
    public TTTBoard move(Integer location) {
        TTTPiece[] tempPosition = Arrays.copyOf(position, position.length);
        tempPosition[location] = turn;
        return new TTTBoard(tempPosition, (TTTPiece) turn.opposite());
    }

    @Override
    public List<Integer> getLegalMoves() {
        var legalMoves = new ArrayList<Integer>();
        // TODO implement legal movements
        var cont = 0;
		for (var cell : position) 
        { 
            if(cell.toString() == " "){
                legalMoves.add(cont);
            }
            cont++;
        }

        return legalMoves;
    }

    @Override
    public boolean isWin() {
        return
                checkPos(0, 1, 2) || checkPos(3, 4, 5) || checkPos(6, 7, 8)
                        || checkPos(0, 3, 6) || checkPos(1, 4, 7) || checkPos(2, 5, 8)
                        || checkPos(0, 4, 8) || checkPos(2, 4, 6);
    }
    private boolean checkPos(int p0, int p1, int p2) {
        // TODO implement method
        boolean check = false;
        if(position[p0].toString().equals(position[p1].toString()) && position[p1].toString().equals(position[p2].toString()) && position[p2].toString().equals(position[p0].toString())){

        if(position[p0].toString() == " "){
            check = false;
            // return false;
        }
        else{
            check = true;
            // return true;
        }

        }

        return check;
    }

    @Override
    public double evaluate(Piece player) {
        if (isWin() && turn == player) {
            return -1;
        } else if (isWin() && turn != player) {
            return 1;
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sb.append(position[row * 3 + col].toString());
                if (col != 2) {
                    sb.append("|");
                }
            }
            sb.append(System.lineSeparator());
            if (row != 2) {
                sb.append("-----");
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

}
