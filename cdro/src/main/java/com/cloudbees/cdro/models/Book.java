package com.cloudbees.cdro.models;

import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Book {
	@NotBlank(message = "From should not be Black")
	private String from;
	@NotBlank(message = "To should not be Black")
	private String to;
	@NumberFormat(style = NumberFormat.Style.CURRENCY)
	private double price;
	@NotBlank(message = "Section should not be Black")
	private String section;
	private int seatNumber;
	@NotNull(message = "User should not be null")
	User user;
}
