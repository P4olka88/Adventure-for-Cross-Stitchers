import java.util.Random;

public enum Special {
    START,
    FINISH,
    JUMP_BACK_START,
    JUMP_BACK_FINISH,
    JUMP_AHEAD_START,
    JUMP_AHEAD_FINISH,
    PASS, // pass turn
    START_AGAIN,
    ADDITIONAL, // additional turn without stitching
    X2, // double up, norm * 2, Double the norm
    ADD500x, // +500x
    SPECIAL_COLOR, // All in one color or twice as much, random color from list
    GO_AHEAD, // move on 1-10 steps
    GO_BACK, // move on 1-10 steps
    PROTECTION,
    DARTS,
    JACKPOT,
    TRAJECTORY_CHANGE,
    NORMAL_FIELD;

    public Special getRandom(){
        Special[] specials = Special.values();
        Random random = new Random();
        return specials[random.nextInt(specials.length)];
    }

}
