package br.com.acoesprojetos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_acao")
@NamedQueries({
		@NamedQuery(name = "Acao.listar", query = "SELECT acao FROM Acao acao"),
		@NamedQuery(name = "Acao.buscarPorCodigo", query = "SELECT acao FROM Acao acao WHERE acao.id = :id")
		})
public class Acao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "aco_id")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "aco_usr_id", referencedColumnName = "usr_id")
	private Usuario usuario;

	@Column(name = "aco_nome", length = 60, nullable = false)
	private String nome;

	@Column(name = "aco_descricao")
	private String descricao;

	@Column(name = "aco_quantidade")
	private int quantidade;

	@Column(name = "aco_preco", precision = 15, scale = 2)
	private Double preco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void somaPreco(Double preco) {
		this.preco += preco;
	}

	public void subtraiPreco(Double preco) {
		this.preco -= preco;
	}

	public void somaQuantidade(int quantidade) {
		this.quantidade += quantidade;
	}

	public void subtraiQuantidade(int quantidade) {
		this.quantidade -= quantidade;
	}

	@Override
	public String toString() {
		return "Acao [id=" + id + ", usuario=" + usuario + ", nome=" + nome
				+ ", descricao=" + descricao + ", quantidade=" + quantidade
				+ ", preco=" + preco + "]";
	}

}
