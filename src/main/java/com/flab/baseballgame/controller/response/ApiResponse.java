package com.flab.baseballgame.controller.response;

import com.flab.baseballgame.controller.response.dto.Data;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class ApiResponse {
    private String success;
    private Data data;

    public ApiResponse(@Nullable String success, Data data) {

        this.success = Optional.ofNullable(success).orElse("true");
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public Data getData() {
        return data;
    }



}

