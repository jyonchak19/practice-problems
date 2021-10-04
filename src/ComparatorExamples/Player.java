package ComparatorExamples;
import java.lang.Comparable;

public class Player implements Comparable<Player> {
    private int ranking;
    private String name;
    private int age;

    public Player(int ranking, String name, int age){
        this.ranking = ranking;
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getRanking(){
        return ranking;
    }

    public int compareTo(Player secondPlayer){
        return Integer.compare(this.getRanking(), secondPlayer.getRanking());
    }
}




