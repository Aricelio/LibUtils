package br.com.ti.aricelio.libutils.DataAccess;

/**
 * Created by aricelio on 15/07/16.
 */
public class BuildSQL {

    // Método para construção da instrução SQL de criação da Tabela.................................
    public static final String createTable(String tableName,
                                           int nLinhas,
                                           int nColunas,
                                           String fields[],
                                           String types[]){

        String matriz[][] = new String[nLinhas][nColunas];
        String sql;

        // Preenche a matriz
        for(int i=0; i < nLinhas; i++){

            for(int j=0; j < nColunas; j++){
                if(j==0){
                    matriz[i][j] = fields[i];
                }
                else if(j==1){
                    matriz[i][j] = types[i];
                }
            }
        }

        // Gera a instruçao SQL de Inserçao com base na matriz
        sql = buildSQLCreate(tableName + " ( ", matriz);

        // Retorna a instrução SQL
        return sql;
    }

    private static String buildSQLCreate(String tableName, String matriz[][]){

        int nLinhas = matriz.length;

        String sql = "CREATE TABLE ";

        // Nome da tabela
        sql += tableName;

        // Campos da Tabela
        for(int i=0; i < nLinhas; i++){

            sql += matriz[i][0]; // Coluna 0 da Linha
            sql += matriz[i][1]; // Coluna 1 da Linha

            // Se for
            if(i+1 == nLinhas)
                sql += " ) ";
            else
                sql += " , ";
        }

        return sql;
    }

    // Método para consulta no Banco de dados.......................................................
    public static final String select(String tableName){
        return " SELECT * FROM " + tableName;
    }

    public static final String select(String tableName, int rows, boolean isOrderByDesc, String fieldOrderBy){

        String strConsulta = "SELECT * FROM " + tableName;
        String tipoOrder;

        if(isOrderByDesc){
            tipoOrder = " DESC";
        }
        else{
            tipoOrder = " ASC";
        }

        if(!fieldOrderBy.equals("")){
            strConsulta += " ORDER BY " + fieldOrderBy + tipoOrder;
        }

        if(rows > 0){
            strConsulta += " LIMIT " + rows;
        }

        return strConsulta;
    }
}
