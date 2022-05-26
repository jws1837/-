package com.flab.baseballgame.exceptions;

public class GameEndException extends RuntimeException {
    private static final long serialVersionUID = 6644861982372096636L;

    public GameEndException() {
        super();
    }

    public GameEndException(String s) {
        super(s);
    }

}
