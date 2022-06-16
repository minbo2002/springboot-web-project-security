package org.zerock.club;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootWebProjectSecurityApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootWebProjectSecurityApplication.class, args);
    }

}
