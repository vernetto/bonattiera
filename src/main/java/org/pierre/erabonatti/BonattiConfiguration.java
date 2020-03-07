package org.pierre.erabonatti;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BonattiConfiguration {
    @Bean
    public BonattiCalculator getBonattiCalculator() {
        return new BonattiCalculator();
    }
}
