package com.flab.baseballgame.repository;

import com.flab.baseballgame.service.Score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository implements Repository {
    private final Map<Integer, Map<String, Object>> outerMap = new HashMap<>();
    private final List<Map<String, Object>> list = new ArrayList<>();

    @Override
    public void crete(int roomId, int answer) {
        Map<String, Object> innerMap = new HashMap<>();
        int remainingCount = 10;
        innerMap.put("remainingCount", remainingCount);
        innerMap.put("answer", answer);
        innerMap.put("correct", false);
        outerMap.put(roomId, innerMap);
    }

    @Override
    public String findOriginAnswer(int key) {
        Map<String, Object> innerMap = outerMap.get(key);
//        return String.valueOf(innerMap.get("answer"));
        return (String) innerMap.get("answer");
    }

    @Override
    public int findRemainingCount(int roomId) {
        Map<String, Object> innerMap = outerMap.get(roomId);
        return (int) innerMap.get("remainingCount");
    }

    @Override
    public void insertHistory(String userAnswer, Score score, int roomId) {
        Map<String,Object> innerMap = outerMap.get(roomId);

        Map<String,Object> historyMap = new HashMap<>();
        historyMap.put("result", score);
        historyMap.put("answer", userAnswer);

        list.add(historyMap);

        innerMap.put("history", list);

    }

    @Override
    public void insertRemainingCountAndCorrect(int roomId, int remainingCount, boolean correct) {
        Map<String,Object> innerMap =  outerMap.get(roomId);
        innerMap.put("remainingCount", remainingCount);
        innerMap.put("correct", correct);
        outerMap.put(roomId, innerMap);

    }

    @Override
    public List findHistory(int roomId) {
        Map<String,Object> innerMap = outerMap.get(roomId);
        List list =  (ArrayList)innerMap.get("history");
        return list;
    }

    @Override
    public boolean findCorrect(int roomId) {
        Map<String,Object> innerMap =  outerMap.get(roomId);
        return (boolean) innerMap.get("correct");
    }
}
