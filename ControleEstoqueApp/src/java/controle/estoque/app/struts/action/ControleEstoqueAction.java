package controle.estoque.app.struts.action;

import controle.estoque.ejb.EstoqueRemote;
import controle.estoque.modelo.Estoque;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ControleEstoqueAction extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
        EstoqueRemote estoque = null;
        List<Estoque> listEstoque = null;
        try
        {
            Context context = new InitialContext();
            estoque = (EstoqueRemote) context.lookup("controle.estoque.ejb.EstoqueRemote");
        } catch (NamingException e)
        {
            e.printStackTrace();
            throw new RuntimeException("error accessing EJB");

        }
        listEstoque = estoque.listar();
        request.setAttribute("listEstoque", listEstoque);
        return mapping.findForward("success");
    }
    
}
