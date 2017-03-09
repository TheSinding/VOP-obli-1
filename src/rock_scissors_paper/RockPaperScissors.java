package rock_scissors_paper;

import java.util.Random;

/**
 * Created by thesinding on 3/5/17.
 */
public class RockPaperScissors {
    private int computer = 0;
    private int player = 0;
    private String[] computerString = new String[]{"Rock", "Paper", "Scissors"};
    private Random rng = new Random();


    public String play(String play) {
        this.computer = this.rng.nextInt(3) + 1;
        switch (play){
            case "rock":
                this.player = 1;
            break;
            case "paper":
                this.player = 2;
            break;
            case "scissors":
                this.player = 3;
            break;
        }
        return check(this.player, this.computer);
    }
    private String check(int a, int b){
        if(a == b){
            return "It's a tie";
            // this was the shortest way of doing the check, I didnt want to do alot of if statements.
        } else if (a == (b - 1) || b == (a - 2)){
            return "Computer win";
        } else {
            return "You win";
        }
    }

    public int[] getHands(){
        return new int[] {this.player, this.computer};
    }

    public String getComputerString(){
        // Gets the computer's hand string
        return computerString[this.computer - 1];
    }


}
