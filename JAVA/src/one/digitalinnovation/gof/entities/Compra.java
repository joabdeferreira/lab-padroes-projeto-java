package one.digitalinnovation.gof.entities;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Compra implements Transacao{
	private Long id;
	private double valor;
	private LocalDate data;
	private final Long idCliente;
	private int quant;
	private String ticker;
	
	public Compra(Cliente cliente, String ticker, double precoUnit, int quant, LocalDate data, Long id) {
		this.id = id;
		this.idCliente = cliente.getId();	
		this.quant = quant;
		this.ticker = ticker;
		this.valor = (quant * precoUnit) * -1;
		this.data = data;
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

	public LocalDate getData() {
		return this.data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}


	@Override
	public String tipoTransacao() {
		return "COMPRA";
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
		return("ID: "+this.id+ " | "+tipoTransacao()+" | TICKER: " + this.ticker + " | PRECO: " + (this.valor / this.quant) + " | QUANT: " + this.quant + " | TOTAL: R$" + df.format(this.valor) + " | DATA: " + this.data );
	}

	/**
	 * @return the quant
	 */
	public int getQuant() {
		return quant;
	}

	/**
	 * @param quant the quant to set
	 */
	public void setQuant(int quant) {
		this.quant = quant;
	}

	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return ticker;
	}

	/**
	 * @param ticker the ticker to set
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	

}
