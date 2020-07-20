package com.thoughtworks.basic.RollingBallGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BowlingGame {
    private List<Frame> frames;
    private Frame currentFrame;
    private Frame lastFrame;

    BowlingGame(){
        frames = new ArrayList<>();
    }
    public void roll(int hits) {
        if (currentFrame==null||currentFrame.isEnd()){
            lastFrame=currentFrame;
            currentFrame = new Frame();
            frames.add(currentFrame);
        }
        currentFrame.roll(hits);
        if (!currentFrame.isEnd()&&lastFrame!=null){
            lastFrame.spare(hits);
        }
        if (frames.size()<=10){
            System.out.println(this.showFramesScore());
        }
    }

    public int getScore() {
        if (frames.size()>10){
            frames.remove(10);
        }
        int score = 0;
        for (Frame frame :
                frames) {
            score += frame.getScore();
        }
        return score;
    }

    public boolean isEnd(){
        if (frames.size()==10&&currentFrame.isSpare()){
            return false;
        }
        if (frames.size()>10){
            return true;
        }
        if (currentFrame!=null&&frames.size()>=10&&currentFrame.isEnd()){
            return true;
        }
        return false;
    }
    public String showFramesScore(){
        String result = "";
        for (int i = 0; i < frames.size(); i++) {
            result+=frames.get(i).getScore()+(i==frames.size()-1?"":"|");
        }
        return result;
    }
    public static void main(String[] args) {
        BowlingGame bowlingGame = new BowlingGame();
        Scanner sc = new Scanner(System.in);
        //需求1：
        while (!bowlingGame.isEnd()){
            bowlingGame.roll(1);
        }
        System.out.println("游戏总得分"+bowlingGame.getScore());
        
        //需求2
        BowlingGame bowlingGame2 = new BowlingGame();
        while (!bowlingGame2.isEnd()){
            bowlingGame2.roll(5);
        }
        System.out.println("游戏总得分"+bowlingGame2.getScore());
        sc.close();
    }
}
