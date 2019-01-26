package com.makesrc.common.util;

//Class declared final so it cannot be extended
public final class RandomGenerator {

    //Private constructor to prevent instantiation
    //Static calls, so no reason to use excess heap memory
    private RandomGenerator() {

    }

    public static int generateRandomValue(int lowerBound, int upperBound) {
        // Do error checking for valid values
        if (upperBound < lowerBound)
            return 0;
        if (upperBound == lowerBound)
            return lowerBound;
        return (lowerBound + (int) (Math.random() * (upperBound - lowerBound + 1)));
    }

    public static void main(String args[]) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("usage: test lowerbound upperBound <repetition>");
            return;
        }
        int lowerBound = Integer.parseInt(args[0]);
        int upperBound = Integer.parseInt(args[1]);
        int repetition = 13;
        if (args.length == 3)
            repetition = Integer.parseInt(args[2]);
        for (int i = 0; i < repetition; i++) {
            System.out.println("Random number " + i + " = " +
                    generateRandomValue(lowerBound, upperBound));
        }
    }
}