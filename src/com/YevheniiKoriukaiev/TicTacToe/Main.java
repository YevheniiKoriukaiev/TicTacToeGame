package com.YevheniiKoriukaiev.TicTacToe;

import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static boolean isGameOver;
    static byte count;
    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };


        while (!isGameOver) {
            printBoard(board);
            doPlayerTurn(board);
            doComputerTurn(board);
        }
    }

    private static void checkDrawConditions(char[][] board){
        if(count == 9){
            isGameOver = true;
            System.out.println("Draw");
        }
    }
    private static void checkWinConditionsX(char[][] board) {
        //Horizontal
        if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') {
            System.out.println(" X won");
            isGameOver = true;
        }
        if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') {
            System.out.println(" X won");
            isGameOver = true;
        }
        if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') {
            System.out.println(" X won");
            isGameOver = true;
        }
        //Vertical
        if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') {
            System.out.println(" X won");
            isGameOver = true;
        }
        if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') {
            System.out.println(" X won");
            isGameOver = true;
        }
        if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') {
            System.out.println(" X won");
            isGameOver = true;
        }
        //Diagonal
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            System.out.println(" X won");
            isGameOver = true;
        }
        if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
            System.out.println(" X won");
            isGameOver = true;
        }
    }

    private static void checkWinConditionsO(char[][] board) {
        //Horizontal
        if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') {
            System.out.println(" O won");
            isGameOver = true;
        }
        if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') {
            System.out.println(" O won");
            isGameOver = true;
        }
        if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') {
            System.out.println(" O won");
            isGameOver = true;
        }
        //Vertical
        if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') {
            System.out.println(" O won");
            isGameOver = true;
        }
        if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') {
            System.out.println(" O won");
            isGameOver = true;
        }
        if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') {
            System.out.println(" O won");
            isGameOver = true;
        }
        //Diagonal
        if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
            System.out.println(" O won");
            isGameOver = true;
        }
        if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
            System.out.println(" O won");
            isGameOver = true;
        }
    }

    private static void doComputerTurn(char[][] board) {
        if (!isGameOver) {
            Random random = new Random();
            int computerMove;
            do {
                computerMove = random.nextInt(9) + 1;
            } while (!isValidMove(board, computerMove));
            placeMove(board, computerMove, 'O');
            printBoard(board);
            count++;
            checkWinConditionsO(board);
            if(!isGameOver){
                checkDrawConditions(board);
            }
        }
    }

    private static void doPlayerTurn(char[][] board) {
        if (!isGameOver) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите координату 1 - 9");
            String userInput = scanner.next();
            while (!isValidMove(board, Integer.parseInt(userInput))) {
                System.out.println("Это наша точка, занято - выберите другую позицию");
                userInput = scanner.next();
            }
            placeMove(board, Integer.parseInt(userInput), 'X');
            printBoard(board);
            count++;
            checkWinConditionsX(board);
            if(!isGameOver){
                checkDrawConditions(board);
            }
        }
//        scanner.close();
    }

    private static void placeMove(char[][] board, int position, char symbol) {
        switch (position) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Еблан, неверная координата, нахуй с пляжа");
        }
    }


    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println();
    }

    private static boolean isValidMove(char[][] board, int position) {
        switch (position) {
            case 1:
                return (board[0][0] == ' ');

            case 2:
                return (board[0][1] == ' ');

            case 3:
                return (board[0][2] == ' ');

            case 4:
                return (board[1][0] == ' ');

            case 5:
                return (board[1][1] == ' ');

            case 6:
                return (board[1][2] == ' ');

            case 7:
                return (board[2][0] == ' ');

            case 8:
                return (board[2][1] == ' ');

            case 9:
                return (board[2][2] == ' ');

            default:
                return false;
        }
    }
}