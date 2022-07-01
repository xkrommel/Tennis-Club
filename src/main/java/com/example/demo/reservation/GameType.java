package com.example.demo.reservation;

/**
 * @author Karolina Krommelova
 *
 * Enum which consists of game-types and values to multiply the price with.
 */
public enum GameType {
    SINGLES(1), DOUBLES(1.5);

    private final double numVal;

    GameType(double numVal) {
        this.numVal = numVal;
    }

    public double getNumVal() {
        return numVal;
    }
}
