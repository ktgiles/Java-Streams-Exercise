package com.stackroute.streams;

public class CountryNotFoundException extends RuntimeException {

        public CountryNotFoundException()
        {
            super("Country not found.");
        }
}