package org.example.control;

import org.example.util.Constants;
import org.example.gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContentController {
    private int index = 0;
    private int range = Constants.numbers.length;
    MainFrame mainFrame;
    public ContentController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        attachListeners();
    }

    private void attachListeners() {
        mainFrame.getMyPalette().getButtonBefore().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index--;
                if(index  < 0 ){
                    index = range;
                }
                mainFrame.getMyPanel().getMyTextPane().setText(" ");
                mainFrame.getMyPanel().getMyTextPane().setText(Constants.code[index]);
            }
        });

        mainFrame.getMyPalette().getButtonNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index++;
                if(index == range-1){
                    index = 0;
                }
                mainFrame.getMyPanel().getMyTextPane().setText(" ");
                mainFrame.getMyPanel().getMyTextPane().setText(Constants.code[index]);
            }
        });
    }






}
