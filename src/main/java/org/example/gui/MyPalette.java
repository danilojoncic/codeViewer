package org.example.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyPalette extends JToolBar {
    private JButton buttonNext;

    private JButton buttonBefore;

    public MyPalette() {
        super(JToolBar.HORIZONTAL);
        this.setLayout(new BorderLayout());
        buttonBefore = new JButton("Before");
        buttonNext = new JButton("Next");
        this.add(buttonBefore,BorderLayout.WEST);
        this.add(buttonNext,BorderLayout.EAST);
        this.setFloatable(false);
    }


    public JButton getButtonNext() {
        return buttonNext;
    }

    public void setButtonNext(JButton buttonNext) {
        this.buttonNext = buttonNext;
    }

    public JButton getButtonBefore() {
        return buttonBefore;
    }

    public void setButtonBefore(JButton buttonBefore) {
        this.buttonBefore = buttonBefore;
    }
}
