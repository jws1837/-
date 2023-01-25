package com.flab.baseballgame.controller;


import com.flab.baseballgame.controller.request.Answer;
import com.flab.baseballgame.controller.response.dto.Data;
import com.flab.baseballgame.controller.response.ApiResponse;
import com.flab.baseballgame.service.BaseballService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/game")
public class baseballController {
    private final BaseballService service;

    public baseballController(BaseballService service) {
        this.service = service;
    }

    @PostMapping(path = "/start")
    public ResponseEntity<ApiResponse> start() {
        Data data = service.roomCreate();
        ApiResponse apiResponse = new ApiResponse(null, data);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping(path = "/{id}/answer")
    public ResponseEntity<ApiResponse> guessAnswer(@PathVariable(name = "id") int roomId, @RequestBody Answer userAnswer) {
        Data data = service.guessAnswer(roomId, userAnswer.getAnswer());
        ApiResponse apiResponse = new ApiResponse(null, data);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> getCount(@PathVariable(name = "id") int roomId) {
        Data data = service.getCount(roomId);
        ApiResponse apiResponse = new ApiResponse(null, data);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(path = "/{id}/history")
    public ResponseEntity<ApiResponse> getHistory(@PathVariable(name = "id") int roomId) {
        Data data = service.getHistory(roomId);
        ApiResponse apiResponse = new ApiResponse(null, data);
        return ResponseEntity.ok(apiResponse);
    }

}

