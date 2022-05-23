package com.flab.baseballgame.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRepository implements Repository {
    private ArrayList<HashMap> list = new ArrayList<>();
    //    private ConcurrentHashMap map = new ConcurrentHashMap();
    private int remainingCount = 10;
    private String answer = "";

    @Override
    public void crete(int roomId, int answer) {
        HashMap map = new HashMap();
        map.put("remainingCount", remainingCount);
        map.put("answer", answer);
        list.add(roomId, map);
    }

    @Override
    public int select(int key) {
        return Integer.parseInt((String) map.get(key));
    }
}
