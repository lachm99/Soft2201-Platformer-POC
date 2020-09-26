package Stickman.view;


import Stickman.model.Entity;

public interface EntityView {

    Entity getEntity();

    void render();

    void setLayer();
}
