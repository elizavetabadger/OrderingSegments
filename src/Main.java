import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public  static void main() {
        List<Point> points = readPoints("points.txt");
        System.out.println("points = " + points);
        //сортировка точек по расстоянию до НК
        //points.sort(Comparator.comparingDouble(p->p.distanceTo(Point.ZERO)));
        List<Point> sortedPoints = points.stream()      //превращаем список в "поток" Точек
                .sorted(Comparator.comparingDouble(p-> p.distanceTo(Point.ZERO))) // сортируем поток Точек
                .toList();     //собираем неизменяемый список Точек из потока
        System.out.println("Исходный points = " + points);
        System.out.println("sorted   Points = " + sortedPoints);

        List<Segment> segments = makeSegments(points);
        printSegmentsWithLength(segments);

//        segments.sort(Comparator.comparingDouble(Segment::length));
        var sortedSegments = segments.stream().sorted(Comparator.comparingDouble(Segment::length)).toList();
        printSegmentsWithLength(sortedSegments);

//        List<Double> listSegmentLen = new ArrayList<>();
//        for (Segment s: segments)
//            listSegmentLen.add(s.length());
        List<Double> listSegmentLen = segments.stream().map(Segment::length).toList();
//        double average = listSegmentLen.stream().mapToDouble(Double::doubleValue).sum() / listSegmentLen.size();
        double average = average(listSegmentLen);
        System.out.println("average = " + average);

        //segments.sort(null);    //не работает, поскольку Segment не есть Comparable
        //printSegmentsWithLength(segments);
    }

    static double average(List<Double> values) {
        double s = 0;
        for (Double x: values)
            s+= x;
        return s/values.size();
    }

    static void printSegmentsWithLength(List<Segment> segments) {
        System.out.println("--- Список сегментов в количестве " + segments.size()+" шт. -----");
        segments.forEach(s->IO.println(s+" длина = "+s.length()));
        System.out.println("-----------------------------------------------------------------");
    }

    private static List<Segment> makeSegments(List<Point> points) {
        if (points == null)
            return null;
        List<Segment> res = new ArrayList<>();  // можно заранее посчитать количество сегментов и передать конструктору
        for (int i = 0; i< points.size()-1; i++){
            for (int j = i+1; j < points.size(); j++) {
                res.add(new Segment(points.get(i), points.get(j)));
            }
        }
        return res;
    }

    static List<Point> readPoints(String filename) {
        List<Point> points = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                Point p = new Point(x,y);
                points.add(p);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return points;
    }
}