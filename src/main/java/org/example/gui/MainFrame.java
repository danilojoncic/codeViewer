package org.example.gui;

import org.example.control.ContentController;
import org.example.control.LoadController;
import org.example.control.SaveController;
import org.example.control.ScreenshotController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static MainFrame instance;
    private ContentController contentController;
    private MyEditorScrollPane myEditorScrollPane;
    private LoadController loadController;
    private SaveController saveController;
    private ScreenshotController screenshotController;
    private MyPanel myPanel;
    private MyToolbar myToolbar;
    private MyPalette myPalette;
    private MainFrame(){
        init();
    }

    private void init(){
        this.setTitle("codeViewer");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(720,720));
        this.setLayout(new BorderLayout());
        myPanel = new MyPanel();
        myToolbar = new MyToolbar();
        myPalette = new MyPalette();
        myEditorScrollPane = new MyEditorScrollPane(myPanel.myTextPane);
        myPanel.add(myEditorScrollPane);
        myPanel.add(myEditorScrollPane);
        this.add(myToolbar,BorderLayout.NORTH);
        this.add(myPanel,BorderLayout.CENTER);
        this.add(myPalette,BorderLayout.SOUTH);
        contentController = new ContentController(this);
        loadController = new LoadController(this);
        saveController = new SaveController(this);
        screenshotController = new ScreenshotController(this);
    }



    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
        }
        return instance;
    }

    public MyPanel getMyPanel() {
        return myPanel;
    }

    public void setMyPanel(MyPanel myPanel) {
        this.myPanel = myPanel;
    }

    public MyToolbar getMyToolbar() {
        return myToolbar;
    }

    public void setMyToolbar(MyToolbar myToolbar) {
        this.myToolbar = myToolbar;
    }

    public MyPalette getMyPalette() {
        return myPalette;
    }

    public void setMyPalette(MyPalette myPalette) {
        this.myPalette = myPalette;
    }

    public MyEditorScrollPane getMyEditorScrollPane() {
        return myEditorScrollPane;
    }

    public void setMyEditorScrollPane(MyEditorScrollPane myEditorScrollPane) {
        this.myEditorScrollPane = myEditorScrollPane;
    }
}
