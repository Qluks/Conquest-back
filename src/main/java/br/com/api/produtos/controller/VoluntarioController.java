package br.com.api.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.model.RespostaModel;
import br.com.api.produtos.model.VoluntarioModel;
import br.com.api.produtos.service.VoluntarioService;

@RestController
@CrossOrigin(origins = "*")
public class VoluntarioController {

    @Autowired
    private VoluntarioService ps;

    @DeleteMapping("/remover/voluntario/{id}")
    public ResponseEntity<RespostaModel> remover(@PathVariable long id) {
        return ps.remover(id);
    }

    @PutMapping("/alterar/voluntario")
    public ResponseEntity<?> alterar(@RequestBody VoluntarioModel pm) {
        return ps.cadastrarAlterar(pm, "alterar");
    }

    @PostMapping("/cadastrar/voluntario")
    public ResponseEntity<?> cadastrar(@RequestBody VoluntarioModel pm) {
        return ps.cadastrarAlterar(pm, "cadastrar");
    }

    @GetMapping("/listar/voluntario")
    public Iterable<VoluntarioModel> listar() {
        return ps.listar();
    }
}
