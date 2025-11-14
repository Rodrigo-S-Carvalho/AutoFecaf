package rcautofecaf.Database;

import rcautofecaf.Models.Veiculo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VeiculoController {

    private ConexaoBD conexao;

    private Connection objConexao;

    private Statement declaracao;


    private Boolean sucessoCadastro = false;

    public VeiculoController() {

        try {
            conexao = new ConexaoBD();

            objConexao = conexao.fazerConexao();
            declaracao = objConexao.createStatement();

        } catch (Exception connErro){

            System.out.println("Erro ao acessar banco de dados para operações de cadastro: " +
                    connErro.getMessage());
        }
    }

    public Boolean getSucessoCadastro(){

        return sucessoCadastro;
    }

    public void cadastrarVeiculo(Veiculo veiculo){

        try {

            String queryCadastro = String.format(
                    "INSERT INTO `veiculos_cadastrados`(`categoria_veiculo`, `marca_veiculo`, `modelo_veiculo`, " +
                            "`ano_fabric_veiculo`, `cor_veiculo`, `motor_veiculo`, `num_chassi_veiculo`, " +
                            "`placa_veiculo`, `condicao_veiculo`, `descricao_veiculo`, `preco_veiculo`) " +

                            "VALUES ('%s','%s','%s','%s','%s','%s'," +
                            "'%s','%s','%s','%s', '" + veiculo.getPreco() + "')",

                    veiculo.getCategoria(),
                    veiculo.getMarca(),
                    veiculo.getModelo(),
                    Integer.parseInt(veiculo.getAnoFabric()),
                    veiculo.getCor(),
                    veiculo.getMotor(),
                    veiculo.getNumerochassi(),
                    veiculo.getPlaca(),
                    veiculo.getCondicao(),
                    veiculo.getDescricao());

            declaracao.executeUpdate(queryCadastro);

            this.sucessoCadastro = true;

        } catch (Exception cadastroErro){

            System.out.println("Desculpe, mas algo deu errado durante tentativa de cadastro: " +
                    cadastroErro.getMessage());

            this.sucessoCadastro = false;
        }

    }

    public void consultarVeiculo(){

        try {

            String queryConsulta = "SELECT * from veiculos_cadastrados";

            ResultSet resultadoQuery = declaracao.executeQuery(queryConsulta);

            while (resultadoQuery.next()) {

                Veiculo veiculo = new Veiculo();
                int idVeiculo;

                idVeiculo = (resultadoQuery.getInt("id"));
                veiculo.setCategoria(resultadoQuery.getString("categoria_veiculo"));
                veiculo.setMarca(resultadoQuery.getString("marca_veiculo"));
                veiculo.setModelo(resultadoQuery.getString("modelo_veiculo"));
                veiculo.setAnoFabric(resultadoQuery.getString("ano_fabric_veiculo"));
                veiculo.setCor(resultadoQuery.getString("cor_veiculo"));
                veiculo.setMotor(resultadoQuery.getString("motor_veiculo"));
                veiculo.setNumerochassi(resultadoQuery.getString("num_chassi_veiculo"));
                veiculo.setPlaca(resultadoQuery.getString("placa_veiculo"));
                veiculo.setCondicao(resultadoQuery.getString("condicao_veiculo"));
                veiculo.setDescricao(resultadoQuery.getString("descricao_veiculo"));
                veiculo.setPreco(resultadoQuery.getBigDecimal("preco_veiculo"));

                System.out.printf("\n----------------- Veículo %d: -----------------------\n\n", idVeiculo);
                veiculo.listarInfoVeiculo();

            }


        } catch (Exception erroConexao){

            System.out.println("Erro durante tentativa de consultar veículo:" +
                    erroConexao.getMessage());
        }

    }

    public void deletarVeiculo(){}

}
