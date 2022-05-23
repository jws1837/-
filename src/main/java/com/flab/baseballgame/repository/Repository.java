package com.flab.baseballgame.repository;

import java.util.Random;

public interface Repository {
    void crete(int roomId, int answer);

    String findOrginAnswer(int key);


    int findRemainingCount(int key);
}
