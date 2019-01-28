package ru.clsoft.cmv2000;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class GUIParameterBoolean {

    CMV2000BooleanParameters params = null;

    public GUIParameterBoolean(CMV2000BooleanParameters params) {
        this.params = params;
    }

    private Map<JCheckBox, CMV2000BoleanItem> mapCheckBoxToItem;

    public JPanel generateUI() {

        JPanel ui = new JPanel();
        mapCheckBoxToItem = new HashMap<>();
        ui.setLayout(new BoxLayout(ui, BoxLayout.Y_AXIS));
        ui.add(new JLabel(params.getName()));
        JPanel panelButton = new JPanel();
        for(CMV2000BoleanItem item: params.getItems()) {
            JCheckBox chk = new JCheckBox(item.getName());
            chk.setSelected(item.isVal());
            mapCheckBoxToItem.put(chk, item);
            chk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JCheckBox src = (JCheckBox)e.getSource();
                    mapCheckBoxToItem.get(src).setVal(src.isSelected());
                }
            });
            panelButton.add(chk);
        }
        ui.add(panelButton);
        return ui;
    }
}
