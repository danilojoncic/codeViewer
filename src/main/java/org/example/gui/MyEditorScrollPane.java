package org.example.gui;

import org.example.control.LineNumberController;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * veliko hvala Philipp Wilhelm
 * Provides a JScrollPane with line-numbers
 */
public class MyEditorScrollPane extends JScrollPane {
    private JTextPane inputArea;
    private String indentation = "  ";
    private JTextPane lineNumbers;
    private LineNumberController lineNumberController;

    public MyEditorScrollPane(MyTextPane myTextPane) {
        inputArea = myTextPane;
        this.setSize(myTextPane.getSize());
        Document doc = inputArea.getDocument();
        lineNumbers = new JTextPane();
        lineNumbers.setBackground(Color.GRAY);
        lineNumbers.setEditable(false);
        SimpleAttributeSet rightAlign = new SimpleAttributeSet();
        StyleConstants.setAlignment(rightAlign, StyleConstants.ALIGN_RIGHT);
        lineNumbers.setParagraphAttributes(rightAlign, true);
        lineNumberController = new LineNumberController(this);
        this.setFont(new Font(Font.MONOSPACED, 15, Font.BOLD));
        this.getViewport().add(inputArea);
        this.setRowHeaderView(lineNumbers);
    }
    public JTextPane getInputArea() {
        return inputArea;
    }

    public void setInputArea(JTextPane inputArea) {
        this.inputArea = inputArea;
    }

    public JTextPane getLineNumbers() {
        return lineNumbers;
    }

    public void setLineNumbers(JTextPane lineNumbers) {
        this.lineNumbers = lineNumbers;
    }

    }