package ru.clsoft.cmv2000;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIParameterInteger {

    private boolean flagUpdate = false;

    CMV2000IntegerParameters params = null;

    private void changeValue(int step) {
        setGUIValue(params.changeValue(step));
    }

    private boolean isValid(int value) {
        return params.isValid(value);
    }

    private JTextField textField = null;
    private JSlider slider = null;

    private void setGUIValue(int value) {
        if (textField == null || slider == null) return;
        if (value < params.getMinValue() || value > params.getMaxValue()) return;
        flagUpdate = true;
        textField.setText(Integer.toString(value));
        slider.setValue(value);
        flagUpdate = false;
    }

    public GUIParameterInteger(CMV2000IntegerParameters params) {
        this.params = params;
    }

    public JPanel generateUI() {

        JPanel ui = new JPanel();
        ui.setLayout(new BoxLayout(ui, BoxLayout.Y_AXIS));
        ui.add(new JLabel(params.getName()));
        JPanel panelButton = new JPanel();
        ActionListener command = new CommandAction();
        addButton(panelButton, "<<", command);
        addButton(panelButton, "<", command);

        textField = new JTextField(10);
        AbstractDocument document = (AbstractDocument) textField.getDocument();
        document.setDocumentFilter(new TextInputVerifier());
        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                int value  = 0;
                if (flagUpdate) return;
                flagUpdate = true;
                try {
                    value = Integer.parseInt(textField.getText());
                    params.setValue(value);
                } catch (NumberFormatException ex) {

                }
                slider.setValue(value);
                flagUpdate = false;
            }

            public void removeUpdate(DocumentEvent e) {
                int value = 0;
                if (flagUpdate) return;
                flagUpdate = true;
                try {
                    value = Integer.parseInt(textField.getText());
                    params.setValue(value);
                } catch (NumberFormatException ex) {

                }
                slider.setValue(value);
                flagUpdate = false;
            }

            public void changedUpdate(DocumentEvent e) {
                int value = 0;
                if (flagUpdate) return;
                flagUpdate = true;
                try {
                    value = Integer.parseInt(textField.getText());
                    params.setValue(value);
                } catch (NumberFormatException ex) {

                }
                slider.setValue(value);
                flagUpdate = false;
            }
        });
        panelButton.add(textField);


        addButton(panelButton, ">", command);
        addButton(panelButton, ">>", command);
        ui.add(panelButton);
        slider = new JSlider(params.getMinValue(), params.getMaxValue(), params.getValue());
        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (flagUpdate) return;
                flagUpdate  = true;
                JSlider source = (JSlider)e.getSource();
                params.setValue(source.getValue());
                setGUIValue(params.getValue());
                flagUpdate = false;
            }
        };
        slider.addChangeListener(changeListener);
        ui.add(slider);
        setGUIValue(params.getValue());
        return ui;
    }

    private void addButton(JPanel panel, String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    private class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("<<")) {
                changeValue(-params.getBigStep());
            } else if (command.equals("<")) {
                changeValue(-params.getStep());
            } else if (command.equals(">")) {
                changeValue(params.getStep());
            } else if (command.equals(">>")) {
                changeValue(params.getBigStep());
            }
        }
    }

    private class TextInputVerifier extends DocumentFilter {
        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
//            String text = fb.getDocument().getText(0,
//                    fb.getDocument().getLength());
//            int value = params.getMinValue();
//            try {
//                value = Integer.parseInt(text);
//            } catch (NumberFormatException ex) {
//            }
//            params.setValue(value);
            super.remove(fb, offset, length);
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            String text = fb.getDocument().getText(0,
                    fb.getDocument().getLength());
            text = text.substring(0, offset) + string +  ((offset < text.length() - 1) ? text.substring(offset + 1) : "");
            int val = 0;
            boolean valid = false;
            try {
                val = Integer.parseInt(text);
                valid = isValid(val);
            } catch (NumberFormatException ex) {

            }
            if (valid) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            String txt = fb.getDocument().getText(0,
                    fb.getDocument().getLength());
            txt = txt.substring(0, offset) + text + ((offset + length <= txt.length() - 1) ? txt.substring(offset + length) : "");
            int val = 0;
            boolean valid = false;
            try {
                val = Integer.parseInt(txt);
                valid = isValid(val);
            } catch (NumberFormatException ex) {

            }
            if (valid)
            super.replace(fb, offset, length, text, attrs);
        }
    }
}

