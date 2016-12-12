package com.example.the_c.ddcharacterapp;

public class Character {

    //--- MANY MANY ATTRIBUTES --//

    //id
    private int charID;

    //character basics
    private String charName, charClass, charBG, charRace, charAlign;
    private int charLvl, charXP;

    //character abilities
    private int charStr, charDex, charCon, charInt, charWis, charCha, charProfStr, charProfDex,
                charProfCon, charProfInt, charProfWis, charProfCha;

    //character misc stats
    private int charAC, charProf, charInit, charSpd, charHPCurr, charHPMax;

    //character skills
    private int charSkAcro, charSkAnimal, charSkArcana, charSkAth, charSkDecept, charSkHist,
            charSkInsight, charSkIntim, charSkInvest, charSkMed, charSkNat, charSkPerc, charSkPerf,
            charSkPers, charSkRel, charSkSleight, charSkStealth, charSkSurv;

    //equipment and feats
    private String charEquip, charFeats;

    //character spell info
    private int charSpSaveDC, charSpAtk;
    private String charCastStat, charCantrips, charSpLv1, charSpLv2, charSpLv3, charSpLv4, charSpLv5, charSpLv6,
            charSpLv7, charSpLv8, charSpLv9;

    //--- CONSTRUCTORS --//

    //with parameters (shouldn't need one without)
    public Character(int charID, String charName, int charLvl, String charClass, String charBG,
                     String charRace, String charAlign, int charXP, int charStr, int charDex,
                     int charCon, int charInt, int charWis, int charCha, int charProfStr,
                     int charProfDex, int charProfCon, int charProfInt,
                     int charProfWis, int charProfCha, int charAC, int charProf,
                     int charInit, int charSpd, int charHPCurr, int charHPMax, int charSkAcro,
                     int charSkAnimal, int charSkArcana, int charSkAth,
                     int charSkDecept, int charSkHist, int charSkInsight,
                     int charSkIntim, int charSkInvest, int charSkMed, int charSkNat,
                     int charSkPerc, int charSkPerf, int charSkPers, int charSkRel,
                     int charSkSleight, int charSkStealth, int charSkSurv,
                     String charEquip, String charFeats, int charSpSaveDC, int charSpAtk,
                     String charCastStat, String charCantrips, String charSpLv1, String charSpLv2,
                     String charSpLv3, String charSpLv4, String charSpLv5, String charSpLv6,
                     String charSpLv7, String charSpLv8, String charSpLv9)
    {
        //set basics
        this.charID = charID;   this.charName = charName;   this.charLvl = charLvl;
        this.charClass = charClass; this.charBG = charBG;   this.charRace = charRace;
        this.charAlign = charAlign; this.charXP = charXP;
        //set abilities
        this.charStr = charStr; this.charDex = charDex; this.charCon = charCon;
        this.charInt = charInt; this.charWis = charWis; this.charCha = charCha;
        this.charProfStr = charProfStr; this.charProfDex = charProfDex;
        this.charProfCon = charProfCon; this.charProfInt = charProfInt;
        this.charProfWis = charProfWis; this.charProfCha = charProfCha;
        //set misc stats
        this.charAC = charAC;   this.charProf = charProf;   this.charInit = charInit;
        this.charSpd = charSpd; this.charHPCurr = charHPCurr;   this.charHPMax = charHPMax;
        //set skills
        this.charSkAcro = charSkAcro;   this.charSkAnimal = charSkAnimal;
        this.charSkArcana = charSkArcana;   this.charSkAth = charSkAth;
        this.charSkDecept = charSkDecept;   this.charSkHist = charSkHist;
        this.charSkInsight = charSkInsight; this.charSkIntim = charSkIntim;
        this.charSkInvest = charSkInvest;   this.charSkMed = charSkMed;
        this.charSkNat = charSkNat; this.charSkPerc = charSkPerc;
        this.charSkPerf = charSkPerf;   this.charSkPers = charSkPers;
        this.charSkRel = charSkRel; this.charSkSleight = charSkSleight;
        this.charSkStealth = charSkStealth; this.charSkSurv = charSkSurv;
        //equipment and feats
        this.charEquip = charEquip; this.charFeats = charFeats;
        //set spell info
        this.charSpSaveDC = charSpSaveDC;   this.charSpAtk = charSpAtk;
        this.charCastStat = charCastStat; this.charCantrips = charCantrips;
        this.charSpLv1 = charSpLv1; this.charSpLv2 = charSpLv2; this.charSpLv3 = charSpLv3;
        this.charSpLv4 = charSpLv4; this.charSpLv5 = charSpLv5; this.charSpLv6 = charSpLv6;
        this.charSpLv7 = charSpLv7; this.charSpLv8 = charSpLv8; this.charSpLv9 = charSpLv9;
    }

