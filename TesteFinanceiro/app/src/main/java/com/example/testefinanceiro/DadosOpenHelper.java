package com.example.testefinanceiro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DadosOpenHelper extends SQLiteOpenHelper {
    public DadosOpenHelper(@Nullable Context context ) {
        super(context, "bdfilmes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( ScriptDLL.getCreateTableFilme() );
    }

    @Override
    public void onUpgrade( SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Implementar adicao de colunas ou novas tabelas





    }



}

