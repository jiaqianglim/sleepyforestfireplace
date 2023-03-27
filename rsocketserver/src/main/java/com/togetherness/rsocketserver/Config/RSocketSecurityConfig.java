// package com.togetherness.rsocketserver.Config;

// import org.springframework.boot.rsocket.server.RSocketServerCustomizer;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.rsocket.EnableRSocketSecurity;
// import org.springframework.security.config.annotation.rsocket.RSocketSecurity;
// import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;

// import org.springframework.security.rsocket.core.PayloadSocketAcceptorInterceptor;

// import io.rsocket.plugins.SocketAcceptorInterceptor;

// //https://docs.spring.io/spring-security/reference/reactive/integrations/rsocket.html
// @Configuration
// @EnableRSocketSecurity
// public class RSocketSecurityConfig {

//     @Bean
//     public MapReactiveUserDetailsService userDetailsService() {
//         UserDetails user = User.withUsername("user")
//                 .username("user")
//                 .password("user")
//                 .roles("USER")
//                 .build();
//         return new MapReactiveUserDetailsService(user);
//     }

//     @Bean
//     RSocketServerCustomizer springSecurityRSocketSecurity(SocketAcceptorInterceptor interceptor) {
//         return (server) -> server.interceptors((registry) -> registry.forSocketAcceptor(interceptor));
//     }

//     @Bean
//     PayloadSocketAcceptorInterceptor rsocketInterceptor(RSocketSecurity rsocket) {
//         rsocket
//                 .authorizePayload(authorize -> authorize
//                         .anyRequest().authenticated()
//                         .anyExchange().permitAll())
//                 .jwt(Customizer.withDefaults());
//         return rsocket.build();
//     }
// }
