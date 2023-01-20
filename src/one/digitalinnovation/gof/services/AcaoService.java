package one.digitalinnovation.gof.services;

//import com.google.gson.Gson;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;

import java.util.List;

import one.digitalinnovation.gof.entities.Transacao;

public class AcaoService {
    static String webService = "https://api.dadosdemercado.com.br/v1/tickers/";
    static int codigoSucesso = 200;
    
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
	

	//calcularPreco venda
	//validarprecoCompra

}


/*
public class ServicoDeCep {
    static String webService = "http://viacep.com.br/ws/";
    static int codigoSucesso = 200;

    public static Endereco buscaEnderecoPelo(String cep) throws Exception {
        String urlParaChamada = webService + cep + "/json";

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Util.converteJsonEmString(resposta);

            Gson gson = new Gson();
            Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);

            return endereco;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }
} */