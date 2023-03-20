package App.State;

import App.CrossDecorator;
import App.Point;
import App.Shape;
import App.ShapeContainer;

public class MarkState extends State{
    public MarkState(ShapeContainer shape) {
        super(shape);
    }

    @Override
    public void pointerDown(Point point) {
        container.select(point);
        if(container.getSelected() != null){
            //App.Shape markedShape = new App.ShapeDecorator(selected);
            Shape markedShape = new CrossDecorator(container.getSelected());
            shapes.remove(container.getSelected());
            shapes.add(markedShape);
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
