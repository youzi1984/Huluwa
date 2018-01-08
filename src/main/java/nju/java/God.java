package nju.java;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class God  implements Runnable {
	//ArrayList<Player> positive;
    //ArrayList<Player> negative;
    Field field;
    private ArrayList<Thread> creaturesThreads = null;
    
    public God(Field field) {
    		//positive = new ArrayList<Player>();
    		//negative = new ArrayList<Player>();
    		//this.positive = field.positiveCreatures;
    		//this.negative = field.negativeCreatures;
    		this.field = field;
    		this.creaturesThreads = field.creaturesThreads;
    }
    
    @SuppressWarnings("deprecation")
	public void run() {
    	URL loc = this.getClass().getClassLoader().getResource("huluwa-dead.png");
        ImageIcon iia = new ImageIcon(loc);
        Image huluwaDead = iia.getImage();
        loc = this.getClass().getClassLoader().getResource("lackey-dead.png");
        iia = new ImageIcon(loc);
        Image lackeyDead = iia.getImage();
        loc = this.getClass().getClassLoader().getResource("scorpion-dead.png");
        iia = new ImageIcon(loc);
        Image scorpionDead = iia.getImage();
        loc = this.getClass().getClassLoader().getResource("Ò¯Ò¯ËÀ.png");
        iia = new ImageIcon(loc);
        Image grandpaDead = iia.getImage();
        loc = this.getClass().getClassLoader().getResource("Éß¾«ËÀ.png");
        iia = new ImageIcon(loc);
        Image snakeDead = iia.getImage();
        while (!Thread.interrupted()) {
        	 Random rand = new Random();
        		for(int i = 0; i < field.positiveCreatures.size();++i) {
        			for(int j = 0; j < field.negativeCreatures.size();++j) {
        				if(field.positiveCreatures.get(i).isAlive&&field.negativeCreatures.get(j).isAlive) {
        					if((Math.abs(field.positiveCreatures.get(i).x()-field.negativeCreatures.get(j).x())<30) 
        							&&(Math.abs(field.positiveCreatures.get(i).y()-field.negativeCreatures.get(j).y())<3)) {
        						if(rand.nextInt(10)>7) {
        							field.positiveCreatures.get(i).isAlive = false;
        							if(field.positiveCreatures.get(i).isLeader==1) {
        								field.positiveCreatures.get(i).setImage(grandpaDead);
        							}
        							else {
            							field.positiveCreatures.get(i).setImage(huluwaDead);

        							}
        						}
        						else {
        							field.negativeCreatures.get(j).isAlive = false;
        							if(field.negativeCreatures.get(j).isLeader==1) {
        								field.negativeCreatures.get(j).setImage(scorpionDead);
        							}
        							else if(field.negativeCreatures.get(j).isLeader==2) {
        								field.negativeCreatures.get(j).setImage(snakeDead);
        							}
        							else {
        								field.negativeCreatures.get(j).setImage(lackeyDead);
        							}
        						}
        					}
        				}
        			}
        		}
        		int i, j;
        		for(i = 0; i < field.positiveCreatures.size();++i) {
        			if(field.positiveCreatures.get(i).isAlive) break;
        		}
        		if(i==field.positiveCreatures.size()) {
        			field.setCompleted(true);
//        			for(Thread t:creaturesThreads) {
//                		t.interrupt();
//                	}
        		}
        		for(j = 0; j < field.negativeCreatures.size();++j) {
        			if(field.negativeCreatures.get(j).isAlive) break;
        		}
        		if(j==field.negativeCreatures.size()) {
        			field.setCompleted(true);
//        			for(Thread t:creaturesThreads) {
//                		t.interrupt();
//                	}
        			
        		}
        		try {

                    Thread.sleep(rand.nextInt(100));

                } catch (Exception e) {
                	
                }       
        }
    }
    
}
