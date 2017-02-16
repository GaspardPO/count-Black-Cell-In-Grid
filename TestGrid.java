import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TestGrid {

    @Test
    public void gridShouldBeCreatedWhite(){
        Grid grid = new Grid("");
        Set set = (Set) grid.getBlackCell().collect(toSet());
        Assert.assertTrue(set.isEmpty());
    }

    @Test
    public void gridShouldBeCreatedWithArg(){
        Grid grid = new Grid("18,00");
        Assert.assertEquals(grid.getBlackCell().collect(toSet()), getSetFromArray(new Cell(0, 0, true), new Cell(1, 8, true)));
    }

    @Test
    public void gridCountBlackNeigbourhs(){
        Grid grid = new Grid("");
        Assert.assertEquals(0, grid.countBlackNeigbors(1,8));
    }

    @Test
    public void gridCountBlackNeigbourhsWhenOne(){
        Grid grid = new Grid("17,18");
        Assert.assertEquals(1, grid.countBlackNeigbors(1,8));
    }

    @Test
    public void gridCountMaxBlackNeigbourhs(){
        Grid grid = new Grid("17,18,19");
        Assert.assertEquals(2, grid.countBlackNeigbors(1,8));
        Assert.assertEquals(2, grid.countMaxBlackArea());
    }




    private Set<Cell> getSetFromArray(Cell... array) {
        return new HashSet<Cell>(Arrays.asList(array));
    }
}
