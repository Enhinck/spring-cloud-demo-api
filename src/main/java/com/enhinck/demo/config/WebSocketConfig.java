package com.enhinck.demo.config;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import com.enhinck.demo.jwt.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hueb
 * @date 2018/6/13
 */
@Slf4j
@Configuration
@EnableWebSocketMessageBroker  
public class WebSocketConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserDetailsService userDetailsService;

	
	  @Override  
	    public void configureMessageBroker(MessageBrokerRegistry config) {  
	        config.enableSimpleBroker("/topic","/user");  
	        config.setApplicationDestinationPrefixes("/app");  
	        config.setUserDestinationPrefix("/user/");  
	    }  
	  
	    @Override  
	    public void registerStompEndpoints(StompEndpointRegistry registry) {  
	        registry.addEndpoint("/webServer").setAllowedOrigins("*").withSockJS();  
	    }  
	
/*	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}*/

	@Override
	protected void customizeClientInboundChannel(ChannelRegistration registration) {
		registration.interceptors(new ChannelInterceptorAdapter() {
			@Override
			public Message<?> preSend(Message<?> message, MessageChannel channel) {
				StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
				if (StompCommand.CONNECT.equals(accessor.getCommand())) {
					String jwtToken = accessor.getFirstNativeHeader("Authorization");
					log.debug("webSocket token is {}", jwtToken);
					if (StringUtils.isNotEmpty(jwtToken)) {
						Map<String, Object> sessionAttributes = SimpMessageHeaderAccessor
								.getSessionAttributes(message.getHeaders());
						sessionAttributes.put(CsrfToken.class.getName(),
								new DefaultCsrfToken("Authorization", "Authorization", jwtToken));
						String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
						UserDetails userDetails = userDetailsService.loadUserByUsername(username);
						// For simple validation it is completely sufficient to just check the token
						// integrity. You don't have to call
						// the database compellingly. Again it's up to you ;)
						if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
							UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
									userDetails, null, userDetails.getAuthorities());
							// authentication.setDetails(new
							// WebAuthenticationDetailsSource().buildDetails(request));
							log.info("authorizated user '{}', setting security context", username);
							SecurityContextHolder.getContext().setAuthentication(authentication);
							accessor.setUser(authentication);
						}
					}
				}
				return message;
			}
		});
	}

	@Override
	protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
		messages.anyMessage().permitAll();
	}

	@Override
	protected boolean sameOriginDisabled() {
		return true;
	}
}
