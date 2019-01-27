package ru.clsoft.cmv2000;

import sun.nio.ch.Net;

import java.awt.*;
import javax.swing.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final ReadConfig readConfig = new ReadConfig();
        final NetCom communication = new NetCom();
        readConfig.run();
        communication.setPort(readConfig.getPort());
        communication.setAddress(readConfig.getIpAddress());
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new CMV2000Frame(readConfig, communication);
                frame.setTitle("CMV2000");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
