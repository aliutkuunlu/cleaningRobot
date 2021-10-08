package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] R = {"...X..", "....XX", "..X..."};
        System.out.println(solution(R));
    }

    public static int solution(String[] R) {
        List<String> room = new ArrayList<>(Arrays.asList(R));
        int rowSize = room.size();
        int columnSize = R[0].length();
        List<List<Boolean>> cleanCheckMap = new ArrayList<>();
        for (int i = 0; i < rowSize; i++) {
            List<Boolean> rowCheck = new ArrayList<>();
            for (int j = 0; j < columnSize; j++) {
                rowCheck.add(Boolean.FALSE);
            }
            cleanCheckMap.add(rowCheck);
        }

        int x = 0;
        int y = 0;
        int cleanCount = 0;
        return moveRight(y, columnSize, x, rowSize, cleanCount, cleanCheckMap, room);
    }

    public static boolean isClean(int x, int y, List<List<Boolean>> cleanCheckMap, int rowSize, int columnSize) {
        if (x < 0 || y < 0 || x >= rowSize || y >= columnSize) {
            return false;
        }
        return cleanCheckMap.get(x).get(y);
    }

    public static int moveRight(int y, int columnSize, int x, int rowSize, int cleanCount, List<List<Boolean>> cleanCheckMap, List<String> room) {
        boolean shift = false;
        if (y == columnSize) {
            y = columnSize - 1;
            shift = true;
        }
        if (isClean(x, y + 1, cleanCheckMap, rowSize, columnSize)) {
            return cleanCount;
        }
        if (shift) {
            return moveDown(y, columnSize, x, rowSize, cleanCount, cleanCheckMap, room);
        } else {
            if (y < columnSize - 1 && room.get(x).charAt(y + 1) == 'X') {
                return moveDown(y, columnSize, x, rowSize, cleanCount, cleanCheckMap, room);
            } else {
                if (!isClean(x, y, cleanCheckMap, rowSize, columnSize)) {
                    cleanCheckMap.get(x).set(y, Boolean.TRUE);
                    cleanCount++;
                }
                y++;
                return moveRight(y, columnSize, x, rowSize, cleanCount, cleanCheckMap, room);
            }
        }
    }

    public static int moveDown(int y, int columnSize, int x, int rowSize, int cleanCount, List<List<Boolean>> cleanCheckMap, List<String> room) {
        boolean shift = false;
        if (x == rowSize) {
            x = rowSize - 1;
            shift = true;
        }
        if (isClean(x + 1, y, cleanCheckMap, rowSize, columnSize)) {
            return cleanCount;
        }
        if (shift) {
            return moveLeft(y, columnSize, x, rowSize, cleanCount, cleanCheckMap, room);
        } else {
            if (x < rowSize - 1 && room.get(x + 1).charAt(y) == 'X') {
                return moveLeft(y, columnSize, x, rowSize, cleanCount, cleanCheckMap, room);
            } else {
                if (!isClean(x, y, cleanCheckMap, rowSize, columnSize)) {
                    cleanCheckMap.get(x).set(y, Boolean.TRUE);
                    cleanCount++;
                }
                x++;
                return moveDown(y, columnSize, x, rowSize, cleanCount, cleanCheckMap, room);
            }
        }
    }

    public static int moveLeft(int y, int columnSize, int x, int rowSize, int cleanCount, List<List<Boolean>> cleanCheckMap, List<String> room) {
        boolean shift = false;
        if (y == -1) {
            y = 0;
            shift = true;
        }
        if (isClean(x, y - 1, cleanCheckMap, rowSize, columnSize)) {
            return cleanCount;
        }
        if (shift) {
            return moveTop(y, columnSize, x, rowSize, cleanCount, cleanCheckMap, room);
        } else {
            if (y > 0 && room.get(x).charAt(y - 1) == 'X') {
                return moveTop(y, columnSize, x, rowSize, cleanCount, cleanCheckMap, room);
            } else {
                if (!isClean(x, y, cleanCheckMap, rowSize, columnSize)) {
                    cleanCheckMap.get(x).set(y, Boolean.TRUE);
                    cleanCount++;
                }
                y--;
                return moveLeft(y, columnSize, x, rowSize, cleanCount, cleanCheckMap, room);
            }

        }
    }

    public static int moveTop(int y, int columnSize, int x, int rowSize, int cleanCount, List<List<Boolean>> cleanCheckMap, List<String> room) {
        boolean shift = false;
        if (x == -1) {
            x = 0;
            shift = true;
        }
        if (isClean(x - 1, y, cleanCheckMap, rowSize, columnSize)) {
            return cleanCount;
        }
        if (shift) {
            return moveRight(y, columnSize, x, rowSize, cleanCount, cleanCheckMap, room);
        } else {
            if (x > 0 && room.get(x - 1).charAt(y) == 'X') {
                return moveRight(y, columnSize, x, rowSize, cleanCount, cleanCheckMap, room);
            } else {
                if (!isClean(x, y, cleanCheckMap, rowSize, columnSize)) {
                    cleanCheckMap.get(x).set(y, Boolean.TRUE);
                    cleanCount++;
                }
                x--;
                return moveTop(y, columnSize, x, rowSize, cleanCount, cleanCheckMap, room);
            }
        }
    }
}
