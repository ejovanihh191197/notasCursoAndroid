package com.sysprac.notas.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sysprac.notas.R;

public class MainActivity extends AppCompatActivity {
    private Button btn_login;
    private TextView txt_usuario;
    private TextView txt_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btn_login = findViewById(R.id.buttonLogin);
        txt_usuario = findViewById(R.id.editTextUsuario);
        txt_pass = findViewById(R.id.editTextPassword);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        });


    }
}
