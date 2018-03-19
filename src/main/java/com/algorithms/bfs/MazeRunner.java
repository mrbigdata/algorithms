package com.algorithms.bfs;

import com.google.common.collect.Lists;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MazeRunner {
  static class Point {
    private final int x;
    private final int y;

    Point(int x, int y){
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }
  private final int[][] maze;

  public MazeRunner(int[][] maze){
    this.maze = maze;
  }

  /**
   * Finds the shortest path between two points using BFS algorithm (wave propagation)
   * @param start
   * @param end
   * @return
   */
  public int findShortestPath(Point start, Point end){
    final Queue<Point> queue = new LinkedList<>();
    final boolean[][] visited = new boolean[maze.length][maze[0].length];
    queue.add(start);
    visited[start.getY()][start.getX()] = true;
    int currentDistance = 0;
    while (!queue.isEmpty()){
      Point current = queue.remove();
      visited[current.getY()][current.getX()] = true;
      //reached destination/done
      if( current.getY() == end.getY() && current.getX() == end.getX()){
        return currentDistance;
      }
      currentDistance++;
      int left = current.getX()-1;
      int right = current.getX()+1;
      int up = current.getY()-1;
      int down = current.getY()+1;
      List<Point> adjacentPoints = Lists.newArrayList();
      if( left >= 0)
        adjacentPoints.add(new Point(left, current.getY()));
      if( right < maze[0].length )
        adjacentPoints.add(new Point(right, current.getY()));
      if( up >= 0)
        adjacentPoints.add(new Point(current.getX(), up));
      if (down < maze.length)
        adjacentPoints.add(new Point(current.getX(), down));
      for( Point point : adjacentPoints){
        if(!visited[point.getY()][point.getX()] && maze[point.getY()][point.getX()] == 1){
          queue.add(point);
        }
      }
    }
    //no path available from source to destination
    return -1;
  }
}
