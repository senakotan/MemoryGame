/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;

public class Game {

    private Card[][] board;
    private int size;
    private int lives;

    public Game(int size, int lives) {
        this.size = size;
        this.lives = lives;
        initializeBoard();
    }

    private void initializeBoard() {
        board = new Card[size][size];
        List<Character> values = new ArrayList<>();

        char ch = 'A';
        for (int i = 0; i < (size * size) / 2; i++) {
            values.add(ch);
            values.add(ch);
            ch++;
        }

        Collections.shuffle(values);
        Iterator<Character> iterator = values.iterator();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Card(iterator.next());
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🎮 WELCOME TO THE MEMORY GAME!\n");

        while (!isGameOver()) {
            displayBoard();
            System.out.println("Remaining Lives: " + lives);

            int[] first = prompt(scanner, "Enter first card (row col): ");
            board[first[0]][first[1]].setRevealed(true);
            displayBoard();

            int[] second = prompt(scanner, "Enter second card (row col): ");
            board[second[0]][second[1]].setRevealed(true);
            displayBoard();

            if (board[first[0]][first[1]].getValue() != board[second[0]][second[1]].getValue()) {
                System.out.println("❌ Wrong guess!");
                board[first[0]][first[1]].setRevealed(false);
                board[second[0]][second[1]].setRevealed(false);
                lives--;
            } else {
                System.out.println("✅ Good job! Cards match.");
            }

            System.out.println();
        }

        if (lives == 0) {
            System.out.println("💀 Game Over! You ran out of lives.");
        } else {
            System.out.println("🏆 Congratulations! You've completed the game.");
        }
    }

    private int[] prompt(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                if (row >= 0 && row < size && col >= 0 && col < size && !board[row][col].isRevealed()) {
                    return new int[]{row, col};
                }
                System.out.println("Invalid input or already revealed. Try again.");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter two integers.");
                scanner.nextLine(); // clear buffer
            }
        }
    }

    private void displayBoard() {
        System.out.println("\n   " + " ".repeat(2) + " ".join(" ", Collections.nCopies(size, " ")));
        for (int i = 0; i < size; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < size; j++) {
                if (board[i][j].isRevealed()) {
                    System.out.print("[" + board[i][j].getValue() + "]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    private boolean isGameOver() {
        if (lives <= 0) {
            return true;
        }

        for (Card[] row : board) {
            for (Card card : row) {
                if (!card.isRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter board size (even number, e.g., 4): ");
        int size = scanner.nextInt();

        while (size % 2 != 0 || size <= 0) {
            System.out.print("Invalid size. Enter a positive even number: ");
            size = scanner.nextInt();
        }

        System.out.print("Enter number of lives: ");
        int lives = scanner.nextInt();

        Game game = new Game(size, lives);
        game.play();
    }
}
