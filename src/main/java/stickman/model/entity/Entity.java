package stickman.model.entity;

public abstract class Entity {
    protected double xPos;
    protected double yPos;
    protected double width;
    protected double height;

    public double getX() {
        return this.xPos;
    }

    public double getY() {
        return this.yPos;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setX(double xPos) {
        this.xPos = xPos;
    }

    public void setY(double yPos) {
        this.yPos = yPos;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
