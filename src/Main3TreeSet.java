import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main3TreeSet {
    static void main(String[] args) {
        List<SegmentComp> segmentList = new ArrayList<>(List.of(new SegmentComp(new Point(-4, 0), new Point(3, 4)),
                new SegmentComp(0, 3, 4, 0),
                new SegmentComp(10, 10, 2, 5),
                new SegmentComp(4, 0, 0, 3),
                new SegmentComp(-10, -10, -2, -5) ));
        List<String> stringList = new ArrayList<>(List.of("Костя", "Аня", "Маша", "Вася", "Борис", "Аня", "Вася"));

        Set<String> uniqueStrings = new TreeSet<>(stringList);
        System.out.println("uniqueStrings = " + uniqueStrings);

        Set<SegmentComp> uniqueSegments = new TreeSet<>(segmentList);
        System.out.println("Исходный список сегментов:");
        Main.printSegmentsWithLength(segmentList.stream().map(sc -> (Segment) sc).toList());    //Работает, потому что Comparable
        System.out.println("Уникальные сегменты:");
        Main.printSegmentsWithLength(uniqueSegments.stream().map(sc -> (Segment) sc).toList());

        List<Point> points = List.of(new Point(0, 3), new Point(4, 0), new Point(4, 0), new Point(3, 0));
        System.out.println("points = " + points);
        Set<Point> uniquePoints = new TreeSet<>(points);            //Нельзя! нет метода compareTo у точки
//        System.out.println("uniquePoints = " + uniquePoints);
    }
}