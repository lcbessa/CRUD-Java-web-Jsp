<%@ page import="dao.ProdutoDAO"%>
<jsp:useBean id="p" class="model.Produto"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>


<%
	ProdutoDAO.deleteProduto(p);
	response.sendRedirect("ViewProduto.jsp");
%>