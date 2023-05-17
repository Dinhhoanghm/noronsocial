package com.socialmedia.socialmedia.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

public class PasswordValidatorContraint implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(final ValidPassword arg0) {

    }

    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {
        // @formatter:off
        PasswordValidator validator = new PasswordValidator(
                new LengthRule(8,30),
                new CharacterRule(EnglishCharacterData.LowerCase,1),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),

                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new CharacterRule(EnglishCharacterData.Alphabetical,3),
//                new IllegalSequenceRule(EnglishSequenceData.Numerical,5,false),
//                new IllegalSequenceRule(EnglishSequenceData.Alphabetical,5,false),
//                new IllegalSequenceRule(EnglishSequenceData.USQwerty , 5, false),
                new WhitespaceRule()

        );


        final RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }

        return false;
    }
}
