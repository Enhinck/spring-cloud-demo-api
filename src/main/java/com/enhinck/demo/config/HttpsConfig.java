package com.enhinck.demo.config;

import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * HTTP自动转向HTTPS的配置
 *
 * @author huenbin
 * @date 2018/6/13
 */
@Component
public class HttpsConfig {

	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint constraint = new SecurityConstraint();
				constraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				constraint.addCollection(collection);
				context.addConstraint(constraint);
			}
		};
		//tomcat.addAdditionalTomcatConnectors(httpConnector());
		return tomcat;
	}

	/*
	 * @Bean 1.5.x public EmbeddedServletContainerFactory servletContainer() {
	 * TomcatEmbeddedServletContainerFactory tomcat = new
	 * TomcatEmbeddedServletContainerFactory() {
	 * 
	 * @Override protected void postProcessContext(Context context) {
	 * SecurityConstraint constraint = new SecurityConstraint();
	 * constraint.setUserConstraint("CONFIDENTIAL"); SecurityCollection collection =
	 * new SecurityCollection(); collection.addPattern("/*");
	 * constraint.addCollection(collection); context.addConstraint(constraint); } };
	 * tomcat.addAdditionalTomcatConnectors(httpConnector()); return tomcat; }
	 */

	
	
	/*private Connector createSslConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		try {
			File keystore = new ClassPathResource("cas-enhinck.keystore").getFile();
			File truststore = new ClassPathResource("ENHINCK.cer").getFile();
			connector.setScheme("https");
			connector.setSecure(true);
			connector.setPort(8443);
			protocol.setSSLEnabled(true);
			protocol.setKeystoreFile(keystore.getAbsolutePath());
			protocol.setKeystorePass("enhinck");
			protocol.setTruststoreFile(truststore.getAbsolutePath());
			protocol.setTruststorePass("changeit");
			protocol.setKeyAlias("ENHINCK");
			return connector;
		}
		catch (IOException ex) {
			throw new IllegalStateException("can't access keystore: [" + "keystore"
					+ "] or truststore: [" + "keystore" + "]", ex);
		}
	}*/
	
	
	/*@Bean
	public Connector httpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		// Connector监听的http的端口号
		connector.setPort(8081);
		connector.setSecure(false);
		// 监听到http的端口号后转向到的https的端口号
		connector.setRedirectPort(8443);
		return connector;
	}*/
}
