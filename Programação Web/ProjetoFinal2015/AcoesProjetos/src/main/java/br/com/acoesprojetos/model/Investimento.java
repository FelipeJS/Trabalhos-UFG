package br.com.acoesprojetos.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_investimento")
@NamedQueries({
		@NamedQuery(name = "Investimento.listarporAcao", query = "SELECT i FROM Investimento i WHERE i.acao = :acao_id "),
		@NamedQuery(name = "Investimento.buscarPorCodigo", query = "SELECT investimento FROM Investimento investimento WHERE investimento.id = :id") })
public class Investimento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "inv_aco_id", referencedColumnName = "aco_id")
	private Acao acao;

	@Column(name = "inv_data")
	@Temporal(value = TemporalType.DATE)
	private Date data;

	@Column(name = "inv_quantidade", nullable = false)
	private Integer quantidade;

	@Column(name = "inv_valor", nullable = false, precision = 15, scale = 2)
	private double valor;

	@Column(name = "inv_custo", precision = 15, scale = 2)
	private double custos;

	@Column(name = "inv_total", nullable = false, precision = 15, scale = 2)
	private double total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getCustos() {
		return custos;
	}

	public void setCustos(double custos) {
		this.custos = custos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Investimento [id=" + id + ", acao=" + acao + ", data=" + data
				+ ", quantidade=" + quantidade + ", valor=" + valor
				+ ", custos=" + custos + ", total=" + total + "]";
	}

}
