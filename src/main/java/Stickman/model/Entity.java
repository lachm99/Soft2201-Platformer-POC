package Stickman.model;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Entity {
    private String imgPath;
    private ImageView img;
    private double posX;
    private double posY;
    private double velX;
    private double velY;
    private double width;
    private double height;

    public Sprite(String imgPath, double posX, double posY) {
        this.img = new ImageView(imgPath);
        this.posX = posX;
        this.posY = posY;
    }

    public boolean setImg(String imgPath) {
        this.imgPath = imgPath;
        this.img = new ImageView(this.imgPath);
    }

    // ...
    // methods omitted for brevity
    // ...

    public void update() {
        posX += velX;
        posY += velY;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(this.img, this.posX, this.posY);
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(posX, posY, width, height);
    }

    public boolean intersects(Sprite s) {
        return s.getBoundary().intersects(this.getBoundary());
    }

}
