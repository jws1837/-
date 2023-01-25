package com.flab.baseballgame.controller.response.dto;

public class RemainingCountData implements Data {
    private int remainingCount;
    private int answerCount;

    public RemainingCountData(int remainingCount, int answerCount) {
        this.remainingCount = remainingCount;
        this.answerCount = answerCount;
    }

    public int getRemainingCount() {
        return remainingCount;
    }

    public void setRemainingCount(int remainingCount) {
        this.remainingCount = remainingCount;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }
}
