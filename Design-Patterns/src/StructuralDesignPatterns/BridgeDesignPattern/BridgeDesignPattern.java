package StructuralDesignPatterns.BridgeDesignPattern;
/* Implementor Interface **/
interface Renderer {
    void renderShape(String shape);
}
/* Abstract Shape */
abstract class Shape {
    protected Renderer renderer;

    protected Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    abstract void draw();
}

class RedRenderer implements Renderer {
    public void renderShape(String shape) {
        System.out.println("Rendering " + shape + " in RED");
    }
}

class BlueRenderer implements Renderer {
    public void renderShape(String shape) {
        System.out.println("Rendering " + shape + " in BLUE");
    }
}

class Circle extends Shape {
    public Circle(Renderer renderer) {
        super(renderer);
    }

    public void draw() {
        renderer.renderShape("Circle");
    }
}

class Rectangle extends Shape {
    public Rectangle(Renderer renderer) {
        super(renderer);
    }

    public void draw() {
        renderer.renderShape("Rectangle");
    }
}


public class BridgeDesignPattern {
    public static void main(String args[])
    {
        Shape redCircle = new Circle(new RedRenderer());
        Shape blueRectangle = new Rectangle(new BlueRenderer());

        redCircle.draw();
        blueRectangle.draw();
    }
}
