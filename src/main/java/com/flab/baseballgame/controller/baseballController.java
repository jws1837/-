package com.flab.baseballgame.controller;


import com.flab.baseballgame.controller.dto.Data;
import com.flab.baseballgame.controller.dto.HistoryData;
import com.flab.baseballgame.controller.dto.RemainingCountData;
import com.flab.baseballgame.controller.response.ApiResponse;
import com.flab.baseballgame.service.BaseballService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/game")
public class baseballController {
    private final BaseballService service;

    public baseballController(BaseballService service) {
        this.service = service;
    }

    @PostMapping(path = "/start")
    public ResponseEntity start() {
        Data data = service.roomCreate();
        ApiResponse apiResponse = new ApiResponse(null, data);

        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping(path = "/{id}/answer")
    public ResponseEntity correctAnswer(@PathVariable(name = "id") int roomId, @RequestBody Map userAnswer) {
        String answer = (String) userAnswer.get("answer");
        Data data = service.correctAnswer(roomId, answer);
        ApiResponse apiResponse = new ApiResponse(null, data);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> getCount(@PathVariable(name = "id") int roomId) {
        RemainingCountData data = service.getCount(roomId);
        ApiResponse apiResponse = new ApiResponse(null, data);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(path = "/{id}/history")
    public ResponseEntity getHistory(@PathVariable(name = "id") int roomId) {

        HistoryData data = service.getHistory(roomId);
        ApiResponse apiResponse = new ApiResponse(null, data);

        return ResponseEntity.ok(apiResponse);
    }

}

