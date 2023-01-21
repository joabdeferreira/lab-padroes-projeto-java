package one.digitalinnovation.gof.entities;

import java.util.List;
import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;

public class Cliente /* implements Comparable<Transacao>*/{
	
	private Long id;
	private String nome;
	private String cpf;
	private List<Transacao> transacoes;
	
	
	public Cliente (Long id, String nome, String cpf) {
		this.id = id;
		this.cpf = cpf;
		this.nome =  nome.toUpperCase();
		this.transacoes = new ArrayList<Transacao>();
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return("ID: " + this.id +
				" | NOME: " + this.nome + 
				"| CPF: " + this.cpf);
	}



	/**
	 * @return the transacoes
	 */
	public List<Transacao> getTransacoes() {
		return transacoes;
	}


	/**
	 * @param transacoes the transacoes to set
	 */
	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}


	public void listarTransacoes() {
		System.out.println("\n\nID: " + this.id + " / NOME: " + this.nome + " / CPF: "+ this.cpf);
		System.out.println("-----------------------------------------------------------");
		for (Transacao transacao: transacoes) {
			System.out.println(transacao.toString());
		}
	}

	





}
