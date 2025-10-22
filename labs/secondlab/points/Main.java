package points;

public class Main {
    public static void main(String[] args) {
        Point2d myPoint = new Point2d();
        Point2d myOtherPoint = new Point2d(5,3);
        Point3d myThirdPoint = new Point3d();
        Point3d myLastPoint = new Point3d(4, 5, 3);
        
        myPoint.setX(6.2);
        myOtherPoint.setY(9);

        System.out.println(myPoint.getX());
        System.out.println(myOtherPoint.getY());

        myThirdPoint.setX(12);
        myThirdPoint.setZ(13);
        myLastPoint.setY(7.9);

        System.out.println(myThirdPoint.getX());
        System.out.println(myThirdPoint.getZ());
        System.out.println(myLastPoint.getY());

    }
}
