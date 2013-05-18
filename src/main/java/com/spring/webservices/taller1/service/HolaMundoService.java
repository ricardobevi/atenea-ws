package com.spring.webservices.taller1.service;

import javax.jws.WebService;

@WebService
public interface HolaMundoService {

	String holamundo( String name );
}
