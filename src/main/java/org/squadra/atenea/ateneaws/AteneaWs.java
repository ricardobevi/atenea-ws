package org.squadra.atenea.ateneaws;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Esta clase es el webservice que expone los metodos que se utilizan desde 
 * AteneaClient
 * 
 * @author tempuses
 */
@WebService
public interface AteneaWs {

	/**
	 * Metodo que permite dialogar con el servidor atenea
	 * @param message es el mensaje mediante el cual se desea dialogar con atenea
	 * @return respuesta devuelta por atenea 
	 * @author tempuses
	 */
	String dialog( @WebParam(name="message")  String message );
}
