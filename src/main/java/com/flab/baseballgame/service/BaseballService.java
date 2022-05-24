package com.flab.baseballgame.service;

import com.flab.baseballgame.controller.dto.*;
import com.flab.baseballgame.controller.response.ApiResponse;
import com.flab.baseballgame.repository.Repository;

import java.util.ArrayList;

public class BaseballService {
    private final Repository repository;

    public BaseballService(Repository repository) {
        this.repository = repository;
    }


    public Data roomCreate() {
        int roomId = Utils.getThreeRandumNumber();
        int answer = Utils.getThreeRandumNumber();

        repository.crete(roomId, answer);

        Data data = new RoomData(roomId);
        return data;
    }

    public Data correctAnswer(int roomId, String userAnswer) {
        String originAnswer = repository.findOrginAnswer(roomId); //원래 정답.
        BaseballRecordData data = applyRuleAndGetData(originAnswer, userAnswer, roomId);
        return data;
    }

    private BaseballRecordData applyRuleAndGetData(String originAnswer, String userAnswer, int roomId) {
        Score score = Rule.caculateScore(originAnswer, userAnswer);
        boolean correct = false;
        if (3 == score.getStrike()) {
            correct = true;
        }
        int remainingCount = repository.findRemainingCount(roomId);
        remainingCount--;
        repository.insertRemainingCount(roomId, remainingCount);
        BaseballRecordData data = new BaseballRecordData(correct, remainingCount, score);
        repository.insertHistory(userAnswer, score, roomId);
        return data;
    }


    //예외로 만들어버리기 .
    private ApiResponse notExistIdResponse() {
        ApiResponse apiResponse = new ApiResponse("false", null);
        apiResponse.setErr(new ApiResponse.Err("CLOSED_GAME", ""));
        return apiResponse;
    }


    public RemainingCountData getCount(int roomId) {
        int remainingCount = repository.findRemainingCount(roomId);
        int answerCount = 10 - remainingCount;
        RemainingCountData data = new RemainingCountData(remainingCount, answerCount);
        return data;
    }

    public HistoryData getHistory(int roomId) {

        ArrayList list = repository.findHistory(roomId);
        HistoryData data = new HistoryData(list);
        return data;

    }
}
