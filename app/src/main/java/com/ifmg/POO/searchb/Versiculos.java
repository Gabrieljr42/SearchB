package com.ifmg.POO.searchb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.ifmg.POO.searchb.modelos.Biblia;
import com.ifmg.POO.searchb.modelos.Capitulo;
import com.ifmg.POO.searchb.modelos.Versiculo;

public class Versiculos extends AppCompatActivity  {
    private int livro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versiculos);

        LinearLayout versiculos_holder = (LinearLayout) findViewById(R.id.versiculos_holder);

        Intent intencao = getIntent();
        livro = intencao.getIntExtra("livro", 0);


        EventosDb db = new EventosDb(this);

        Biblia biblia = db.getLivroById(livro);
        Capitulo capitulos[] = biblia.getBiblia();

        LinearLayout horizontal = new LinearLayout(this);
        horizontal.setOrientation(LinearLayout.HORIZONTAL);
        ScrollView versiculos_scroll = new ScrollView(this);
        LinearLayout linear_scroll = new LinearLayout(this);
        linear_scroll.setOrientation(LinearLayout.VERTICAL);

        //Maior número de capitulos possivel em um livro (Salmos com 150)
        for (int x = 1; x != 151; x++) {
            //Se estiver como null acabou os capitulos disponiveis
            if (capitulos[x - 1] == null && x != 1) {
                break;
            } else {
                //A cada 4 capitulos pula de linha, para isso reseta o LinearLayout
                if (x % 4 == 1) {
                    horizontal = new LinearLayout(this);
                    horizontal.setOrientation(LinearLayout.HORIZONTAL);
                    linear_scroll.addView(horizontal);
                }
                Button versiculo = new Button(this);
                versiculo.setText("" + x);
                versiculo.setTag("teste");
                versiculo.setId(x);
                versiculo.setWidth(20);
                versiculo.setHeight(20);
                versiculo.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent trocaAct = new Intent(Versiculos.this, Reading.class);
                        trocaAct.putExtra("capitulo", versiculo.getId());
                        trocaAct.putExtra("livro", livro);
                        startActivityForResult(trocaAct, 0);
                    }
                });
                horizontal.addView(versiculo);
            }
        }
        versiculos_scroll.addView(linear_scroll);
        versiculos_holder.addView(versiculos_scroll);

    }

}