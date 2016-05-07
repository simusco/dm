package com.moma.dawnlove.excel;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;

public interface ParseRowMapper<T> {

	T parse(HSSFRow hssfRow, MessageCollector collector, Map<String, Object> params);

}
