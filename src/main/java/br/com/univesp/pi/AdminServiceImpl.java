package br.com.univesp.pi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private Environment environment;

    private static final String FRONT_FLAGS = "front-app";


    @Override
    public String getFlagValue(String flagName) {


        return environment.getProperty(FRONT_FLAGS + "." + flagName);
    }

}
