package au.edu.jcu.cp3406.guessinggame;

public class Game {
    public boolean check(int i) {
        int max = 10;
        int min = 1;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        if (i == random_int){
            return true;
        } else{
            return false;
        }
    }
}
