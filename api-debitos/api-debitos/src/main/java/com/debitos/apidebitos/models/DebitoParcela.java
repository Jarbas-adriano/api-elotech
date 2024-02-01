package com.debitos.apidebitos.models;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;

import java.io.Serializable;
import java.util.Date;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="DebitoParcela")
public class DebitoParcela implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private long id;
	
	private long numero;
	
	@FutureOrPresent(message = "A data de Vencimento deve ser superior ou igual a data atual")
	private Date dataVencimento;
	
	@Min(message = "O valor deve ser maior do que 0", value = 1)
	private double valor;	
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Debito.class)
    @JoinColumn(name = "debito_id",referencedColumnName = "id", nullable = false)
	private Debito debito;
	
    public long getId() {
		return id;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public Debito getDebito() {
		return debito;
	}

	public void setDebito(Debito debito) {
		this.debito = debito;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "DebitoParcela [id=" + id + ", numero=" + numero + ", dataVencimento=" + dataVencimento + ", valor="
				+ valor + ", debito=" + debito + "]";
	}
	

	
}
