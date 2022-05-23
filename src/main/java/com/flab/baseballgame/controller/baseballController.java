package com.flab.baseballgame.controller;


import com.flab.baseballgame.controller.dto.BaseballRecordData;
import com.flab.baseballgame.controller.dto.Data;
import com.flab.baseballgame.controller.dto.HistoryData;
import com.flab.baseballgame.controller.dto.RemainingCountData;
import com.flab.baseballgame.controller.response.ApiResponse;
import com.flab.baseballgame.service.BaseballService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;


@RestController
@RequestMapping("/game")
public class baseballController {

    private ConcurrentHashMap map = null;
    private ArrayList list = null;

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

        BaseballService service = new BaseballService();
        Data data = service.roomCreate();
        ApiResponse apiResponse = new ApiResponse(null, data);

        return ResponseEntity.ok(apiResponse);
    }

    //data를 추상클래스로 만들어야하나? 인터페이스로?
    @PostMapping(path = "/{id}/answer")
    public ResponseEntity getInformation(@PathVariable(name = "id") int roomId, @RequestBody String answer) {

        ApiResponse apiResponse = new ApiResponse(null, null);
        if (!(map.keySet().contains(roomId))) {
            System.out.println(1);
            apiResponse = new ApiResponse("false", null);
            apiResponse.setErr(new ApiResponse.Err("CLOSED_GAME", ""));
            return ResponseEntity.ok(apiResponse);
        }
        BaseballRecordData record = Rule.rule(answer, map, roomId);
        apiResponse = new ApiResponse(null, record);
        return ResponseEntity.ok(apiResponse);
    }


    /**
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
        HistoryData data = new HistoryData();
        ApiResponse apiResponse = new ApiResponse(null, data);
        return ResponseEntity.ok(apiResponse);
    }

}

