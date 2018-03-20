package com.algorithms.maze;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.algorithms.maze.MazeRunner.Point;
import org.junit.Test;

public class MazeRunnerTest {

  @Test
  public void testFindExistingShortestPath(){
    final int[][] maze = new int[][]{{1,0,1},{1,0,1},{1,0,0}};
    MazeRunner mazeRunner = new MazeRunner(maze);
    assertEquals(2, mazeRunner.findShortestPath(new Point(0,0), new Point(0,2)));
  }

  @Test
  public void testNoPathFound(){
    final int[][] maze = new int[][]{{1,0,1},{1,0,1},{1,0,0}};
    MazeRunner mazeRunner = new MazeRunner(maze);
    assertEquals(-1, mazeRunner.findShortestPath(new Point(0,0), new Point(2,0)));
  }

  @Test
  public void testRescueRat(){
    final int[][] maze = new int[][]{{1,0,1},{1,0,1},{1,0,0}};
    MazeRunner mazeRunner = new MazeRunner(maze);
    assertFalse(mazeRunner.rescueRat(new Point(0,0), new Point(2,2)));
    assertTrue(mazeRunner.rescueRat(new Point(2, 0), new Point(2, 1)));
  }
}
