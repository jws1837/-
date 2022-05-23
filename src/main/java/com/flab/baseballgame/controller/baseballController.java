package com.flab.baseballgame.controller;


import com.flab.baseballgame.controller.dto.*;
import com.flab.baseballgame.controller.response.ApiResponse;
import com.flab.baseballgame.repository.Db;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;


@RestController
@RequestMapping("/game")
public class baseballController {

    private ConcurrentHashMap map = null;

    /**
     * //메서드호출흐름확인해볼려고 잠시만든것.
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

        int number = getThreeRandumNumber();

        map = new ConcurrentHashMap();
        Db repo = new Db() {
            @Override
            public void insert(int key, int value) {
                map.put(key, value);
            }

            @Override
            public int select(int key) {
                return 0;
            }
        };
        repo.insert(number, getThreeRandumNumber());


        Data data = new RoomData(number);
        ApiResponse apiResponse = new ApiResponse(null, data);
        return ResponseEntity.ok(apiResponse);
    }

    private int getThreeRandumNumber() {
        int number = new Random().nextInt(999);
        for (; ; ) {
            if (number < 100) {
                number = new Random().nextInt(999);
            } else {
                break;
            }
        }
        return number;
    }

    //data를 추상클래스로 만들어야하나? 인터페이스로?
    @PostMapping(path = "/{id}/answer")
    public ResponseEntity getInformation(@PathVariable(name = "id") int roomId, @RequestBody String answer) {

        System.out.println(0);
        ApiResponse apiResponse = new ApiResponse(null, null);
        if (!(map.keySet().contains(roomId))) {
            System.out.println(1);
            apiResponse = new ApiResponse("false", null);
            apiResponse.setErr(new ApiResponse.Err("CLOSED_GAME", ""));
            return ResponseEntity.ok(apiResponse);
        }
        System.out.println(2);
        BaseballRecordData record = Rule.rule(answer, map, roomId);
        System.out.println(3);
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
 *  histories: [
 *             {
 *                 "answer": "123",
 *                 "result": {
 *                     "strike": 0,
 *                     "ball": 0,
 *                     "out": 3
 *                 }
 *             },
 *             {
 *                 "answer": "456",
 *                 "result": {
 *                     "strike": 0,
 *                     "ball": 2,
 *                     "out": 1
 *                 }
 * **/
    @GetMapping(path = "/{id}/history")
    public ResponseEntity getHistory(@PathVariable(name = "id") int roomId) {
        HistoryData data = new HistoryData();
        ApiResponse apiResponse = new ApiResponse(null,data);
        return ResponseEntity.ok(apiResponse);
    }

}

