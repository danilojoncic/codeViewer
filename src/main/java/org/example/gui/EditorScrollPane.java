package org.example.gui;

import org.example.control.LineNumberController;
import org.example.gui.MyTextPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * veliko hvala Philipp Wilhelm
 * Provides a JScrollPane with line-numbers
 */
public class EditorScrollPane extends JScrollPane {
    private JTextPane inputArea;
    private String indentation = "  ";
    private JTextPane lineNumbers;
    private LineNumberController lineNumberController;

    public EditorScrollPane(MyTextPane myTextPane) {
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

        doc.addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                lineNumbers();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                lineNumbers();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                lineNumbers();
            }
        });
        this.setFont(new Font(Font.MONOSPACED, 15, Font.BOLD));
        this.getViewport().add(inputArea);
        this.setRowHeaderView(lineNumbers);
    }

    private void lineNumbers() {
        try {
            String str = inputArea.getText();
            SimpleAttributeSet lineNumbersAttributes = new SimpleAttributeSet();
            StyleConstants.setFontFamily(lineNumbersAttributes, inputArea.getFont().getFamily());
            StyleConstants.setFontSize(lineNumbersAttributes, inputArea.getFont().getSize());
            StyleConstants.setAlignment(lineNumbersAttributes, StyleConstants.getAlignment(inputArea.getParagraphAttributes()));
            lineNumbers.setParagraphAttributes(lineNumbersAttributes, true);
            Document doc = lineNumbers.getDocument();
            doc.remove(0, doc.getLength());
            int length = str.length() - str.replaceAll("\n", "").length() + 1;
            for (int i = 1; i <= length; i++) {
                if (i < length) {
                    doc.insertString(doc.getLength(), i + "\n", lineNumbersAttributes);
                } else {
                    doc.insertString(doc.getLength(), i + "\n", lineNumbersAttributes);
                }
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    public void setIndentationSize(int size) {
        String cache = indentation;
        indentation = "";
        for (int i = 0; i < size; i++) {
            indentation += " ";
        }

        inputArea.setText(inputArea.getText().replaceAll(cache, indentation));
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

    public String getText() {
        return inputArea.getText();
    }
    public void setText(String str) {
        inputArea.setText(str);
    }
}