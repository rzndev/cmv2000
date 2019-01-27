package ru.clsoft.cmv2000;

import java.util.HashMap;
import java.util.Map;

public class CMV2000IntegerParameters {
    private int addr;
    private String name;
    private int minValue;
    private int maxValue;
    private int defaultValue;
    private int bitlen;
    private int step;
    private int bigStep;

    private int value;

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

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    public int getBitlen() {
        return bitlen;
    }

    public void setBitlen(int bitlen) {
        this.bitlen = bitlen;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getBigStep() {
        return bigStep;
    }

    public void setBigStep(int bigStep) {
        this.bigStep = bigStep;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        boolean isValueChanged = (value != this.value) ? true : false;
        this.value = value;
        if (isValueChanged)
            valueChanged();
    }

    public void setFromMap(Map<String, String> opt) {
        String registerType = opt.get("type");
        if (registerType.compareTo("integer") != 0) return;
        // <register addr="1" name="numberLines" type="integer" bitlen="16" min="1" max="1088" val="1088" />
        String strAddr = opt.get("addr");
        String strName = opt.get("name");
        String strBitlen = opt.get("bitlen");
        String strMinVal = opt.get("min");
        String strMaxVal = opt.get("max");
        String strVal = opt.get("val");
        String strStep = opt.get("step");
        String strBigStep = opt.get("bigstep");
        int addr = 0;
        int bitlen = 0;
        int minVal = 0;
        int maxVal = 0;
        int val = 0;
        int step = 0;
        int bigStep = 0;

        try {
            addr = Integer.parseInt(strAddr);
        } catch (NumberFormatException ex) {
        }
        try {
            bitlen = Integer.parseInt(strBitlen);
        } catch (NumberFormatException ex) {
        }

        try {
            minVal = Integer.parseInt(strMinVal);
        } catch (NumberFormatException ex) {
        }
        try {
            maxVal = Integer.parseInt(strMaxVal);
        } catch (NumberFormatException ex) {
        }

        try {
            val = Integer.parseInt(strVal);
        } catch (NumberFormatException ex) {
        }

        try {
            step = Integer.parseInt(strStep);
        } catch (NumberFormatException ex) {
        }

        try {
            bigStep = Integer.parseInt(strBigStep);
        } catch (NumberFormatException ex) {
        }

        setName(strName);
        setAddr(addr);
        setBitlen(bitlen);
        setMinValue(minVal);
        setMaxValue(maxVal);
        setDefaultValue(val);
        setValue(val);
        setStep(step);
        setBigStep(bigStep);
    }

    public int changeValue(int step) {
        value = value + step;
        if (value > maxValue)
            value = maxValue;
        else if (value < minValue)
            value = minValue;
        return value;
    }

    public boolean isValid(int value) {
        if (value < minValue) return false;
        if (value > maxValue) return false;
        return true;
    }

    public void valueChanged() {

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
        int currentValue = value;
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
