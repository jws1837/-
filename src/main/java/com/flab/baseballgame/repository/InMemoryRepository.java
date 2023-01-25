package com.flab.baseballgame.repository;

import com.flab.baseballgame.controller.response.dto.BaseballRecordData;
import com.flab.baseballgame.domain.BaseballGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository implements Repository {
    private final Map<Integer, BaseballGame> map = new HashMap<>();
    private final List<Map<String, Object>> list = new ArrayList<>();

    @Override
    public void crete(int roomId, BaseballGame game) {
        map.put(roomId, new BaseballGame());
    }

    @Override
    public BaseballGame findById(int roomId) {
        BaseballGame game = map.get(roomId);
        return game;
    }

    @Override
    public void save(int roomId, BaseballRecordData data) {
        BaseballGame game = map.get(roomId);
        List<BaseballRecordData> histories = game.getHistories();
        histories.add(data);
        game.setHistories(histories);
    }


}
