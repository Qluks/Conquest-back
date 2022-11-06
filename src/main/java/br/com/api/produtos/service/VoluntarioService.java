package br.com.api.produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.model.RespostaModel;
import br.com.api.produtos.model.VoluntarioModel;
import br.com.api.produtos.repository.VoluntarioRepository;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository pr;

    @Autowired
    private RespostaModel rm;

    // Método para listar todos os produtos
    public Iterable<VoluntarioModel> listar() {
        return pr.findAll();
    }

    // Método para cadastrar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(VoluntarioModel pm, String acao) {

        if (pm.getTitulov().equals("")) {
            rm.setMensagem("O Título é obrigatório!!");
            return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getDescricaov().equals("")) {
            rm.setMensagem("A descrição é obrigatória!!");
            return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<VoluntarioModel>(pr.save(pm), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<VoluntarioModel>(pr.save(pm), HttpStatus.OK);
            }
        }
    }

    // Método para remover produtos
    public ResponseEntity<RespostaModel> remover(long id) {
        pr.deleteById(id);

        rm.setMensagem("A conquista foi removida com sucesso!!");
        return new ResponseEntity<RespostaModel>(rm, HttpStatus.OK);
    }
}
