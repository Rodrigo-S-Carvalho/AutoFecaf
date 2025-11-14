package rcautofecaf.Database;

import java.sql.*;

public class ConexaoBD {

    private String bdUrl, bdUser, bdPass;

    public Connection conexao;


   public ConexaoBD(){

       bdUrl = "jdbc:mysql://localhost:3306/autofecaf";

       bdUser = "root";

       bdPass = "";

   }

    public Boolean driverConectado() {

       try {
           this.conexao = DriverManager.getConnection(bdUrl, bdUser, bdPass);

           return true;

       } catch (SQLException erroDriver){

           System.out.println("Desculpe, mas houve um erro na conexão com o banco de dados: " +
                   erroDriver.getMessage());

            return false;
       }

    }

    public Connection fazerConexao(){
        System.out.println(driverConectado());

       boolean sucessoConexao = driverConectado();

        if (sucessoConexao){

            return this.conexao;

        }

        return null;
    }



}

