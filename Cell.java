/**
 * Created by Gaspard on 16/02/2017.
 */
public class Cell {

     final int x;
     final int y;
    private final boolean isBlack;

    public Cell(int x, int y, boolean isBlack) {
        this.x = x;
        this.y = y;
        this.isBlack = isBlack;
    }

    public Cell(String str) {
        x = Integer.parseInt(str.split("")[0]);
        y = Integer.parseInt(str.split("")[1]);
        this.isBlack = true;
    }

    public Cell(int x, int y) {
        this(x, y, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        if (y != cell.y) return false;
        return isBlack == cell.isBlack;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (isBlack ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                ", isAlive=" + isBlack +
                '}';
    }

    public boolean isBlack() {
        return isBlack;
    }
}
