package nju.java;


import java.awt.Image;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;

public class Player extends Thing2D implements Runnable {
    protected Field field;
    int orientation;
    public boolean isAlive;
    public int isLeader;
    private final int OFFSET = 30;
    boolean side;

    public Player(int x, int y, int w, int h, Field field) {
        super(x, y, w, h);

        this.field = field;

        URL loc = this.getClass().getClassLoader().getResource("player.png");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
        
        orientation = 1;
        isAlive = true;
        isLeader = 0;
        side = true;
    }

    public String toString() {
    	return null;
    }
    
    
    
    public void move(int x, int y) {
    	Random rand = new Random();
    	if(isAlive) {
    		
    		if(this.side) {
    			for(Player c:field.positiveCreatures) {
    				if(c!=this) {
        				while((Math.abs(this.x()+x-c.x())<30)&&(Math.abs(this.y()+y-c.y())<30)) {
        					x = rand.nextInt(11)*this.orientation;
        					y = rand.nextInt(11)-5;
        					c = field.positiveCreatures.get(0);
        				}
    				}
        		}
    		}
    		else {
	    		for(Player c:field.negativeCreatures) {
	    			if(c!=this) {
		    			while((Math.abs(this.x()+x-c.x())<30)&&(Math.abs(this.y()+y-c.y())<30)) {
	    					x = rand.nextInt(11)*this.orientation;
	    					y = rand.nextInt(11)-5;
	    					c = field.negativeCreatures.get(0);
	    				}
	    			}
	    		}
    		}
    		
    		if(this.side) {
    			int p;
    			for(p = 0; p <field.negativeCreatures.size(); ++p) {
    				if(field.negativeCreatures.get(p).isAlive&&(Math.abs(x-field.negativeCreatures.get(p).x())+Math.abs(y-field.negativeCreatures.get(p).y())<1000))break;
    			}
    			if(p!=field.negativeCreatures.size()) {
    				x = (-1)*(int) (Math.signum(this.x()-field.negativeCreatures.get(p).x())*Math.abs(x));
    				y = (-1)*(int) (Math.signum(this.y()-field.negativeCreatures.get(p).y())*Math.abs(y));
    			}
    		}
    			
    		
    		
	        int nx = this.x() + x;
	        if(nx<OFFSET) {
	        		nx = OFFSET;
	        		this.orientation *= -1;
	        }
	        if(nx>this.w()) {
	        		nx = this.w();
	        		this.orientation *= -1;
	        }
	        int ny = this.y() + y;
	        if(ny<OFFSET)ny = OFFSET;
	        if(ny>this.h())ny = this.h();
	        this.setX(nx);
	        this.setY(ny);
    	}
    }

    public void run() {
        while (!Thread.interrupted()) {
            Random rand = new Random();

            this.move(rand.nextInt(10)*orientation, rand.nextInt(10)-5);
            try {

                Thread.sleep(rand.nextInt(1000));
                this.field.repaint();

            } catch (Exception e) {

            }
        }
    }
}