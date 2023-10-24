package org.example.control;

import org.example.gui.EditorScrollPane;
import org.example.gui.MainFrame;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class LineNumberController {

    EditorScrollPane editorScrollPane;
    public LineNumberController(EditorScrollPane editorScrollPane) {
        this.editorScrollPane = editorScrollPane;
        attachListeners();
    }

    private void attachListeners() {
        editorScrollPane.getInputArea().getDocument().addDocumentListener(new DocumentListener() {
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
            String str = editorScrollPane.getInputArea().getText();
            SimpleAttributeSet lineNumbersAttributes = new SimpleAttributeSet();
            StyleConstants.setFontFamily(lineNumbersAttributes,editorScrollPane.getInputArea().getFont().getFamily());
            StyleConstants.setFontSize(lineNumbersAttributes, editorScrollPane.getInputArea().getFont().getSize());
            StyleConstants.setAlignment(lineNumbersAttributes, StyleConstants.getAlignment(editorScrollPane.getInputArea().getParagraphAttributes()));
            editorScrollPane.getLineNumbers().setParagraphAttributes(lineNumbersAttributes, true);
            Document doc = editorScrollPane.getLineNumbers().getDocument();
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
