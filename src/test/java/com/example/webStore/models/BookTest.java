package com.example.webStore.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BookTest {
	@Test
	public void testBookSetCount_WithPositiveNumber()
	{
		Book book = new Book();
		book.setCount(15);
		assertEquals(15, book.getCount());
	}
	@Test
	public void testBookSetCount_WithNegativeNumber()
	{
		Book book = new Book();
		assertThrows(IllegalArgumentException.class, () -> {
            book.setCount(-15);
        });
	}
	@Test
	public void testBookAddCount_WithPositiveNumber()
	{
		Book book = new Book();
		book.addCount(15);
		assertEquals(15, book.getCount());
	}
	@Test
	public void testBookAddCount_WithNegativeNumber()
	{
		Book book = new Book();
		assertThrows(IllegalArgumentException.class, () -> {
            book.addCount(-15);
        });
	}
	@Test
	public void testBookRemoveCount_WithPositiveNumber()
	{
		Book book = new Book();
		book.setCount(50);
		book.removeCount(15);
		assertEquals(50-15, book.getCount());
	}
	@Test
	public void testBookRemoveCount_WithNegativeNumber()
	{
		Book book = new Book();
		book.setCount(50);
		assertThrows(IllegalArgumentException.class, () -> {
            book.addCount(-15);
        });
	}
	@Test
	public void testBookRemoveCount_WithHighNumber()
	{
		Book book = new Book();
		book.setCount(50);
		assertThrows(IllegalArgumentException.class, () -> {
            book.addCount(-55);
        });
	}
}
