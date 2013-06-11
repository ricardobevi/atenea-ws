package org.squadra.atenea.ateneaws.impl;

import javax.jws.WebService;

import org.squadra.atenea.ateneaws.AteneaWs;
import org.squadra.atenea.aiengineaccess.AIEngineAccessFacade;


/**
 * 
 * Implementacion de AteneaWs
 * 
 * @author tempuses
 *
 */
@WebService(endpointInterface="org.squadra.atenea.ateneaws.AteneaWs")
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
