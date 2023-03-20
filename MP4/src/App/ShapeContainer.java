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

    public enum Mode {
        INSERT, MOVE, DELETE, MARK, UNMARK, RESIZE
    };

    private State state = new InsertState(this);
    private Mode mode = Mode.INSERT;
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
        /*
        if (mode == Mode.INSERT) {
            shapes.add(new Circle(point, Math.random() * 50.0));
            //shapes.add(new App.Rectangle(point, Math.random() * 100, Math.random() * 100));
            repaint(); // uppmanar swing att måla om
        } else if (mode == Mode.MOVE)
            select(point);
        else if (mode == Mode.DELETE) {
            select(point);
            if (selected != null)
                shapes.remove(selected);
            selected = null;
            repaint(); // uppmanar swing att måla om
        } else if (mode == Mode.MARK) {
            select(point);
            if (selected != null) {
                //App.Shape markedShape = new App.ShapeDecorator(selected);
                Shape markedShape = new CrossDecorator(selected);
                shapes.remove(selected);
                shapes.add(markedShape);
                repaint();
            }
        } else if (mode == Mode.UNMARK) {
            select(point);
            if (selected != null) {
                Shape unmarkedShape = selected.peel();
                shapes.remove(selected);
                shapes.add(unmarkedShape);
                repaint();
            }
        } else if (mode == Mode.RESIZE) {
            select(point);
        }*/
    }

    public void pointerUp(Point point) {
        state.pointerUp(point);
        //selected = null;
    }

    public void pointerMoved(Point point, boolean pointerDown) {
        state.pointerMoved(point,selected,pointerDown);
        /*
       if (selected != null && pointerDown) {
            if (mode == Mode.MOVE) {
                selected.moveTo(point);
                repaint(); // uppmanar swing att måla om
            } else if (mode == Mode.RESIZE) {
                selected.resizeTo(point);
                repaint();
            }
        }*/
    }

    public void setMode(Mode mode, State state) {
        this.mode = mode;
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