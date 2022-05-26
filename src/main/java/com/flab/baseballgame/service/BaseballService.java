package com.flab.baseballgame.service;

import com.flab.baseballgame.controller.dto.*;
import com.flab.baseballgame.exceptions.GameEndException;
import com.flab.baseballgame.repository.Repository;

import java.util.List;

public class BaseballService {
    private final Repository repository;

    public BaseballService(Repository repository) {
        this.repository = repository;
    }


    public Data roomCreate() {
        int roomId = Utils.getThreeRandumNumber();
        int answer = Utils.getThreeRandumNumber();
        repository.crete(roomId, answer);

        return new RoomData(roomId);
    }

    public Data correctAnswer(int roomId, String userAnswer) {
        String originAnswer = repository.findOriginAnswer(roomId); //원래 정답.
        return applyRuleAndGetData(originAnswer, userAnswer, roomId);
    }

    private BaseballRecordData applyRuleAndGetData(String originAnswer, String userAnswer, int roomId) {
        int remainingCount = repository.findRemainingCount(roomId);
        boolean correct = repository.findCorrect(roomId);

        if (0 == remainingCount||correct) {
            throw new GameEndException("10번의 기회를 다 소진하거나 정답을 맞혀 게임이 종료되었습니다." );
        }
        remainingCount--;

        Score score = Rule.caculateScore(originAnswer, userAnswer);
        if (3 == score.getStrike()) {
            correct = true;
        }
        repository.insertRemainingCountAndCorrect(roomId, remainingCount, correct);
        BaseballRecordData data = new BaseballRecordData(correct, remainingCount, score);
        repository.insertHistory(userAnswer, score, roomId);

        return data;
    }

    public RemainingCountData getCount(int roomId) {
        int remainingCount = repository.findRemainingCount(roomId);
        int answerCount = 10 - remainingCount;
        return new RemainingCountData(remainingCount, answerCount);
    }

    public HistoryData getHistory(int roomId) {

        List list = repository.findHistory(roomId);
        return new HistoryData(list);
    }
}
