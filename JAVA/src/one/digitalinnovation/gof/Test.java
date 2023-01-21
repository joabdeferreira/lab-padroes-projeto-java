package one.digitalinnovation.gof;

import java.time.LocalDate;

import one.digitalinnovation.gof.services.CorretoraService;

public class Test {

	public static void main(String[] args) {
		
		CorretoraService broker = CorretoraService.getInstancia();
		broker.adicionarCliente("Jose da Silva Santos", "00010300244");
		broker.adicionarCliente("Maria Souza Pereira", "00100200304");
		//broker.listarClientes();
		
		broker.adicionarTransacao(broker.getClientesById(1L), 1000D, LocalDate.of(2021, 01, 02), "", 1);
		broker.adicionarTransacao(broker.getClientesById(1L), -500D, LocalDate.of(2022, 01, 03), "", 1);
		broker.adicionarTransacao(broker.getClientesById(1L), 100D, LocalDate.of(2023, 01, 02), "", 1);
	
		
		broker.adicionarTransacao(broker.getClientesById(2L), 100D, LocalDate.of(2021, 01, 02), "", 1);
		broker.adicionarTransacao(broker.getClientesById(2L), -60D, LocalDate.of(2022, 01, 03), "", 1);
		broker.adicionarTransacao(broker.getClientesById(2L), 10D, LocalDate.of(2023, 01, 02), "", 1);


		
		
		//(Cliente cliente, double valor, LocalDate data, String ticker, int quant)
		broker.adicionarTransacao(broker.getClientesById(1L), 15D, LocalDate.of(2020, 01, 02), "SANB11", 3);
		broker.adicionarTransacao(broker.getClientesById(1L), 15D, LocalDate.of(2021, 01, 02), "SANB11", -5);
		broker.adicionarTransacao(broker.getClientesById(1L), 15D, LocalDate.of(2022, 01, 02), "SANB11", 3);
		broker.adicionarTransacao(broker.getClientesById(1L), 15D, LocalDate.of(2023, 01, 02), "SANB11", -5);
		
		broker.getClientesById(1L).listarTransacoes();
		broker.getClientesById(2L).listarTransacoes();
		broker.calcularPatrimonio(broker.getClientesById(1L));
		broker.calcularPatrimonio(broker.getClientesById(2L));
		
		
		
		
	}

}
