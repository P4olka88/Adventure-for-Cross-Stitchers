public class Field {
    private int id;
    Special special;
    boolean player_position;
    private int idFinish;

    public Field(int id, int idFinish, Special special, boolean player_position)  {
        this.special = special;
        this.player_position = player_position;
        this.id = id;
        this.idFinish = idFinish;
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

    public int getIdFinish() {
        return idFinish;
    }

    public void setIdFinish(int idFinish) {
        this.idFinish = idFinish;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", idFinish=" + idFinish +
                ", special=" + special +
                ", player_position=" + player_position +
                '}';
    }
}
