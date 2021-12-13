package main.java.ComparatorExamples;

import java.util.Comparator;

public class PlayerAgeComparator implements Comparator<Player>{
    public int compare(Player firstPlayer, Player secondPlayer) {
        return Integer.compare(firstPlayer.getAge(), secondPlayer.getAge());
    }
}
