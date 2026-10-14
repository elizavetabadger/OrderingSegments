public class SegmentComp extends Segment implements Comparable<SegmentComp>{
    public SegmentComp(Point p1, Point p2) {
        super(p1, p2);
    }

    public SegmentComp(double x1, double y1, double x2, double y2) {
        super(new Point(x1, y1), new Point(x2, y2));
    }
    @Override
    public int compareTo(SegmentComp o) {
        double len1 = this.length();
        double len2 = o.length();
        return Double.compare(len1, len2);
    }
}