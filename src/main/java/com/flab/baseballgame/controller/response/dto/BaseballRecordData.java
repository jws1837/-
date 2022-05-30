package com.flab.baseballgame.controller.response.dto;

import com.flab.baseballgame.domain.Score;

public class BaseballRecordData implements Data {
    private boolean correct;
    private int remainingCount;
    private int strike;
    private int ball;
    private int out;

    public BaseballRecordData() {
    }

    public BaseballRecordData(boolean correct, int remainingCount, Score score) {
        this.correct = correct;
        this.remainingCount = remainingCount;
        this.strike = score.getStrike();
        this.ball = score.getBall();
        this.out = score.getOut();
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getRemainingCount() {
        return remainingCount;
    }

    public void setRemainingCount(int remainingCount) {
        this.remainingCount = remainingCount;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }
}
