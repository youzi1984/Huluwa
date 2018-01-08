package nju.java;


import javax.swing.JFrame;


public final class Ground extends JFrame {

    private final int OFFSET = 30;
    private Field field;

    public Ground() {
        InitUI();
    }

    public void InitUI() {
        field = new Field();
        add(field);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(field.getBoardWidth() + OFFSET,
                field.getBoardHeight() + 2 * OFFSET);
        //setSize(field.getBoardWidth(),
        //        field.getBoardHeight());
        setLocationRelativeTo(null);
        setTitle("Ground");
        
        this.setVisible(true);
        
        
    }
/*

    public static void main(String[] args) {
        Ground ground = new Ground();
       // ground.setVisible(true);
        
    }
    */
}