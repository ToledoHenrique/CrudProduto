package br.edu.atitus.pooavancado.CadUsuario.repositories;

import br.edu.atitus.pooavancado.CadUsuario.entities.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends GenericRepository<Produto> {
    Produto findById(long id);
}
