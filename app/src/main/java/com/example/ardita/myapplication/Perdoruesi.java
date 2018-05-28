package com.example.ardita.myapplication;

public class Perdoruesi {

        String emri, mbiemri, perdoruesi, fjalekalimi;
        int Mosha;

        public Perdoruesi(String emri, String Mbiemri, int Mosha, String perdoruesi, String fjalekalimi) {
            this.emri = emri;
            this.mbiemri= mbiemri;
            this.Mosha = Mosha;
            this.perdoruesi = perdoruesi;
            this.fjalekalimi = fjalekalimi;
        }

        public Perdoruesi(String perdoruesi, String fjalekalimi) {
            this("","", -1, perdoruesi, fjalekalimi);
        }
}
