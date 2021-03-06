package lin.louis.game.common.board;

import lin.louis.game.common.Point;

public class MatrixIntegerBoard {
    private static final int INITIAL_VALUE = -1;
    private int[][] board;
    private int width;
    private int height;

    public MatrixIntegerBoard(int width, int height) {
        this.board = new int[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.board[x][y] = INITIAL_VALUE;
            }
        }
        this.width = width;
        this.height = height;
    }

    public int get(int x, int y) {
        return board[x][y];
    }

    public int get(Point point) {
        return get(point.x, point.y);
    }

    public void set(int x, int y, int val) {
        board[x][y] = val;
    }

    public void set(Point point, int val) {
        set(point.x, point.y, val);
    }

    public boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x > width - 1 || y > height - 1;
    }

    public boolean isOutOfRange(Point p) {
        return isOutOfRange(p.x, p.y);
    }

    @Override
    public String toString() {
        StringBuilder mapLine = new StringBuilder();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                mapLine.append(get(x, y)).append("\t");
            }
            mapLine.append('\n');
        }

        return mapLine.toString();
    }
}
