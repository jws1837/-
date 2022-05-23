package com.flab.baseballgame.service;

import com.flab.baseballgame.controller.dto.BaseballRecordData;
import com.flab.baseballgame.controller.dto.Data;
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
        BaseballRecordData data = applyRuleAndGetData(originAnswer,userAnswer);
        return data;
    }

    private BaseballRecordData applyRuleAndGetData(String originAnswer, String userAnswer) {
        int strike = Rule.caculateStrike();
        boolean correct= false;
        if (strike == 3) {
            correct = true;
        }
        int ball = Rule.caculateBall();
        int out = Rule.caculateOut();
        int remainingCount = repository.findRemainingCount();
        BaseballRecordData data = new BaseballRecordData(true, remainingCount, strike, ball, out);
//        map.put(343, data);
        return data;
    }

    private static int caculateOut() {
        return 2;
    }

    private static int caculateBall() {
        return 1;
    }

    private static int caculateStrike() {
        return 0;
    }
    }


            private ApiResponse notExistIdResponse() {
                                    ApiResponse apiResponse = new ApiResponse("false", null);
                                    apiResponse.setErr(new ApiResponse.Err("CLOSED_GAME", ""));
                                    return apiResponse;
                                }

}
