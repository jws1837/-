package com.flab.baseballgame.domain;

//Todo: 의존성 방향 점검 필요.

import com.flab.baseballgame.controller.response.dto.BaseballRecordData;
import com.flab.baseballgame.exceptions.GameEndException;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private String answer;
    private State state;
    private int answerCount;
    private int remainingCount;

    private List<BaseballRecordData> histories = new ArrayList<>();

    public BaseballGame() {
        this.answer = Utils.getNotDuplicationRandomNumber();
        this.state = State.STARTED;
        this.answerCount = 0;
        this.remainingCount = 10;
    }

    public void setHistories(List<BaseballRecordData> histories) {
        this.histories = histories;
    }

    public BaseballRecordData guessAnswer(String guess) {
        if (this.remainingCount <= 0 || State.STARTED != this.state) {
            throw new GameEndException("Game is closed");
        }

        this.remainingCount--;
        this.answerCount++;

        Score score = Rule.caculateScore(this.answer, guess);
        if (3 == score.getStrike()) {
            this.state = State.CORRECT;
        }
        return new BaseballRecordData(
                this.state == State.STARTED,
                this.remainingCount,
                score
        );
    }

    private enum State {
        STARTED,
        CORRECT,
        CLOSED
    }

    public String getAnswer() {
        return answer;
    }

    public State getState() {
        return state;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public int getRemainingCount() {
        return remainingCount;
    }

    public List<BaseballRecordData> getHistories() {
        return histories;
    }


}
