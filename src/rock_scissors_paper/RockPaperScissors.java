package rock_scissors_paper;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by thesinding on 3/5/17.
 */
public class RockPaperScissors {
    public final static String[] HANDS = new String[]{"Sten","Saks","Papir"};
    public HashMap <String, String > winners = new HashMap<>();

    private String player = "Player";
    private String computer = "Computer";
    public String getPlayer() {
        return player;
    }

    public RockPaperScissors (){
        winners.put(HANDS[0],HANDS[1]);
        winners.put(HANDS[1],HANDS[2]);
        winners.put(HANDS[2],HANDS[0]);

    }

    public String getComputer() {
        return computer;
    }

    public void play(String player) {
        double random = Math.random() * 10;
        if(random < 3.33f){
            computer = HANDS[0];
        } else if (random < 3.33d && random > 6.66d){
            computer = HANDS[1];
        } else {
            computer = HANDS[2];
        }
        this.player = player;
    }


    public String getWinner(){
        return "";
    }
    public static void main(String[] args) {

    }
}
