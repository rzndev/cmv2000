package ru.clsoft.cmv2000;

public class CMV2000Registers {
    private final int NUMBER_LINES_LOW = 1;
    private final int NUMBER_LINES_HIGH = 2;

    private final int START1_LOW = 3;
    private final int START1_HIGH = 4;
    private final int START2_LOW = 5;
    private final int START2_HIGH = 6;
    private final int START3_LOW = 7;
    private final int START3_HIGH = 8;
    private final int START4_LOW = 9;
    private final int START4_HIGH = 10;
    private final int START5_LOW = 11;
    private final int START5_HIGH = 12;
    private final int START6_LOW = 13;
    private final int START6_HIGH = 14;
    private final int START7_LOW = 15;
    private final int START7_HIGH = 16;
    private final int START8_LOW = 17;
    private final int START8_HIGH = 18;

    private final int NUMBER_LINES1_LOW = 19;
    private final int NUMBER_LINES1_HIGH = 20;
    private final int NUMBER_LINES2_LOW = 21;
    private final int NUMBER_LINES2_HIGH = 22;
    private final int NUMBER_LINES3_LOW = 23;
    private final int NUMBER_LINES3_HIGH = 24;
    private final int NUMBER_LINES4_LOW = 25;
    private final int NUMBER_LINES4_HIGH = 26;
    private final int NUMBER_LINES5_LOW = 27;
    private final int NUMBER_LINES5_HIGH = 28;
    private final int NUMBER_LINES6_LOW = 29;
    private final int NUMBER_LINES6_HIGH = 30;
    private final int NUMBER_LINES7_LOW = 31;
    private final int NUMBER_LINES7_HIGH = 32;
    private final int NUMBER_LINES8_LOW = 33;
    private final int NUMBER_LINES8_HIGH = 34;

    private final int SUB_S_LOW = 35;
    private final int SUB_S_HIGH = 36;
    private final int SUB_A_LOW = 37;
    private final int SUB_A_HIGH = 38;

    private final int MONO = 39;
    private final int IMAGE_FLIPPING = 40;

    private final int INTE_SYNC_EXP_DUAL_EXP_EXT = 41;

    private final int EXP_TIME_LOW = 42;
    private final int EXP_TIME_MIDDLE = 43;
    private final int EXP_TIME_HIGH = 44;

    private final int EXP_STEP_LOW = 45;
    private final int EXP_STEP_MIDDLE = 46;
    private final int EXP_STEP_HIGH = 47;

    private final int EXP_KP1_LOW = 48;
    private final int EXP_KP1_MIDDLE = 49;
    private final int EXP_KP1_HIGH = 50;

    private final int EXP_KP2_LOW = 51;
    private final int EXP_KP2_MIDDLE = 52;
    private final int EXP_KP2_HIGH = 53;

    private final int NR_SLOPES = 54;

    private final int EXP_SEQ = 55;

    private final int EXP_TIME2_LOW = 56;
    private final int EXP_TIME2_MIDDLE = 57;
    private final int EXP_TIME2_HIGH = 58;

    private final int EXP_STEP2_LOW = 59;
    private final int EXP_STEP2_MIDDLE = 60;
    private final int EXP_STEP2_HIGH = 61;

    private final int EXP2_SEQ = 69;

    private final int NUMBER_FRAMES_LOW = 70;
    private final int NUMBER_FRAMES_HIGH = 71;

    private final int OUTPUT_MODE = 72;

    private final int FOT_LENGTH = 73;

    private final int I_LVDS_REC = 74;

    private final int COL_CALIB_DC_CALIB = 77;

    private final int TRAINING_PATTERN_LOW = 78;
    private final int TRAINING_PATTERN_HIGH = 79;

    private final int CHANNEL_EN_LOW = 80;
    private final int CHANNEL_EN_MIDDLE = 81;
    private final int CHANNEL_EN_HIGH = 82;

    private final int I_LVDS = 83;

    private final int I_COL = 84;

    private final int I_COL_PRECH = 85;

    private final int I_AMP = 87;

    private final int VTF_L1 = 88;

    private final int VLOW2 = 89;
    private final int VLOW3 = 90;

    private final int VRES_LOW = 91;

    private final int V_PRECH = 94;
    private final int V_REF = 95;

