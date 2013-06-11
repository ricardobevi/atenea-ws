package org.squadra.atenea.ateneaws;

//import java.net.URL;
//import java.security.ProtectionDomain;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * 
 * Clase que inicia el servidor web Jetty para iniciar el webservice 
 * y exponer los metodos de la clase AteneaWs
 * 
 * @author tempuses
 *
 */
public class ServerWeb {
	
	public static void main(String args[]) throws Exception {
		
			Server server = new Server();
			SocketConnector connector = new SocketConnector();
			// Set some timeout options to make debugging easier.
			connector.setMaxIdleTime(1000 * 60 * 60);
			connector.setSoLingerTime(-1);
			connector.setPort(20002);
			server.setConnectors(new Connector[] { connector });

			WebAppContext bb = new WebAppContext();
			bb.setServer(server);
			bb.setContextPath("/AteneaWs");
			bb.setWar("src/main/webapp");

			server.addHandler(bb);

			try {
				System.out
						.println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP");
				server.start();
				while (System.in.available() == 0) {
					Thread.sleep(5000);
				}
				server.stop();
				server.join();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(100);
			}	
		
		
	/*	Server server = new Server();
		SocketConnector connector = new SocketConnector();
		
		// Set some timeout options to make debugging easier.
		connector.setMaxIdleTime(1000 * 60 * 60);
		connector.setSoLingerTime(-1);
		connector.setPort(20002);
		server.setConnectors(new Connector[] { connector });

		WebAppContext bb = new WebAppContext();
		bb.setServer(server);
		bb.setContextPath("/AteneaWs");
		
		/*
		ProtectionDomain domain = ServerWeb.class.getProtectionDomain();

		URL location = domain.getCodeSource().getLocation();

		bb.setDescriptor(location.toExternalForm() + "/WEB-INF/web.xml");
		
		bb.setWar(location.toExternalForm());
		 
		
		bb.setWar("src/main/webapp");
		
		server.addHandler(bb);

		try {
			System.out
					.println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP");
			server.start();
			while (System.in.available() == 0) {
				Thread.sleep(5000);
			}
			server.stop();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(100);
		}
		*/
		
		

	}

}