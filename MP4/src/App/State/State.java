package App.State;

import App.Point;
import App.Shape;
import App.ShapeContainer;

import java.util.List;

public abstract class State {

    public ShapeContainer container;
    protected List<Shape> shapes;
    public State(ShapeContainer container){
        this.container = container;
        shapes = container.getList();
    }

    public abstract void pointerDown(Point point);
    public abstract void pointerUp(Point point);

    public abstract void pointerMoved(Point point, Shape selected, boolean pointerDown);
}
