package com.acconex.simulator;

import com.acconex.simulator.internal.direction.DirectionLookup;

public class Position {
  private  int x ;
  private int y ;
  private DirectionLookup direction;
  
  public Position(int x, int y, DirectionLookup moveDirection) {
    this.x = x;
    this.y = y;
    this.direction = moveDirection;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((direction == null) ? 0 : direction.hashCode());
    result = prime * result + x;
    result = prime * result + y;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Position other = (Position) obj;
    if (direction != other.direction)
      return false;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

  public DirectionLookup getDirection() {
    return direction;
  }

  public void setDirection(DirectionLookup moveDirection) {
    this.direction = moveDirection;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getY() {
    return y;
  }


}
