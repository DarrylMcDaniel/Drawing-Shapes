
import javax.swing.*;
import java.awt.*;


abstract class Shape extends Rectangle {
    Color color;
    boolean isHollow;

    public static int shapeCount;

    public Shape(Rectangle shape, Color color, boolean isHollow){
        super(shape.x, shape.y, shape.width, shape.height);
        this.color = color;
        this.isHollow = isHollow;
        shapeCount++;
    }

    public void setColor(Graphics g) {
        g.setColor(this.color);
    }

    public void getSolid(){
        if(this.isHollow){
            System.out.println("Its Hollow");
        }
        else {
            System.out.println("Its Solid");
        }

    }

    public static int getNoOfShapes(){
        return shapeCount;
    }

    abstract void draw(Graphics g);
}

class Oval extends Shape {

    public Oval(Rectangle shape, Color color, boolean isHollow) {
        super(shape, color, isHollow);

    }

    @Override
    void draw(Graphics g) {

        super.setColor(g);
        if (this.isHollow) {
            g.drawOval(this.x, this.y, this.width, this.height);
        } else {
            g.fillOval(this.x, this.y, this.width, this.height);
        }
    }
}
class Rectangular extends Shape {
    public Rectangular(Rectangle shape, Color color, boolean isHollow) {
        super(shape, color, isHollow);
    }

    @Override
    void draw(Graphics g) {
        super.setColor(g);
        if (this.isHollow) {
            g.drawRect(this.x, this.y, this.width, this.height);
        } else {
            g.fillRect(this.x, this.y, this.width, this.height);
        }
    }
}
    class Drawing extends JPanel {
        Shape currentShape;


        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public void drawShape(Shape currentShape) throws OutsideBounds{
            if (currentShape.x <=0){
               throw new OutsideBounds();
            }

            if (currentShape.x >= this.getPreferredSize().getWidth()){
                throw new OutsideBounds();
            }

            if (currentShape.y <= 0){
                throw new OutsideBounds();
            }

            if (currentShape.y >= this.getPreferredSize().getHeight()){
                throw new OutsideBounds();
            }
            if(currentShape.getMaxX() >= this.getPreferredSize().getWidth())
                throw new OutsideBounds();
            if(currentShape.getMaxY() >= this.getPreferredSize().getHeight())
                throw new OutsideBounds();
            if(currentShape.width <= 0)
                throw new OutsideBounds();
            if(currentShape.height <= 0)
                throw new OutsideBounds();


            this.currentShape = currentShape;
            this.repaint();

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(currentShape != null) {
                g.drawString("" + Shape.getNoOfShapes(), 0, 10);
                currentShape.draw(g);

            }
        }

    }

    class OutsideBounds extends Exception {
        public OutsideBounds() {
            JOptionPane.showMessageDialog(null,"Out of Drawing Parameters");
        }
    }






