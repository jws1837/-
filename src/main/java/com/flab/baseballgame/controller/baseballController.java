package com.flab.baseballgame.controller;


import com.flab.baseballgame.controller.dto.Data;
import com.flab.baseballgame.controller.response.ApiResponse;
import com.flab.baseballgame.repository.Db;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;


@RestController
@RequestMapping("/game")
public class baseballController {
    /**
     * // room id가 발급되고, 중복되지 않는 1-9 사이의 세 숫자가 정답으로 저장이 되어있어야 함
     * >>그러니깐 db에 저장하는식으로 정답이 있어야 겠네.
     * key값이 roomId이고 value가 1-9사이의 3개의 숫자가 저장되어야 겠네.
     * response
     * {
     * "success": true,
     * "data": {
     * "roomId": 123
     * }
     * }
     **/
    private ConcurrentHashMap map = null;

    //메서드호출흐름알려고 잠시 만든 것.


    @PostMapping(path = "/start2")
    public String start2() {
        StackTraceElement[] stack = new Throwable().getStackTrace();
        for (StackTraceElement stackTraceElement : stack) {
            System.out.println(stackTraceElement);
        }
        return "323";
    }

    @PostMapping(path = "/start")
    public ResponseEntity start() {
        Random random = new Random();
        int number = random.nextInt(999);
        for (; ; ) {
            if (number < 100) {
                random.nextInt();
            } else {
                break;
            }
        }

        map = new ConcurrentHashMap();
        Db repo = new Db() {
            @Override
            public void insert(Random key, String value) {
                map.put(key, value);
            }
        };
        repo.insert(random, "별도의랜덤값");

        System.out.println(number);

        Data data = new Data(number);
        ApiResponse apiResponse = new ApiResponse(null, data);
        return ResponseEntity.ok(apiResponse);
    }


    @PostMapping(path = "/{id}/answer")
    public ResponseEntity getInoformation(@PathVariable(name = "id") int id, @RequestBody int answer) throws Exception {
        if (false) {
            throw new Exception();
        }


        ApiResponse apiResponse = new ApiResponse(null, null);
        if (id의 방이없으면, 즉 게임이 종료되었을 때){
            apiResponse = new ApiResponse(false, data, error);
            return ResponseEntity.ok(apiResponse);
        }
        Rule.rule(id, map);


        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(path = "/123")
    //responsebody,responseentity차이.
    public String getInoformation2() {
        return "";
    }


    @GetMapping(path = "/123/history")
    //responsebody,responseentity차이.
    public String getInoformation3() {
        return "";
    }


//success,data,error(optional) 이것은 json으로 반환하는 객체 필요.


}

