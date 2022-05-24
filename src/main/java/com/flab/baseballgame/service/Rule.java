package com.flab.baseballgame.service;

public class Rule {

    public static Score caculateScore(String originAnswer, String userAnswer) {

        int totalcount = 3;
        int strikeCount = getStrikeCount(originAnswer, userAnswer);
        int ballCount = getBallCount(originAnswer, userAnswer);
        int outCount = totalcount - strikeCount - ballCount;

        return new Score(strikeCount, ballCount, outCount);
    }

    private static int getBallCount(String originAnswer, String userAnswer) {
        int ballCount = 0;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (originAnswer.charAt(k) == userAnswer.charAt(l)) {
                    if (k != l)
                        ballCount++;
                }
            }
        }
        return ballCount;
    }

    private static int getStrikeCount(String originAnswer, String userAnswer) {
        int strikeCount = 0;
        for (int j = 0; j < 3; j++) {
            if (originAnswer.charAt(j) == userAnswer.charAt(j)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
