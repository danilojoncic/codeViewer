package org.example.control;

import org.example.gui.MyEditorScrollPane;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class LineNumberController {

    MyEditorScrollPane myEditorScrollPane;
    public LineNumberController(MyEditorScrollPane myEditorScrollPane) {
        this.myEditorScrollPane = myEditorScrollPane;
        attachListeners();
    }

    private void attachListeners() {
        myEditorScrollPane.getInputArea().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                lineNumbers();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                lineNumbers();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                lineNumbers();
            }
        });
    }
    private void lineNumbers(){
        try {
            String str = myEditorScrollPane.getInputArea().getText();
            SimpleAttributeSet lineNumbersAttributes = new SimpleAttributeSet();
            StyleConstants.setFontFamily(lineNumbersAttributes, myEditorScrollPane.getInputArea().getFont().getFamily());
            StyleConstants.setFontSize(lineNumbersAttributes, myEditorScrollPane.getInputArea().getFont().getSize());
            StyleConstants.setAlignment(lineNumbersAttributes, StyleConstants.getAlignment(myEditorScrollPane.getInputArea().getParagraphAttributes()));
            myEditorScrollPane.getLineNumbers().setParagraphAttributes(lineNumbersAttributes, true);
            Document doc = myEditorScrollPane.getLineNumbers().getDocument();
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
}
