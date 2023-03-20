import java.awt.*;

public class CrossDecorator implements Shape{
    private Shape decoratee;
    public CrossDecorator(Shape shape){
        this.decoratee = shape;
    }
    @Override
    public void draw(Graphics g) {
        decoratee.draw(g);
        int x = (int) decoratee.getPosition().getX();
        int y = (int) decoratee.getPosition().getY();
        int halfHeight = (int) (decoratee.getHeight() / 2.0);
        int halfWidth = (int) (decoratee.getWidth() / 2.0);
        g.drawLine(x, y, x, y + halfHeight);
        g.drawLine(x, y, x + halfWidth, y);
        g.drawLine(x, y, x, y - halfHeight);
        g.drawLine(x, y, x - halfWidth, y);
    }

    @Override
    public Point getPosition() {
        return null;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public boolean intersects(Point point) {
        return false;
    }

    @Override
    public void moveTo(Point point) {

    }

    @Override
    public void move(double dx, double dy) {

    }

    @Override
    public void resizeTo(Point point) {

    }

    @Override
    public Shape peel() {
        return null;
    }
}
