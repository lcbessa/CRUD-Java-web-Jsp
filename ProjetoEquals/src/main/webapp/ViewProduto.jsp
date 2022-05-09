
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projeto Equals</title>
</head>
<body>
	<%@ page import="dao.ProdutoDAO,model.Produto, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<h1>Listagem de Produtos</h1>
	
	<%List<Produto> list = ProdutoDAO.getAllProdutos();
	request.setAttribute("list", list);
	%>
	
	<table border="1" >
		<tr>
			<th>Codigo do Produto</th>
			<th>Nome</th>
			<th>Valor</th>
			<th>Descrição</th>	
			<th>Desconto</th>
			<th>Valor com Desconto</th>
			<th>Editar</th>
			<th>Excluir</th>
			
		</tr> 
			<c:forEach items="${list}" var="produto">
				<tr>
					<td>${produto.getCodigoProduto()}</td>
					<td>${produto.getNomeProduto()}</td>
					<td>R$ ${produto.getValorProduto()}</td>
					<td>${produto.getDescricaoProduto()}</td>
					<td>${produto.getDescontoProduto()} %</td>
					<td>R$ ${produto.getValorAposDescontoProduto()}</td>
					<td><a href="EditarProduto.jsp?codigoProduto=${produto.getCodigoProduto()}"><button>Editar Produto</button></a> </td>
					<td><a href="ExcluirProduto.jsp?codigoProduto=${produto.getCodigoProduto()}"><button>Excluir Produto</button></a></td>					
				</tr>
			</c:forEach>
				
	</table>
	<br>
	<a href="EditarProduto.jsp"><button>Adicionar novo Produto</button></a>
</body>
</html>