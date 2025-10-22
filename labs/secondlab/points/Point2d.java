package points;

public class Point2d {
    /** координата X **/
    private double xCoord;
    /** координата Y **/
    private double yCoord;
    /** конструктор с параметрами **/
    public Point2d(double x, double y) {
        xCoord = x;
        yCoord = y;
    }
    /** конструктор по умолчанию **/
    public Point2d() {
        this(0, 0);
    }
    /** получение координаты X **/
    public double getX() {
        return xCoord;
    }
    /** получение координаты Y **/
    public double getY() {
        return yCoord;
    }
    /** установка значения координаты X. **/
    public void setX(double val) {
        xCoord = val;
    }
    /** установка значения координаты Y. **/
    public void setY(double val) {
        yCoord = val;
    }
}
