package br.com.veiculos_fecaf_api.services;

import br.com.veiculos_fecaf_api.models.Veiculo;
import br.com.veiculos_fecaf_api.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculorepository;

    // LISTAR  O BANCO INTEIRO (RECONSIDERAR SE VOLUME DE DADOS FOR MUITO GRANDE)
    public List<Veiculo> listarVeiculos(){

        return veiculorepository.findAll();
    }
    // CADASTRAR
    public Veiculo salvar(Veiculo veiculo) {
        //return veiculorepository.save(veiculo);
        return validarPlaca(veiculo);
    }

    // ATUALIZAR
    public Veiculo atualizar(Integer id, Veiculo novosDados) {

        Veiculo original =
                veiculorepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Veículo não encontrado!"));

        // Copia cada campo
        original.setCategoria(novosDados.getCategoria());
        original.setMarca(novosDados.getMarca());
        original.setModelo(novosDados.getModelo());
        original.setAnoFabric(novosDados.getAnoFabric());
        original.setCor(novosDados.getCor());
        original.setMotor(novosDados.getMotor());
        original.setNumerochassi(novosDados.getNumerochassi());
        original.setPlaca(novosDados.getPlaca());
        original.setCondicao(novosDados.getCondicao());
        original.setDescricao(novosDados.getDescricao());
        original.setDisponibilidade(novosDados.getDisponibilidade());
        original.setQuilometragem(novosDados.getQuilometragem());
        original.setPreco(novosDados.getPreco());

        //return veiculorepository.save(veiculo)
        return validarPlaca(original);
    }

    private Veiculo validarPlaca(Veiculo veiculo){

        if (!"Novo".equals(veiculo.getCondicao()) && !StringUtils.hasText(veiculo.getPlaca())){

            throw new IllegalArgumentException("Desculpe, mas a placa é " +
                    "obrigatória para veículos Seminovo ou Usado.");

        } else {

            return veiculorepository.save(veiculo);
        }
    }

}
