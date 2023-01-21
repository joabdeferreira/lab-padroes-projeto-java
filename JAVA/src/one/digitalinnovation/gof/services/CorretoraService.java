package one.digitalinnovation.gof.services;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import one.digitalinnovation.gof.entities.*;

public class CorretoraService{
	
	private List<Cliente> clientes;
	private int contadorTransacoes;
	
	// Bloco de código necessário para garantir o Singleton (unica instancia dessa classe)
	private static class corretora{
		public static CorretoraService instancia = new CorretoraService();
	}
	private CorretoraService() {
		super();
	}
	public static synchronized CorretoraService getInstancia() {
		return corretora.instancia;
	}
	// Fim do bloco de código do Singleton
	
	public void adicionarCliente(String nome, String cpf) {
		if (this.clientes == null) {
			this.clientes = new ArrayList<Cliente>();
			this.adicionarCliente(nome, cpf);
		}
		else {
			if (clientes.isEmpty()) {
				Cliente cliente =  new Cliente(1L, nome, cpf);
				clientes.add(cliente);
			}
			else {
				Cliente cliente =  new Cliente(Long.valueOf(clientes.size()+1) , nome, cpf);
				clientes.add(cliente);	
			}
			
		}

		
	}

	public void listarClientes() {
		if (clientes == null || clientes.isEmpty()) {
			System.out.println("NAO HA CLIENTES CADASTRADOS!");
		}
		else {
			clientes.forEach(cliente -> System.out.println(cliente.toString()));
		}
	}
	
	public Cliente getClientesById(Long id) {
		return clientes.get(Math.toIntExact(id-1));
	}		
	
	
	//Implementação de Strategy (cada tipo de Transacao possui variações)
 	public void adicionarTransacao(Cliente cliente, double valor, LocalDate data, String ticker, int quant){
 		if (ticker == "") {
 			
 			if (quant != 1) System.out.println("OPERACAO SEM TICKER / SERA TRATADA COMO SAQUE/DEPOSITO / QUANTIDADE IGNORADA");
 			
 			if (valor > 0) {
 				contadorTransacoes++;
 				Transacao transacao = new Deposito(cliente, valor, data, Long.valueOf(contadorTransacoes));
 				cliente.getTransacoes().add(transacao);
 				cliente.getTransacoes().sort(Comparator.comparing(Transacao::getData));
 			}
 			if(valor < 0){
 				List<Transacao> teste = cliente.getTransacoes();
 				Transacao transacao = new Saque(cliente, valor, data, Long.valueOf(contadorTransacoes+1));
 				cliente.getTransacoes().sort(Comparator.comparing(Transacao::getData));
 				if (validarTransacao(teste, transacao)){
 					contadorTransacoes++;	
 				}
 				else {
 					teste.remove(transacao);
 					System.out.println("O SALDO NAO PODE FICAR NEGATIVO EM NENHUM MOMENTO!!!");
 				}
 			}
 			
 		}
 		else {
			AcaoService auditor = new AcaoService();
 			if (quant == 0)  System.out.println("A QUANTIDADE NÃO PODE SER ZERO (0)");
 			if (quant > 0) {
 				//public Compra(Cliente cliente, String ticker, double precoUnit, int quant, LocalDate data, Long id)
 				List<Transacao> teste = cliente.getTransacoes();
 				Transacao transacao = new Compra(cliente, ticker, valor, quant, data, Long.valueOf(contadorTransacoes+1));
 				if ((validarTransacao(teste, transacao))&&(auditor.existeAcao(transacao))){
 					contadorTransacoes++;
 					teste.add(transacao);
 					teste.sort(Comparator.comparing(Transacao::getData));
 					cliente.setTransacoes(teste);
 				}
 				else {
 					teste.remove(transacao);
 					System.out.println("O SALDO NAO PODE FICAR NEGATIVO EM NENHUM MOMENTO!!!");
 				}
 			}
 			if (quant < 0) {
 				Transacao transacao = new Venda(cliente, ticker, valor, quant, data, Long.valueOf(contadorTransacoes+1));

 				if ((auditor.validaVenda(cliente.getTransacoes(), transacao))&&(auditor.existeAcao(transacao))){
 					contadorTransacoes++;
 					cliente.getTransacoes().add(transacao);
 					cliente.getTransacoes().sort(Comparator.comparing(Transacao::getData));
 				}
 				else {
 					System.out.println("QUANTIDADE EM VENDA MAIOR QUE EM CUSTODIADA / OPERACAO NEGADA!!!");
 				}
 			}
 		}
		
	}
 	
 	
 	public boolean validarTransacao(List<Transacao> teste, Transacao transacao) {
 		teste.add(transacao);
		teste.sort(Comparator.comparing(Transacao::getData));
		double saldo = 0;
		for (Transacao t: teste) {
			saldo += t.getValor();
			if (saldo < 0) {
				return false;
			}
		}
		if (transacao.getValor()==0) {
			return false;
		}
		else {
			return true;
		}
 	}
	/**
	 * @return the contadorTransacoes
	 */
	public int getContadorTransacoes() {
		return contadorTransacoes;
	}
	
	
	public double calcularPatrimonio(Cliente cliente) {
		List<Transacao> transacoes = cliente.getTransacoes();
		double patrimonio = 0;
		for (Transacao teste: transacoes) {
			patrimonio += teste.getValor();
		}
		System.out.println(patrimonio);
		return patrimonio;
	}
	
	
}