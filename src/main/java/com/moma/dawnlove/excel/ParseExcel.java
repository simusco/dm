package com.moma.dawnlove.excel;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface ParseExcel<T> {

	public List<T> parse(InputStream is, MessageCollector collector, Map<String, Object> params);
	
}
