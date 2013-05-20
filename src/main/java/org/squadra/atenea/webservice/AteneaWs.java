package org.squadra.atenea.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AteneaWs {

	String dialog( @WebParam(name="message")  String message );
}
