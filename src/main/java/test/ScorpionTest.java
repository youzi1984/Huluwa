package test;

import nju.java.Scorpion;
import org.junit.Test;

import javax.swing.*;

import java.net.URL;

public class ScorpionTest {
    @Test
    public void testString() throws Exception {
        Scorpion scorpion = new Scorpion(0, 0, 100, 100, null);
        assert(scorpion.toString().equals("Ð«"));
    }

    @Test
    public void testLocation() throws Exception{
    	Scorpion scorpion = new Scorpion(0, 0, 100, 100, null);
        assert( scorpion.x() == 0);
        assert( scorpion.y() == 0);
        scorpion.setX(scorpion.x() + 100 );
        assert( scorpion.x() == 100 );
    }

    @Test
    public void testImage() throws Exception{
    	Scorpion scorpion = new Scorpion(0, 0, 100, 100, null);
        URL url = this.getClass().getClassLoader().getResource("Ð«×Ó¾«.png");
        ImageIcon imageIcon = new ImageIcon(url);
        assert( scorpion.getImage() == imageIcon.getImage() );
    }

}
