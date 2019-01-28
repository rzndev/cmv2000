package ru.clsoft.cmv2000;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class NetCom {
    private int port = 8888;
    private String address = "127.0.0.1";

    private DatagramSocket sock;

    public  NetCom() {
        try {
            sock = new DatagramSocket();
        } catch (SocketException ex) {

        }
    }

    private Map<Integer, Integer> dataForTransfer = new TreeMap<>();

    public void sendPacket() {
        //try(DatagramSocket sock = new DatagramSocket()) {
            List<Short> transferData = prepareTransferBuffer();
            byte[] b = new byte[transferData.size() * 2 + 1];
            int idx = 0;
            b[idx++] = (byte)transferData.size();
            for(Short addressData : transferData) {
                b[idx++] = (byte)(addressData >> 8);
                b[idx++] = (byte)(addressData & 0xFF);
            }
            try {
                DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getByName(address), port);

            sock.send(dp);
     //   } catch (SocketException ex) {
     //       int a = 1;
        } catch (UnknownHostException ex) {
            int bv = 1;
        } catch (IOException ex) {
            int c = 1;
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void clearTransferData() {
        dataForTransfer.clear();
    }

    public void addTransferData(Map<Integer, Integer> data) {
        dataForTransfer.putAll(data);
    }

    public List<Short> prepareTransferBuffer() {
        List<Short> result = new ArrayList<>();
        for(Integer address : dataForTransfer.keySet()) {
            Integer value = dataForTransfer.get(address);
            int item = ((0x80 |  address.intValue()) << 8) | (value.intValue() & 0xFF);
            result.add((short)item);
        }
        return result;
    }
}
