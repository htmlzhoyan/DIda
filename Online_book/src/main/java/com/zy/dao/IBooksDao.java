package com.zy.dao;

import java.util.List;

import com.zy.entity.Books;

public interface IBooksDao {
	public List<Books> findAllBooks(String username);
	public Books findBooksByName(Integer bid);
}
