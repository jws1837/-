package com.flab.baseballgame.controller.dto;

public class HistoryData implements  Data{

    private String answer;
    private Result result;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public HistoryData(String answer, Result result) {
        this.answer = answer;
        this.result = result;
    }

    private class Result {
        private int strike;

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

        public Result(int strike, int ball, int out) {
            this.strike = strike;
            this.ball = ball;
            this.out = out;
        }

        private int ball;
        private int out;
    }
}
