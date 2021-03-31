package lab06;

import java.awt.*;

public class Shape {
    private int id;
    private Color color;
    private int radius, sides;
    private int x, y;
    private int width, height;
    private String form;

    public Shape(int id) { this.id = id; }

    public int getId() { return id; }

    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }
    public int getSides() { return sides; }
    public void setSides(int sides) { this.sides = sides; }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public String getForm() { return form; }
    public void setForm(String form) { this.form = form; }

    @Override
    public String toString() {
        return "Shape{" +
                "id=" + id +
                ", shapeCenter=" + x + " " + y +
                ", radius=" + radius +
                ", sides=" + sides +
                '}';
    }
}
