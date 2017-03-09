package rock_scissors_paper;

import java.util.Random;

/**
 * Created by thesinding on 3/5/17.
 */
public class RockPaperScissors {

    public String play(String play) {
        Random rng = new Random();
        int randomInt = rng.nextInt(3) + 1;
        String returnString = null;
        switch (play){
            case "rock":
                returnString = check(1, randomInt);
            break;
            case "paper":
                returnString = check(2, randomInt);
            break;
            case "scissors":
                returnString = check(3, randomInt);
            break;
        }
        return returnString;
    }
    private String check(int a, int b){
        if(a == b){
            return "It's a tie";
        } else if (a == (b - 1) || b == (a - 2)){
            return "Computer win";
        } else {
            return "You win";
        }
    }

}
