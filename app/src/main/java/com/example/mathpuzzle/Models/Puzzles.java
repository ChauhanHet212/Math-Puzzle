package com.example.mathpuzzle.Models;

public class Puzzles {
    int puzzle;
    long ans;

    public Puzzles(int puzzle, long ans) {
        this.puzzle = puzzle;
        this.ans = ans;
    }

    public int getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(int puzzle) {
        this.puzzle = puzzle;
    }

    public long getAns() {
        return ans;
    }

    public void setAns(long ans) {
        this.ans = ans;
    }
}
