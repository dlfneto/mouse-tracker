package classes;

public class Coord {
    public int x, y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(String text){
        String[] coords = text.split(", ");

        if(coords.length != 2) return;
        try{
            this.x = Integer.parseInt(coords[0]);
            this.y = Integer.parseInt(coords[1]);
        }catch(Exception e){
            System.out.println("Invalid Data! :/");
        }
    }

    public Coord(String text){
        String[] coords = text.split(", ");
        this.x = Integer.parseInt(coords[0]);
        this.y = Integer.parseInt(coords[1]);
    }

    @Override
    public String toString(){
        return String.format("%d, %d", x, y);
    }

    public boolean compare(Coord c){
        return ((this.x == c.x) && (this.y == c.y));
    }
}
