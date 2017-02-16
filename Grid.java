import java.util.Arrays;
import java.util.stream.Stream;


public class Grid {
    Cell[][] cells = new Cell[10][10];

    public Grid(String arg) {
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++) {
                cells[x][y] = new Cell(x, y);
            }
        }

        if(arg != null && ! arg.isEmpty()){
            Stream.of(arg.split(",")).forEach(str -> colorCellInBlack(str));
        }
    }

    private  void colorCellInBlack(String str) {
        int x = Integer.parseInt(str.split("")[0]);
        int y = Integer.parseInt(str.split("")[1]);
        cells[x][y] = new Cell(x, y, true);
    }


    public Stream<Cell> getBlackCell() {
        return Arrays.stream(cells).flatMap(row -> Arrays.stream(row)).filter(c -> c.isBlack());
    }



    public int countBlackNeigbors(int x, int y) {
        int count = 0;
        for(int i = x-1; i <= x+1; i++){
            for(int j = y-1; j <= y+1; j++){
                if (!(i == x && y == j)
                        && isInGrid(i) && isInGrid(j)
                        && cells[i][j].isBlack()){
                    count ++;
                }
            }
        }

        return count;
    }

    private boolean isInGrid(int y) {
        return (y >= 0) && y < 10;
    }

    public int countBlackNeigbors(Cell cell) {
        return countBlackNeigbors(cell.x, cell.y);
    }

    public int countMaxBlackArea() {
        return getBlackCell().mapToInt(c -> countBlackNeigbors(c)).max().orElse(0);
    }
}
