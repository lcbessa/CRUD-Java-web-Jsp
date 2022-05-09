<%@ page import="dao.ProdutoDAO"%>
<jsp:useBean id="p" class="model.Produto"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
int status = 0; 
if(p.getCodigoProduto() == 0) {
	ProdutoDAO.insertProduto(p);
} else {
	ProdutoDAO.updateProduto(p);
}
response.sendRedirect("ViewProduto.jsp");
%>