package model;

public class Produto {
	private int codigoProduto;
	private String nomeProduto;
	private float valorProduto;
	private String descricaoProduto;
	private int descontoProduto;
	private float valorAposDescontoProduto;
	
	public Produto() {
		this.nomeProduto = "";
		this.descricaoProduto = "";
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public float getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public int getDescontoProduto() {
		return descontoProduto;
	}

	public void setDescontoProduto(int descontoProduto) {
		this.descontoProduto = descontoProduto;
	}

	public float getValorAposDescontoProduto() {
		return valorAposDescontoProduto;
	}

	public void setValorAposDescontoProduto() {
		float valorAposDescontoProduto = valorProduto - (valorProduto * descontoProduto) / 100;
		if(valorAposDescontoProduto < 0) {
			this.valorAposDescontoProduto = 0;
		}
		else {
			this.valorAposDescontoProduto = valorAposDescontoProduto;
			
		}
	}
}
