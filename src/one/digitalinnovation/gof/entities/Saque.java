package one.digitalinnovation.gof.entities;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Saque implements Transacao{
	private Long id;
	private double valor;
	private LocalDate data;
	private final Long idCliente;
	private String ticker;
	private int quant;
	
	/**
	 * @return the quant
	 */
	public int getQuant() {
		return quant;
	}

	public Saque(Cliente cliente, double valor, LocalDate data, Long id) {
		this.id = id;
		this.idCliente = cliente.getId();	
		this.valor = valor;
		this.data = data;
		this.ticker = "";
		this.quant = 1;
	}

	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return ticker;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public LocalDate getData() {
		return this.data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}


	@Override
	public String tipoTransacao() {
		return "SAQUE";
	}

	/**
	 * @return the idCliente
	 */
	public Long getIdCliente() {
		return idCliente;
	}

	@Override
	public double calcularSaldo() {
		return 0;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("####.00");
		return("ID: "+this.id+ " | "+tipoTransacao()+" | VALOR: R$" + df.format(this.valor) + " | DATA: " + this.data );
	}
	

}
