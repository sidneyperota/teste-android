package com.example.testefinanceiro;

public class ScriptDLL {

    public static String getCreateTableFilme() {

        StringBuilder sql = new StringBuilder();

        sql.append(" CREATE TABLE IF NOT EXISTS filme (");
        sql.append(" codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sql.append(" titulo VARCHAR(30) NOT NULL DEFAULT ('')," );
        sql.append(" ano VARCHAR(4) NOT NULL DEFAULT ('') )");
        return sql.toString();
    }

}
