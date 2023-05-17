package com.socialmedia.socialmedia.validation;

import com.socialmedia.socialmedia.dto.UserSignInDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, Object> {
    @Override
    public void initialize(final PasswordMatch constraintAnnotation) {
        //
    }
    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final UserSignInDTO user = (UserSignInDTO) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
