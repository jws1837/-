package com.flab.baseballgame.repository;

import com.flab.baseballgame.service.Score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRepository implements Repository {
    private ConcurrentHashMap outerMap = new ConcurrentHashMap();
    private int remainingCount = 10;
    private String answer = "";

    @Override
    public void crete(int roomId, int answer) {
        HashMap innerMap = new HashMap();
        innerMap.put("remainingCount", remainingCount);
        innerMap.put("answer", answer);
        outerMap.put(roomId, innerMap);
    }

    @Override
    public String findOrginAnswer(int key) {
        HashMap innerMap = (HashMap) outerMap.get(key);
        String orginAnswer =String.valueOf(innerMap.get("answer"));
        return orginAnswer;
    }

    @Override
    public int findRemainingCount(int roomId) {
        HashMap innerMap = (HashMap) outerMap.get(roomId);
        int remainingCount = (int) innerMap.get("remainingCount");
        return remainingCount;
    }

    @Override
    public void insertHistory(String userAnswer, Score score, int roomId) {
        Map innerMap = (HashMap) outerMap.get(roomId);

        HashMap historyMap = new HashMap();
        historyMap.put("answer", userAnswer);
        historyMap.put("Score", score);

        ArrayList historyList = new ArrayList();
        historyList.add(historyMap);

        innerMap.put("history", historyList);

    }
}
