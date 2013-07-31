package org.squadra.atenea.ateneaws.impl;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.squadra.atenea.aiengine.Message;
import org.squadra.atenea.aiengineaccess.AIEngineAccessFacade;
import org.squadra.atenea.ateneaws.AteneaWs;


/**
 * 
 * Implementacion de AteneaWs
 * 
 * @author tempuses
 *
 */
@WebService(endpointInterface="org.squadra.atenea.ateneaws.AteneaWs")
public class AteneaWsImpl implements AteneaWs {

	AIEngineAccessFacade server;
	public static final Logger logger = Logger.getLogger(AteneaWsImpl.class);
	
	public AteneaWsImpl(){
		this.server = new AIEngineAccessFacade();
	}

	@Override
	public Message dialog(Message message) {
		//validar q el mensaje no sea nulo
		return server.execute(message);
	}
	
	@Override
	public String dialogString(@WebParam(name = "message") String message) {
		logger.debug("------------Llamada a WS");
		return "pepe";
	}

}
