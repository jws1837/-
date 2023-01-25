package com.flab.baseballgame.service;


import com.flab.baseballgame.controller.response.dto.*;
import com.flab.baseballgame.domain.BaseballGame;
import com.flab.baseballgame.domain.Utils;
import com.flab.baseballgame.repository.Repository;

import java.util.List;

public class BaseballService {
    private final Repository repository;

    public BaseballService(Repository repository) {
        this.repository = repository;
    }


    public Data roomCreate() {
        int roomId = Utils.getThreeRandomNumber();
        repository.crete(roomId, new BaseballGame());
        return new RoomData(roomId);
    }

    public Data guessAnswer(int roomId, String userAnswer) {
        BaseballGame game = repository.findById(roomId);
        BaseballRecordData data = game.guessAnswer(userAnswer);
        repository.save(roomId, data);
        return data;
    }


    public Data getCount(int roomId) {
        BaseballGame game = repository.findById(roomId);
        int remainingCount = game.getRemainingCount();
        int answerCount = 10 - remainingCount;
        return new RemainingCountData(remainingCount, answerCount);
    }

    public Data getHistory(int roomId) {
        BaseballGame game = repository.findById(roomId);
        List<BaseballRecordData> gameHistories = game.getHistories();
        return new HistoryData(gameHistories);
    }
}
