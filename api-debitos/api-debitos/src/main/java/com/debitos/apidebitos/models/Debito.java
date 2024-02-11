package com.debitos.apidebitos.models;

import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.br.CPF;

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
    
	@PastOrPresent(message = "A data de Lançamento deve ser menor ou igual a data atual")
	private Date dataLancamento;

	@CPF(message = "Informe um CPF Válido")
	private String cpf;

	private String nome;

	@Valid
	@OneToMany(mappedBy = "debito",cascade = CascadeType.ALL,targetEntity = DebitoParcela.class,orphanRemoval = true)
	@NotEmpty(message = "O Débito deve conter ao menos uma parcela")
	private List<DebitoParcela> parcela =  new ArrayList<DebitoParcela>();


	public List<DebitoParcela> getParcela() {
		 if (parcela == null) {
			 parcela = new ArrayList();
	      }
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
