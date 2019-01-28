package ru.clsoft.cmv2000;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.*;

public class CMV2000Frame extends JFrame {

    private final ReadConfig config;
    private final NetCom communication;

    public CMV2000Frame(ReadConfig config, NetCom communication) {
        this.config = config;
        this.communication = communication;
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JButton buttonSend = new JButton("SEND");
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                communication.clearTransferData();
                java.util.List<Object> params = config.getParameters();
                for(Object item : params) {
                    if (item instanceof CMV2000IntegerParameters) {
                        Map<Integer, Integer> transferData = ((CMV2000IntegerParameters) item).getTransferData();
                        communication.addTransferData(transferData);
                    } else if (item instanceof CMV2000BooleanParameters) {
                        Map<Integer, Integer> transferData = ((CMV2000BooleanParameters)item).getTransferData();
                        communication.addTransferData(transferData);
                    }
                }
                communication.sendPacket();
            }
        });
        topPanel.add(buttonSend);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        topPanel.add(scrollPane);
        getContentPane().add(topPanel);



        java.util.List<Object> data = config.getParameters();
        for(Object item : data) {
            if (item instanceof CMV2000IntegerParameters) {
                GUIParameterInteger prm = new GUIParameterInteger((CMV2000IntegerParameters)item);
                JPanel panel = prm.generateUI();
                mainPanel.add(panel);
            } else if (item instanceof CMV2000BooleanParameters) {
                GUIParameterBoolean prm = new GUIParameterBoolean((CMV2000BooleanParameters)item);
                JPanel panel = prm.generateUI();
                mainPanel.add(panel);
            }
        }
        pack();
    }
}
