package com.gk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration 
{
    @Autowired
    private EmailConfiguration emailProperties;
    
    

    /**
     * @return EmailConfiguration return the emailProperties
     */
    public EmailConfiguration getEmailProperties() {
        return emailProperties;
    }

    /**
     * @param emailProperties the emailProperties to set
     */
    public void setEmailProperties(EmailConfiguration emailProperties) {
        this.emailProperties = emailProperties;
    }

}