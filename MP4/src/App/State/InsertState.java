package App.State;

import App.Circle;
import App.Point;
import App.Shape;
import App.ShapeContainer;

public class InsertState extends State{
    public InsertState(ShapeContainer container) {
        super(container);
    }

    @Override
    public void pointerDown(Point point) {
        //container.addShape(new Circle(point, Math.random() * 50.0));
        container.addShape(new App.Rectangle(point, Math.random() * 100, Math.random() * 100));
        container.repaint(); // uppmanar swing att måla om
    }

    @Override
    public void pointerUp(Point point) {
        container.setSelected(null);
    }

    @Override
    public void pointerMoved(Point point, Shape selected, boolean pointerDown) {
        //Ingen Implementation
    }
}
