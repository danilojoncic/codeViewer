package org.example.gui;



import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{
    MyTextPane myTextPane;
    public MyPanel() {
        this.setBackground(Color.gray);
        this.setLayout(new BorderLayout());
        myTextPane = new MyTextPane();
        this.add(myTextPane);
        this.setVisible(true);
    }

    public MyTextPane getMyTextPane() {
        return myTextPane;
    }

    public void setMyTextPane(MyTextPane myTextPane) {
        this.myTextPane = myTextPane;
    }
}
