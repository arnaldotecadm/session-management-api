package br.com.emerion.enums;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum EnumTipoVersao {
	DESENVOLVIMENTO("Ambiente de desenvolvimento da aplicação, sujeito a todos os tipos de bugs."),
	SNAPSHOT("Ambiente um pouco mais estável, geralmente pela equipe de testes."),
	HOMOLOGACAO("Ambiente estável, já tendo passado por testes. Serve como uma versão de validação e para a realização de testes mais rigorosos(Estresse, Carga, etc)."),
	PRODUCAO("Ambiente seguro e livre de erros. Pelo menos teóricamente.");

	private final String label;

	private EnumTipoVersao(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
	
	public static final String ENUMERADO_SWAGGER = "DESENVOLVIMENTO, SNAPSHOT, HOMOLOGACAO, PRODUCAO";
	
}
