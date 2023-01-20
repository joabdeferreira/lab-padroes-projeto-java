package one.digitalinnovation.gof.entities;

import java.time.LocalDate;
//import java.util.List;

public interface Transacao {
	
	double getValor();
	String getTicker();
	int getQuant();
	double calcularSaldo();
	//double calcularPatrimonio();
	//double calcularAtivos();
	String tipoTransacao();
	Long getId();
	LocalDate getData();

}
