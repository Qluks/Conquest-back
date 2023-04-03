package br.com.api.produtos.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

import br.com.api.produtos.model.HobbiesModel;
import br.com.api.produtos.model.RespostaModel;
import br.com.api.produtos.service.HobbiesService;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "API REST Conquest")
public class HobbiesController {

    @Autowired
    private HobbiesService ps;

    @ApiOperation(value = "Remove um Hobbie já registrado")
    @DeleteMapping("/remover/hobbies/{id}")
    public ResponseEntity<RespostaModel> remover(@PathVariable long id) {
        return ps.remover(id);
    }

    @ApiOperation(value = "Altera um Hobbie já registrado")
    @PutMapping("/alterar/hobbies")
    public ResponseEntity<?> alterar(@RequestBody HobbiesModel pm) {
        return ps.cadastrarAlterar(pm, "alterar");
    }

    @ApiOperation(value = "Registra um Hobbie novo")
    @PostMapping("/cadastrar/hobbies")
    public ResponseEntity<?> cadastrar(@RequestBody HobbiesModel pm) {
        return ps.cadastrarAlterar(pm, "cadastrar");
    }

    @ApiOperation(value = "Lista todos os Hobbies existentes")
    @GetMapping("/listar/hobbies")
    public Iterable<HobbiesModel> listar() {
        return ps.listar();
    }
}
