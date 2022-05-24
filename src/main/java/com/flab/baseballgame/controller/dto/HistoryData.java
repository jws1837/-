package com.flab.baseballgame.controller.dto;

import java.util.List;

public class HistoryData implements Data {
    private List histories;

    public List getHistories() {
        return histories;
    }

    public void setHistories(List histories) {
        this.histories = histories;
    }

    public HistoryData(List histories) {
        this.histories = histories;
    }
}
