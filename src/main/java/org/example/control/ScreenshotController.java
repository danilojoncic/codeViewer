package org.example.control;

import org.example.gui.MainFrame;
import org.example.util.MyFileWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotController{

    MainFrame mainFrame;
    public ScreenshotController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        attachListener();
    }

    private void attachListener() {
        mainFrame.getMyToolbar().getBtnScreenshot().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel mojPanel = MainFrame.getInstance().getMyPanel();
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setSelectedFile(new File("slika.png"));
                fileChooser.setDialogTitle("Save as Image");
                int result = fileChooser.showSaveDialog(mojPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    BufferedImage bi = new BufferedImage(mojPanel.getSize().width, mojPanel.getSize().height, BufferedImage.TYPE_INT_ARGB);
                    Graphics g = bi.createGraphics();
                    mojPanel.paint(g);
                    g.dispose();
                    try {
                        File file = fileChooser.getSelectedFile();

                        ImageIO.write(bi, "png", file);

                        // ukoliko korisnik nije stavio da je slika .png, postavice sam
                        if (!file.getName().endsWith(".png")) {
                            file.renameTo(new File(file.getPath() + ".png"));
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });
    }
}


