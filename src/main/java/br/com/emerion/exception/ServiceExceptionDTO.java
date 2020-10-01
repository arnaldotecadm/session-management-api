package br.com.emerion.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ServiceExceptionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4600215658629972779L;

	private String descricao;
}
