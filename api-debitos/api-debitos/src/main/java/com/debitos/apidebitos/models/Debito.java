package com.debitos.apidebitos.models;

import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;
import java.util.List;

@Entity
@Table(name = "Debito")


public class Debito implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)

	private long id;

	private Date dataLancamento;

	private String cpf;

	private String nome;

	@OneToMany(mappedBy = "debito",cascade = CascadeType.PERSIST,targetEntity = DebitoParcela.class)
	private List<DebitoParcela> parcela =  new ArrayList<DebitoParcela>();


	public List<DebitoParcela> getParcela() {
		return parcela;
	}

	public void setParcela(List<DebitoParcela> parcela) {
		this.parcela = parcela;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Debito [id=" + id + ", dataLancamento=" + dataLancamento + ", cpf=" + cpf + ", nome=" + nome
				+ ", DebitoParcela=" + parcela.toString() + "]";
	}

}
