package com.flab.baseballgame.controller;

import com.flab.baseballgame.controller.dto.BaseballRecordData;
import com.flab.baseballgame.repository.Db;
import com.flab.baseballgame.repository.InMemoryRepository;
import com.flab.baseballgame.repository.Repository;

import java.util.concurrent.ConcurrentHashMap;

public class Rule {

    private static boolean correct = false;
    private static int strike;
    private static int ball;
    private static int out;

    public Rule() {
    }

    public static BaseballRecordData rule(String requestNumber, ConcurrentHashMap map, int roomId) {
        Repository repository = new InMemoryRepository();
        repository.select(requestNumber);
//        char[] target = Character.toChars(requestNumber);
//        char[] source = Character.toChars(db.select(requestNumber));

        strike = caculateStrike();
        if (strike == 3) {
            correct = true;
        }
        ball = caculateBall();
        out = caculateOut();

        int remainingCount = 0;
        BaseballRecordData data = new BaseballRecordData(true, remainingCount, strike, ball, out);
        map.put(343, data);
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
