package rcautofecaf;

import rcautofecaf.Database.ConexaoBD;
import rcautofecaf.Database.VeiculoController;
import rcautofecaf.Models.Veiculo;

public class AutoApp {

    public static void main (String[] args){

        //VeiculoController veiculo = new VeiculoController();
        Veiculo veiculoMenu = new Veiculo();

        System.out.println("-------Bem-vindo(a) à RC Auto Fecaf! -------------\n");
        //veiculo.consultarVeiculo();
        veiculoMenu.cadastroVeiculo();


    }
}
