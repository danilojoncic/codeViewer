package org.example.gui;

import org.example.util.Constants;
import org.example.control.WordController;

import javax.swing.*;
import java.awt.*;

public class MyTextPane extends JTextPane {
    public MyTextPane() {
        this.getDocument().addDocumentListener(new WordController(this));
        this.setBackground(Color.WHITE);
        Font font = new Font(Font.MONOSPACED,Font.BOLD,15);
        this.setFont(font);
        this.setVisible(true);
        this.setText(Constants.code1);
    }
}
