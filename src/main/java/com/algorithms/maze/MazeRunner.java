package com.algorithms.maze;

import com.google.common.collect.Lists;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * example for BFS and backtracking(recursion) algorithms usage
 */
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
   * Problem definition:
   *   Given a 2D map find the shortest distance from the starting point to the finish
   *  point. You can only move horizontally or vertically. You cannot leave the
   *  boundaries of the map.
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

  /**
   * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e.,
   * maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach destination.
   * The rat can move only in two directions: forward and down.
   * Solve with backtracking.
   * @return true if there is a way out.
   */
  public boolean rescueRat(Point start, Point end){
    if( start.getY() == end.getY() && start.getX() == end.getX()){
      return true;
    }
    if( start.getX() >= maze[0].length || start.getY() >= maze.length || maze[start.getY()][start.getX()] == 0 ){
      return false;
    }
    return rescueRat(new Point(start.getX(), start.getY()+1), end) || rescueRat(new Point(start.getX()+1, start.getY()), end);
  }

}
