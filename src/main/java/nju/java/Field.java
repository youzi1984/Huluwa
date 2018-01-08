package nju.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URL;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Field extends JPanel {
	
    private final int OFFSET = 30;
    private final int SPACE = 30;
        
    //private ArrayList tiles = new ArrayList();
    public ArrayList<Player> positiveCreatures;
    public ArrayList<Player> negativeCreatures;
    public ArrayList<Thread> creaturesThreads;
    public Recorder recorder;
    public God god;
    public ArrayList<Huluwa> brothers;
    public ArrayList<Lackey> lackeys;
    public Scorpion scorpion;
    public Snake snake;
    public Grandpa grandpa;

   // private int w = 0;
   // private int h = 0;
    private int w = OFFSET;
    private int h = OFFSET;
    private boolean completed = false;
    private boolean isPlaying = false;
    private String level =
    				"..........................&...\n" +
    				"..............................\n" +
    				"........................&.....\n" +
    				"..............................\n" +
    				"......................&.......\n" +
                    "..............................\n" +
                    "!..@...@...@........&.........\n" +
                    "..................#...........\n" +
                    ".@...@...@...@................\n" +
                    "..................%...........\n" +
                    "....................&.........\n" +
                    "..............................\n" +
                    "......................&.......\n" +
                    "..............................\n" +
                    "........................&.....\n" +
                    "..............................\n" +
                    "..........................&...\n" +
                    "..............................\n";

    public boolean isCompleted() {
    	return this.completed;
    }
    
    public void setCompleted(boolean con) {
    	this.completed = con;
    }
    
    public Field() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        initWorld();
    }

    public int getBoardWidth() {
        return this.w;
    }

    public int getBoardHeight() {
        return this.h;
    }

    public final void initWorld() {

    		
        int x = OFFSET;
        int y = OFFSET;
    		//int x = 0;
    		//int y = 0;
    		positiveCreatures = new ArrayList<Player>();
    		negativeCreatures = new ArrayList<Player>();
    		creaturesThreads = new ArrayList<Thread>();
    		brothers = new ArrayList<Huluwa>();
    		lackeys = new ArrayList<Lackey>();
    		god = new God(this);
            
        //Tile a;
        recorder = new Recorder(this);

        //get w&h
        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);

            if (item == '\n') {
                y += SPACE;
                if (this.w < x) {
                    this.w = x;
                }

                x = OFFSET;
              //  x = 0;
            } else {
                x += SPACE;
            }

            h = y;
        }

        //x = 0;
        //y = 0;
        x = OFFSET;
        y = OFFSET;
        int temphulu = 0;
        int templackey = 0;
        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);

            if (item == '\n') {
                y += SPACE;
                x = OFFSET;
              //  x = 0;
            } else if (item == '.') {

                x += SPACE;
            } else if (item == '@') {
                brothers.add(new Huluwa(x, y, w-2*SPACE, h-2*SPACE, this,COLOR.values()[temphulu], SENIORITY.values()[temphulu]));
                ++temphulu;
                x += SPACE;
            } else if (item == '&') {
                lackeys.add(new Lackey(x, y, w-2*SPACE, h-2*SPACE, this));
                ++templackey;
                x += SPACE;
            } else if (item == '#') {
            		scorpion = new Scorpion(x, y, w-2*SPACE, h-2*SPACE, this);
            		negativeCreatures.add(scorpion);
            		x += SPACE;
            } else if (item == '%') {
        		snake = new Snake(x, y, w-2*SPACE, h-2*SPACE, this);
        		negativeCreatures.add(snake);
        		x += SPACE;
            } else if (item == '!') {
        		grandpa = new Grandpa(x, y, w-2*SPACE, h-2*SPACE, this);
        		positiveCreatures.add(grandpa);
        		x += SPACE;
            } else if (item == ' ') {
                x += SPACE;
            }

        }
        positiveCreatures.addAll(brothers);
        negativeCreatures.addAll(lackeys);
      //  player2 = new Player(0+ OFFSET,0+OFFSET, w, h, this);
       // player2 = new Player(0, 0, w, h, this);
    }

    
    public void buildWorld(Graphics g) {

        g.setColor(new Color(250, 240, 170));
        //g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.fillRect(0, 0, 960, 580);
        
        
        ArrayList world = new ArrayList();
        URL loc = this.getClass().getClassLoader().getResource("background1.png");
        ImageIcon iia = new ImageIcon(loc);
        Image background = iia.getImage();
        g.drawImage(background, 0,0,this);
        g.setColor(new Color(0,0,0));
        g.setFont(new Font("宋体",Font.BOLD,30));//设置字体  
        g.drawString("按空格键开始战斗，按L键选择回放", 30, 30);

        world.addAll(positiveCreatures);
        world.addAll(negativeCreatures);


        for (int i = 0; i < world.size(); i++) {

            Thing2D item = (Thing2D) world.get(i);

            if (item instanceof Player) {
                g.drawImage(item.getImage(), item.x() + 2, item.y() + 2, this);
            } else {
                g.drawImage(item.getImage(), item.x(), item.y(), this);
            }

            if (completed) {
            	isPlaying = false;
                g.setFont(new Font("宋体",Font.BOLD,30));//设置字体  
                g.drawString("战斗结束", 30, 100);
            }

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buildWorld(g);
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {


            int key = e.getKeyCode();


            if (key == KeyEvent.VK_SPACE) {
            	if(!isPlaying) {
            		isPlaying = true;
	            	new Thread(god).start();
	            	creaturesThreads.add(new Thread(recorder));
	            	for(int i = 0; i < positiveCreatures.size();++i) {
	            		creaturesThreads.add(new Thread(positiveCreatures.get(i)));
	            	}
	            	for(int i = 0; i < negativeCreatures.size();++i) {
	            		creaturesThreads.add(new Thread(negativeCreatures.get(i)));
	            	}
	            	for(Thread t:creaturesThreads) {
	            		t.start();
	            	}
            	}
            	

            } else if (key == KeyEvent.VK_R) {
                restartLevel();
            }else if (key == KeyEvent.VK_L) {
            	//replaying();
            	completed = false;
            	myPaint mypaint = new myPaint(Field.this);
            	new Thread(mypaint).start();
            }

            repaint();
        }
    }


    public void restartLevel() {

        //tiles.clear();
        initWorld();
        if (completed) {
            completed = false;
        }
    }
    
    
   
}