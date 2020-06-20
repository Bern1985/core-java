package com.bern.exceptionhandling;

public class PlayerScoreException extends Exception {

    public PlayerScoreException(Exception e) {
        super(e);
    }
}
