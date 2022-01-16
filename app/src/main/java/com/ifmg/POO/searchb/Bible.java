package com.ifmg.POO.searchb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Bible extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible);

        //Bottom Menu
        View bible_page =  findViewById(R.id.bible_page);
        bible_page.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(Bible.this, Bible.class);
                startActivityForResult(trocaAct, 0);
            }
        });

        View home_menu =  findViewById(R.id.home_page);
        home_menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(Bible.this, MainActivity.class);
                startActivityForResult(trocaAct, 0);
            }
        });
        View search_page =  findViewById(R.id.search_page);
        search_page.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent trocaAct = new Intent(Bible.this, Search.class);
                startActivityForResult(trocaAct, 0);
            }
        });
    }
    //Quando o usuario clica em um dos botoes essa função é chamada e redireciona para o livro da biblia de acordo com o que foi escolhido
    public void buttonClicked(View view) {

        if (view.getId() == R.id.Gênesis) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 1);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Êxodo) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 2);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Levítico) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 3);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Números) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 4);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Deuteronômio) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 5);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Josué) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 6);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Juízes) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 7);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Rute) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 8);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Samuel1) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 9);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Samuel2) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 10);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Reis1) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 11);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Reis2) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 12);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Crônicas1) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 13);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Crônicas2) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 14);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Esdras) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 15);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Neemias) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 16);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.ester) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 17);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.jó) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 18);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.salmos) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 19);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.provérbios) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 20);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.eclesiastes) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 21);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.cânticos) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 22);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.isaías) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 23);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.jeremias) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 24);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.lamentações) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 25);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.ezequiel) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 26);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.daniel) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 27);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Oséias) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 28);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Joel) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 29);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Amós) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 30);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Obadias) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 31);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Jonas) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 32);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Miquéias) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 33);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Naum) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 34);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Habacuque) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 35);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Sofonias) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 36);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Ageu) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 37);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Zacarias) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 38);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Malaquias) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 39);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Mateus) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 40);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Marcos) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 41);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Lucas) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 42);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.João) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 43);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Atos) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 44);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Romanos) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 45);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Coríntios1) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 46);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Coríntios2) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 47);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Gálatas) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 48);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Efésios) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 49);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Filipenses) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 50);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Colossenses) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 51);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Tessalonicenses1) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 52);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Tessalonicenses2) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 53);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Timóteo1) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 54);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Timóteo2) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 55);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Tito) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 56);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Filemom) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 57);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Hebreus) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 58);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Tiago) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 59);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Pedro1) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 60);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.Pedro2) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 61);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.João1) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 62);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.João2) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 63);
            startActivityForResult(trocaAct, 0);
        }else if (view.getId() == R.id.João3) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 64);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Judas) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 65);
            startActivityForResult(trocaAct, 0);
        } else if (view.getId() == R.id.Apocalipse) {
            Intent trocaAct = new Intent(Bible.this, Versiculos.class);
            trocaAct.putExtra("livro", 66);
            startActivityForResult(trocaAct, 0);
        }

    }
}