import java.util.HashMap;
import java.util.Random;

public class MapGeneration {
    private int size = 30;
    private int jumpBack = 3;
    private int jumpAhead = 5;
    private int pass=2;
    private int startAgain=1;
    private int additional;
    private int x2;
    private int add500x;
    private int specialColor;
    private int goAhead;
    private int goBack;
    private int protection;
    private int darts;
    private int jackPot;
    private int trajectoryChange;
    private int normalField;
    HashMap<Integer, Field> gameMap = new HashMap<>();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getJumpBack() {
        return jumpBack;
    }

    public void setJumpBack(int jumpBack) {
        this.jumpBack = jumpBack;
    }

    public int getJumpAhead() {
        return jumpAhead;
    }

    public void setJumpAhead(int jumpAhead) {
        this.jumpAhead = jumpAhead;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getStartAgain() {
        return startAgain;
    }

    public void setStartAgain(int startAgain) {
        this.startAgain = startAgain;
    }

    public int getAdditional() {
        return additional;
    }

    public void setAdditional(int additional) {
        this.additional = additional;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getAdd500x() {
        return add500x;
    }

    public void setAdd500x(int add500x) {
        this.add500x = add500x;
    }

    public int getSpecialColor() {
        return specialColor;
    }

    public void setSpecialColor(int specialColor) {
        this.specialColor = specialColor;
    }

    public int getGoAhead() {
        return goAhead;
    }

    public void setGoAhead(int goAhead) {
        this.goAhead = goAhead;
    }

    public int getGoBack() {
        return goBack;
    }

    public void setGoBack(int goBack) {
        this.goBack = goBack;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getDarts() {
        return darts;
    }

    public void setDarts(int darts) {
        this.darts = darts;
    }

    public int getJackPot() {
        return jackPot;
    }

    public void setJackPot(int jackPot) {
        this.jackPot = jackPot;
    }

    public int getTrajectoryChange() {
        return trajectoryChange;
    }

    public void setTrajectoryChange(int trajectoryChange) {
        this.trajectoryChange = trajectoryChange;
    }

    public HashMap generate(){
        jumps(jumpBack, jumpAhead);
        for(int i=1;i<=pass; i++) {
            setGameMap(generateSpecialField(), Special.PASS);
        }
        for(int i=1;i<=startAgain;i++){
            setGameMap(generateSpecialField(), Special.START_AGAIN);
        }
        for (int i=1;i<=additional; i++){
            setGameMap(generateSpecialField(), Special.ADDITIONAL);
        }
        for(int i=1; i<=x2;i++){
            setGameMap(generateSpecialField(), Special.X2);
        }
        for(int i=1; i<=x2;i++){
            setGameMap(generateSpecialField(), Special.X2);
        }
        for(int i=1; i<=x2;i++){
            setGameMap(generateSpecialField(), Special.X2);
        }
        for(int i=1; i<=add500x;i++){
            setGameMap(generateSpecialField(), Special.ADD500x);
        }
        for(int i=1; i<=specialColor;i++){ // todo
            setGameMap(generateSpecialField(), Special.SPECIAL_COLOR);
        }
        for(int i=1; i<=goAhead;i++){
            setGameMap(generateSpecialField(), Special.GO_AHEAD);
        }
        for(int i=1; i<=goBack;i++){
            setGameMap(generateSpecialField(), Special.GO_BACK);
        }
        for(int i=1; i<=goBack;i++){
            setGameMap(generateSpecialField(), Special.GO_BACK);
        }
        for(int i=1; i<=protection;i++){
            setGameMap(generateSpecialField(), Special.PROTECTION);
        }
        for(int i=1; i<=darts;i++){ //todo
            setGameMap(generateSpecialField(), Special.DARTS);
        }
        for(int i=1; i<=jackPot;i++){ // todo
            setGameMap(generateSpecialField(), Special.JACKPOT);
        }
        for (int i=1; i<=trajectoryChange;i++){ // todo
            setGameMap(generateSpecialField(), Special.TRAJECTORY_CHANGE);
        }
        setNormalField();
        printGameMap();
        return null;
    }

    private HashMap<Integer,Field> jumps(int jumpBack, int jumpAhead){
        Random random = new Random();
        System.out.println("Back: " );
        for(int i=1;i<=jumpBack; i++){
            int jumpStartBack = 0;
            int attempt = 0;
            do {
                attempt++;
                jumpStartBack = random.nextInt(3, size);
            }while (gameMap.containsKey(jumpStartBack) && attempt <=size);
            int jumpFinishBack = random.nextInt(1,jumpStartBack-1);
            if(!gameMap.containsKey(jumpStartBack) && !gameMap.containsKey(jumpFinishBack)) {
                gameMap.put(jumpStartBack, new Field(jumpStartBack,jumpFinishBack, Special.JUMP_BACK_START, false));
                gameMap.put(jumpFinishBack, new Field(jumpFinishBack,0, Special.JUMP_BACK_FINISH, false));
                System.out.println("jumpStartBack " + jumpStartBack);
                System.out.println("jumpFinishBack " + jumpFinishBack);
            }
        }
        System.out.println("Ahead: " );
        for(int i=1;i<=jumpAhead; i++) {
            int jumpStartAhead = 0;
            int attempt = 0;
            int jumpFinishAhead = 0;
            do {
                attempt++;
                jumpStartAhead = random.nextInt(1, size - 1);
                jumpFinishAhead = random.nextInt(jumpStartAhead + 1, size);
            }while(gameMap.containsKey(jumpStartAhead)&& (gameMap.containsKey(jumpFinishAhead)) && attempt <=size);
            //if(!gameMap.containsKey(jumpStartAhead) && !gameMap.containsKey(jumpFinishAhead)) {
                gameMap.put(jumpStartAhead, new Field(jumpStartAhead,jumpFinishAhead, Special.JUMP_AHEAD_START, false));
                gameMap.put(jumpFinishAhead, new Field(jumpFinishAhead, 0,Special.JUMP_AHEAD_FINISH, false));
                System.out.println("jumpStartAhead " + jumpStartAhead);
                System.out.println("jumpFinishAhead " + jumpFinishAhead);
            //}
        }
        System.out.println(gameMap);
        return  gameMap;
    }

    private int generateSpecialField(){
        Random random = new Random();
        int field = 0;
        int attempt = 0;
        do {
            attempt++;
            field = random.nextInt(1, size - 1);
        }while(gameMap.containsKey(field) && attempt <=size);
        return field;
    }

    private void setNormalField(){
        gameMap.put(0, new Field(0,0, Special.START, true));
        gameMap.put(size+1, new Field(size+1,0, Special.FINISH, false));
        for (int i=1; i<=size; i++){
            if(!gameMap.containsKey(i)){
                gameMap.put(i, new Field(i, 0,Special.NORMAL_FIELD, false));
            }
        }
    }

    private void setGameMap(int field, Special special){
        gameMap.put(field, new Field(field,0, special, false));
    }

    private void printGameMap(){
        for(Integer key: gameMap.keySet()){
            System.out.print(key + ":");
            System.out.println(gameMap.get(key).toString());
        }
    }
}
