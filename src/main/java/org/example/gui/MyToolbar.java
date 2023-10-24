package org.example.gui;

import org.example.control.InputListener;
import org.example.control.LoadController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyToolbar extends JToolBar implements ActionListener {
    private JButton btnExec;
    private String useless;
    private JButton clicked;
    private JButton btnSave;
    private JButton btnLoad;
    private JButton btnScreenshot;
    private InputListener inputListener;

    public MyToolbar() {
        init();
    }

    public void init() {
        useless = new String("local value that the interface will overwrite anyway");
        btnExec = new JButton("Run");
        btnSave = new JButton();
        btnLoad = new JButton();
        btnScreenshot = new JButton();
        btnSave.setIcon(new ImageIcon(getClass().getResource("/save.png")));
        btnLoad.setIcon(new ImageIcon(getClass().getResource("/openFolder.png")));
        btnScreenshot.setIcon(new ImageIcon(getClass().getResource("/picture.png")));
        this.setBorder(BorderFactory.createEtchedBorder());
        btnExec.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(btnSave);
        this.add(btnScreenshot);
        this.add(btnLoad);
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

    public JButton getBtnScreenshot() {
        return btnScreenshot;
    }

    public void setBtnScreenshot(JButton btnScreenshot) {
        this.btnScreenshot = btnScreenshot;
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

    public JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSave = btnSave;
    }

    public JButton getBtnLoad() {
        return btnLoad;
    }

    public void setBtnLoad(JButton btnLoad) {
        this.btnLoad = btnLoad;
    }

    public void setUseless(String useless) {
        this.useless = useless;
    }
}

