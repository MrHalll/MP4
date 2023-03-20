package App.State;

import App.Point;
import App.Shape;
import App.ShapeContainer;

public class UnmarkState extends State{
    public UnmarkState(ShapeContainer shape) {
        super(shape);
    }

    @Override
    public void pointerDown(Point point) {
        container.select(point);
        if(container.getSelected() != null){
            Shape unmarkedShape = container.getSelected().peel();
            shapes.remove(container.getSelected());
            shapes.add(unmarkedShape);
            container.repaint();
        }
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
