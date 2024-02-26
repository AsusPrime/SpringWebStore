package com.example.webStore.models;

import java.util.List;

public class Book {
	private String name;
	private String author;
	private Price price;
	private Assessment assessment;
	private List<Image> images;
	private List<Review> comments;
	private int count = 0;
	private Promotion promotion;
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
	public void setPrice(double price) {
		this.price.setPrice(price);
	}
	public int getAssessment() {
		return assessment.getRating();
	}
	public void setAssessment(int assessment) {
		this.assessment.setRating(assessment);
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images)
	{
		this.images = images;
	}
	public void addImage(Image image) {
		this.images.add(image);
	}
	public List<Review> getComments() {
		return comments;
	}
	public void addComment(Review comment) {
		this.comments.add(comment);
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
		if(this.count < count) { throw new IllegalArgumentException("Canэt remove more than have"); }
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
}
