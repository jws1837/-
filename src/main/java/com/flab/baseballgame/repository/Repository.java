package com.flab.baseballgame.repository;

import com.flab.baseballgame.controller.response.dto.BaseballRecordData;
import com.flab.baseballgame.domain.BaseballGame;

public interface Repository {
    void crete(int roomId,BaseballGame game);

    BaseballGame findById(int roomId);

    void save(int id,BaseballRecordData data);
}
