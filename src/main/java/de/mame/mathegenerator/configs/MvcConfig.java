package de.mame.mathegenerator.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


@Configuration
public class MvcConfig {

    /* Die MessageSource Bean gibt an,aus welchen Dateien die Messages (z.b. #{text.welcome}) bezogen werden.
    *  Für die classpath Angaben unter "messageSource.setBasenames" ist das projekt resources Verzeichnis der root.
    *  d.h. "/messages/main-page-messages" zeigt auf die Datei "resources/messages/main-page-messages.properties"
    * */
    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:/messages/main-page-messages", "classpath:/another-projects/mvc-messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(5);
        return messageSource;
    }


}
