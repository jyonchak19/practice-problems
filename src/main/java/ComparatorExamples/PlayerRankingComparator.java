package main.java.ComparatorExamples;

import java.util.Comparator;

public class PlayerRankingComparator implements Comparator<Player> {
    public int compare(Player firstPlayer, Player secondPlayer) {
        return Integer.compare(firstPlayer.getRanking(), secondPlayer.getRanking());
    }
}
