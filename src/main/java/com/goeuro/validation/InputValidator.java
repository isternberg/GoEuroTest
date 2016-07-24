package com.goeuro.validation;

import org.springframework.stereotype.Component;

import static org.springframework.util.StringUtils.*;

@Component
public class InputValidator {
    public boolean inputOK(String... args) {
        if (args.length != 1) {
            return false;
        }
        return doValidate(args[0]);
    }

    private boolean doValidate(String arg) {
        String input = uncapitalize(trimAllWhitespace(arg));
        if (!hasLength(input) ){
            return false;
        }
        return true;
    }
}
