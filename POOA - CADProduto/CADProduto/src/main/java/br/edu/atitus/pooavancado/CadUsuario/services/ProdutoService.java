package br.edu.atitus.pooavancado.CadUsuario.services;

import br.edu.atitus.pooavancado.CadUsuario.entities.Produto;
import br.edu.atitus.pooavancado.CadUsuario.repositories.ProdutoRepository;
import org.springframework.data.repository.query.Param;

public interface ProdutoService extends GenericService<Produto, ProdutoRepository>{

    void alteraValorUnitario(@Param("id") long id, double valor) throws Exception;
}
