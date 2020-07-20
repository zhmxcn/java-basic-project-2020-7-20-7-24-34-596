package com.thoughtworks.basic.RollingBallGame;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private List<Integer> rolls;
    Frame(){
        rolls = new ArrayList<>();
    }

    public int getScore() {
        int score = 0;
        for (Integer rool:
             rolls) {
            score+=rool;
        }
        return score;
    }

    public void roll(int hits) {
        rolls.add(hits);
    }

    public boolean isEnd() {
        if (rolls.size()==2) return true;
        return false;
    }

    public void spare(int hits){
        if (isSpare())
        rolls.set(1,rolls.get(1)+hits);
    }

    public boolean isSpare(){
        if (this.isEnd()&&this.rolls.get(1)!=0&&this.getScore()==10)
            return true;
        return false;
    }
}
