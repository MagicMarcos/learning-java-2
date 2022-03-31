package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;
import static com.duckrace.Reward.*;


import java.util.Scanner;

/**
 * This is the application "controller"
 * It directs the overall flow of the application
 * It interacts with the user prompts and send those responses into the system "Model"
 */
public class DuckRaceApp {
    private Board board = Board.getInstance();
    private Scanner scanner = new Scanner(System.in);

    /*
     * Directs the high-level application flow
     */
    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward= promptForReward();
        updateBoard(id, reward);
        showBoard(); // this is the updated board, with new winner info in thereR
    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private Reward promptForReward() {
        Reward reward = null;

        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().toUpperCase(); // standardizes input as uppercase
            if (input.matches("P|D")) {
                validInput = true;

                reward = "D".equals(input) ? DEBIT_CARD : PRIZES;
            }
        }
        return reward;
    }

    private int promptForId() {
        int id = 0;

        boolean validInput = false;
        while(!validInput) {
            System.out.print("Please enter id of the winner [1-22]");
            String input = scanner.nextLine();
            if (input.matches("\\d{1,2}")) { // any digit, one or two times
                id = Integer.parseInt(input);
                if (id >=1 && id <= 22) {
                    validInput = true;
                }
            }
        }

        return id;
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("\n\n");
        System.out.println("W E L C O M E  T O  T H E  D U C K R A C E  A P P L I C A T I O N");
        System.out.println("\n\n");
    }
}