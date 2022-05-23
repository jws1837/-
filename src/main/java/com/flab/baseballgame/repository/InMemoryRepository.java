package com.flab.baseballgame.repository;

import java.util.HashMap;
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
        String orginAnswer = (String) innerMap.get("answer");
        return orginAnswer;
    }

    @Override
    public int findRemainingCount(int key) {
        HashMap innerMap = (HashMap) outerMap.get(key);
        int remainingCount = (int) innerMap.get("remainingCount");
        return remainingCount;
    }
}
