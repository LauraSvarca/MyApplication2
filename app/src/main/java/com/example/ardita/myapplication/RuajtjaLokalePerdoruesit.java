package com.example.ardita.myapplication;
import android.content.Context;
import android.content.SharedPreferences;


public class RuajtjaLokalePerdoruesit {

    public static final String SP_NAME = "DetajetPerdoruesit";

        SharedPreferences DatabazaLokalePerdoruesit;

        public RuajtjaLokalePerdoruesit(Context context) {
            DatabazaLokalePerdoruesit = context.getSharedPreferences(SP_NAME, 0);
        }

        public void RuajTeDhenatPerdoruesit(Perdoruesi user) {
            SharedPreferences.Editor userLocalDatabaseEditor = DatabazaLokalePerdoruesit.edit();
            userLocalDatabaseEditor.putString("emri", user.emri);
            userLocalDatabaseEditor.putString("perdoruesi", user.perdoruesi);
            userLocalDatabaseEditor.putString("fjalekalimi", user.fjalekalimi);
            userLocalDatabaseEditor.putString("mbiemri", user.mbiemri);
            userLocalDatabaseEditor.putInt("mosha", user.Mosha);
            userLocalDatabaseEditor.commit();
        }

        public void KyqePerdoruesin(boolean kyqu) {
            SharedPreferences.Editor userLocalDatabaseEditor = DatabazaLokalePerdoruesit.edit();
            userLocalDatabaseEditor.putBoolean("Kyqe", kyqu);
            userLocalDatabaseEditor.commit();
        }

        public void fshijTeDhenatPerdouesit() {
            SharedPreferences.Editor userLocalDatabaseEditor = DatabazaLokalePerdoruesit.edit();
            userLocalDatabaseEditor.clear();
            userLocalDatabaseEditor.commit();
        }

        public Perdoruesi MerrePerdoruesinKyqur() {
            if (DatabazaLokalePerdoruesit.getBoolean("kyqe", false) == false) {
                return null;
            }

            String emri = DatabazaLokalePerdoruesit.getString("emri", "");
            String mbiemri = DatabazaLokalePerdoruesit.getString("mbiemri", "");
            String fjalekalimi = DatabazaLokalePerdoruesit.getString("fjalekalimi", "");
            String perdoruesi = DatabazaLokalePerdoruesit.getString("perdoruesi", "");
            int mosha = DatabazaLokalePerdoruesit.getInt("mosha", -1);

            Perdoruesi user = new Perdoruesi(emri, mbiemri, mosha, perdoruesi, fjalekalimi);
            return user;
        }
    }

