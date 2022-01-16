package com.ifmg.POO.searchb;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.ifmg.POO.searchb.modelos.Biblia;
import com.ifmg.POO.searchb.modelos.Versiculo;
import com.ifmg.POO.searchb.modelos.Capitulo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public  class EventosDb extends SQLiteOpenHelper {
    private Context contexto;

    public EventosDb(Context cont) {
        super(cont, "Biblia", null, 20);
        contexto = cont;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            try {
                //Criando o banco de dados dos vérsiculos
                db.execSQL("CREATE TABLE IF NOT EXISTS `versiculos` (\n" +
                        "  `ver_id` int(10) NOT NULL ,\n" +
                        "  `ver_vrs_id` tinyint(3) NOT NULL,\n" +
                        "  `ver_liv_id` tinyint(3)  NOT NULL,\n" +
                        "  `ver_capitulo` tinyint(3)  NOT NULL,\n" +
                        "  `ver_versiculo` tinyint(3)  NOT NULL,\n" +
                        "  `ver_texto` text NOT NULL,\n" +
                        "  PRIMARY KEY (`ver_id`)\n" +
                        ")");
            } catch (SQLiteException ex) {

            }
            //Pegando o arquivo SQL com a Biblia arquivo em res/raw
            InputStream insertsStream = contexto.getResources().openRawResource(R.raw.biblia_8);
            BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));

            // Interagindo em cada linha e executando o SQL
            while (insertReader.ready()) {
                String insertStmt = insertReader.readLine();
                try {
                    db.execSQL(insertStmt);
                } catch (SQLiteException ex) {

                }

            }
            //Fechando o arquivo
            insertReader.close();

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
    }


    //Retorna um livro inteiro da biblia com base no seu id
    public Biblia getLivroById(int livroId){
        Capitulo capitulo = new Capitulo();
        Versiculo versiculo = new Versiculo();
        Versiculo versiculos[] = new Versiculo[177];//Número maximo de versículos possiveis em um capitulo(Salmos 119 com 176 versículos)
        Capitulo capitulos[] = new Capitulo[150];

        String sql = "SELECT * FROM versiculos where ver_vrs_id = '1' and ver_liv_id = '"+livroId+"'";
        try (SQLiteDatabase db = this.getWritableDatabase()) {
            Cursor res = db.rawQuery(sql, null);
            while (res.moveToNext()) {
                //Esse IF seria para separar os capitulos
                if(res.getInt(3) != versiculo.getCapitulo() && versiculo.getCapitulo() != 0){
                    capitulo.createCapitulo(versiculos);
                    capitulos[versiculo.getCapitulo()] = capitulo;
                    versiculo = new Versiculo(res.getInt(0), res.getString(5), false, res.getInt(3), res.getInt(2),res.getInt(4));
                    versiculos[versiculo.getNumVer()] = versiculo;
                }else{
                    versiculo = new Versiculo(res.getInt(0), res.getString(5), false, res.getInt(3), res.getInt(2),res.getInt(4));
                    versiculos[versiculo.getNumVer()] = versiculo;
                }

            }
        }
        Biblia biblia = new Biblia(1,capitulos);
        return biblia;
    }

    //Retorna o capitulo com base no ID
    public Capitulo getCapituloById(int livroId,int capituloId){
        Capitulo capitulo = new Capitulo();
        Versiculo versiculo = new Versiculo();
        Versiculo versiculos[] = new Versiculo[177];//Número maximo de versiculos possiveis(Salmos 119:176)


        String sql = "SELECT * FROM versiculos where ver_vrs_id = '1' and ver_liv_id = '"+livroId+"' and ver_capitulo = '"+capituloId+"'";
        try (SQLiteDatabase db = this.getWritableDatabase()) {
            Cursor res = db.rawQuery(sql, null);
            while (res.moveToNext()) {
                    versiculo = new Versiculo(res.getInt(0), res.getString(5), false, res.getInt(3), res.getInt(2),res.getInt(4));
                    versiculos[versiculo.getNumVer()] = versiculo;
            }
        }
        capitulo.createCapitulo(versiculos);
        return capitulo;
    }

    //Procura pela biblia toda por um versiculo que contenha a palavra digitada
    public ArrayList searchBiblia(String palavra) {
        //ArrayList que contem a biblia
        ArrayList<Versiculo> versiculos = new ArrayList();

        try (SQLiteDatabase db = this.getWritableDatabase()) {
            //Pegando os versiculos usando  Select
            String sql = "SELECT * FROM versiculos where ver_vrs_id = '1' and ver_texto LIKE '%"+palavra+"%'";
            Cursor res = db.rawQuery(sql, null);

            while (res.moveToNext()) {
                Versiculo versiculo = new Versiculo(res.getInt(0), res.getString(5), false, res.getInt(3), res.getInt(2),res.getInt(4));
                versiculos.add(versiculo);
            }
            return versiculos;
        }
    }

        //Dando erro de memoria. Ideia principal tera que ser reestruturada
        //Até a reestruturação, usarei um metodo fora do POO com Array List
        // Erro : I/Gabriel.search: Waiting for a blocking GC Alloc
        //I/Gabriel.search: WaitForGcToComplete blocked Alloc on HeapTrim for 187.630ms
        //  Starting a blocking GC Alloc
    /*
    public  ArrayList<Capitulo>  setBiblia(){

        ArrayList<Versiculo> versiculos = new ArrayList();
        ArrayList<Capitulo> capitulos = new ArrayList();
        try(SQLiteDatabase db = this.getWritableDatabase()){
            String sql = "SELECT*FROM versiculos ";
            Cursor res = db.rawQuery(sql, null);

            while (res.moveToNext()) {
                Versiculo versiculo = new Versiculo(res.getInt(0),res.getString(5),false,res.getInt(3));
                versiculos.add(versiculo);
            }
            Versiculo ver[] = new Versiculo[versiculos.size()];
            Capitulo capitulo = new Capitulo();

        for(int x = 0; x!= versiculos.size(); x ++){
            ver[x] = versiculos.get(x);
            if(x != 0 && ver[x-1] != null ){
                if(ver[x].getCapitulo() != ver[x-1].getCapitulo()) {
                    capitulo.setConteudo(ver);
                    capitulos.add(capitulo);
                }

            }else{

                ver = new Versiculo[versiculos.size()];
            }

        }


        }catch (SQLiteException ex) {

        }
        return capitulos;
    }
    */

        @Override
        public void onUpgrade (SQLiteDatabase sqLiteDatabase,int i, int i1){

        }
    }

