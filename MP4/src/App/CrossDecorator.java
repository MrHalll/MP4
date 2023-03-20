package App;

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
        return decoratee.getPosition();
    }

    @Override
    public double getWidth() {
        return decoratee.getWidth();
    }

    @Override
    public double getHeight() {
        return decoratee.getHeight();
    }

    @Override
    public boolean intersects(Point point) {
        return decoratee.intersects(point);
    }

    @Override
    public void moveTo(Point point) {
        decoratee.moveTo(point);
    }

    @Override
    public void move(double dx, double dy) {
        decoratee.move(dx, dy);
    }

    @Override
    public void resizeTo(Point point) {
        decoratee.resizeTo(point);
    }

    @Override
    public Shape peel() {
        return decoratee;
    }
}
