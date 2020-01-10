package com.gk;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController 
{
    @Autowired
    EmailConfiguration emailProperties;

    @GetMapping("/test")
    public Map<String,Object> MailProperties() 
    {
		return emailProperties.getMailProperties();
    }
    
    @GetMapping("/test1")
    public Map<String,Object> getMailProperties() 
    {
        String processName = "NB UW";
        String activityName = "Data Entry/Verification";
        JavaMailSenderImpl mailSender = null;
        Map<String,Object> totalConfig =  (Map<String,Object>)emailProperties.getMailProperties().get("activityConfiguration");
        if(null != totalConfig)
        {
            Map<String,Object> processConfig =  (Map<String,Object>)totalConfig.get("NB UW");
            if(null != processConfig)
            {
                Map<String,Object> activityConfig = (Map<String,Object>)processConfig.get("Data Entry/Verification");
                if(null != activityConfig)
                {
                    mailSender = new JavaMailSenderImpl();
                    mailSender.setHost((String)activityConfig.get("host"));
                    mailSender.setPort((Integer)activityConfig.get("port"));

                    mailSender.setUsername((String)activityConfig.get("mailConfigUser"));
                    mailSender.setPassword((String)activityConfig.get("encryptedPassword"));

                    Properties props = mailSender.getJavaMailProperties();

                    props.put(activityConfig.get("protocol"),activityConfig.get("protocolName"));
                    props.put(activityConfig.get("auth"),activityConfig.get("authValue"));
                    props.put(activityConfig.get("enable"),activityConfig.get("enableValue"));
                    props.put(activityConfig.get("debug"),activityConfig.get("debugValue"));
                    mailSender.setJavaMailProperties(props);
                   
                    return activityConfig;
                }
            }
        }
        
        if(null == mailSender)
        {
            mailSender = new JavaMailSenderImpl();
            mailSender.setHost(emailProperties.getHost());
            mailSender.setPort(emailProperties.getPort());

            mailSender.setUsername(emailProperties.getMailConfigUser());
            mailSender.setPassword(emailProperties.getEncryptedPassword());

            Properties props = mailSender.getJavaMailProperties();

            props.put(emailProperties.getMailProperties().get("protocol"),emailProperties.getMailProperties().get("protocolName"));
            props.put(emailProperties.getMailProperties().get("auth"),emailProperties.getMailProperties().get("authValue"));
            props.put(emailProperties.getMailProperties().get("enable"),emailProperties.getMailProperties().get("enableValue"));
            props.put(emailProperties.getMailProperties().get("debug"),emailProperties.getMailProperties().get("debugValue"));

            mailSender.setJavaMailProperties(props);
            
        }

        return null;
	}
}