package App.State;

import App.Point;
import App.Shape;
import App.ShapeContainer;

public class ResizeState extends State{
    public ResizeState(ShapeContainer container) {
        super(container);
    }

    @Override
    public void pointerDown(Point point) {
        container.select(point);
    }

    @Override
    public void pointerUp(Point point) {
        container.setSelected(null);
    }

    @Override
    public void pointerMoved(Point point, Shape selected, boolean pointerDown) {
        if (selected != null && pointerDown) {
            selected.resizeTo(point);
            container.repaint();
        }
    }
}
