package com.duckrace.client;

import com.duckrace.DuckRacer;
import com.duckrace.Reward;

import java.util.List;

class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer racer = new DuckRacer(1, "Marcos");

        System.out.println(racer.getName() + " has won " + racer.getWins() + " races!");

        racer.win(Reward.DEBIT_CARD);
        racer.win(Reward.DEBIT_CARD);
        racer.win(Reward.DEBIT_CARD);
        racer.win(Reward.DEBIT_CARD);
        racer.win(Reward.PRIZES);


        System.out.println(racer.getName() + " has won " + racer.getWins() + " races!");

        // DONE: find out which rewards a racer has chosen
        System.out.println(racer.getName() + " has these rewards: " + racer.getRewards());

        // I need to know what racer's first choice of reward was.
        Reward firstReward = racer.getRewards().get(0);
        System.out.println(racer.getName() + " chose " + firstReward + " as it's first reward.");

        // show toString() in action
        System.out.println(racer);

        /*
          * NOTE: As it stands we can cheat by adding rewards without calling winning
          *
          * List<Reward> rewardList = racer.getRewards();
                rewardList.add(Reward.DEBIT_CARD);
                rewardList.add(Reward.PRIZES);
                System.out.println("cheater! " + racer);
          *
          * FIXED: used copyOf() method on getRewards() -- List is now "Read-Only"
         */

    }
}