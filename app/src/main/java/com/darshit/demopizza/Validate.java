package com.darshit.demopizza;

import android.util.Patterns;

public class Validate {

    public boolean eValidation(String email) {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches() && !email.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
