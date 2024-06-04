package org.example.client.validation;



import org.example.client.validation.rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static void validate(String value, List<Rule> rules) {
        List<String> errors = new ArrayList<>();
        if (value == null || value.isBlank()) {
            errors.add("Поле не должно быть пустым!");
        } else {
            for (Rule rule : rules) {
                if (!rule.check(value)) {
                    errors.add(rule.errorMessage());
                }
            }
        }
        if (!errors.isEmpty()) throw new ValidationException(errors);
    }
}
