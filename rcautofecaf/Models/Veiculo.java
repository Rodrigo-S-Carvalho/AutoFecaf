package rcautofecaf.Models;

import rcautofecaf.Database.VeiculoController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.Year;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Scanner;

public class Veiculo extends Marca{

    private String categoria, marca, modelo, anoFabric, cor, motor,
            numerochassi, placa, condicao, descricao, disponibilidade;

    private double quilometragem;
    private DecimalFormat mascaraKm = new DecimalFormat("0000000000.0",
            new DecimalFormatSymbols(Locale.forLanguageTag("pt-BR")));

    private BigDecimal preco;
    private NumberFormat mascaraReais = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));

    private String [] listaCondicao = {"Novo", "Seminovo", "Usado"};

    private String[] listaMarca;

    //private double preco;


    private String [] opcoesCadastro = {"Confirmar cadastro", "Refazer", "Cancelar"};

    private String [] categorias = {"Ciclomotor", "Motoneta/Moto", "Triciclo", "Quadriciclo",
            "Hatchback", "Sedan", "SUV", "Esportivo", "Picape", "Crossover", "Perua",
            "Minivan", "Caminhão", "Ônibus", "Trator"};

    private String
            descMarca = "Especifique a marca como \"Ford\", \"Chevrolet\",\n" +
            " \"Renault\", \"Fiat\" etc. ou informe manualmente a marca do veículo.",

            descModelo = "Especifique o modelo como \"Celta LT\", \"Clio RT\",\n" +
                    "\"Uno Fire\", \"Mustang GT\" etc.",

            descAnoFabric = "Espefifique o ano de fabricação do veículo como \"1998\",\n" +
                    " \"2010\" etc. O ano mínimo permitido é 1750, até o ano atual.",

            descCategoria = "Especifique a categoria de veículo como \"ciclomotor\", \"moto\",\n" +
                    " \"sedan\", \"esportivo\", \"minivan\", \"caminhão\" etc.",

            descCor = "Especifique a cor do veículo, conforme documentação oficial.\n" +
                    " Digite ao menos 3 caracteres para informar a cor.",

            descMotor = "Descreva o tipo de motor com informações como número de válvulas,\n" +
                    "cilindradas, denominação por tipo de combustível (como \"Flex\") etc. " +
                    " Digite ao menos 10 caracteres nesta descrição.",

            descNumerochassi = "Informe os 17 caracteres que compôem o código de chassi do veículo.\n" +
                    "Caso o veículo não possua numeração de chassis, apenas ignore o campo.",

            descPlaca = "Informe a placa do veículo.Se ele ainda não está emplacado, ignorar o campo.\n" +
                    "Se o veículo já é emplacado, a informação é obrigatória.",

            descCondicao = "Especifique a condição ou estado de conservação do veículo:\n" +
                    "\"Novo\", \"Seminovo\" ou \"Usado\"",

            descKm = "Especifique a quilometragem indicada no veículo.\n" +
                    "Se ele percorreu menos de 1km, representar com 0,número_de_metros, se possível.\n" +
                    "Se não for possível estimar a quilometragem, use uma estimativa, mas nunca zero.",

            descDescricao = "Descreva o veículo com o máximo de detalhes que possam interessar\n" +
                    "compradores, tais como tração, lugares, peso, dimensões etc.\n" +
                    "Digite ao menos dez caracteres com uma descrição coerente e informativa,\n" +
                    "e um máximo de três mil caracteres.",

            descPreco = "Informe o preço do veículo, conforme a forma de negociação desejada: ";


    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAnoFabric() {
        return anoFabric;
    }

    public String getCor() {
        return cor;
    }

    public String getMotor() {
        return motor;
    }

    public String getNumerochassi() {
        return numerochassi;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCondicao() {
        return condicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoFabric(String anoFabric) {
        this.anoFabric = anoFabric;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setNumerochassi(String numerochassi) {
        this.numerochassi = numerochassi;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void cadastroVeiculo(){
        int opcaoEscolhida;
        String mascaraIndice;
        int listaNumDados;
        Scanner scanner = new Scanner(System.in);
        Boolean resultadoCadastro = false;


        do {
            opcaoEscolhida = -1;
            listaNumDados = 1;


            System.out.println("\n\nPor favor, preencha os dados conforme a descrição de cada um");

            do {

                System.out.printf("\n%d. TIPO DE VEÍCULO (CAMPO OBRIGATÓRIO)\n", listaNumDados);
                System.out.println(this.descCategoria + "\n");

                for (int i = 0; i < this.categorias.length; i++) {

                    System.out.println(i + " - " + this.categorias[i]);

                }

                System.out.printf("Por favor, digite apenas o número da opção desejada, entre 0 e %d: ",
                        this.categorias.length - 1);

                mascaraIndice = scanner.nextLine();

                if (mascaraIndice.matches("\\d+")) opcaoEscolhida = Integer.parseInt(mascaraIndice);
                //scanner.nextLine();

            } while (!mascaraIndice.matches("\\d+") || opcaoEscolhida < 0 || opcaoEscolhida >= this.categorias.length);

            this.categoria = this.categorias[opcaoEscolhida];
            System.out.println("Categoria escolhida: " + this.categoria);


            listaNumDados++;

            do {

                System.out.printf("\n%d. MARCA DO VEÍCULO (CAMPO OBRIGATÓRIO)\n", listaNumDados);
                System.out.println(this.descMarca + "\n");

                filtrarMarca(opcaoEscolhida);
                System.out.printf("%d Outra marca...", this.listaMarca.length);

                System.out.printf("\nPor favor, digite apenas o número da opção desejada, entre 0 e %d: ", this.listaMarca.length);


                mascaraIndice = scanner.nextLine();

                if (mascaraIndice.matches("\\d+")) opcaoEscolhida = Integer.parseInt(mascaraIndice);
                //scanner.nextLine();

                if (opcaoEscolhida == this.listaMarca.length) {

                    System.out.print("Por favor, digite a marca do veículo: ");


                    this.marca = limitarCaracteres(scanner.nextLine(), 30);

                } else if (opcaoEscolhida >= 0 && opcaoEscolhida < this.listaMarca.length) {

                    this.marca = this.listaMarca[opcaoEscolhida];

                }
                System.out.println("Marca escolhida: " + this.marca);


            } while (!mascaraIndice.matches("\\d+") || opcaoEscolhida < 0 ||
                    opcaoEscolhida > listaMarca.length);

            opcaoEscolhida = -1;
            listaNumDados++;
            do {

                System.out.printf("\n%d. MODELO DE VEÍCULO (CAMPO OBRIGATÓRIO)\n", listaNumDados);
                System.out.println(this.descModelo + "\n");
                System.out.print("Por favor, digite ao menos uma letra ou número que descreva " +
                        "o modelo, conforme documentação ou descrição: ");

                this.modelo = limitarCaracteres(scanner.nextLine(), 60);

                System.out.println("Modelo informado: " + this.modelo);

            } while (this.modelo.isEmpty());


            listaNumDados++;
            do {

                System.out.printf("\n%d. ANO DE FABRICAÇÃO DO VEÍCULO (CAMPO OBRIGATÓRIO)\n", listaNumDados);
                System.out.println(this.descAnoFabric + "\n");

                System.out.print("Por favor, digite o ano de fabricação do veículo no formato \"AAAA\" (2000, por exemplo): ");

                this.anoFabric = limitarCaracteres(scanner.nextLine(), 4);

                System.out.println("Ano de fabricação informado: " + this.anoFabric);

            } while (!this.anoFabric.matches("-?\\d+") ||
                    Integer.parseInt(this.anoFabric) < 1750 ||
                    Integer.parseInt(this.anoFabric) >
                            Year.now(ZoneId.of("America/Sao_Paulo")).getValue() ||
                    this.anoFabric.length() < 4);


            listaNumDados++;
            do {

                System.out.printf("\n%d. COR DO VEÍCULO (CAMPO OBRIGATÓRIO)\n", listaNumDados);
                System.out.println(this.descCor + "\n");

                System.out.print("Por favor, digite o nome exato da cor do veículo, conforme documentação: ");

                this.cor = limitarCaracteres(scanner.nextLine(), 30);

                System.out.println("Cor informada do veículo: " + this.cor);
            } while (this.cor.length() < 3);


            listaNumDados++;
            do {

                System.out.printf("\n%d. MOTOR DO VEÍCULO (CAMPO OBRIGATÓRIO)\n", listaNumDados);
                System.out.println(this.descMotor + "\n");

                System.out.print("Por favor, digite características técnicas relevantes sobre o motor: ");

                this.motor = limitarCaracteres(scanner.nextLine(), 100);

                System.out.println("Informações dadas sobre motor do veículo: " + this.motor);

            } while (this.motor.length() < 10);

            listaNumDados++;
            do {

                System.out.printf("\n%d. NUMERAÇÃO DO CHASSI DO VEÍCULO (OBEIGATÓRIO)\n", listaNumDados);
                System.out.println(this.descNumerochassi + "\n");

                System.out.println("Por favor, digite os 17 caracteres que formam a numeração do chassi: ");
                String chassiDigitado;

                chassiDigitado = limitarCaracteres(scanner.nextLine(), 17);

                this.numerochassi = chassiDigitado.replaceAll("\\s+", "");
                System.out.println("Numeração informada do chassi do veículo: " + this.numerochassi);

            } while (this.numerochassi.length() != 17);


            listaNumDados++;
            do {
                System.out.printf("\n%d. CONDIÇÃO DO VEÍCULO (OBRIGATÓRIO)\n", listaNumDados);
                System.out.println(this.descCondicao + "\n");

                for (int i = 0; i < listaCondicao.length; i++) {

                    System.out.println(i + " - " + listaCondicao[i]);

                }

                System.out.print("Por favor, escolha a condição atual do veículo: ");

                mascaraIndice = scanner.nextLine();


                if(mascaraIndice.matches("\\d+")) opcaoEscolhida = Integer.parseInt(mascaraIndice);
                //scanner.nextLine();

            } while (opcaoEscolhida < 0 || opcaoEscolhida >= listaCondicao.length);

            if (opcaoEscolhida != 0) {

                String kmDigitado;
                listaNumDados++;

                do {

                    System.out.printf("\n%d. QUILOMETRAGEM DO VEÍCULO (OBRIGATÓRIO)\n", listaNumDados);
                    System.out.println(this.descKm + "\n");
                    System.out.print("Por favor, informe a quilometragem do veículo: ");

                    kmDigitado = limitarCaracteres(scanner.nextLine(), 13);

                    if (kmDigitado.contains(",")) kmDigitado = kmDigitado.replaceAll(",", ".");

                } while (!kmDigitado.matches("^\\d+(\\.\\d{1})?$") ||
                        kmDigitado.isEmpty() || Double.parseDouble(kmDigitado) <= 0f);

                this.quilometragem = Double.parseDouble(kmDigitado);

                System.out.printf("Quilometragem do veículo é: %.1f km\n", this.quilometragem);
            }

            this.condicao = listaCondicao[opcaoEscolhida];
            System.out.println("Condição informada do veículo: " + this.condicao);
            opcaoEscolhida = -1;

            listaNumDados++;
            do {

                if (this.condicao.equals("Novo")) {
                    System.out.printf("\n%d. PLACA DO VEÍCULO\n", listaNumDados);
                } else {
                    System.out.printf("\n%d. PLACA DO VEÍCULO (OBRIGATÓRIO)\n", listaNumDados);
                }
                System.out.println(this.descPlaca + "\n");

                if (this.condicao.equals("Novo")) {
                    System.out.print("Por favor, digite os 6 ou 7 dígitos da placa do veículo.\n" +
                            "Se o veículo ainda não foi emplacado, apenas ignore com a tecla Enter: ");
                } else {
                    System.out.print("Por favor, digite os 6 ou 7 dígitos da placa do veículo: ");
                }

                String placaDigitada;

                placaDigitada = limitarCaracteres(scanner.nextLine(), 7);

                this.placa = placaDigitada.replaceAll("\\s+", "");
                System.out.println("Placa informada do veículo: " + this.placa);

            } while (!this.condicao.equals("Novo") &&
                    (this.placa.length() <6 || this.placa.length() > 7));


            listaNumDados++;
            do {
                System.out.printf("\n%d. DESCRIÇÃO DO VEÍCULO (OBRIGATÓRIO)\n", listaNumDados);
                System.out.println(this.descDescricao + "\n");

                System.out.println("Por favor, escreva uma descrição de características relevantes do veículo: ");

                this.descricao = limitarCaracteres(scanner.nextLine(), 3000);
                System.out.println("Descrição do veículo: " + this.descricao);
            } while (this.descricao.length() < 10);

            listaNumDados++;
            String mascaraPreco;

            do {
                System.out.printf("\n%d. PREÇO DO VEÍCULO (OBRIGATÓRIO)\n", listaNumDados);
                System.out.println(this.descPreco + "\n");
                System.out.print("Por favor, informe o preço do veículo: R$ ");

                mascaraPreco = limitarCaracteres(scanner.nextLine(), 18);

                if (mascaraPreco.contains(",")) {
                    mascaraPreco = mascaraPreco.replaceAll(",", ".");
                }


            } while (!mascaraPreco.matches("^\\d+(\\.\\d{2})?$") || mascaraPreco.isEmpty());

            this.preco = new BigDecimal (mascaraPreco);
            System.out.println("Preço informado do veículo: " + mascaraReais.format(Double.parseDouble(mascaraPreco)));

            do {

                System.out.println("\nObrigado! Agora confirme, por favor, " +
                        "se todos os dados foram informados corretamente: ");

                System.out.println("\n----------------- Veículo: -----------------------\n");
                listarInfoVeiculo();

                System.out.println("O que você deseja fazer?\n");

                for (int i = 0; i < opcoesCadastro.length; i++) {

                    System.out.println((i + 1) + " - " + opcoesCadastro[i]);

                }

                System.out.println("\nEscolha uma das opções acima: ");

                mascaraIndice = scanner.nextLine();
                if(mascaraIndice.matches("\\d+")) opcaoEscolhida= Integer.parseInt(mascaraIndice);
                //scanner.nextLine();

            } while (opcaoEscolhida < 1 || opcaoEscolhida > opcoesCadastro.length);

            if (opcaoEscolhida == 1) {

                VeiculoController veiculo = new VeiculoController();

                veiculo.cadastrarVeiculo(this);

                if (veiculo.getSucessoCadastro()) {
                    System.out.printf("\n***Cadastro de %s, %s, %s, %s, %s realizado com sucesso!***\n",
                            this.categoria, this.marca, this.modelo, this.anoFabric, this.cor);

                    veiculo.consultarVeiculo();
                }

            } else if (opcaoEscolhida == 3) {

                System.out.printf("\nCadastro de %s, %s, %s, %s, %s cancelado.",
                        this.categoria, this.marca, this.modelo, this.anoFabric, this.cor);

            }

        } while (opcaoEscolhida == 2);

    }


    public void listarInfoVeiculo(){

        System.out.println("Categoria: " + this.categoria);
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Ano: " + this.anoFabric);
        System.out.println("Placa: " + this.placa);
        System.out.println("Numeração do chassi: " + this.numerochassi);
        System.out.println("Condição: " + this.condicao);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Preço : " + mascaraReais.format(this.preco));

        System.out.println("\n-------------------------------------------------\n");

    }


    private void filtrarMarca(int tipo){

        switch (tipo){

            case 0:
            case 1:
                this.listaMarca = this.getMarcaMoto();

                break;

            case 2:
                this.listaMarca = this.getMarcaTriciclo();

                break;

            case 3:
                this.listaMarca = this.getMarcaQuadriciclo();

                break;

            case 4: case 5: case 6:
            case 7: case 8: case 9:
            case 10: case 11:
                this.listaMarca = this.getMarcaCarro();

                break;

            case 12:
                this.listaMarca = this.getMarcaCaminhao();
                break;

            case 13:
                this.listaMarca = this.getMarcaOnibus();

                break;

            case 14:
                this.listaMarca = this.getMarcaTrator();

                break;

            default:
                System.out.println("Desculpe, mas valor \"" + tipo + "\" não existe na lista." +
                        "Por favor, escolha uma opção válida de marca de veículo.");
        }

        for (int i = 0; i < listaMarca.length; i++){

            System.out.println(i + " - " + this.listaMarca[i]);

        }

    }

    private String limitarCaracteres(String entrada, int limiteMaximo){

        String linhaLimitada;

        if (entrada.length() <= limiteMaximo){

            linhaLimitada = entrada;
        } else {

            linhaLimitada = entrada.substring(0, limiteMaximo);
        }

        return linhaLimitada;
    }

}
