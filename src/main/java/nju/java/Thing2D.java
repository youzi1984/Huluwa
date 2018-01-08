package nju.java;

import java.awt.Image;

public class Thing2D {

    private final int SPACE = 20;

    private int x;
    private int y;
    private Image image;
    private int w;//moving field
    private int h;
    
    public Thing2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Thing2D(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image img) {
        image = img;
    }

    public void resetImage() {
    	return;
    }
    
    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }
    
    public int w() {
        return this.w;
    }

    public int h() {
        return this.h;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


} 