import java.util.Random;

public enum Color {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    CYAN,
    BLUE,
    PURPLE,
    WHITE,
    BLACK,
    GRAY,
    BROWN
    ;

    public Color getRandom(){
        Color[] color = Color.values();
        Random random = new Random();
        return color[random.nextInt(color.length)];
    }
}
