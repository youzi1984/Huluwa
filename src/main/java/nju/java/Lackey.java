package nju.java;

import java.awt.Image;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;

public class Lackey extends Player{

	public Lackey(int x, int y, int w, int h, Field field) {
		super(x, y, w, h, field);
		// TODO Auto-generated constructor stub
		URL loc = this.getClass().getClassLoader().getResource("С����.png");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
        
        this.orientation = -1;
        this.side = false;
	}
	
	@Override
    public String toString() { return "��"; }

	@Override
	public void resetImage() {
		URL loc = this.getClass().getClassLoader().getResource("С����.png");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
	}
	
	
	@Override
		public void run() {
	        while (!Thread.interrupted()) {
	            Random rand = new Random();
	
	            this.move(rand.nextInt(11)*orientation, rand.nextInt(11)-5);
	            try {

	                //Thread.sleep(rand.nextInt(100));
	            	Thread.sleep(100);
	                this.field.repaint();

	            } catch (Exception e) {
	            	e.printStackTrace();
	                Thread.interrupted();
	                break;
	            }
	        }
	    }
	
	

}
