package org.example.control;

import org.example.util.Constants;
import org.example.gui.MyTextPane;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordListener implements DocumentListener {
    private MyTextPane myTextPane;
    private StyledDocument styledDocument;
    private Style keywordStyle;
    private Style numberStyle;
    private Style symbolStyle;
    public WordListener(MyTextPane myTextPane) {
        this.myTextPane = myTextPane;
        this.styledDocument = myTextPane.getStyledDocument();
        this.keywordStyle = styledDocument.addStyle("KeywordStyle",null);
        this.numberStyle = styledDocument.addStyle("NumberStyle",null);
        this.symbolStyle = styledDocument.addStyle("SymbolStyle",null);
        StyleConstants.setForeground(keywordStyle, Color.BLUE);
        StyleConstants.setForeground(numberStyle, Color.PINK);
        StyleConstants.setForeground(symbolStyle, Color.RED);
    }

    private void highlightText() {
        SwingUtilities.invokeLater(() -> {
            String text = myTextPane.getText();
            styledDocument.setCharacterAttributes(0, text.length(), styledDocument.getStyle(StyleContext.DEFAULT_STYLE), true);

            for (String keyword : Constants.keywords) {
                Pattern pattern = Pattern.compile("\\b" + Pattern.quote(keyword) + "\\b", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(text);

                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    styledDocument.setCharacterAttributes(start, end - start, keywordStyle, false);
                }
            }

            Pattern numberPattern = Pattern.compile("\\b\\d+\\b");
            Matcher numberMatcher = numberPattern.matcher(text);

            while (numberMatcher.find()) {
                int start = numberMatcher.start();
                int end = numberMatcher.end();
                styledDocument.setCharacterAttributes(start, end - start, numberStyle, false);
            }

            for (char symbol : Constants.symbols) {
                String symbolAsString = String.valueOf(symbol);
                Pattern pattern = Pattern.compile(Pattern.quote(symbolAsString));
                Matcher matcher = pattern.matcher(text);

                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    styledDocument.setCharacterAttributes(start, end - start, symbolStyle, false);
                }
            }
        });
    }




    @Override
    public void insertUpdate(DocumentEvent e) {
        highlightText();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        highlightText();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
