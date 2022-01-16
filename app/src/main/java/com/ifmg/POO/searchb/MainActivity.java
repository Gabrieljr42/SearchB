package com.ifmg.POO.searchb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import android.widget.ScrollView;
import android.widget.TextView;

import com.ifmg.POO.searchb.modelos.Versiculo;



import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Botão de alarme
        View alarme_button =  findViewById(R.id.alarme_home_button);
        alarme_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(MainActivity.this, Alerta.class);
                startActivityForResult(trocaAct, 0);
            }
        });
        //bottom menu
       View bible_page =  findViewById(R.id.bible_page);
        bible_page.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(MainActivity.this, Bible.class);
                startActivityForResult(trocaAct, 0);
            }
        });
        View home_menu =  findViewById(R.id.home_page);
        home_menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(MainActivity.this, MainActivity.class);
                startActivityForResult(trocaAct, 0);
            }
        });
        View search_page =  findViewById(R.id.search_page);
        search_page.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(MainActivity.this, Search.class);
                startActivityForResult(trocaAct, 0);
            }
        });

        // Botão dos versículos
        Button vs1 =  (Button) findViewById(R.id.vs1Button);
        vs1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(MainActivity.this, Reading.class);
                trocaAct.putExtra("capitulo", 11);
                trocaAct.putExtra("livro", 58);
                startActivityForResult(trocaAct, 0);
            }
        });

        Button vs2 =  (Button) findViewById(R.id.vs2Button);
        vs2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(MainActivity.this, Reading.class);
                trocaAct.putExtra("capitulo", 3);
                trocaAct.putExtra("livro", 43);
                startActivityForResult(trocaAct, 0);
            }
        });

        Button vs3 =  (Button) findViewById(R.id.vs3Button);
        vs3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(MainActivity.this, Reading.class);
                trocaAct.putExtra("capitulo", 139);
                trocaAct.putExtra("livro", 19);
                startActivityForResult(trocaAct, 0);
            }
        });

        //Palavras de pesquisa
        ImageButton pesquisa1 =  (ImageButton ) findViewById(R.id.pesquisa_1_button);
        pesquisa1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(MainActivity.this, Search.class);
                trocaAct.putExtra("palavra", "Amor");
                startActivityForResult(trocaAct, 0);
            }
        });
        ImageButton pesquisa2 =  (ImageButton ) findViewById(R.id.pesquisa_2_button);
        pesquisa2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(MainActivity.this, Search.class);
                trocaAct.putExtra("palavra", "Fe");
                startActivityForResult(trocaAct, 0);
            }
        });

        //Pesquisa de livros
        ImageButton book1 =  (ImageButton ) findViewById(R.id.book_1_button);
        book1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(MainActivity.this, Versiculos.class);
                trocaAct.putExtra("livro", 43);
                startActivityForResult(trocaAct, 0);
            }
        });
        ImageButton book2 =  (ImageButton ) findViewById(R.id.book_2_button);
        book2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(MainActivity.this, Versiculos.class);
                trocaAct.putExtra("livro", 19);
                startActivityForResult(trocaAct, 0);
            }
        });
    }








}