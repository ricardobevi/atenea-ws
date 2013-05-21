package org.squadra.atenea.webservice.impl;

import javax.jws.WebService;

import org.atenea.aiengineaccess.AIEngineAccessFacade;
import org.squadra.atenea.webservice.AteneaWs;



/**
 * 
 * Implementacion de AteneaWs
 * 
 * @author tempuses
 *
 */
@WebService(endpointInterface="org.squadra.atenea.webservice.AteneaWs")
public class AteneaWsImpl implements AteneaWs {


	@Override
	public String dialog(String message) {
		
		AIEngineAccessFacade server = new AIEngineAccessFacade();
		
		//System.out.println( message );
		
		if ( message != null ){
			return server.excecute(message);
		} 
		else{
			
			// aca puedo generar un random entre n respuestas o levantarlas de un archivo, eso seria mejor
			return "No te escuche ¿Cómo dijiste?";
		}
		
	}

}
