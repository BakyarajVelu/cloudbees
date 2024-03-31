package com.cloudbees.cdro.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class User {
	@NotBlank(message = "FirstName should not be Black")
	private String  firstName;
	@NotBlank(message = "LastName should not be Black")
	private String lastName;
	@NotBlank(message = "Email should not be Black")
	private String email;
}
