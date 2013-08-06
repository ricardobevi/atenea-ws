package org.squadra.atenea.ateneaws;

import javax.jws.WebParam;
import javax.jws.WebService;

import lombok.extern.log4j.Log4j;

import org.squadra.atenea.aiengineaccess.AIEngineAccessFacade;
import org.squadra.atenea.ateneacommunication.AteneaWs;
import org.squadra.atenea.ateneacommunication.Message;


/**
 * 
 * Implementacion de AteneaWs
 * 
 * @author tempuses
 *
 */
@Log4j
@WebService(endpointInterface="org.squadra.atenea.ateneacommunication.AteneaWs")
public class AteneaWsImpl implements AteneaWs {

	AIEngineAccessFacade server;
	
	public AteneaWsImpl(){
		this.server = new AIEngineAccessFacade();
	}

	@Override
	public Message dialog(Message message) {
		//validar q el mensaje no sea nulo
		log.debug("------------log AteneaWs");
		return server.execute(message);
	}
	
	@Override
	public String dialogString(@WebParam(name = "message") String message) {
		log.debug("------------log AteneaWs");
		return server.execute(message);
	}

}
