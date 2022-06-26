//package mk.ukim.finki.dnick.prototype.springbootlearningsystem.config;
//
//import org.springframework.context.annotation.Configuration;
////import org.springframework.context.annotation.Profile;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
////@Profile("stateful-auth")
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final PasswordEncoder passwordEncoder;
//    private final CustomUsernamePasswordAuthenticationProvider authenticationProvider;
//
//    public WebSecurityConfig(PasswordEncoder passwordEncoder,
//                             CustomUsernamePasswordAuthenticationProvider authenticationProvider) {
//        this.passwordEncoder = passwordEncoder;
//        this.authenticationProvider = authenticationProvider;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/", "/api/**","/h2", "/lectures").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .failureUrl("/login?error=BadCredentials")
//                .defaultSuccessUrl("/lectures", true)
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .clearAuthentication(true)
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .logoutSuccessUrl("/login")
//                .and()
//                .exceptionHandling().accessDeniedPage("/access_denied");
//        //http.headers().frameOptions().sameOrigin();
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("kiko")
//                .password(passwordEncoder.encode("kiko"))
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("professor1")
//                .password(passwordEncoder.encode("professor1"))
//                .authorities("ROLE_ADMIN");
//        //auth.authenticationProvider(authenticationProvider);
//    }
//
//
//
//}