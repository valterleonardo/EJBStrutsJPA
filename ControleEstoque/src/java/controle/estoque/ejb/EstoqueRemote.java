package controle.estoque.ejb;

import controle.estoque.modelo.Estoque;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface EstoqueRemote {
    public Estoque salvar(Estoque estoque) throws Exception;
    public List<Estoque> listar() throws Exception;
}
