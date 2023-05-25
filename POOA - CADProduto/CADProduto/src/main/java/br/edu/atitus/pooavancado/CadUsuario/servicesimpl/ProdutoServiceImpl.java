package br.edu.atitus.pooavancado.CadUsuario.servicesimpl;

import br.edu.atitus.pooavancado.CadUsuario.entities.Produto;
import br.edu.atitus.pooavancado.CadUsuario.repositories.ProdutoRepository;
import br.edu.atitus.pooavancado.CadUsuario.services.ProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        super();
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoRepository getRepository() {
        return produtoRepository;
    }

    @Override
    public void alteraValorUnitario(long id, double valor) throws Exception {
        if (!produtoRepository.existsById(id))
            throw new Exception("Não existe produto com o Id: " + id);
        Produto produto = produtoRepository.findById(id);
        produto.setValorUnitario(valor);
        produtoRepository.save(produto);

    }
}
