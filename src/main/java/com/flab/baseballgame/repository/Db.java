package com.flab.baseballgame.repository;

import java.util.Random;

public interface Db {
    void insert(int key, int value);
    int select(int key);
}
