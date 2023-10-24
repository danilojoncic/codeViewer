package org.example.control;

import org.example.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoadController{

    MainFrame mainFrame;
    public LoadController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        attachListener();
    }

    private void attachListener() {
        mainFrame.getMyToolbar().getBtnLoad().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == mainFrame.getMyToolbar().getBtnLoad()) {
                    System.out.println("IM PRESSED");
                    JFileChooser fileChooser = new JFileChooser();
                    int returnValue = fileChooser.showOpenDialog(null);

                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        String filePath = selectedFile.getAbsolutePath();

                        String fileContent = org.example.util.MyFileReader.readFile(filePath);
                        if (fileContent != null) {
                            System.out.println("File Content:\n" + fileContent);
                            mainFrame.getMyPanel().getMyTextPane().setText(fileContent);

                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to read the selected file.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }
}
