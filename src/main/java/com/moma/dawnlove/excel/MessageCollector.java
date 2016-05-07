package com.moma.dawnlove.excel;

import java.util.List;

public interface MessageCollector {

	public void add(String String);
	
	public void add(Integer row, Integer column, String message);
	
	public boolean has();

	public List<String> get();
	
}
