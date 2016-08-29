package br.com.ti.aricelio.libutils.DataAccess;

/**
 * Created by aricelio on 15/07/16.
 */
public class Type {
    public static final String DATE = " DATE ";
    public static final String TEXT = " TEXT ";
    public static final String DOUBLE = " DOUBLE ";
    public static final String INT = " INTEGER ";
    public static final String PK = " INTEGER PRIMARY KEY AUTOINCREMENT ";

    public static final String FK (String FK_ID, String FK_TABLE){
        return " FOREIGN KEY (" + FK_ID + ") REFERENCES " + FK_TABLE + "(id)";
    }
}
