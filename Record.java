package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Record {
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	private LocalDateTime datetime;
	private String name;
	private String contents;
	private String mood;
	
	public Record(String name, String contents, String mood) {
		super();
		this.name = name;
		this.contents = contents;
		this.mood = mood;
		this.datetime = LocalDateTime.now();
	}


	public String getDatetime() {
		return datetime.format(fmt);
	}

	public String getName() {
		if(name == null) {
			System.out.println("名前を入力してください");
		}
		return name;
	}
	

	public String getContents() {
		if(contents == null) {
			System.out.println("コメントを入力してください");
		}
		return contents.replaceAll("\n", "<br>");
	}
	public String getMood() {
		if(contents == null) {
			System.out.println("気分を入力してください");
		}
		return mood.replaceAll("\n", "<br>");
	}
	
	


	}