    private final int VRAMP1 = 98;
    private final int VRAMP2 = 99;
    private final int OFFSET = 100;

    private final int OFFSET_LOW = 101;
    private final int OFFSET_HIGH = 102;

    private final int PGA_GAIN = 102;

    private final int ADC_GAIN = 103;

    private final int T_DIG1 = 108;
    private final int T_DIG2 = 109;

    private final int BIT_MODE = 111;

    private final int ADC_RESOLUTION = 112;
    private final int PLL_ENABLE = 113;
    private final int PLL_IN_FRE = 114;
    private final int PLL_BYPASS = 115;
    private final int PLL_FEATURES = 116;
    private final int PLL_LOAD = 117;
    private final int DUMMY = 118;
    private final int BLACK_COL_EN_PGA_GAIN = 121;
    private final int V_BLACKSUN = 123;
    private final int TEMP_LOW = 126;
    private final int TEMP_HIGHT = 127;

    private int numberLines = 1088;
    private int start1 = 0;
    private int start2 = 0;
    private int start3 = 0;
    private int start4 = 0;
    private int start5 = 0;
    private int start6 = 0;
    private int start7 = 0;
    private int start8 = 0;
    private int numberLines1 = 0;
    private int numberLines2 = 0;
    private int numberLines3 = 0;
    private int numberLines4 = 0;
    private int numberLines5 = 0;
    private int numberLines6 = 0;
    private int numberLines7 = 0;
    private int numberLines8 = 0;
    private int subS = 0;
    private int subA = 0;
    private int mono = 1;
    private int imageFlipping = 0;
    private int inteSyncExpDualExpExt = 4;
    private int expTime = 1088;
    private int expStep = 0;
    private int expKp1 = 1;
    private int expKp2 = 1;
    private int nrSlopers = 1;
    private int expSeq = 1;
    private int expTime2 = 2048;
    private int expStep2 = 0;
    private int exp2Seq = 1;
    private int numberFrames = 1;
    private int outputMode = 0;
    private int fotLength = 10;
    private int iLvdsRec = 8;
    private int colCalibADCCalib = 0; //default 3
    private int trainingPattern = 85;
    private int channelEn = 0x3ffff;
    private int iLvds = 8;
    private int iCol = 4; // default 8;
    private int iColPrech = 1; // default 8
    private int iAmp = 12; // default 8
    private int vtfL1 = 64; // default 8
    private int vLow2 = 96;
    private int vLow3 = 96;
    private int vResLow = 64; //default 96
    private int vPrech = 101; //default 96
    private int vRef = 106; // default 96
    private int vRamp1 = 96;
    private int vRamp2 = 96;
    private int offset = 16323;
    private int pgaGain = 1; // default 1
    private int adcGain = 32;
    private int tDig1 = 0;
    private int tDig2 = 0;
    private int bitMode = 1;
    private int adcResolution = 0;
    private int pllEanble = 1;
    private int pllInFre = 0;
    private int pllBypass = 0;
    private int pllFeatures = 217;
    private int pllLoad = 8;
    private int dummy =1; // default 0
    private int blackColEnPGAGain = 0;
    private int vBlacksun = 98; // default 64
    private int temp = 0;

    public int getNumberLines() {
        return numberLines;
    }

    public void setNumberLines(int numberLines) {
        this.numberLines = numberLines;
    }

    public int getStart1() {
        return start1;
    }

    public void setStart1(int start1) {
        this.start1 = start1;
    }

    public int getStart2() {
        return start2;
    }

    public void setStart2(int start2) {
        this.start2 = start2;
    }

    public int getStart3() {
        return start3;
    }

    public void setStart3(int start3) {
        this.start3 = start3;
    }

    public int getStart4() {
        return start4;
    }

    public void setStart4(int start4) {
        this.start4 = start4;
    }

    public int getStart5() {
        return start5;
    }

    public void setStart5(int start5) {
        this.start5 = start5;
    }

    public int getStart6() {
        return start6;
    }

    public void setStart6(int start6) {
        this.start6 = start6;
    }

    public int getStart7() {
        return start7;
    }

    public void setStart7(int start7) {
        this.start7 = start7;
    }

    public int getStart8() {
        return start8;
    }

    public void setStart8(int start8) {
        this.start8 = start8;
    }

