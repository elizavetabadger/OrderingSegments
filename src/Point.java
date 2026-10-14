public class Point {
    static final Point ZERO = new Point(0, 0);

    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    double distanceTo(Point other){
        return Math.hypot(x- other.x, y- other.y);
    }
}
