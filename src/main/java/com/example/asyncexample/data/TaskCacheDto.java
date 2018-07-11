package com.example.asyncexample.data;

import java.util.List;

public class TaskCacheDto {

	private long size;
	private List<String> keys;
	
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public List<String> getKeys() {
		return keys;
	}
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	@Override
	public String toString() {
		return "TaskCacheDto [size=" + size + ", keys=" + keys + "]";
	}
	
}
