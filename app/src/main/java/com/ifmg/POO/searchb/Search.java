package com.ifmg.POO.searchb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ifmg.POO.searchb.modelos.Versiculo;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    private ArrayList<Versiculo> versiculo = new ArrayList();

    //Fazendo a conexão com o Banco de dados SQLite em busca das informações
    private EventosDb db = new EventosDb(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //Bottom Menu
        View bible_page =  findViewById(R.id.bible_page);
        bible_page.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(Search.this, Bible.class);
                startActivityForResult(trocaAct, 0);
            }
        });

        View home_menu =  findViewById(R.id.home_page);
        home_menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(Search.this, MainActivity.class);
                startActivityForResult(trocaAct, 0);
            }
        });
        View search_page =  findViewById(R.id.search_page);
        search_page.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(Search.this, Search.class);
                startActivityForResult(trocaAct, 0);
            }
        });
        //Pega uma palavra, se existe
        Intent intencao = getIntent();
        String palavra = intencao.getStringExtra("palavra");
        //Criando o LinearLayout e ScrollView que exibira os versiculos
        LinearLayout principal = (LinearLayout) findViewById(R.id.Search);


        ScrollView scrollView = (ScrollView) findViewById(R.id.ScrollSearch);


        //Entrada de texto do usuario
        EditText texto = (EditText) findViewById(R.id.searchInBible);
        //Se entrar veio do menu principal com uma palavra definida
        if(palavra != null && palavra.length() != 0){
            texto.setText(palavra);
        }
        //Botão de procura
        ImageButton lupa = (ImageButton) findViewById(R.id.lupaSearch);


        lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Quando usuario clicar no botão pegando o texto e chamando a função de procura
                String frase =texto.getText().toString();
                buscaFrase(frase,principal,scrollView);
            }
        });


    }

    public void buscaFrase(String frase,LinearLayout principal, ScrollView scrollView){



        //Criando um ArrayList com os versículos que contem a palavra

        versiculo = db.searchBiblia(frase);

        //Criando o LinearLayout que ficara os versiculos
        LinearLayout versiculos = new LinearLayout(this);
        versiculos.setOrientation(LinearLayout.VERTICAL);

        //Removendo se existia versiculos anteriores
        principal.removeView(scrollView);


        //Loop Por todos os versiculos
        for(int x = 0; x != versiculo.size(); x++){

            //Criando um textView para adicionar o pedido
            TextView textView = new TextView(this);

            //Achando a sigla com base no id do livro(Gn = "1", EX = "2"
            String sigla = this.NomeById(versiculo.get(x).getLivro());

            //Criando o text View com "Sigla" + número do capitulo + número do versiculo + vérsiculo em si (Ex : Gn 1:1 No princípio criou Deus o céu e a terra.
            textView.setText(sigla+" "+versiculo.get(x).getCapitulo()+":"+versiculo.get(x).getNumVer()+"-"+versiculo.get(x).getConteudo()+"\n");

            //Adicionando o textView no LinearLayout
            versiculos.addView(textView);


        }
        //Limpando o que existia no ScrollView antes
        scrollView.removeAllViews();

        //Adicionando os novos vérsiculos
        scrollView.addView(versiculos);



    }
    //Procurando a sigla com base no ID
    public String NomeById(int id){
        String name = "";
        switch(id){
            case 1:
                name ="Gn";
                break;
            case 2:
                name ="Ex";
                break;
            case 3:
                name ="Lv";
                break;
            case 4:
                name ="Nm";
                break;
            case 5:
                name ="Dt";
                break;
            case 6:
                name ="Js";
                break;
            case 7:
                name ="Jz";
                break;
            case 8:
                name ="Rute";
                break;
            case 9:
                name ="1Sm";
                break;
            case 10:
                name ="2Sm";
                break;
            case 11:
                name ="1Rn";
                break;
            case 12:
                name ="2Rn";
                break;
            case 13:
                name ="1Cr";
                break;
            case 14:
                name ="2Cr";
                break;
            case 15:
                name ="Ed";
                break;
            case 16:
                name ="Ne";
                break;
            case 17:
                name ="Et";
                break;
            case 18:
                name ="Jó";
                break;
            case 19:
                name ="Sl";
                break;
            case 20:
                name ="Pv";
                break;
            case 21:
                name ="Ec";
                break;
            case 22:
                name ="Ct";
                break;
            case 23:
                name ="Is";
                break;
            case 24:
                name ="Jr";
                break;
            case 25:
                name ="Lm";
                break;
            case 26:
                name ="Ez";
                break;
            case 27:
                name ="Dn";
                break;
            case 28:
                name ="Os";
                break;
            case 29:
                name ="Jl";
                break;
            case 30:
                name ="Am";
                break;
            case 31:
                name ="Ob";
                break;
            case 32:
                name ="Jn";
                break;
            case 33:
                name ="Mq";
                break;
            case 34:
                name ="Na";
                break;
            case 35:
                name ="Hc";
                break;
            case 36:
                name ="Sf";
                break;
            case 37:
                name ="Ag";
                break;
            case 38:
                name ="Zc";
                break;
            case 39:
                name ="Ml";
                break;
            case 40:
                name ="Mt";
                break;
            case 41:
                name ="Mc";
                break;
            case 42:
                name ="Lc";
                break;
            case 43:
                name ="Jo";
                break;
            case 44:
                name ="At";
                break;
            case 45:
                name ="Rm";
                break;
            case 46:
                name ="1Co";
                break;
            case 47:
                name ="2Co";
                break;
            case 48:
                name ="Gl";
                break;
            case 49:
                name ="Ef";
                break;
            case 50:
                name ="Fp";
                break;
            case 51:
                name ="Cl";
                break;
            case 52:
                name ="1Ts";
                break;
            case 53:
                name ="2Ts";
                break;
            case 54:
                name ="1Tm";
                break;
            case 55:
                name ="2Tm";
                break;
            case 56:
                name ="Tt";
                break;
            case 57:
                name ="Fm";
                break;
            case 58:
                name ="Hb";
                break;
            case 59:
                name ="Tg";
                break;
            case 60:
                name ="1Pe";
                break;
            case 61:
                name ="2Pe";
                break;
            case 62:
                name ="1Jo";
                break;
            case 63:
                name ="2Jo";
                break;
            case 64:
                name ="3Jo";
                break;
            case 65:
                name ="Jd";
                break;
            case 66:
                name ="Ap";
                break;
        }
        return name;
    }
}