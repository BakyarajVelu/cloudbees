package com.cloudbees.cdro.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.cloudbees.cdro.models.Book;

@Repository
public class TrainBoardDao {
	Map<String, Book> userBookings = new HashMap<>();
	Map<Integer, String> idBookingUserMap = new HashMap<>();
	Map<String, Integer> userBookingIdMap = new HashMap<>();
	AtomicInteger idGen = new AtomicInteger(1000);

	public Integer book(Book book) {
		if (userBookings.containsKey(book.getUser().getEmail())) {
			return userBookingIdMap.get(book.getUser().getEmail());
		}
		Integer id = idGen.getAndIncrement();
		userBookings.put(book.getUser().getEmail(), book);
		idBookingUserMap.put(id, book.getUser().getEmail());
		userBookingIdMap.put(book.getUser().getEmail(), id);
		return id;
	}

	public Integer modify(String email, Book book) {
		userBookings.put(email, book);
		return userBookingIdMap.get(email);
	}

	public Book fetchTicketByUserId(String email) {
		return userBookings.get(email);
	}

	public Book fetchTicketById(Integer id) {
		return userBookings.get(idBookingUserMap.get(id));
	}

	public Boolean delete(String email) {
		if (!userBookings.containsKey(email))return false;
		userBookings.remove(email);
		idBookingUserMap.remove(userBookingIdMap.get(email));
		userBookingIdMap.remove(email);
		return true;
	}
}
