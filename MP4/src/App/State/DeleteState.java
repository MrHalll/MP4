package App.State;

import App.Point;
import App.Shape;
import App.ShapeContainer;

public class DeleteState extends State{
    public DeleteState(ShapeContainer shape) {
        super(shape);
    }

    @Override
    public void pointerDown(Point point) {
        container.select(point);
        if(container.getSelected() != null){
            shapes.remove(container.getSelected());
        }
        container.setSelected(null);
        container.repaint(); // uppmanar swing att måla om
    }

    @Override
    public void pointerUp(Point point) {
        container.setSelected(null);
    }

    @Override
    public void pointerMoved(Point point, Shape selected, boolean pointerDown) {
        //Ingen implementation
    }
}