    public int getNumberLines1() {
        return numberLines1;
    }

    public void setNumberLines1(int numberLines1) {
        this.numberLines1 = numberLines1;
    }

    public int getNumberLines2() {
        return numberLines2;
    }

    public void setNumberLines2(int numberLines2) {
        this.numberLines2 = numberLines2;
    }

    public int getNumberLines3() {
        return numberLines3;
    }

    public void setNumberLines3(int numberLines3) {
        this.numberLines3 = numberLines3;
    }

    public int getNumberLines4() {
        return numberLines4;
    }

    public void setNumberLines4(int numberLines4) {
        this.numberLines4 = numberLines4;
    }

    public int getNumberLines5() {
        return numberLines5;
    }

    public void setNumberLines5(int numberLines5) {
        this.numberLines5 = numberLines5;
    }

    public int getNumberLines6() {
        return numberLines6;
    }

    public void setNumberLines6(int numberLines6) {
        this.numberLines6 = numberLines6;
    }

    public int getNumberLines7() {
        return numberLines7;
    }

    public void setNumberLines7(int numberLines7) {
        this.numberLines7 = numberLines7;
    }

    public int getNumberLines8() {
        return numberLines8;
    }

    public void setNumberLines8(int numberLines8) {
        this.numberLines8 = numberLines8;
    }

    public int getSubS() {
        return subS;
    }

    public void setSubS(int subS) {
        this.subS = subS;
    }

    public int getSubA() {
        return subA;
    }

    public void setSubA(int subA) {
        this.subA = subA;
    }

    public int getMono() {
        return mono;
    }

    public void setMono(int mono) {
        this.mono = mono;
    }

    public int getImageFlipping() {
        return imageFlipping;
    }

    public void setImageFlipping(int imageFlipping) {
        this.imageFlipping = imageFlipping;
    }

    public int getInteSyncExpDualExpExt() {
        return inteSyncExpDualExpExt;
    }

    public void setInteSyncExpDualExpExt(int inteSyncExpDualExpExt) {
        this.inteSyncExpDualExpExt = inteSyncExpDualExpExt;
    }

    public int getExpTime() {
        return expTime;
    }

    public void setExpTime(int expTime) {
        this.expTime = expTime;
    }

    public int getExpStep() {
        return expStep;
    }

    public void setExpStep(int expStep) {
        this.expStep = expStep;
    }

    public int getExpKp1() {
        return expKp1;
    }

    public void setExpKp1(int expKp1) {
        this.expKp1 = expKp1;
    }

    public int getExpKp2() {
        return expKp2;
    }

    public void setExpKp2(int expKp2) {
        this.expKp2 = expKp2;
    }

    public int getNrSlopers() {
        return nrSlopers;
    }

    public void setNrSlopers(int nrSlopers) {
        this.nrSlopers = nrSlopers;
    }

    public int getExpSeq() {
        return expSeq;
    }

    public void setExpSeq(int expSeq) {
        this.expSeq = expSeq;
    }

    public int getExpTime2() {
        return expTime2;
    }

    public void setExpTime2(int expTime2) {
        this.expTime2 = expTime2;
    }

    public int getExpStep2() {
        return expStep2;
    }

    public void setExpStep2(int expStep2) {
        this.expStep2 = expStep2;
    }

    public int getExp2Seq() {
        return exp2Seq;
    }

    public void setExp2Seq(int exp2Seq) {
        this.exp2Seq = exp2Seq;
    }

    public int getNumberFrames() {
        return numberFrames;
    }

    public void setNumberFrames(int numberFrames) {
        this.numberFrames = numberFrames;
    }

    public int getOutputMode() {
        return outputMode;
    }

    public void setOutputMode(int outputMode) {
        this.outputMode = outputMode;
    }

    public int getFotLength() {
        return fotLength;
    }

    public void setFotLength(int fotLength) {
        this.fotLength = fotLength;
    }

    public int getiLvdsRec() {
        return iLvdsRec;
    }

    public void setiLvdsRec(int iLvdsRec) {
        this.iLvdsRec = iLvdsRec;
    }

    public int getColCalibADCCalib() {
        return colCalibADCCalib;
    }

    public void setColCalibADCCalib(int colCalibADCCalib) {
        this.colCalibADCCalib = colCalibADCCalib;
    }

