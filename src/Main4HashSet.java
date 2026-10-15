import java.util.*;

public class Main4HashSet {
    static void main(String[] args) {
        List<String> stringList = new ArrayList<>(List.of("Костя", "Аня", "Маша", "Вася", "Борис", "Аня", "Вася"));

        Set<String> uniqueStrings = new HashSet<>(stringList);
        System.out.println("uniqueStrings = " + uniqueStrings);

        List<Point> points = List.of(new Point(0, 3), new Point(4, 0), new Point(4, 0), new Point(3, 0));
        Set<Point> uniquePoints = new HashSet<>(points);
        System.out.println("uniquePointss = " + uniquePoints);

        List<SegmentComp> segmentList = new ArrayList<>(List.of(new SegmentComp(new Point(-4, 0), new Point(3, 4)),
                new SegmentComp(0, 3, 4, 0),
                new SegmentComp(10, 10, 2, 5),
                new SegmentComp(4, 0, 0, 3),
                new SegmentComp(-10, -10, -2, -5) ));
        Set<SegmentComp> uniqueSegments = new HashSet<>(segmentList);   //остается всего 4 РАЗНЫХ сегмента
        System.out.println("uniqueSegments = " + uniqueSegments);

        List uniqueSegmentsList = segmentList.stream().distinct().toList();     //Тоже всего 4 РАЗНЫХ элемента
        System.out.println("uniqueSegmentsList = " + uniqueSegmentsList);
    }
}
