package com.flab.baseballgame.controller;


import com.flab.baseballgame.controller.dto.Data;
import com.flab.baseballgame.controller.dto.HistoryData;
import com.flab.baseballgame.controller.dto.RemainingCountData;
import com.flab.baseballgame.controller.response.ApiResponse;
import com.flab.baseballgame.service.BaseballService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/game")
public class baseballController {
    private BaseballService service;

    /**
     * //메서드호출흐름확인용
     *
     * @PostMapping(path = "/start2")
     * public String start2() {
     * StackTraceElement[] stack = new Throwable().getStackTrace();
     * for (StackTraceElement stackTraceElement : stack) {
     * System.out.println(stackTraceElement);
     * }
     * return "323";
     * }
     **/

    @PostMapping(path = "/start")
    public ResponseEntity start() {

        Data data = service.roomCreate();
        ApiResponse apiResponse = new ApiResponse(null, data);

        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping(path = "/{id}/answer")
    public ResponseEntity correctAnswer(@PathVariable(name = "id") int roomId, @RequestBody String userAnswer) {
        Data data = service.correctAnswer(roomId, userAnswer);
        ApiResponse apiResponse = new ApiResponse(null, data);
        return ResponseEntity.ok(apiResponse);
    }


    /**
     * ex)
     * "success": true,
     * "data": {
     * "remainingCount": 8,
     * "answerCount": 2
     **/

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> getCount(@PathVariable(name = "id") int roomId) {
        int remainingCount = 0;
        int answerCount = 0;
        RemainingCountData data = new RemainingCountData(remainingCount, answerCount);
        ApiResponse apiResponse = new ApiResponse(null, data);
        return ResponseEntity.ok(apiResponse);
    }

    /**
     * ex)
     * histories: [
     * {
     * "answer": "123",
     * "result": {
     * "strike": 0,
     * "ball": 0,
     * "out": 3
     * }
     * },
     * {
     * "answer": "456",
     * "result": {
     * "strike": 0,
     * "ball": 2,
     * "out": 1
     * }
     **/
    @GetMapping(path = "/{id}/history")
    public ResponseEntity getHistory(@PathVariable(name = "id") int roomId) {
//        HistoryData data = new HistoryData();
        HistoryData data = null;
        ApiResponse apiResponse = new ApiResponse(null, data);
        return ResponseEntity.ok(apiResponse);
    }

}

