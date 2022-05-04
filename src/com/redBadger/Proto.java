package com.redBadger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Proto {
    private static boolean runProgram = true;

    public static void main(String[] args) {
        int maxMarsDimension = 50;
        boolean[][] marsGrid = null;
        int maxInstructionsForRobot = 100;
        boolean scent = false;
        List<Robot> robots = new ArrayList<>();
        // get inputs
        Scanner scanner = new Scanner(System.in);

        int y;
        int x;
        do {
//            try {
                print("Please input the size of the mars grid maximum size is 50 ex: 10 8");
                x = scanner.nextInt();
                y = scanner.nextInt();
                if (x >= maxMarsDimension || y >= maxMarsDimension) {
                    print("Invalid mars grid dimension!!! Let's try again");
                }
        } while (x >= maxMarsDimension && y >= maxMarsDimension);

        marsGrid = new boolean[x][y];
        print("Mars grid of " + x + "X" + y + " is created!");



        while (runProgram) {
            print("Please enter the initial position of the Martian robot");
            x = scanner.nextInt();
            y = scanner.nextInt();
            char orientation = scanner.next().charAt(0);
            print("Please enter the instructions for the  Martian robot");
            String instructions = scanner.next();

            Robot r = new Robot(x, y, orientation, instructions);
            print(r.toString());

            robots.add(r);

            String res = processInstructions(r, marsGrid);

            print("The final position for this robot is");
            print(res);

            print("Please enter yes/no to continue");
            String isContinue = scanner.next();
            if(isContinue.equalsIgnoreCase("no")) {
                runProgram = false;
            }
        }

        print("Thanks for taking your time!!!");
        print("See you later!!!");


    }

    private static String processInstructions(Robot r, boolean[][] marsGrid) {
        char[] commands = r.getInstruction().toCharArray();
        Command c = Command.getInstance();
        for (char ch : commands) {
            boolean isLost = c.processCommand(r.getPosition(), ch, marsGrid);
            print(r.getPosition().toString() + (isLost ? "LOST" : ""));
            if (isLost) {
                r.setLost(true);
                break;
            }
        }
        return r.getPosition().toString();
    }

    private static void print(String s) {
        System.out.println(s);
    }

    private static class Command {
        private final char[] directions = {'N', 'E', 'S', 'W'};
        private final int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0},};
        private final Map<Character, Integer> directionMap;

        private Command() {
            this.directionMap = new HashMap<>();
            directionMap.put('N', 0);
            directionMap.put('E', 1);
            directionMap.put('S', 2);
            directionMap.put('W', 3);
        }

        public static Command getInstance() {
            return new Command();
        }

        public boolean processCommand(Position p, char command, boolean[][] marsGrid) {
            boolean isLost = false;
            int v = directionMap.get(p.getOrientation());
            int nv = v;
            int newX = p.getX();
            int newY = p.getY();
            if (command == 'L') {
                nv = Math.abs((v - 1) % directionMap.size());

            } else if (command == 'R') {
                nv = Math.abs((v + 1) % directionMap.size());
                p.setOrientation(directions[nv]);
            } else if (command == 'F') {
                int[] currentMove = move[v];
                newX = p.getX() + currentMove[0];
                newY = p.getY() + currentMove[1];
            }


            p.setOrientation(directions[nv]);

            if (newX >= marsGrid.length || newY >= marsGrid[0].length) {
                // lost
                marsGrid[p.getX()][p.getY()] = true;
                isLost = true;
            }

            if (newX < marsGrid.length && newY < marsGrid[0].length && !marsGrid[newX][newY]) {
                p.setX(newX);
                p.setY(newY);
            }

            return isLost;
        }

    }
}
