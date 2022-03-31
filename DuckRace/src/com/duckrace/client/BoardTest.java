package com.duckrace.client;

import com.duckrace.Board;
import static com.duckrace.Reward.*;

class BoardTest {
    public static void main(String[] args) {
        Board board = new Board();

        // board.dumpStudentIdMap();

        board.update(8, DEBIT_CARD);
        board.update(8, DEBIT_CARD);
        board.update(12, DEBIT_CARD);
        board.update(1, DEBIT_CARD);
        board.update(12, PRIZES);

        board.show();
    }
}