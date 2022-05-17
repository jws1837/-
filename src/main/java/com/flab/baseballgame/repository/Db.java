package com.flab.baseballgame.repository;

import java.util.Random;

public interface Db {
    void insert(Random key, String value);
    int select(int key);
}
