package com.galvanize.collecties.collectie.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPlayback extends Random {
    private List<Integer> genratedValues = new ArrayList<>();
    private List<Integer> sequence = new ArrayList<>();
    private int nextValue;

    public int nextInt() {
        int result;
        if(nextValue < sequence.size()) {
            result = sequence.get(nextValue++);
        } else {
            result = super.nextInt();
        }
        genratedValues.add(result);
        return result;
    }

    public int nextInt(int bound) {
        int result;
        if(nextValue < sequence.size()) {
            result = sequence.get(nextValue++);
        } else {
            result = super.nextInt(bound);
        }
        genratedValues.add(result);
        return result;
    }

    public String getGeneratedValues() {
        return genratedValues.toString();
    }

    public void setSequence(List<Integer> sequence) {
        this.sequence = new ArrayList<>(sequence);
    }
}
