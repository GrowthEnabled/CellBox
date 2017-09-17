package cellbox.model.util;

/**
 * Created by luca on 16.08.17.
 */
public class GeometriX {
/*
    public static double getAngleOne(Cell cell, Element e) {
        double x = e.position.getX();
        double x1 = cell.position.getX();
        double y = e.position.getY();
        double y1 = cell.position.getY();
        double rotation = cell.getAngle();

        Point2D relativePos = new Point2D(
                (x1 + Math.cos(rotation) * (x - x1) - Math.sin(rotation) * (y - y1)) - x1,
                (y1 + Math.sin(rotation) * (x - x1) + Math.cos(rotation) * (y - y1)) - y1
        );
        Point2D vector = relativePos;
        double distance = Math.sqrt(Math.pow(vector.getX(), 2) + Math.pow(vector.getY(), 2));
        double angle = 360 / (2 * Math.PI) * vector.getX() / distance;
        return angle;
    }

    public static double getAngle(Cell cell, Element e) {
        double x = e.position.getX();
        double x1 = cell.position.getX();
        double y = e.position.getY();
        double y1 = cell.position.getY();
        double angle = cell.getAngle();


        Point2D cellVector = new Point2D(-Math.sin(angle), Math.cos(angle));
        Point2D foodVector = new Point2D(x - x1, y - y1);

        double prod = cellVector.getX() * foodVector.getX() + cellVector.getY() * foodVector.getY();

        double lenCell = Math.sqrt(Math.pow(cellVector.getX(),2) + Math.pow(cellVector.getY(), 2));
        double lenFood = Math.sqrt(Math.pow(foodVector.getX(),2) + Math.pow(foodVector.getY(), 2));

        double result = Math.toDegrees(Math.acos(prod / (lenCell * lenFood)));

        return result;
    }

    public static double getDistance(Element a, Element b) {
        double x = a.position.getX();
        double x1 = b.position.getX();
        double y = a.position.getY();
        double y1 = b.position.getY();
        double distance = Math.sqrt(Math.pow(x-x1, 2) + Math.pow(y - y1, 2));
        return distance;
    }*/
}
