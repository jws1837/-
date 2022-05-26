package com.flab.baseballgame.controller.response.dto;

public class RoomData implements Data {

    private int roomId;

    public int getRoomId() {
        return roomId;
    }

    public RoomData(int number) {
        this.roomId = number;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

}