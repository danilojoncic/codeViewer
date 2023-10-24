package org.example.control;

import org.example.gui.MainFrame;
import org.example.util.MyFileWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveController{

    MainFrame mainFrame;
    public SaveController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        attachListener();
    }

    private void attachListener() {
        mainFrame.getMyToolbar().getBtnSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == mainFrame.getMyToolbar().getBtnSave()) {
                    JFileChooser fileChooser = new JFileChooser();
                    int returnValue = fileChooser.showSaveDialog(null);

                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        String filePath = selectedFile.getAbsolutePath();

                        String contentToSave = mainFrame.getMyPanel().getMyTextPane().getText();

                        if (MyFileWriter.writeFile(filePath, contentToSave)) {
                            System.out.println("File saved successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to save the file.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }

}

