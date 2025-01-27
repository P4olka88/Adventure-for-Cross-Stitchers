import java.util.HashMap;
import java.util.Random;

public class MapGeneration {
    private int size = 100;
    private int jumpBack = 3;
    private int jumpAhead = 4;
    HashMap<Integer, Object> gameMap = new HashMap<>();

    public HashMap generate(){
        HashMap<Integer, Integer> jumps = jumps(jumpBack, jumpAhead);
        return null;
    }

    private HashMap<Integer,Integer> jumps(int jumpBack, int jumpAhead){
        Random random = new Random();
        HashMap<Integer, Integer> jumps = new HashMap<>();
        System.out.println("Back: " );
        for(int i=1;i<=jumpBack; i++){
            int jumpStartBack = random.nextInt(3,size);
            int jumpFinishBack = random.nextInt(1,jumpStartBack-1);
            jumps.put(jumpStartBack, jumpFinishBack);
            System.out.println("jumpStartBack " +  jumpStartBack);
            System.out.println("jumpFinishBack " +jumpFinishBack);
        }

        System.out.println("Ahead: " );
        for(int i=1;i<=jumpAhead; i++) {
            int jumpStartAhead = random.nextInt(1, size - 1);
            int jumpFinishAhead = random.nextInt(jumpStartAhead + 1, size);
            jumps.put(jumpStartAhead, jumpFinishAhead);
            System.out.println("jumpStartAhead " + jumpStartAhead);
            System.out.println("jumpFinishAhead " + jumpFinishAhead);
        }
        System.out.println(jumps);
        return  jumps;
    }

    private HashMap<Integer, Object> SpecialField(){
        return  null;
    }
}
