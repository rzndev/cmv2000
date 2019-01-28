package ru.clsoft.cmv2000;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CMV2000BooleanParameters {
    private int addr;
    private String name;
    private int bitlen;
    private List<CMV2000BoleanItem> items;

    public int getAddr() {
        return addr;
    }

    public void setAddr(int addr) {
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBitlen() {
        return bitlen;
    }

    public void setBitlen(int bitlen) {
        this.bitlen = bitlen;
    }

    public List<CMV2000BoleanItem> getItems() {
        return items;
    }

    public void setItems(List<CMV2000BoleanItem> items) {
        this.items = items;
    }

    public void setFromMap(Map<String, String> opt, List<CMV2000BoleanItem> table) {
        String registerType = opt.get("type");
        if (registerType.compareTo("bool") != 0) return;
        String strAddr = opt.get("addr");
        String strName = opt.get("name");
        String strBitlen = opt.get("bitlen");
        int addr = 0;
        int bitlen = 0;
        try {
            addr = Integer.parseInt(strAddr);
        } catch (NumberFormatException ex) {
        }
        try {
            bitlen = Integer.parseInt(strBitlen);
        } catch (NumberFormatException ex) {
        }
        setName(strName);
        setAddr(addr);
        setBitlen(bitlen);
        setItems(table);
    }

    private int getMask(int nBits) {
        if (nBits > 7) return 0xFF;
        switch (nBits) {
            case 7: return 0x7F;
            case 6: return 0x3F;
            case 5: return 0x1F;
            case 4: return 0x0F;
            case 3: return 0x07;
            case 2: return 0x03;
            case 1: return 0x01;
            case 0: return 0x00;
        }
        return 0x00;
    }

    public Map<Integer, Integer> getTransferData() {
        Map<Integer, Integer> data = new HashMap<>();
        int currentAddress = addr;
        int currentBits = bitlen;
        int currentValue = 0;
        for(CMV2000BoleanItem item : items) {
            if (item.isVal()) {
                int val = 1 << item.getId();
                currentValue = currentValue | val;
            }
        }
        while(currentBits > 0) {
            int dataForSend = currentValue & getMask(currentBits);
            data.put(currentAddress, dataForSend);
            currentBits = currentBits - 8;
            currentValue = currentValue >> 8;
            currentAddress++;
        }
        return data;
    }
}

class CMV2000BoleanItem {
    private int id;
    private String name;
    private boolean val;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVal() {
        return val;
    }

    public void setVal(boolean val) {
        this.val = val;
    }

}