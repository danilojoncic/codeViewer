package org.example.gui;

import org.example.util.Constants;
import org.example.control.WordListener;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class MyTextPane extends JTextPane {
    public MyTextPane() {
        this.getDocument().addDocumentListener(new WordListener(this));
        this.setBackground(Color.WHITE);
        Font font = new Font(Font.MONOSPACED,Font.BOLD,15);
        this.setFont(font);
        this.setVisible(true);
        this.setText(Constants.code1);
    }
}
