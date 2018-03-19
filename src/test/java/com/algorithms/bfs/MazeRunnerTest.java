package com.algorithms.bfs;

import com.algorithms.bfs.MazeRunner.Point;
import org.junit.Test;

public class MazeRunnerTest {

  @Test
  public void testFindShortestPath(){
    final int[][] maze = new int[][]{{1,0,1},{1,0,1},{1,0,0}};
    MazeRunner mazeRunner = new MazeRunner(maze);
    for(int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(maze[i][j]);
      }
      System.out.println("\n");
    }
    System.out.println(mazeRunner.findShortestPath(new Point(0,0), new Point(0,2)));
  }
}
