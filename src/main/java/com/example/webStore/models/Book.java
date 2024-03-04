package com.example.webStore.models;

import org.springframework.data.annotation.Id;

public class Book {
	@Id
	private long id;
	private String name;
	private String author;
	private Price price = new Price();
	private int count = 0;
	private Promotion promotion = new Promotion();

	public long getId()
	{
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price.getPrice();
	}
    public double getFinalPrice() { return promotion.calcPriceWithPromotion(price.getPrice()); }
	public void setPrice(double price) {
		this.price.setPrice(price);
	}
	public boolean isInStock()
	{
		return count > 0;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		if(count < 0) { throw new IllegalArgumentException("Quantity of books must be positive number"); }
		this.count = count;
	}
	public void addCount(int count)
	{
		if(count < 0) { throw new IllegalArgumentException("Count must be positive number"); }
		this.count += count;
	}
	public void removeCount(int count)
	{
		if(count < 0) { throw new IllegalArgumentException("Count must be positive number"); }
		if(this.count < count) { throw new IllegalArgumentException("Can't remove more than have"); }
		this.count -= count;
	}
	public void setPromotion(int percent)
	{
		this.promotion.setPercent(percent);
	}
	public void removePromotion()
	{
		this.promotion.setPercent(0);
	}
	public boolean isPromotion()
	{
		return this.promotion.getPercent() > 0;
	}
	public int getPromotionPercent()
	{
		return this.promotion.getPercent();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		Book book = (Book) obj;

		if(book.name != name)
			return false;
		if(book.author != author)
			return false;
		if(book.id != id)
			return false;

		return true;
	}
}
