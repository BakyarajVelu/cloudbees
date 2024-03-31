package com.cloudbees.cdro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudbees.cdro.models.Book;
import com.cloudbees.cdro.services.TrainBoardService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/board")
public class TrainBoardController {

	@Autowired
	private TrainBoardService trainBoardService;
	
	Logger logger = LoggerFactory.getLogger(TrainBoardController.class);

	@PostMapping(path = "/v1/book")
	public ResponseEntity<Integer> book(@RequestBody @Valid Book book) {
		Integer id = trainBoardService.book(book);
		logger.info("Create Ticker for userId :{} and Ticket Id:{}", book.getUser().getEmail(),id);
		return new ResponseEntity<>(id, HttpStatus.CREATED);

	}

	@PutMapping(path = "/v1/book/{email}")
	public ResponseEntity<Integer> modify(@PathVariable String email, @RequestBody @Valid Book book) {
		Integer id = trainBoardService.modify(email, book);
		logger.info("Modify Ticker for userId :{} and Ticket Id:{}", book.getUser().getEmail(),id);
		return new ResponseEntity<>(id, HttpStatus.OK);

	}

	@GetMapping(path = "/v1/book/user/{email}")
	public ResponseEntity<Book> fetchTicketByUserId(@PathVariable String email) {
		Book book = trainBoardService.fetchTicketByUserId(email);
		return new ResponseEntity<>(book, HttpStatus.OK);

	}

	@GetMapping(path = "/v1/book/{id}")
	public ResponseEntity<Book> fetchTicketById(@PathVariable Integer id) {
		Book book = trainBoardService.fetchTicketById(id);
		return new ResponseEntity<>(book, HttpStatus.OK);

	}
	
	@DeleteMapping(path = "/v1/book/{email}")
	public ResponseEntity<Boolean> delete(@PathVariable String email) {
		Boolean isDeleted = trainBoardService.delete(email);
		logger.info("Delete Ticket for the userId :{} and status:{}", email,isDeleted);
		return new ResponseEntity<>(isDeleted, HttpStatus.OK);

	}

}
