import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    static void main(String[] args) {
//        exempleStr();
//        exempleSegmentComp();
        exempleStrUnNatural();
    }

    private static void exempleStr() {
        List<String> stringList = new ArrayList<>(List.of("Костя", "Аня", "Маша", "Вася", "Борис"));
        System.out.println("stringList = " + stringList);
        stringList.sort(null);              // Работает!
        System.out.println("stringList = " + stringList);
        stringList.sort(Comparator.reverseOrder());
        System.out.println("stringList = " + stringList);
    }

    private static void exempleSegmentComp() {
        List<SegmentComp> segmentList = new ArrayList<>(List.of(new SegmentComp(new Point(-4, 0), new Point(3, 4)),
                new SegmentComp(0, 3, 4, 0),
                new SegmentComp(10, 10, 2, 5)));
        //Вынужденно используем stream.map() для превращения списка объектов класса - наследника в список объектов родительского класса
        Main.printSegmentsWithLength(segmentList.stream().map(sc -> (Segment) sc).toList());
        segmentList.sort(null);              // Работает!
        Main.printSegmentsWithLength(segmentList.stream().map(sc -> (Segment) sc).toList());
        segmentList.sort(Comparator.reverseOrder());
        Main.printSegmentsWithLength(segmentList.stream().map(sc -> (Segment) sc).toList());
    }

    private static void exempleStrUnNatural() {
        List<String> stringList = new ArrayList<>(List.of("Костя", "Аня", "Маша", "Вася", "Борис"));
        System.out.println("stringList = " + stringList);
        stringList.sort(Comparator.comparingInt(s -> s.length()));
        System.out.println("stringList = " + stringList);
        stringList.sort(Comparator.comparingInt(s -> ((String)s).length()).reversed());
        System.out.println("stringList = " + stringList);
        //два уровня сортировки:
        stringList.sort(Comparator.comparing(s->((String)s).length()).thenComparing(s->(String)s));
        System.out.println("stringList = " + stringList);
    }
}