package com.flab.baseballgame.repository;

import com.flab.baseballgame.service.Score;

import java.util.ArrayList;
import java.util.Random;

public interface Repository {
    void crete(int roomId, int answer);

    String findOrginAnswer(int key);

    int findRemainingCount(int roomId);


    void insertHistory(String userAnswer, Score score, int roomId);


    void insertRemainingCount(int roomId, int remainingCount);


    ArrayList findHistory(int roomId);
}
