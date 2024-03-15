package com.example.webStore.models;

import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {
	@Id
	@EqualsAndHashCode.Include long id;
	private String name;
	private String author;

//	@Embedded
	private double price;
	private int count = 0;
	private int promotion;

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
		return price;
	}
    public double getFinalPrice() { return price - (price / 100 * promotion); }
	public void setPrice(double price) {
		if(price < 0) throw new IllegalArgumentException("Price cannot be null");
		this.price = price;
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
		if(percent < 0) throw new IllegalArgumentException("Promotion cannot be negative");
		this.promotion = percent;
	}
	public boolean isPromotion()
	{
		return this.promotion > 0;
	}
	public int getPromotionPercent()
	{
		return this.promotion;
	}

}
