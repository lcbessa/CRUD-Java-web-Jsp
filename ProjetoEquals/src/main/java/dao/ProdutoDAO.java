package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import model.Produto;

public class ProdutoDAO {
	
	public static Connection getConnection() {
		Connection conexao = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/ESTOQUE?enabledTLSProtocols=TLSv1.2","root","123456789");
		} catch (Exception e) {
			System.out.println(conexao);
			System.out.print(e);
		}
		return conexao; 
	}
	public static Produto getProdutoById(int codigoProduto) {
		Produto produto = null;
		try {
			Connection conexao = getConnection();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("SELECT * FROM PRODUTO WHERE codigoProduto=?");
			ps.setInt(1, codigoProduto);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				produto = new Produto();
				produto.setCodigoProduto(rs.getInt("codigoProduto"));
				produto.setNomeProduto(rs.getString("nomeProduto"));
				produto.setValorProduto(rs.getFloat("valorProduto"));
				produto.setDescricaoProduto(rs.getString("descricaoProduto"));
				produto.setDescontoProduto(rs.getInt("descontoProduto"));
				produto.setValorAposDescontoProduto();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return produto;
		
	}
	
	public static int updateProduto(Produto p) {
		int status = 0;
		try {
			p.setValorAposDescontoProduto();
			Connection conexao = getConnection();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("UPDATE PRODUTO SET nomeProduto=?,"
					+ "valorProduto=?, descricaoProduto=?, descontoProduto=?, valorAposDescontoProduto=? WHERE codigoProduto=?");
			ps.setString(1, p.getNomeProduto());
			ps.setFloat(2, p.getValorProduto());
			ps.setString(3, p.getDescricaoProduto());
			ps.setInt(4, p.getDescontoProduto());
			ps.setFloat(5, p.getValorAposDescontoProduto());
			ps.setInt(6, p.getCodigoProduto());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int insertProduto(Produto p) {
		int status = 0;
		try {
			p.setValorAposDescontoProduto();
			Connection conexao = getConnection();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("INSERT INTO PRODUTO (nomeProduto,valorProduto,"
					+ "descricaoProduto,descontoProduto,valorAposDescontoProduto) VALUES (?,?,?,?,?)");
			ps.setString(1, p.getNomeProduto());
			ps.setFloat(2, p.getValorProduto());
			ps.setString(3, p.getDescricaoProduto());
			ps.setInt(4, p.getDescontoProduto());
			ps.setFloat(5, p.getValorAposDescontoProduto());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	public static List<Produto> getAllProdutos(){
		List<Produto> list =  new ArrayList<Produto>();
		try {
			Connection conexao = getConnection();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("SELECT * FROM PRODUTO");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setCodigoProduto(rs.getInt("codigoProduto"));
				produto.setNomeProduto(rs.getString("nomeProduto"));
				produto.setValorProduto(rs.getFloat("valorProduto"));
				produto.setDescricaoProduto(rs.getString("descricaoProduto"));
				produto.setDescontoProduto(rs.getInt("descontoProduto"));
				produto.setValorAposDescontoProduto();
				list.add(produto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	public static int deleteProduto(Produto p) {
		int status = 0;
		try {
			Connection conexao = getConnection();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("DELETE FROM PRODUTO WHERE codigoProduto=?");
			ps.setInt(1, p.getCodigoProduto());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;		
	}
}

