package com.AoC.Diego.day12;

import java.util.*;

public class PuzzleSolver {

    public boolean canFit(Board board, Map<Shape, Integer> requirements) {
        List<Map.Entry<Shape, Integer>> items = new ArrayList<>(requirements.entrySet());
        return backtrack(board, items, 0);
    }

    private boolean backtrack(Board board,
                              List<Map.Entry<Shape, Integer>> items,
                              int index) {

        if (index == items.size()) return true;

        Shape shape = items.get(index).getKey();
        int count = items.get(index).getValue();

        if (count == 0) {
            return backtrack(board, items, index + 1);
        }

        List<List<Point>> transforms = shape.getTransformations();

        return tryPlace(board, items, index, shape, transforms, count, 0);
    }

    private boolean tryPlace(Board board,
                             List<Map.Entry<Shape, Integer>> items,
                             int index,
                             Shape shape,
                             List<List<Point>> transforms,
                             int remaining,
                             int placed) {

        if (placed == remaining) {
            return backtrack(board, items, index + 1);
        }

        for (List<Point> variant : transforms) {
            for (int y = 0; y < 20; y++) {
                for (int x = 0; x < 20; x++) { // límite simple (defendible)
                    if (board.canPlace(variant, x, y)) {
                        board.place(variant, x, y, true);

                        if (tryPlace(board, items, index, shape, transforms, remaining, placed + 1))
                            return true;

                        board.place(variant, x, y, false);
                    }
                }
            }
        }

        return false;
    }
}