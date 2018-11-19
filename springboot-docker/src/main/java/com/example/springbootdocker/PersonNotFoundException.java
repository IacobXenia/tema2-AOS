package com.example.springbootdocker;

public class PersonNotFoundException extends RuntimeException {
 public PersonNotFoundException(String exception) {
	 super(exception);
 }
}
