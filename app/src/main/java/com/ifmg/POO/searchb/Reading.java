package com.ifmg.POO.searchb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ifmg.POO.searchb.modelos.Capitulo;
import com.ifmg.POO.searchb.modelos.Versiculo;

import org.w3c.dom.Text;

public class Reading extends AppCompatActivity {
    private int livroId;
    private int capituloId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        LinearLayout versiculos_leitura = (LinearLayout) findViewById(R.id.Leitura_versiculos);
        TextView titulo = (TextView) findViewById(R.id.tituloReading);

        //Chamando de onde veio para buscar no SQL
        Intent intencao = getIntent();
        livroId = intencao.getIntExtra("livro", 0);
        capituloId = intencao.getIntExtra("capitulo",1);

        EventosDb db = new EventosDb(this);
        Capitulo capitulo = new Capitulo();
        capitulo = db.getCapituloById(livroId,capituloId);
        Versiculo[] versiculos = new Versiculo[150];
        versiculos = capitulo.getConteudo();

        ScrollView versiculos_scroll = new ScrollView(this);
        LinearLayout vertical = new LinearLayout(this);
        vertical.setOrientation(LinearLayout.VERTICAL);

        for(int x = 1; x!= 177; x++){
            Versiculo versiculo = new Versiculo();
            if(versiculos[x] != null) {
                versiculo = versiculos[x];
                TextView texto = new TextView(this);

                //Achando a sigla com base no id do livro(Gn = "1", EX = "2"
                String sigla = this.NomeById(versiculo.getLivro());

                titulo.setText(sigla + " - "+versiculo.getCapitulo());

                //Criando o text View com "Sigla" + número do capitulo + número do versiculo + vérsiculo em si (Ex : Gn 1:1 No princípio criou Deus o céu e a terra.
                texto.setText(sigla+" "+versiculo.getCapitulo()+":"+versiculo.getNumVer()+"-"+versiculo.getConteudo()+"\n");

                vertical.addView(texto);
            }else{
                break;
            }
        }
        versiculos_scroll.addView(vertical);
        versiculos_leitura.addView(versiculos_scroll);
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