    public int getTrainingPattern() {
        return trainingPattern;
    }

    public void setTrainingPattern(int trainingPattern) {
        this.trainingPattern = trainingPattern;
    }

    public int getChannelEn() {
        return channelEn;
    }

    public void setChannelEn(int channelEn) {
        this.channelEn = channelEn;
    }

    public int getiLvds() {
        return iLvds;
    }

    public void setiLvds(int iLvds) {
        this.iLvds = iLvds;
    }

    public int getiCol() {
        return iCol;
    }

    public void setiCol(int iCol) {
        this.iCol = iCol;
    }

    public int getiColPrech() {
        return iColPrech;
    }

    public void setiColPrech(int iColPrech) {
        this.iColPrech = iColPrech;
    }

    public int getiAmp() {
        return iAmp;
    }

    public void setiAmp(int iAmp) {
        this.iAmp = iAmp;
    }

    public int getVtfL1() {
        return vtfL1;
    }

    public void setVtfL1(int vtfL1) {
        this.vtfL1 = vtfL1;
    }

    public int getvLow2() {
        return vLow2;
    }

    public void setvLow2(int vLow2) {
        this.vLow2 = vLow2;
    }

    public int getvLow3() {
        return vLow3;
    }

    public void setvLow3(int vLow3) {
        this.vLow3 = vLow3;
    }

    public int getvResLow() {
        return vResLow;
    }

    public void setvResLow(int vResLow) {
        this.vResLow = vResLow;
    }

    public int getvPrech() {
        return vPrech;
    }

    public void setvPrech(int vPrech) {
        this.vPrech = vPrech;
    }

    public int getvRef() {
        return vRef;
    }

    public void setvRef(int vRef) {
        this.vRef = vRef;
    }

    public int getvRamp1() {
        return vRamp1;
    }

    public void setvRamp1(int vRamp1) {
        this.vRamp1 = vRamp1;
    }

    public int getvRamp2() {
        return vRamp2;
    }

    public void setvRamp2(int vRamp2) {
        this.vRamp2 = vRamp2;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPgaGain() {
        return pgaGain;
    }

    public void setPgaGain(int pgaGain) {
        this.pgaGain = pgaGain;
    }

    public int getAdcGain() {
        return adcGain;
    }

    public void setAdcGain(int adcGain) {
        this.adcGain = adcGain;
    }

    public int gettDig1() {
        return tDig1;
    }

    public void settDig1(int tDig1) {
        this.tDig1 = tDig1;
    }

    public int gettDig2() {
        return tDig2;
    }

    public void settDig2(int tDig2) {
        this.tDig2 = tDig2;
    }

    public int getBitMode() {
        return bitMode;
    }

    public void setBitMode(int bitMode) {
        this.bitMode = bitMode;
    }

    public int getAdcResolution() {
        return adcResolution;
    }

    public void setAdcResolution(int adcResolution) {
        this.adcResolution = adcResolution;
    }

    public int getPllEanble() {
        return pllEanble;
    }

    public void setPllEanble(int pllEanble) {
        this.pllEanble = pllEanble;
    }

    public int getPllInFre() {
        return pllInFre;
    }

    public void setPllInFre(int pllInFre) {
        this.pllInFre = pllInFre;
    }

    public int getPllBypass() {
        return pllBypass;
    }

    public void setPllBypass(int pllBypass) {
        this.pllBypass = pllBypass;
    }

    public int getPllFeatures() {
        return pllFeatures;
    }

    public void setPllFeatures(int pllFeatures) {
        this.pllFeatures = pllFeatures;
    }

    public int getPllLoad() {
        return pllLoad;
    }

    public void setPllLoad(int pllLoad) {
        this.pllLoad = pllLoad;
    }

    public int getDummy() {
        return dummy;
    }

    public void setDummy(int dummy) {
        this.dummy = dummy;
    }

    public int getBlackColEnPGAGain() {
        return blackColEnPGAGain;
    }

    public void setBlackColEnPGAGain(int blackColEnPGAGain) {
        this.blackColEnPGAGain = blackColEnPGAGain;
    }

    public int getvBlacksun() {
        return vBlacksun;
    }

    public void setvBlacksun(int vBlacksun) {
        this.vBlacksun = vBlacksun;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
