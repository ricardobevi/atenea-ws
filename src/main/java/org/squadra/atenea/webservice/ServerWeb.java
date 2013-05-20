package org.squadra.atenea.webservice;

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
	/*
	 * protected Server() throws Exception {
	 * System.out.println("Starting Server");
	 * 
	 * /** Important: This code simply starts up a servlet container and adds
	 * the web application in src/webapp to it. Normally you would be using
	 * Jetty or Tomcat and have the webapp packaged as a WAR. This is simply as
	 * a convenience so you do not need to configure your servlet container to
	 * see CXF in action!
	 * 
	 * org.eclipse.jetty.server.Server server = new
	 * org.eclipse.jetty.server.Server();
	 * 
	 * SelectChannelConnector connector = new SelectChannelConnector();
	 * connector.setPort(8080); server.setConnectors(new Connector[]
	 * {connector});
	 * 
	 * WebAppContext webappcontext = new WebAppContext();
	 * webappcontext.setContextPath("/");
	 * 
	 * webappcontext.setWar("target/basicwebservice-0.0.1-SNAPSHOT.war");
	 * 
	 * HandlerCollection handlers = new HandlerCollection();
	 * handlers.setHandlers(new Handler[] {webappcontext, new
	 * DefaultHandler()});
	 * 
	 * server.setHandler(handlers); server.start();
	 * System.out.println("Server ready..."); server.join(); }
	 */

	public static void main(String args[]) throws Exception {
		Server server = new Server();
		SocketConnector connector = new SocketConnector();
		// Set some timeout options to make debugging easier.
		connector.setMaxIdleTime(1000 * 60 * 60);
		connector.setSoLingerTime(-1);
		connector.setPort(8888);
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
	}

}