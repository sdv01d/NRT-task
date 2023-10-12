import java.util.*;

class HoneycombPoint {
    double x;
    double y;

    public HoneycombPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class HoneyCombGridGenerator {
    public static List<HoneycombPoint> generateHoneycombPoints(int n, double radius) {
        List<HoneycombPoint> points = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        
        if (n <= 0) {
            return points;
        }

        points.add(new HoneycombPoint(0, 0));
        visited.add(0.0 + "," + 0.0);

        if (n == 1) {
            return points;
        }

        double[][] directions = {
                {1, 0}, {0.5, Math.sqrt(3) / 2}, {-0.5, Math.sqrt(3) / 2},
                {-1, 0}, {-0.5, -Math.sqrt(3) / 2}, {0.5, -Math.sqrt(3) / 2}
        };

        
        Queue<HoneycombPoint> queue = new LinkedList<>();
        queue.add(new HoneycombPoint(0, 0));

        while (points.size() < n) {
            HoneycombPoint point = queue.poll();
            double x = point.x;
            double y = point.y;

            for (double[] dir : directions) {
                double newX = x + dir[0] * radius;
                double newY = y + dir[1] * radius;
                String key = newX + "," + newY;

                if (!visited.contains(key)) {
                    visited.add(key);
                    points.add(new HoneycombPoint(newX, newY));
                    queue.add(new HoneycombPoint(newX, newY));
                }
            }
        }

        return points;
    }

    public static void main(String[] args) {
        int n;  
        double radius = 20.0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Points:");
        n = sc.nextInt();

        List<HoneycombPoint> points = generateHoneycombPoints(n, radius);

        for (HoneycombPoint point : points) {
            System.out.println("(" + point.x + ", " + point.y+")");
        }
    }
}