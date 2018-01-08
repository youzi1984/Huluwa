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
		URL loc = this.getClass().getClassLoader().getResource("大娃.png");
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
			case 一:loc = this.getClass().getClassLoader().getResource("大娃.png");break;
			case 二:loc = this.getClass().getClassLoader().getResource("二娃.png");break;
			case 三:loc = this.getClass().getClassLoader().getResource("三娃.png");break;
			case 四:loc = this.getClass().getClassLoader().getResource("四娃.png");break;
			case 五:loc = this.getClass().getClassLoader().getResource("五娃.png");break;
			case 六:loc = this.getClass().getClassLoader().getResource("六娃.png");break;
			case 七:loc = this.getClass().getClassLoader().getResource("七娃.png");break;
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
			case 一:loc = this.getClass().getClassLoader().getResource("大娃.png");break;
			case 二:loc = this.getClass().getClassLoader().getResource("二娃.png");break;
			case 三:loc = this.getClass().getClassLoader().getResource("三娃.png");break;
			case 四:loc = this.getClass().getClassLoader().getResource("四娃.png");break;
			case 五:loc = this.getClass().getClassLoader().getResource("五娃.png");break;
			case 六:loc = this.getClass().getClassLoader().getResource("六娃.png");break;
			case 七:loc = this.getClass().getClassLoader().getResource("七娃.png");break;
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
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}

enum SENIORITY {
    一, 二, 三, 四, 五, 六, 七
}
