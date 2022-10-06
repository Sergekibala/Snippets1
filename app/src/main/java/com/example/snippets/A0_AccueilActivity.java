package com.example.snippets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.snippets.a1_layout_xml.A11_LinearLayoutXml;

public class A0_AccueilActivity extends AppCompatActivity {

    /** VARIABLE GLOBALE **/
    TextView tvLineartLayout;

    /** Méthode pour lier design au code **/
    public void initUI(){
        tvLineartLayout = findViewById(R.id.tvLineartLayout);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a0_accueil);
        initUI();

        tvLineartLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                                      // Depart               //Arrivée
                Intent intent = new Intent(A0_AccueilActivity.this, A11_LinearLayoutXml.class);
                startActivity(intent);
            }
        });
    }
}