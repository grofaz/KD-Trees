public class PointSET {
	private SET<Point2D> set;

	public PointSET() {
		set = new SET<Point2D>();
	} // construct an empty set of points

	public boolean isEmpty() {
		return set.isEmpty();
	} // is the set empty?

	public int size() {
		return set.size();
	} // number of points in the set

	public void insert(Point2D p) {
		set.add(p);
	} // add the point p to the set (if it is not already in the set)

	public boolean contains(Point2D p) {
		return set.contains(p);
	} // does the set contain the point p?

	public void draw() {
		for (Point2D p : set)
			StdDraw.point(p.x(), p.y());
	} // draw all of the points to standard draw

	public Iterable<Point2D> range(RectHV rect) {
		Queue<Point2D> lista = new Queue<Point2D>();

		for (Point2D p : set) {
			if (p.x() >= rect.xmin() && p.y() >= rect.ymin()
					&& p.x() <= rect.xmax() && p.y() <= rect.ymax()) {
				lista.enqueue(p);
			}
		}
		return lista;
	} // all points in the set that are inside the rectangle

	public Point2D nearest(Point2D p) {
		double min = -1;
		Point2D nearest = null;
		for (Point2D point : set) {
			if (nearest == null) {
				nearest = point;
				min = point.distanceTo(p);
				continue;
			}
			if (min > point.distanceTo(p)) {
				min = point.distanceTo(p);
				nearest = point;
			}
		}
		return nearest;
	} // a nearest neighbor in the set to p; null if set is empty
}