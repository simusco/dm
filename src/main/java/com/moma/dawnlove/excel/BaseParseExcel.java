package com.moma.dawnlove.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class BaseParseExcel<T> implements ParseExcel<T> {

	private HSSFWorkbook hssfWorkbook;
	private ParseRowMapper<T> rowMapper;

	public BaseParseExcel(ParseRowMapper<T> rowMapper){
		this.rowMapper = rowMapper;
	}
	
	public List<T> parse(InputStream is, MessageCollector collector, Map<String, Object> params) {

		List<T> list = new ArrayList<T>();
		try {
			hssfWorkbook = new HSSFWorkbook(is);
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

			if(hssfSheet == null){
				collector.add("没有表单!");
				return null;
			}
			
			for(int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++){
		        HSSFRow hssfRow = hssfSheet.getRow( rowNum);
		        if(!isLastRow(hssfRow)){
		        	T o = (T) rowMapper.parse(hssfRow, collector, params);
		        	list.add(o);
		        }
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			collector.add("错误:"+e.getMessage());
		}
		
		return list;
	}

	protected boolean isLastRow(HSSFRow hssfRow) {
		return false;
	}

}
