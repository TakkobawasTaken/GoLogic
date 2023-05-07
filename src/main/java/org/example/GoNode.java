package org.example;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GoNode {
/*
    Intersection board;
    Player player;
    int visits;
    double score;
    List<GoNode> children;
    GoNode parent;
    private static final double EXPLORATION_CONSTANT = Math.sqrt(2);
    private int visitsN;
    private double wins;


    public GoNode(Intersection board, Player player, GoNode parent) {
        this.board = board;
        this.player = player;
        this.visits = 0;
        this.score = 0;
        this.children = new ArrayList<>();
        this.parent = parent;
    }

    public boolean isTerminal() {
        return successivePassCount >= 2;
    }

    public List<GoNode> getUntriedMoves() {
        List<Move> untriedMoves = new ArrayList<>();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Move move = new Move(row, col);
                if (isValidMove(move) && !triedMoves.contains(move)) {
                    untriedMoves.add(move);
                }
            }
        }

        return untriedMoves;
    }

    public double calculateUcb1(Node node) {
        double exploitation = GoNode.wins / GoNode.visitsN;
        double exploration = Math.sqrt(Math.log(visits) / node.visitsN);
        return exploitation + EXPLORATION_CONSTANT * exploration;
    }
    public GoNode selectChild() {
        Node selectedChild = null;
        double bestUcb1 = Double.NEGATIVE_INFINITY;

        for (Node child : children) {
            double ucb1 = calculateUcb1(child);
            if (ucb1 > bestUcb1) {
                bestUcb1 = ucb1;
                selectedChild = child;
            }
        }

        return selectedChild;
    }

    public void expand() {
        List<Move> untriedMoves = getUntriedMoves();

        if (!untriedMoves.isEmpty()) {
            Move move = selectRandomMove(untriedMoves);
            Node child = createChildNode(move);
            children.add(child);
            return child;
        }

        return null; // No untried moves, cannot expand
    }

    private Move selectRandomMove(List<Move> moves) {
        Random random = new Random();
        int index = random.nextInt(moves.size());
        return moves.get(index);
    }

    private Node createChildNode(Move move) {
        Node child = new Node(move);  // Assuming a constructor that takes the move as an argument
        child.setParent(this);
        return child;
    }
    public double simulate() {
        // Perform a random simulation of the game and return the result
        // You can modify this code to fit your specific simulation logic

        GameState currentState = gameState.clone();  // Assuming a method to clone the current game state

        while (!currentState.isTerminal()) {
            List<Move> possibleMoves = currentState.getAvailableMoves();
            int randomIndex = (int) (Math.random() * possibleMoves.size());
            Move randomMove = possibleMoves.get(randomIndex);
            currentState.makeMove(randomMove);
        }

        return currentState.getWinner();  // Assuming a method to get the winner of the game

    }

    public void update(double score) {
        // Update the node's statistics based on the result of the simulation
        // specific update logic

        visits++;
        wins += result;
    }

    public GoNode getBestChild() {
        Node bestChild = null;
        double bestUCT = Double.NEGATIVE_INFINITY;

        for (Node child : children) {
            double childUCT = calculateUCT(child);

            if (childUCT > bestUCT) {
                bestUCT = childUCT;
                bestChild = child;
            }
        }

        return bestChild;
    }

    private double calculateUCT(Node node) {
        // Calculate the UCT (Upper Confidence Bound for Trees) value for a node
        // specific UCT calculation logic

        double explorationFactor = 1.0; // Adjust this value as needed

        double uctValue = node.getWins() / (double) node.getVisits()
                + explorationFactor * Math.sqrt(Math.log(this.getVisits()) / (double) node.getVisits());

        return uctValue;
    }

*/
}
