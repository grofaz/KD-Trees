public class RangeSearchVisualizer {

    public static void main(String[] args) {

        String filename = args[0];
        In in = new In(filename);


        StdDraw.show(0);

        // initialize the data structures with N points from standard input
        //PointSET brute = new PointSET();
        KdTree kdtree = new KdTree();
    	int i = 0;
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdtree.insert(p);
            //System.out.println("kdtree size - "+kdtree.size() + " i-" + i);
          //  i++;
          //  brute.insert(p);
        }

        double x0 = 0.0, y0 = 0.0;      // initial endpoint of rectangle
        double x1 = 0.0, y1 = 0.0;      // current location of mouse
        boolean isDragging = false;     // is the user dragging a rectangle

        // draw the points
        //StdDraw.clear();
        //StdDraw.setPenColor(StdDraw.BLACK);
       // StdDraw.setPenRadius(.01);
     //   brute.draw();
        kdtree.draw();
        boolean test = true;
        Point2D punct = new Point2D(0.52, 0.7);
        System.out.println( kdtree.size());
      //  System.out.println( brute.nearest(punct));
        in = new In(filename);
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            System.out.println(p + " - " + kdtree.contains(p));

        }
        Point2D pct = new Point2D(0.024472 ,0.654508);
  //      System.out.println( kdtree.contains(pct));
        Queue<Point2D> l =  (Queue<Point2D>) kdtree.range(new RectHV(0.0,0.0,0.81,0.3));
        while (test) {
        	

            StdDraw.show(0);
        }
    }
}












