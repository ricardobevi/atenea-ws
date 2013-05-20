package org.squadra.atenea.webservice.impl;

import javax.jws.WebService;

import org.squadra.atenea.webservice.AteneaWs;

import test.ServerTest;


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
		
		ServerTest server = new ServerTest();
		
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
