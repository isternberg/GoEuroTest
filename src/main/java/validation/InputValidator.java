package validation;

import org.springframework.stereotype.Component;

@Component
public class InputValidator {
    public boolean inputOK(String... args) {
        if (args.length != 1) {
            return false;
        }
        return true;
    }
}
