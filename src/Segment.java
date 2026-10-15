import java.util.Objects;

public class Segment {
    Point p1, p2;

    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }

    public double length(){
        return p1.distanceTo(p2);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Segment segment)) return false;
        return Objects.equals(p1, segment.p1) && Objects.equals(p2, segment.p2)
                ||   Objects.equals(p2, segment.p1) && Objects.equals(p1, segment.p2);
    }

    @Override
    public int hashCode() {
        return p1.hashCode()+p2.hashCode();
    }
}