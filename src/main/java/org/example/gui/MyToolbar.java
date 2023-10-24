package org.example.gui;

import org.example.control.InputListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyToolbar extends JToolBar implements ActionListener {
    private JButton btnExec;
    private String useless;
    private JButton clicked;
    private InputListener inputListener;

    public MyToolbar() {
        init();
    }

    public void init() {
        useless = new String("local value that the interface will overwrite anyway");
        btnExec = new JButton("Run");
        this.setBorder(BorderFactory.createEtchedBorder());
        btnExec.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(Box.createHorizontalGlue());
        int rightMargin = 25;
        EmptyBorder emptyBorder = new EmptyBorder(7, 25, 7, rightMargin);
        btnExec.setBorder(emptyBorder);
        this.add(btnExec);
    }

    public JButton getBtnExec() {
        return btnExec;
    }

    public void setBtnExec(JButton btnExec) {
        this.btnExec = btnExec;
    }

    public InputListener getInputListener() {
        return inputListener;
    }

    public void setInputListener(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    public JButton getClicked() {
        return clicked;
    }

    public void setClicked(JButton clicked) {
        this.clicked = clicked;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clicked = (JButton) e.getSource();
        if (clicked == btnExec) {
            System.out.println("Not today :)");
            if(inputListener != null){
                inputListener.listenInput(useless);
            }
        }
    }

    public String getUseless() {
        return useless;
    }

    public void setUseless(String useless) {
        this.useless = useless;
    }
}
