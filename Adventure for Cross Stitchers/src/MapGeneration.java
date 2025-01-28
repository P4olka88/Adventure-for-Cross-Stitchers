import java.util.HashMap;
import java.util.Random;

public class MapGeneration {
    private int size = 10;
    private int jumpBack = 3;
    private int jumpAhead = 5;
    private int pass;
    private int startAgain;
    private int additional;
    private int x2;
    private int add500x;
    private int specialColor;
    private int goAhead;
    private int goBack;
    private int 
    HashMap<Integer, Field> gameMap = new HashMap<>();

    public HashMap generate(){
        jumps(jumpBack, jumpAhead);
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
                gameMap.put(jumpStartBack, new Field(jumpStartBack, Special.JUMP_BACK_START, false));
                gameMap.put(jumpFinishBack, new Field(jumpFinishBack, Special.JUMP_BACK_FINISH, false));
                System.out.println("jumpStartBack " + jumpStartBack);
                System.out.println("jumpFinishBack " + jumpFinishBack);
            }
        }
        System.out.println("Ahead: " );
        for(int i=1;i<=jumpAhead; i++) {
            int jumpStartAhead = 0;
            int attempt = 0;
            do {
                attempt++;
                jumpStartAhead = random.nextInt(1, size - 1);
            }while(gameMap.containsKey(jumpStartAhead) && attempt <=size);
            int jumpFinishAhead = random.nextInt(jumpStartAhead + 1, size);
            if(!gameMap.containsKey(jumpStartAhead) && !gameMap.containsKey(jumpFinishAhead)) {
                gameMap.put(jumpStartAhead, new Field(jumpStartAhead, Special.JUMP_AHEAD_START, false));
                gameMap.put(jumpFinishAhead, new Field(jumpFinishAhead, Special.JUMP_AHEAD_FINISH, false));
                System.out.println("jumpStartAhead " + jumpStartAhead);
                System.out.println("jumpFinishAhead " + jumpFinishAhead);
            }
        }
        System.out.println(gameMap);
        return  gameMap;
    }

    private void SpecialField(){
        Random random = new Random();

    }
}
