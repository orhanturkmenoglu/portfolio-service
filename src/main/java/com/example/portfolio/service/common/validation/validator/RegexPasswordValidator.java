package com.example.portfolio.service.common.validation.validator;

import com.example.portfolio.service.common.validation.RegexPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class RegexPasswordValidator implements ConstraintValidator<RegexPassword,String> {

    private static final Pattern PASSWORD_REGEX  =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$");

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if(password !=null) {
            return PASSWORD_REGEX.matcher(password).matches();
        }
        return false;
    }
}
