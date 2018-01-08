package nju.java;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class myPaint implements Runnable{
	Field field;
	Image huluwaDead;
	Image lackeyDead;
	Image scorpionDead;
	Image grandpaDead;
	Image snakeDead;
	int Lackeynum;
	public myPaint(Field field) {
		this.field = field;
		URL loc = this.getClass().getClassLoader().getResource("huluwa-dead.png");
        ImageIcon iia = new ImageIcon(loc);
        huluwaDead = iia.getImage();
        loc = this.getClass().getClassLoader().getResource("lackey-dead.png");
        iia = new ImageIcon(loc);
        lackeyDead = iia.getImage();
        loc = this.getClass().getClassLoader().getResource("scorpion-dead.png");
        iia = new ImageIcon(loc);
        scorpionDead = iia.getImage();
        loc = this.getClass().getClassLoader().getResource("爷爷死.png");
        iia = new ImageIcon(loc);
        grandpaDead = iia.getImage();
        loc = this.getClass().getClassLoader().getResource("蛇精死.png");
        iia = new ImageIcon(loc);
        snakeDead = iia.getImage();
        Lackeynum = 0;
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		
		JFileChooser jfc=new JFileChooser("save");  
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
        jfc.showDialog(new JLabel(), "选择一次战斗记录");  
        File file=jfc.getSelectedFile();  

        for(Player c:field.positiveCreatures) {
			 c.resetImage();
		 }
		 for(Player c:field.negativeCreatures) {
			 c.resetImage();
		 }
            
            
    	String str = "save" + File.separator + jfc.getSelectedFile().getName();
    	File readfile = new File(str);
    	FileReader fileReader = null;
		try {
			fileReader = new FileReader(readfile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str1;
		try {
			str1 = bufferedReader.readLine();
			while(str1 != null) {
            	 if(!str1.equals("***")) {
                    replaying(str1);
                 }
                 else {
                    try {
                    	Lackeynum = 0;
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                 }
            	 str1 = bufferedReader.readLine();
            }
			bufferedReader.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
   }
	 private synchronized void replaying(String str) {
		 
		         String name = null;
		         int x = -1, y = -1;
		         boolean isAlive = false;
		         String[] temp = str.split(" ");
		         if( temp.length != 4 )
		             return;
		         name = temp[0];
		         x = Integer.parseInt(temp[1]);
		         y = Integer.parseInt(temp[2]);
		         isAlive = (temp[3].equals("true")) ? true : false;
		 
		  
		         boolean isHulu = false;
		         int Hulunum = 0;
		         
		         if(name.equals("一")) {
			         	isHulu = true;
			         Hulunum = 0;
			         }
		         else if(name.equals("二")) {
		        	 isHulu = true;
			         Hulunum = 1;
		         }
		         else if(name.equals("三")) {
		        	 isHulu = true;
			         Hulunum = 2;
			     }
		         else if(name.equals("四")) {
		        	 isHulu = true;
			         Hulunum = 3;

			     }
		         else if(name.equals("五")) {
		        	 isHulu = true;
			         Hulunum = 4;

			     }
		         else if(name.equals("六")) {
		        	 isHulu = true;
			         Hulunum = 5;

			     }
		         else if(name.equals("七")) {
		        	 isHulu = true;
			         Hulunum = 6;
			     }
		         else if (name.equals("爷")) {
		        	 field.grandpa.setX(x);
		        	 field.grandpa.setY(y);
		        	 if(!isAlive) {
		        		 field.grandpa.isAlive = false;
		        		 field.grandpa.setImage(grandpaDead);
		        	 }
		         }
		         else if (name.equals("蝎")) {
		        	 field.scorpion.setX(x);
		        	 field.scorpion.setY(y);
		        	 if(!isAlive) {
		        		 field.scorpion.isAlive = false;
		        		 field.scorpion.setImage(scorpionDead);
		        	 }
		         }
		         else if (name.equals("蛇")) {
		        	 field.snake.setX(x);
		        	 field.snake.setY(y);
		        	 if(!isAlive) {
		        		 field.snake.isAlive = false;
		        		 field.snake.setImage(snakeDead);
		        	 }
		         }
		         else if (name.equals("啰")) {
		        	 field.lackeys.get(Lackeynum).setX(x);
		        	 field.lackeys.get(Lackeynum).setY(y);
		        	 if(!isAlive) {
		        		 field.lackeys.get(Lackeynum).isAlive = false;
		        		 field.lackeys.get(Lackeynum).setImage(lackeyDead);
		        	 }
		        	 Lackeynum++;
		         }
		         
		         if(isHulu) {
		        	 field.brothers.get(Hulunum).setX(x);
		        	 field.brothers.get(Hulunum).setY(y);
		        	 if(!isAlive) {
		        		 field.brothers.get(Hulunum).isAlive = false;
		        		 field.brothers.get(Hulunum).setImage(huluwaDead);
		        	 }
		         }
		         field.repaint();
		        

		         return;
		     }

}
