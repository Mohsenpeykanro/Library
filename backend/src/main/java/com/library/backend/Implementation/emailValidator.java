package com.library.backend.Implementation;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
@Service
public class emailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
//          TODO: Regex to Validate email
        return true;
    }
}
