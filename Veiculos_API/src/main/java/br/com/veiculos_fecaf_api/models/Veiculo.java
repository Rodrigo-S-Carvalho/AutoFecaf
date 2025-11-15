package br.com.veiculos_fecaf_api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.persistence.Column;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.yaml.snakeyaml.scanner.Constant;

import java.math.BigDecimal;
import java.time.Year;

@Entity
@Table(name="tb_veiculos")
public class Veiculo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "^[a-zA-Z0-9-#ºª+\\s.,\\\\'\"()áàâãéèêíìîóòôõúùûçÁÀÂÃÉÈÊÍÌÎÓÒÔÕÚÙÛÇ]+$",
            message = "Desculpe, mas a descrição contém caracteres inválidos.")
    @Size(max = 60, message = "Desculpe, mas o limite do texto é de 60 caracteres.")
    @NotBlank(message = "Desculpe, mas categoria precisa ser especificada.")
    @Column(name = "categoria", nullable = false, length = 60)
    private String categoria;

    @Pattern(regexp = "^[a-zA-Z0-9-#ºª+\\s.,\\\\'\"()áàâãéèêíìîóòôõúùûçÁÀÂÃÉÈÊÍÌÎÓÒÔÕÚÙÛÇ]+$",
            message = "Desculpe, mas a descrição contém caracteres inválidos.")
    @Size(max = 60, message = "Desculpe, mas o limite do texto é de 60 caracteres.")
    @NotBlank(message = "Desculpe, mas a marca precisa ser especificada (máximo 60 caracteres).")
    @Column(name = "marca", nullable = false, length = 60)
    private String marca;

    @Pattern(regexp = "^[a-zA-Z0-9-#\\s.,&+°ºª\\\\'\"()áàâãéèêíìîóòôõúùûçÁÀÂÃÉÈÊÍÌÎÓÒÔÕÚÙÛÇ]+$",
            message = "Desculpe, mas a descrição contém caracteres inválidos.")
    @Size(max = 60, message = "Desculpe, mas o limite do texto é de 60 caracteres.")
    @NotBlank(message = "Desculpe, mas você precisa especificar o modelo do veículo (máximo 60 caracteres).")
    @Column(name = "modelo", nullable = false, length = 60)
    private String modelo;

    @Min(value = 1750, message = "Desculpe, mas o ano de fabricação mínimo permitido é 1750.")
    @Max(value = 2100, message = "Desculpe, mas o ano de fabricação não pode ultrapassar 2100.")
    @Column(name = "ano_fabric", nullable = false)
    private int anoFabric;

    @Pattern(regexp = "^[a-zA-Z0-9-#\\s.áàâãéèêíìîóòôõúùûçÁÀÂÃÉÈÊÍÌÎÓÒÔÕÚÙÛÇ]+$",
            message = "Desculpe, mas a descrição contém caracteres inválidos.")
    @Size(max = 20, message = "Desculpe, mas o limite do texto é de 20 caracteres.")
    @NotBlank(message = "Desculpe, mas a cor precisa ser informada (máximo 20 caracteres).")
    @Column(name = "cor_veiculo", nullable = false, length = 20)
    private String cor;

    @Pattern(regexp = "^[a-zA-Z0-9-\\s.,:\\\\'\"+°ºª%#&¹²³()áàâãéèêíìîóòôõúùûçÁÀÂÃÉÈÊÍÌÎÓÒÔÕÚÙÛÇ]+$",
            message = "Desculpe, mas a descrição contém caracteres inválidos.")
    @Size(min = 10, max = 60, message = "Desculpe, mas o limite mínimo do texto é 10 e" +
            "o limite máximo é de 60 caracteres. Por favor, dê uma descrição do tipo de motor.")
    @NotBlank(message = "Desculpe, mas a cor precisa ser informada (máximo 60 caracteres).")
    @Column(name = "motor", nullable = false, length = 60)
    private String motor;

    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @NotBlank(message = "Desculpe, mas a numeração do chassi precisa ser informada, com 17 dígitos.")
    @Size(min = 17, max = 17, message = "Desculpe, mas a numeração do chassi" +
            " deve conter exatamente 17 caracteres (apenas letras e números).")
    @Column(name = "numero_chassi", nullable = false, unique = true, length = 17)
    private String numerochassi;

    //@Pattern(regexp = "^[a-zA-Z0-9-]+$", message = "A placa contém caracteres inválidos. Use apenas letras, números e hífens.")
   // @Size(min = 6, max = 8, message = "A placa deve ter entre 6 e 8 caracteres (incluindo hífen, se aplicável).")
    @Column(name = "placa_veiculo", unique = true, length = 8)
    private String placa;

    @Pattern(regexp = "^[a-zA-Z0-9-\\sáàâãéèêíìîóòôõúùûçÁÀÂÃÉÈÊÍÌÎÓÒÔÕÚÙÛÇ]+$",
            message = "Desculpe, mas a descrição contém caracteres inválidos.")
    @Size(max = 20, message = "Desculpe, mas o limite do texto é de 20 caracteres.")
    @NotBlank(message = "Desculpe, mas a cor precisa ser informada (máximo 20 caracteres).")
    @Column(name = "condicao_veiculo", nullable = false)
    private String condicao;

    @Pattern(regexp = "^[a-zA-Z0-9-\\s.,!?'\"ºª°;:+/\\\\@#%*&$=¹²³()áàâãéèêíìîóòôõúùûçÁÀÂÃÉÈÊÍÌÎÓÒÔÕÚÙÛÇ]+$",
            message = "Desculpe, mas a descrição contém caracteres inválidos.")
    @NotBlank(message = "Desculpe, mas a cor precisa ser informada (máximo 60 caracteres).")
    @Size(min = 10, max = 3000, message = "Desculpe, mas a descrição deve conter " +
            "no mínimo 10 e no máximo 3000 caracteres.")
    @Column(name = "descricao_veiculo", nullable = false, unique = true)
    private String descricao;

    @Pattern(regexp = "^[a-zA-Z\\sáàâãéèêíìîóòôõúùûçÁÀÂÃÉÈÊÍÌÎÓÒÔÕÚÙÛÇ]+$",
            message = "Desculpe, mas a descrição contém caracteres inválidos.")
    @NotBlank(message = "Desculpe, mas a cor precisa ser informada (máximo 20 caracteres).")
    @Size(min = 5, max = 20, message = "Desculpe, mas a descrição deve conter " +
            "no mínimo 5 e no máximo 20 caracteres.")
    @Column(name = "disponibilidade_veiculo", nullable = false)
    private String disponibilidade;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0.0")
    @Min(value = 0, message = "Desculpe, mas a quilometragem deve ser um valor positivo.")
    @Column(name = "quilometragem", nullable = false)
    private double quilometragem;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0.0")
    @Min(value = 0, message = "Desculpe, mas o preço deve ser um valor positivo.")
    @Column(name = "preco_veiculo", nullable = false)
    private BigDecimal preco;

    public Integer getId(){ return id; }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabric() { return anoFabric; }

    public String getCor() {
        return cor;
    }

    public String getMotor() {
        return motor;
    }

    public String getNumerochassi() {
        return numerochassi;
    }

    public String getPlaca() { return placa; }

    public String getCondicao() {
        return condicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDisponibilidade(){ return disponibilidade; }

    public double getQuilometragem() { return quilometragem; }

    public BigDecimal getPreco() {
        return preco;
    }


    public void setId(Integer id) { this.id = id; }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoFabric(int anoFabric) { this.anoFabric = anoFabric; }

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

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public void setDisponibilidade(String disponibilidade) { this.disponibilidade = disponibilidade; }

    public void setQuilometragem(double quilometragem) { this.quilometragem = quilometragem; }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }


    /*public void cadastroVeiculo(VeiculoRequestDTO dto) {

        this.categoria = dto.categoria();
        this.marca = dto.marca();
        this.modelo = dto.modelo();
        this.anoFabric = dto.anoFabric();
        this.cor = dto.cor();
        this.motor = dto.motor();
        this.numerochassi = dto.numerochassi();
        this.placa = dto.placa();
        this.condicao = dto.condicao();
        this.descricao = dto.descricao();
        this.quilometragem = dto.quilometragem();
        this.preco = dto.preco();
        this.disponibilidade = dto.disponibilidade();
    } */

}
