package com.example.pproprojekt;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration


public class SecurityConfig{
  /* @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests(autorize ->autorize
                        .mvcMatchers("/reklamace").hasRole("CMPLAINT")
                        .mvcMatchers("/admin").hasRole("ADMIN")
                        .mvcMatchers("/depot").hasRole("DEPOT")
                        .mvcMatchers("/").permitAll()
                        .mvcMatchers("/login").permitAll()
                        .anyRequest().denyAll()

                )
                .httpBasic(withDefaults());

    }
    @Bean
    public UserDetailsService users() {
        // The builder will ensure the passwords are encoded before saving in memory
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails depotUser = users
                .roles("DEPOT")
                .build();
        UserDetails admin = users
                .roles("ADMIN")
                .build();
        UserDetails complaintUser = users
                .roles("CMPLAINT")
                .build();

        return new InMemoryUserDetailsManager(depotUser, admin, complaintUser);
    }
*/
}
