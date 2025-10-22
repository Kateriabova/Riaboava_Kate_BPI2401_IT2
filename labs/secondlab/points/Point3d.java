package points;

public class Point3d extends Point2d{
    private double zCoord;
    /** конструктор с параметрами **/
    public Point3d(double x, double y, double z) {
        super(x, y);
        zCoord = z;
    }
    /** конструктор по умолчанию **/
    public Point3d() {
        this(0, 0, 0);
    }
    /** получение координаты Z **/
    public double getZ() {
        return zCoord;
    }
    /** установка значения координаты Z. **/
    public void setZ(double val) {
        zCoord = val;
    }
}
