package one.digitalinnovation.gof.services;



import java.util.List;

import one.digitalinnovation.gof.entities.Transacao;

//FACADE: remove parte da complexidade das verificacoes da outra classe de serviço;
public class AcaoService {

    
	//verificar se tem quantidade
	public boolean validaVenda(List<Transacao> lista, Transacao teste) {
		int quant = 0;
		for (Transacao t: lista) {
			if((t.getTicker() == teste.getTicker()) && (t.getData().isBefore(teste.getData()))) {
				quant += t.getQuant();
			}
		}
		if ((quant + teste.getQuant()) >= 0) return true;
		else return false;
	}
	
	
	//verificar ticker se existe
	public boolean existeAcao(Transacao teste) {
		String ticker = teste.getTicker();
		if ((ticker.length()>6)|| (ticker.length()<5)) {
			return false;
		}
		if (((ticker.length() == 6) && ticker.endsWith("11"))||((ticker.length() == 6) && ticker.endsWith("34"))) {
			return true;
		}
		if (((ticker.length() == 5) && ticker.endsWith("4"))||((ticker.length() == 5) && ticker.endsWith("3"))) {
			return true;
		}
		else return false;
	}
	
	

}
