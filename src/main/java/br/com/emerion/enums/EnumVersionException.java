package br.com.emerion.enums;

import org.springframework.http.HttpStatus;

public enum EnumVersionException {
	
	VERSAO_JA_EXISTENTE(HttpStatus.CONFLICT, "Versão informada já existente. Por favor informar uma versão diferente."), 
	VERSAO_INFORMADA_INCORRETAMENTE(HttpStatus.BAD_REQUEST, "Não foi possível recuperar a versão. Por favor informar a versão no formato: \"9.9.9.9\""), 
	INFORMAR_ARQUIVO_DOWNLOAD(HttpStatus.BAD_REQUEST, "Se o download não for se referir à versão completa, por favor especificar o arquivo a ser baixado."),
	ARQUIVO_NAO_ENCONTRADO(HttpStatus.NOT_FOUND, "Erro ao tentar processar requisição; Recurso não encontrado"),
	
	MANIFESTO_MAL_FORMATADO(HttpStatus.NOT_FOUND, "Erro converter o arquivo de MANIFESTO. Arquivo mal formatado, por favor consutar o manual para maiores detalhes sobre formatação"),
	MANIFESTO_INFORMADO_INCORRETAMENTE(HttpStatus.NOT_FOUND, "Erro converter o arquivo de MANIFESTO. Arquivo informado não condiz com arquivos enviados."),
	
	NUMERO_MAXIMO_ARQUIVOS(HttpStatus.METHOD_NOT_ALLOWED, "O serviço pode receber no máximo dois scripts. Leia o manual para maiores detalhes."),
	
	ERRO_DESCONHECIDO(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao tentar processar a requisição. Motivo desconhecido"), 
	
	NENHUM_ARQUIVO_ADICIONADO(HttpStatus.METHOD_NOT_ALLOWED, "Nenhum arquivo foi adicionado para atualização. Por favor verifique"), 
	SCRIPT_ALREADY_REGISTERED(HttpStatus.BAD_REQUEST,"Arquivo de script com o mesmo nome já enviado anteriormente para o mesmo tipo de versão."), 
	
	SCRIPT_TYPE_NOT_ACCEPTABLE(HttpStatus.BAD_REQUEST, "Tipo de arquivo SQL não é aceito, favor enviar os scripts de banco no formato SQL"),
	
	APP_TYPE_NOT_ACCEPTABLE(HttpStatus.BAD_REQUEST, "Tipo de Aplicação não é aceito, favor enviar apenas executáveis");
	
	private final String label;
	private HttpStatus httpStatus;
	
	private EnumVersionException(HttpStatus httpStatus, String label) {
		this.httpStatus = httpStatus;
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}
}
