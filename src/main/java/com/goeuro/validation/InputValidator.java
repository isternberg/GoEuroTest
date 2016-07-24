package com.goeuro.validation;

import org.springframework.stereotype.Component;

import static org.springframework.util.StringUtils.*;

@Component
public class InputValidator {
    public boolean inputOK(String... args) {
        if (args.length != 1) {
            return false;
        }
        String input = uncapitalize(trimAllWhitespace(args[0]));
        if (!hasLength(input) ){
            return false;
        }
        return true;
    }
}
