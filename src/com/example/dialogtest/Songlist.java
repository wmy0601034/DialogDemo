package com.example.dialogtest;

public class Songlist {
	private String coverUrl;
	private String songlistName;
	private int songcount;
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	public String getSonglistName() {
		return songlistName;
	}
	public void setSonglistName(String songlistName) {
		this.songlistName = songlistName;
	}
	public int getSongcount() {
		return songcount;
	}
	public void setSongcount(int songcount) {
		this.songcount = songcount;
	}
	public Songlist(String coverUrl, String songlistName, int songcount) {
		super();
		this.coverUrl = coverUrl;
		this.songlistName = songlistName;
		this.songcount = songcount;
	}
	
}
