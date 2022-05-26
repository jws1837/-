package com.flab.baseballgame.repository;

import com.flab.baseballgame.service.Score;

import java.util.List;

public interface Repository {
    void crete(int roomId, int answer);

    int findOriginAnswer(int key);

    int findRemainingCount(int roomId);


    void insertHistory(String userAnswer, Score score, int roomId);


    void insertRemainingCountAndCorrect(int roomId, int remainingCount, boolean correct);


    List findHistory(int roomId);

    boolean findCorrect(int roomId);
}
