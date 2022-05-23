package com.flab.baseballgame.repository;

import java.util.Random;

public interface Repository {
    void crete(int roomId, int answer);

    int select(int key);
}
