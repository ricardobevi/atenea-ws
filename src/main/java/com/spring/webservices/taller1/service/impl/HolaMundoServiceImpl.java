package com.spring.webservices.taller1.service.impl;

import javax.jws.WebService;

import test.ServerTest;

import com.spring.webservices.taller1.service.HolaMundoService;

@WebService(endpointInterface="com.spring.webservices.taller1.service.HolaMundoService")
public class HolaMundoServiceImpl implements HolaMundoService {

	@Override
	public String holamundo(String name) {
		ServerTest server = new ServerTest();
		
		//System.out.println("Hola " + name );
		
		if ( name != null ){
			return server.excecute(name);
		} 
		else{
			return "No logro entenderte, por favor repitemelo";
		}
		
	}

}
