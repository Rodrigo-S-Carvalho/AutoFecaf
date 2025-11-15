package br.com.veiculos_fecaf_api.controllers;

import br.com.veiculos_fecaf_api.models.Veiculo;
import br.com.veiculos_fecaf_api.repository.VeiculoRepository;
import br.com.veiculos_fecaf_api.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500", allowedHeaders = "*")
@RestController
@RequestMapping("api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoservice;



    // LISTAR
    @GetMapping("/listarveiculos")
    public List<Veiculo> listarVeiculos(){
        return veiculoservice.listarVeiculos();
    }

    // CADASTRAR
    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return veiculoservice.salvar(veiculo);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Veiculo atualizar(@PathVariable Integer id, @RequestBody Veiculo dadosAtualizados) {
        return veiculoservice.atualizar(id, dadosAtualizados);
    }

}
