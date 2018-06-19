package com.enhinck.demo.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enhinck.demo.jwt.JwtTokenUtil;
import com.enhinck.demo.jwt.JwtUser;

@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }
    
    @Autowired
    WebSocketController webSocketController;
    
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void test(@RequestBody Greeting greeting) {
    	UserMessage userMessage = new UserMessage();
    	BeanUtils.copyProperties(userMessage, greeting);
    	webSocketController.template.convertAndSend("/topic/hello",greeting); //广播  
    	webSocketController.template.convertAndSendToUser("1", "/message",userMessage); //一对一发送，发送特定的客户端 
    }

}
