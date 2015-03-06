package com.ppsinfo.rsig.jdbc.model;

import java.util.Date;

public class Test extends BasicData{
	
	public static final String fieldId = "id";
	public static final String fieldNum = "num";
	public static final String fieldString = "string";
	public static final String fieldText = "text";
	public static final String fieldDate = "date";
	
	
	public int id;
	public int num;
	public String string;
	public String text;
	public Date date;
	
	public Test() {
		super();
		tableName = "test";
		defautUpdateColumns = new String[] { "id", "num",
				"string", "text", "date" };
	}
	
	public Test(int id, int num, String string, String text, Date date) {
		this();
		this.id = id;
		this.num = num;
		this.string = string;
		this.text = text;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", num=" + num + ", string=" + string
				+ ", text=" + text + ", date=" + date + "]";
	}
	
	
}
