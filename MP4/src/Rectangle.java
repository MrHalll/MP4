import java.awt.*;

public class Rectangle implements Shape{
    private double height;
    private double width;
    private Point center;

    public Rectangle(double x, double y, double height, double width){
        this.width = width;
        this.height = height;
        this.center = new Point(x, y);
    }

    public Rectangle(Point point, double width, double height){
        this.center = point;
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw(Graphics g) {
        g.drawRect((int) center.getX(), (int) center.getY(), (int) width, (int) height);
    }

    @Override
    public Point getPosition() {
        return center;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public boolean intersects(Point point) {
        if (center.distanceTo(point) < height && center.distanceTo(point) < width)
            return true;
        return false;
    }

    @Override
    public void moveTo(Point point) {
        center.moveTo(point);
    }

    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    @Override
    public void resizeTo(Point point) {
        height = center.distanceTo(point);
        width = center.distanceTo(point);
    }

    @Override
    public Shape peel() {
        return this;
    }
}
