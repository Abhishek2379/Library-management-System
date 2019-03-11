package com.ram.beans;

import java.io.Serializable;

public class BookBean implements Serializable
{
  private int bookId;
  private String title;
  private float price;
  private String grade;
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public int getBookId() {
	return bookId;
}
public void setTitle(String title) {
	this.title = title;
}
public String getTitle() {
	return title;
}
public void setPrice(float price) {
	this.price = price;
}
public float getPrice() {
	return price;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getGrade() {
	return grade;
}
  
  
}
