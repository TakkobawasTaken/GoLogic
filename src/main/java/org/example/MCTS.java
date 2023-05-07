package org.example;
import org.example.Goban;
import org.example.Intersection;
import org.example.Main;
import org.example.StoneChain;
import score.Island;
import score.Scorer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MCTS {
/*
    private static final double EXPLORATION_CONSTANT = Math.sqrt(2);
    private static final int NUM_SIMULATIONS = 1000;
    private static final int BOARD_SIZE = 19;
    private static final int EMPTY = 0;
    private static final int BLACK = 1;
    private static final int WHITE = 2;
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int[][] copyBoard(int[][] board) {
        int[][] copy = new int[board.length][];

        for (int i = 0; i < board.length; i++) {
            copy[i] = Arrays.copyOf(board[i], board[i].length);
        }

        return copy;
    }

    private static boolean isValidMove(int[][] board, int player, int x, int y) {
        // Check if the specified row and column are within the bounds of the board
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        // Check if the specified position on the board is empty
        if (board[row][col] != 0) {
            return false;
        }

        // The move is valid if it passes all the checks
        return true;
    }

    private static int[][] makeMove(int[][] board, int player, int x, int y) {
        // Set the specified position on the board to the player's value
        board[row][col] = player;
    }

    private static int evaluateBoard(int[][] board, int player) {
        int opponent = -player; // Determine the opponent's player value

        // Check rows for a win
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return 1; // Player wins
            } else if (board[row][0] == opponent && board[row][1] == opponent && board[row][2] == opponent) {
                return -1; // Opponent wins
            }
        }

        // Check columns for a win
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return 1; // Player wins
            } else if (board[0][col] == opponent && board[1][col] == opponent && board[2][col] == opponent) {
                return -1; // Opponent wins
            }
        }

        // Check diagonals for a win
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return 1; // Player wins
        } else if ((board[0][0] == opponent && board[1][1] == opponent && board[2][2] == opponent) ||
                (board[0][2] == opponent && board[1][1] == opponent && board[2][0] == opponent)) {
            return -1; // Opponent wins
        }

        // No winner, the game is a draw
        return 0;
    }

    public static int[] getBestMove(int[][] board, int player) {
        GoNode rootNode = new GoNode(board, player, null);

        for (int i = 0; i < NUM_SIMULATIONS; i++) {
            GoNode node = rootNode;
            int[][] state = copyBoard(board);
        }
            // Selection
            while (!GoNode.getUntriedMoves().isEmpty() && GoNode.isTerminal()) {
                node = node.selectChild();
                state = makeMove(state, node.player, x);
            }

        return new int[0];
    }

 */
}
