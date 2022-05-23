package com.flab.baseballgame.service;

import com.flab.baseballgame.controller.dto.BaseballRecordData;
import com.flab.baseballgame.controller.dto.Data;
import com.flab.baseballgame.controller.dto.RemainingCountData;
import com.flab.baseballgame.controller.dto.RoomData;
import com.flab.baseballgame.controller.response.ApiResponse;
import com.flab.baseballgame.repository.Repository;

public class BaseballService {
    private final Repository repository;
    private ApiResponse apiResponse;

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
        Score score = Rule.caculateScore();
        boolean correct = false;
        if (3 == score.getStrike()) {
            correct = true;
        }
        int remainingCount = repository.findRemainingCount(roomId);
        BaseballRecordData data = new BaseballRecordData(correct, remainingCount, score);
        remainingCount--;
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
}