    //--- GETTERS 'N SETTERS --//


    public int getCharID() {
        return charID;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public String getCharBG() {
        return charBG;
    }

    public void setCharBG(String charBG) {
        this.charBG = charBG;
    }

    public String getCharRace() {
        return charRace;
    }

    public void setCharRace(String charRace) {
        this.charRace = charRace;
    }

    public String getCharAlign() {
        return charAlign;
    }

    public void setCharAlign(String charAlign) {
        this.charAlign = charAlign;
    }

    public int getCharLvl() {
        return charLvl;
    }

    public void setCharLvl(int charLvl) {
        this.charLvl = charLvl;
    }

    public int getCharXP() {
        return charXP;
    }

    public void setCharXP(int charXP) {
        this.charXP = charXP;
    }

    public int getCharStr() {
        return charStr;
    }

    public void setCharStr(int charStr) {
        this.charStr = charStr;
    }

    public int getCharDex() {
        return charDex;
    }

    public void setCharDex(int charDex) {
        this.charDex = charDex;
    }

    public int getCharCon() {
        return charCon;
    }

    public void setCharCon(int charCon) {
        this.charCon = charCon;
    }

    public int getCharInt() {
        return charInt;
    }

    public void setCharInt(int charInt) {
        this.charInt = charInt;
    }

    public int getCharWis() {
        return charWis;
    }

    public void setCharWis(int charWis) {
        this.charWis = charWis;
    }

    public int getCharCha() {
        return charCha;
    }

    public void setCharCha(int charCha) {
        this.charCha = charCha;
    }

    public int getCharProfStr() {
        return charProfStr;
    }

    public void setCharProfStr(int charProfStr) {
        this.charProfStr = charProfStr;
    }

    public int getCharProfDex() {
        return charProfDex;
    }

    public void setCharProfDex(int charProfDex) {
        this.charProfDex = charProfDex;
    }

    public int getCharProfCon() {
        return charProfCon;
    }

    public void setCharProfCon(int charProfCon) {
        this.charProfCon = charProfCon;
    }

    public int getCharProfInt() {
        return charProfInt;
    }

    public void setCharProfInt(int charProfInt) {
        this.charProfInt = charProfInt;
    }

    public int getCharProfWis() {
        return charProfWis;
    }

    public void setCharProfWis(int charProfWis) {
        this.charProfWis = charProfWis;
    }

    public int getCharProfCha() {
        return charProfCha;
    }

    public void setCharProfCha(int charProfCha) {
        this.charProfCha = charProfCha;
    }

    public int getCharAC() {
        return charAC;
    }

    public void setCharAC(int charAC) {
        this.charAC = charAC;
    }

    public int getCharProf() {
        return charProf;
    }

    public void setCharProf(int charProf) {
        this.charProf = charProf;
    }

    public int getCharInit() {
        return charInit;
    }

    public void setCharInit(int charInit) {
        this.charInit = charInit;
    }

    public int getCharSpd() {
        return charSpd;
    }

    public void setCharSpd(int charSpd) {
        this.charSpd = charSpd;
    }

    public int getCharHPCurr() {
        return charHPCurr;
    }

    public void setCharHPCurr(int charHPCurr) {
        this.charHPCurr = charHPCurr;
    }

    public int getCharHPMax() {
        return charHPMax;
    }

    public void setCharHPMax(int charHPMax) {
        this.charHPMax = charHPMax;
    }

    public int getCharSkAcro() {
        return charSkAcro;
    }

    public void setCharSkAcro(int charSkAcro) {
        this.charSkAcro = charSkAcro;
    }

    public int getCharSkAnimal() {
        return charSkAnimal;
    }

    public void setCharSkAnimal(int charSkAnimal) {
        this.charSkAnimal = charSkAnimal;
    }

    public int getCharSkArcana() {
        return charSkArcana;
    }

    public void setCharSkArcana(int charSkArcana) {
        this.charSkArcana = charSkArcana;
    }

    public int getCharSkAth() {
        return charSkAth;
    }

    public void setCharSkAth(int charSkAth) {
        this.charSkAth = charSkAth;
    }

    public int getCharSkDecept() {
        return charSkDecept;
    }

    public void setCharSkDecept(int charSkDecept) {
        this.charSkDecept = charSkDecept;
    }

    public int getCharSkHist() {
        return charSkHist;
    }

    public void setCharSkHist(int charSkHist) {
        this.charSkHist = charSkHist;
    }

    public int getCharSkInsight() {
        return charSkInsight;
    }

    public void setCharSkInsight(int charSkInsight) {
        this.charSkInsight = charSkInsight;
    }

    public int getCharSkIntim() {
        return charSkIntim;
    }

    public void setCharSkIntim(int charSkIntim) {
        this.charSkIntim = charSkIntim;
    }

    public int getCharSkInvest() {
        return charSkInvest;
    }

    public void setCharSkInvest(int charSkInvest) {
        this.charSkInvest = charSkInvest;
    }

    public int getCharSkMed() {
        return charSkMed;
    }

    public void setCharSkMed(int charSkMed) {
        this.charSkMed = charSkMed;
    }

    public int getCharSkNat() {
        return charSkNat;
    }

    public void setCharSkNat(int charSkNat) {
        this.charSkNat = charSkNat;
    }

    public int getCharSkPerc() {
        return charSkPerc;
    }

    public void setCharSkPerc(int charSkPerc) {
        this.charSkPerc = charSkPerc;
    }

    public int getCharSkPerf() {
        return charSkPerf;
    }

    public void setCharSkPerf(int charSkPerf) {
        this.charSkPerf = charSkPerf;
    }

    public int getCharSkPers() {
        return charSkPers;
    }

    public void setCharSkPers(int charSkPers) {
        this.charSkPers = charSkPers;
    }

    public int getCharSkRel() {
        return charSkRel;
    }

    public void setCharSkRel(int charSkRel) {
        this.charSkRel = charSkRel;
    }

    public int getCharSkSleight() {
        return charSkSleight;
    }

    public void setCharSkSleight(int charSkSleight) {
        this.charSkSleight = charSkSleight;
    }

    public int getCharSkStealth() {
        return charSkStealth;
    }

    public void setCharSkStealth(int charSkStealth) {
        this.charSkStealth = charSkStealth;
    }

    public int getCharSkSurv() {
        return charSkSurv;
    }

    public void setCharSkSurv(int charSkSurv) {
        this.charSkSurv = charSkSurv;
    }

    public String getCharEquip() {
        return charEquip;
    }

    public void setCharEquip(String charEquip) {
        this.charEquip = charEquip;
    }

    public String getCharFeats() {
        return charFeats;
    }

    public void setCharFeats(String charFeats) {
        this.charFeats = charFeats;
    }

    public int getCharSpSaveDC() {
        return charSpSaveDC;
    }

    public void setCharSpSaveDC(int charSpSaveDC) {
        this.charSpSaveDC = charSpSaveDC;
    }

    public int getCharSpAtk() {
        return charSpAtk;
    }

    public void setCharSpAtk(int charSpAtk) {
        this.charSpAtk = charSpAtk;
    }

    public String getCharCastStat() {
        return charCastStat;
    }

    public void setCharCastStat(String charCastStat) {
        this.charCastStat = charCastStat;
    }

    public String getCharCantrips() {
        return charCantrips;
    }

    public void setCharCantrips(String charCantrips) {
        this.charCantrips = charCantrips;
    }

    public String getCharSpLv1() {
        return charSpLv1;
    }

    public void setCharSpLv1(String charSpLv1) {
        this.charSpLv1 = charSpLv1;
    }

    public String getCharSpLv2() {
        return charSpLv2;
    }

    public void setCharSpLv2(String charSpLv2) {
        this.charSpLv2 = charSpLv2;
    }

    public String getCharSpLv3() {
        return charSpLv3;
    }

    public void setCharSpLv3(String charSpLv3) {
        this.charSpLv3 = charSpLv3;
    }

    public String getCharSpLv4() {
        return charSpLv4;
    }

    public void setCharSpLv4(String charSpLv4) {
        this.charSpLv4 = charSpLv4;
    }

    public String getCharSpLv5() {
        return charSpLv5;
    }

    public void setCharSpLv5(String charSpLv5) {
        this.charSpLv5 = charSpLv5;
    }

    public String getCharSpLv6() {
        return charSpLv6;
    }

    public void setCharSpLv6(String charSpLv6) {
        this.charSpLv6 = charSpLv6;
    }

    public String getCharSpLv7() {
        return charSpLv7;
    }

    public void setCharSpLv7(String charSpLv7) {
        this.charSpLv7 = charSpLv7;
    }

    public String getCharSpLv8() {
        return charSpLv8;
    }

    public void setCharSpLv8(String charSpLv8) {
        this.charSpLv8 = charSpLv8;
    }

    public String getCharSpLv9() {
        return charSpLv9;
    }

    public void setCharSpLv9(String charSpLv9) {
        this.charSpLv9 = charSpLv9;
    }


}
