package App;

import App.State.InsertState;
import App.State.State;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class ShapeContainer extends JPanel implements Pointable {
    private static final long serialVersionUID = 1L;
    private List<Shape> shapes = new LinkedList<Shape>();

    private State state = new InsertState(this);
    private Shape selected;

    public ShapeContainer() {
        super();
        MouseHandler mouseHandler = new MouseHandler(this);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.setBackground(Color.white);
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void paintComponent(Graphics g) // anropas av Swing när det är dags att
    // rendera
    {
        super.paintComponent(g);

        for (Shape shape : shapes)
            shape.draw(g);

    }

    public void select(Point point) {
        for (Shape shape : shapes) {
            if (shape.intersects(point)) {
                selected = shape;
                return;
            }
        }
    }

    public void pointerDown(Point point) {
        state.pointerDown(point);
    }

    public void pointerUp(Point point) {
        state.pointerUp(point);
        //selected = null;
    }

    public void pointerMoved(Point point, boolean pointerDown) {
        state.pointerMoved(point,selected,pointerDown);
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Shape> getList(){
        return shapes;
    }

    public void setSelected(Shape setSelected){
        selected = setSelected;
    }
    public Shape getSelected(){
        return selected;
    }
}
