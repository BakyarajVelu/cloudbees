package com.cloudbees.cdro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudbees.cdro.dao.TrainBoardDao;
import com.cloudbees.cdro.models.Book;

@Service
public class TrainBoardService {

	@Autowired
	private TrainBoardDao trainBoardDao;

	public Integer book(Book book) {
		return trainBoardDao.book(book);

	}

	public Integer modify(String email, Book book) {
		return trainBoardDao.modify(email, book);
	}

	public Book fetchTicketByUserId(String email) {
		return trainBoardDao.fetchTicketByUserId(email);
	}

	public Book fetchTicketById(Integer id) {
		return trainBoardDao.fetchTicketById(id);
	}

	public Boolean delete(String email) {
		return trainBoardDao.delete(email);
	}

}
