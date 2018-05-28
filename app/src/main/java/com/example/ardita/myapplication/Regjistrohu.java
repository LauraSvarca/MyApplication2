package com.example.ardita.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Regjistrohu extends AppCompatActivity implements View.OnClickListener{

    Button Regjistrohu;
    EditText editEmri, editMbiemri, editMosha, editperdoruesi, editfjalekalimi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regjistrohu);


        editEmri = (EditText) findViewById(R.id.editEmri);
        editMbiemri = (EditText) findViewById(R.id.editMbiemri);
        editMosha = (EditText) findViewById(R.id.editMosha);
        editfjalekalimi = (EditText) findViewById(R.id.editfjalekalimi);
        Regjistrohu = (Button) findViewById(R.id.Regjistrohu);
        Regjistrohu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Regjistrohu:
                String emri = editEmri.getText().toString();
                String mbiemri = editMbiemri.getText().toString();
                String perdoruesi = editperdoruesi.getText().toString();
                String fjalekalimi = editfjalekalimi.getText().toString();
                int mosha = Integer.parseInt(editMosha.getText().toString());

                Perdoruesi user = new Perdoruesi(emri, mbiemri, mosha, perdoruesi, fjalekalimi);
                RegjistroPerdoruesin(user);

                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
            private void RegjistroPerdoruesin(Perdoruesi user) {
                KerkesaServer serverRequest = new KerkesaServer(this);
                serverRequest.storeUserDataInBackground(user, new GetUserCallback() {


                    @Override
                    public void done(Perdoruesi returnedUser) {
                        Intent loginIntent = new Intent(Regjistrohu.this, kyqu.class);
                        startActivity(loginIntent);
                    }
                });
        }
    }

