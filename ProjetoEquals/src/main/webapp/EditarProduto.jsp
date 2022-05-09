<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projeto Equals</title>
</head>
<body>
	<%@page import="dao.ProdutoDAO,model.Produto" %>
	<%
		String codigo = request.getParameter("codigoProduto");
		Produto produto = new Produto();
		if(codigo != null) {
			produto = ProdutoDAO.getProdutoById(Integer.parseInt(codigo));
		}
	%>
	1<h1><%out.print(codigo == null ?"Cadastro do Produto":"Edição do Produto");%></h1>
	<form action="RedirecionarViewProduto.jsp" method="post">
	<input type="hidden" name="codigoProduto" value="<%=produto.getCodigoProduto()%>"/>
		<table>
			<tr>
				<td>Nome: </td>
				<td><input type="text" name="nomeProduto" value="<%=produto.getNomeProduto()%>"/></td>
			</tr>
			<tr>
				<td>Valor: </td>
				<td><input type="number" name="valorProduto" value="<%=produto.getValorProduto()%>"/></td>
			</tr>
			<tr>
				<td>Descrição: </td>
				<td><input type="text" name="descricaoProduto" value="<%=produto.getDescricaoProduto()%>"/></td>
			</tr>
			<tr>
				<td>Desconto: </td>
				<td><input type="number" name="descontoProduto" value="<%=produto.getDescontoProduto()%>"/></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="<%out.print(codigo == null ?"Cadastrar Produto":"Editar Produto");%>" /> </td>
			</tr>
		</table>
	</form>
</body>
</html>