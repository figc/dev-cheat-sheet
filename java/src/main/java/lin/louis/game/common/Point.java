package lin.louis.game.common;

import lin.louis.game.common.command.FourDirection;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point position) {
        this(position.x, position.y);
    }

    public Point add(int x, int y) {
        return new Point(this.x + x, this.y + y);
    }

    public Point add(Point pointToAdd) {
        return add(pointToAdd.x, pointToAdd.y);
    }

    public Point add(FourDirection direction) {
        return add(direction.x, direction.y);
    }

    public void set(Point newPosition) {
        x = newPosition.x;
        y = newPosition.y;
    }

    public Point copy() {
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Point)) {
            return false;
        }
        Point p = (Point) obj;
        return this.x == p.x && this.y == p.y;
    }
}
