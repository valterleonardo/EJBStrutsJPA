<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Listagem de Estoque</title>
  </head>
  <body>
<jsp:include page="/jsp/navigation.jsp"></jsp:include>
      <TABLE border="1">
        <tr>
          <td>
            id
          </td>
          <td>
            produto_id
          </td>
          <td>
            quantidade
          </td>
        </tr>
        <c:forEach items="${requestScope.estoques}" var="book">
        <tr>
          <td>
            ${estoque.id}
          </td>
          <td>
            ${estoque.idProduto}
          </td>
          <td>
            ${estoque.quantidade}
          </td>
        </tr>
        </c:forEach>
      </TABLE>
  </body>
</html>
