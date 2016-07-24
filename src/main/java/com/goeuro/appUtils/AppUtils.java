package com.goeuro.appUtils;

import org.springframework.stereotype.Component;

@Component
public class AppUtils {

    public static final String TERMINATING = "\nTerminating.\n\n";


    public void terminate(String message) {
        System.out.println(message+TERMINATING);
        System.exit(0);
    }
}
