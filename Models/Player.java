package Models;

public class Player {
    private String name;
    private int pos;

    public Player(String name) {
        this.name = name;
        this.pos = 0; // standard starting position
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
