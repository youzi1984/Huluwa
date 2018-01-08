package nju.java;

import java.awt.Image;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;

public class Huluwa extends Player{
	private COLOR color;
    private SENIORITY seniority;
	
    public Huluwa(int x, int y, int w, int h, Field field) {
		super(x, y, w, h, field);
		// TODO Auto-generated constructor stub
		URL loc = this.getClass().getClassLoader().getResource("����.png");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
		this.orientation = 1;
	}
	
	public Huluwa(int x, int y, int w, int h, Field field, COLOR color, SENIORITY seniority) {
		super(x, y, w, h, field);
		// TODO Auto-generated constructor stub
		URL loc = null;
		switch(seniority) {
			case һ:loc = this.getClass().getClassLoader().getResource("����.png");break;
			case ��:loc = this.getClass().getClassLoader().getResource("����.png");break;
			case ��:loc = this.getClass().getClassLoader().getResource("����.png");break;
			case ��:loc = this.getClass().getClassLoader().getResource("����.png");break;
			case ��:loc = this.getClass().getClassLoader().getResource("����.png");break;
			case ��:loc = this.getClass().getClassLoader().getResource("����.png");break;
			case ��:loc = this.getClass().getClassLoader().getResource("����.png");break;
			default:break;
		}
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
        this.color = color;
        this.seniority = seniority;
		this.orientation = 1;
	}
	
	@Override
    public String toString(){
        return this.seniority.toString();
    }
	
	@Override
	public void resetImage() {
		URL loc = null;
		switch(seniority) {
			case һ:loc = this.getClass().getClassLoader().getResource("����.png");break;
			case ��:loc = this.getClass().getClassLoader().getResource("����.png");break;
			case ��:loc = this.getClass().getClassLoader().getResource("����.png");break;
			case ��:loc = this.getClass().getClassLoader().getResource("����.png");break;
			case ��:loc = this.getClass().getClassLoader().getResource("����.png");break;
			case ��:loc = this.getClass().getClassLoader().getResource("����.png");break;
			case ��:loc = this.getClass().getClassLoader().getResource("����.png");break;
			default:break;
		}
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
	}
	
	@Override
	public void run() {
        while (!Thread.interrupted()&&!field.isCompleted()) {
            Random rand = new Random();

            this.move(rand.nextInt(11)*orientation*2, rand.nextInt(11)-5);
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


enum COLOR {
    ��, ��, ��, ��, ��, ��, ��
}

enum SENIORITY {
    һ, ��, ��, ��, ��, ��, ��
}
