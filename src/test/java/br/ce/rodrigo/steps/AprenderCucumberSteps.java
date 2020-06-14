package br.ce.rodrigo.steps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.ce.rodrigo.converters.DateConverter;
import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent�o;
import cucumber.api.java.pt.Quando;


public class AprenderCucumberSteps {
	
	@Dado("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {
	}

	@Quando("^execut�-lo$")
	public void execut�Lo() throws Throwable {
	}

	@Ent�o("^a especifica��o deve finalizar com sucesso$")
	public void aEspecifica��oDeveFinalizarComSucesso() throws Throwable {
	}
	
	private int contador = 0;
	
	@Dado("^que o valor do contador � (\\d+)$")
	public void queOValorDoContador�(int arg1) throws Throwable {
		contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
		contador = contador + arg1;
	}

	@Ent�o("^o valor do contador � (\\d+)$")
	public void oValorDoContador�(int arg1) throws Throwable {
		Assert.assertEquals(arg1, contador);
	}
	
	Date entrega = new Date();

	@Dado("^que a entrega � dia (.*)$")
	public void queAEntrega�Dia(@Transform(DateConverter.class)Date data) throws Throwable {
		entrega = data;
	}

	@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(int arg1, String tempo) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		if (tempo.equals("dias")) {
			cal.add(Calendar.DAY_OF_MONTH, arg1);
		}
		if (tempo.equals("meses")) {
			cal.add(Calendar.MONTH, arg1);
		}
		entrega = cal.getTime();
	}

	@Ent�o("^a entrega ser� efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSer�EfetuadaEm(String data) throws Throwable {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(entrega);
		Assert.assertEquals(data, dataFormatada);
	}
	
	@Dado("^que o ticket( especial)? � (A.\\d{3})$")
	public void queOTicket�AF(String tipo, String arg1) throws Throwable {
	}

	@Dado("^que o valor da passagem � R\\$ (.*)$")
	public void queOValorDaPassagem�R$(Double arg2) throws Throwable {
	}

	@Dado("^que o nome do passageiro � \"(.{5,20})\"$")
	public void queONomeDoPassageiro�(String arg1) throws Throwable {
	}

	@Dado("^que o telefone do passageiro � (9\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiro�(String telefone) throws Throwable {
	}

	@Quando("^criar os steps$")
	public void criarOsSteps() throws Throwable {
	}

	@Ent�o("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
	}
	


	
}
