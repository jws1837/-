package com.flab.baseballgame.service;

import com.flab.baseballgame.controller.dto.Data;
import com.flab.baseballgame.controller.dto.RoomData;
import com.flab.baseballgame.repository.InMemoryRepository;
import com.flab.baseballgame.repository.Repository;

public class BaseballService {
    public Data roomCreate() {
        int roomId = Utils.getThreeRandumNumber();
        int answer = Utils.getThreeRandumNumber();

        Repository repository = new InMemoryRepository();
        repository.crete(roomId, answer);

        Data data = new RoomData(roomId);
        return data;
    }
}
