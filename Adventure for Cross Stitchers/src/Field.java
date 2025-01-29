public class Field {
    private int id;
    Special special;
    boolean player_position;

    public Field(int id, Special special, boolean player_position)  {
        this.special = special;
        this.player_position = player_position;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Special getSpecial() {
        return special;
    }

    public void setSpecial(Special special) {
        this.special = special;
    }

    public boolean isPlayer_position() {
        return player_position;
    }

    public void setPlayer_position(boolean player_position) {
        this.player_position = player_position;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", special=" + special +
                ", player_position=" + player_position +
                '}';
    }
}
