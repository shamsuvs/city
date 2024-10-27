package com.smashplus.cityxplor.exception;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class SPException extends Exception {
    public SPException() {
    }

    public SPException(String message, Model model) {
        super(message);
        model.addAttribute("errorMessage",message);
    }
}
