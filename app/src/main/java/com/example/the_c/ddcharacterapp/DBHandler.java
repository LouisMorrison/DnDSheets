package com.example.the_c.ddcharacterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteAssetHelper {

    //database version
    private static final int DATABASE_VERSION = 16;
    //db name
    private static final String DATABASE_NAME = "DnDb.db";
    //characters table name
    private static final String TABLE_CHARS = "characters";

    //characters table column names
    private static final String key_id = "charID";
    private static final String key_name = "charName";
    private static final String key_level = "charLvl";
    private static final String key_class = "charClass";
    private static final String key_bg = "charBG";
    private static final String key_race = "charRace";
    private static final String key_align = "charAlign";
    private static final String key_xp = "charXP";
    private static final String key_str = "charStr";
    private static final String key_dex = "charDex";
    private static final String key_con = "charCon";
    private static final String key_int = "charInt";
    private static final String key_wis = "charWis";
    private static final String key_cha = "charCha";
    private static final String key_pro_str = "charProfStr";
    private static final String key_pro_dex = "charProfDex";
    private static final String key_pro_con = "charProfCon";
    private static final String key_pro_int = "charProfInt";
    private static final String key_pro_wis = "charProfWis";
    private static final String key_pro_cha = "charProfCha";
    private static final String key_ac = "charAC";
    private static final String key_prof = "charProf";
    private static final String key_init = "charInit";
    private static final String key_spd = "charSpd";
    private static final String key_hp_curr = "charHPCurr";
    private static final String key_hp_max = "charHPMax";
    private static final String key_acro = "charSkAcro";
    private static final String key_animal = "charSkAnimal";
    private static final String key_arcana = "charSkArcana";
    private static final String key_ath = "charSkAth";
    private static final String key_decept = "charSkDecept";
    private static final String key_hist = "charSkHist";
    private static final String key_ins = "charSkInsight";
    private static final String key_intim = "charSkIntim";
    private static final String key_invest = "charSkInvest";
    private static final String key_med = "charSkMed";
    private static final String key_nat = "charSkNat";
    private static final String key_perc = "charSkPerc";
    private static final String key_perf = "charSkPerf";
    private static final String key_pers = "charSkPers";
    private static final String key_rel = "charSkRel";
    private static final String key_sleight = "charSkSleight";
    private static final String key_stealth = "charSkStealth";
    private static final String key_surv = "charSkSurv";
    private static final String key_equip = "charEquip";
    private static final String key_feat = "charFeats";
    private static final String key_save = "charSpSaveDC";
    private static final String key_spatk = "charSpAtk";
    private static final String key_cast = "charCastStat";
    private static final String key_cant = "charCantrips";
    private static final String key_lv1 = "charSpLv1";
    private static final String key_lv2 = "charSpLv2";
    private static final String key_lv3 = "charSpLv3";
    private static final String key_lv4 = "charSpLv4";
    private static final String key_lv5 = "charSpLv5";
    private static final String key_lv6 = "charSpLv6";
    private static final String key_lv7 = "charSpLv7";
    private static final String key_lv8 = "charSpLv8";
    private static final String key_lv9 = "charSpLv9";

    //constructor
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade();
    }

    //get all characters, returns an array
    public List<Character> getAllChars() {

        List<Character> charList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_CHARS;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Character character = new Character(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), Integer.parseInt(cursor.getString(2)),
                        cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getString(6), Integer.parseInt(cursor.getString(7)),
                        Integer.parseInt(cursor.getString(8)), Integer.parseInt(cursor.getString(9)),
                        Integer.parseInt(cursor.getString(10)), Integer.parseInt(cursor.getString(11)),
                        Integer.parseInt(cursor.getString(12)), Integer.parseInt(cursor.getString(13)),
                        Integer.parseInt(cursor.getString(14)), Integer.parseInt(cursor.getString(15)),
                        Integer.parseInt(cursor.getString(16)), Integer.parseInt(cursor.getString(17)),
                        Integer.parseInt(cursor.getString(18)), Integer.parseInt(cursor.getString(19)),
                        Integer.parseInt(cursor.getString(20)), Integer.parseInt(cursor.getString(21)),
                        Integer.parseInt(cursor.getString(22)), Integer.parseInt(cursor.getString(23)),
                        Integer.parseInt(cursor.getString(24)), Integer.parseInt(cursor.getString(25)),
                        Integer.parseInt(cursor.getString(26)), Integer.parseInt(cursor.getString(27)),
                        Integer.parseInt(cursor.getString(28)), Integer.parseInt(cursor.getString(29)),
                        Integer.parseInt(cursor.getString(30)), Integer.parseInt(cursor.getString(31)),
                        Integer.parseInt(cursor.getString(32)), Integer.parseInt(cursor.getString(33)),
                        Integer.parseInt(cursor.getString(34)), Integer.parseInt(cursor.getString(35)),
                        Integer.parseInt(cursor.getString(36)), Integer.parseInt(cursor.getString(37)),
                        Integer.parseInt(cursor.getString(38)), Integer.parseInt(cursor.getString(39)),
                        Integer.parseInt(cursor.getString(40)), Integer.parseInt(cursor.getString(41)),
                        Integer.parseInt(cursor.getString(42)), Integer.parseInt(cursor.getString(43)),
                        cursor.getString(44), cursor.getString(45),
                        Integer.parseInt(cursor.getString(46)), Integer.parseInt(cursor.getString(47)),
                        cursor.getString(48), cursor.getString(49), cursor.getString(50),
                        cursor.getString(51), cursor.getString(52), cursor.getString(53),
                        cursor.getString(54), cursor.getString(55), cursor.getString(56),
                        cursor.getString(57), cursor.getString(58));
                charList.add(character);
            } while (cursor.moveToNext());
        }
        return charList;
    }

    //update character
    public int updateChar (Character character) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        //update the freakin character
        values.put(key_name, character.getCharName());
        values.put(key_level, character.getCharLvl());
        values.put(key_class, character.getCharClass());
        values.put(key_bg, character.getCharBG());
        values.put(key_race, character.getCharRace());
        values.put(key_align, character.getCharAlign());
        values.put(key_xp, character.getCharXP());
        values.put(key_str, character.getCharStr());
        values.put(key_dex, character.getCharDex());
        values.put(key_con, character.getCharCon());
        values.put(key_int, character.getCharInt());
        values.put(key_wis, character.getCharWis());
        values.put(key_cha, character.getCharCha());
        values.put(key_pro_str, character.getCharProfStr());
        values.put(key_pro_dex, character.getCharProfDex());
        values.put(key_pro_con, character.getCharProfCon());
        values.put(key_pro_int, character.getCharProfInt());
        values.put(key_pro_wis, character.getCharProfWis());
        values.put(key_pro_cha, character.getCharProfCha());
        values.put(key_ac, character.getCharAC());
        values.put(key_prof, character.getCharProf());
        values.put(key_init, character.getCharInit());
        values.put(key_spd, character.getCharSpd());
        values.put(key_hp_curr, character.getCharHPCurr());
        values.put(key_hp_max, character.getCharHPMax());
        values.put(key_acro, character.getCharSkAcro());
        values.put(key_animal, character.getCharSkAnimal());
        values.put(key_arcana, character.getCharSkArcana());
        values.put(key_ath, character.getCharSkAth());
        values.put(key_decept, character.getCharSkDecept());
        values.put(key_hist, character.getCharSkHist());
        values.put(key_ins, character.getCharSkInsight());
        values.put(key_intim, character.getCharSkIntim());
        values.put(key_invest, character.getCharSkInvest());
        values.put(key_med, character.getCharSkMed());
        values.put(key_nat, character.getCharSkNat());
        values.put(key_perc, character.getCharSkPerc());
        values.put(key_perf, character.getCharSkPerf());
        values.put(key_pers, character.getCharSkPers());
        values.put(key_rel, character.getCharSkRel());
        values.put(key_sleight, character.getCharSkSleight());
        values.put(key_stealth, character.getCharSkStealth());
        values.put(key_surv, character.getCharSkSurv());
        values.put(key_equip, character.getCharEquip());
        values.put(key_feat, character.getCharFeats());
        values.put(key_save, character.getCharSpSaveDC());
        values.put(key_spatk, character.getCharSpAtk());
        values.put(key_cast, character.getCharCastStat());
        values.put(key_cant, character.getCharCantrips());
        values.put(key_lv1, character.getCharSpLv1());
        values.put(key_lv2, character.getCharSpLv2());
        values.put(key_lv3, character.getCharSpLv3());
        values.put(key_lv4, character.getCharSpLv4());
        values.put(key_lv5, character.getCharSpLv5());
        values.put(key_lv6, character.getCharSpLv6());
        values.put(key_lv7, character.getCharSpLv7());
        values.put(key_lv8, character.getCharSpLv8());
        values.put(key_lv9, character.getCharSpLv9());

        //update the gosh darn row
        return db.update(TABLE_CHARS, values, key_id + " = ?",
                new String[]{String.valueOf(character.getCharID())});
    }
}
