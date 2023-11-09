package mypackage.config;

import mypackage.model.Transcript;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean(name = "verbose")
    @Scope("prototype")
    @Primary
    public Transcript verboseTranscript(){
        return new Transcript(4,true);
    }

    @Bean(name = "brief")
    @Scope("prototype")
    public Transcript briefTranscript(){
        return new Transcript(4,false);
    }
}
