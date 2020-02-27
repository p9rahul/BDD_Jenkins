package com.DataBase.pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class DBCall {

	public static void main(String[] args) {

		DataBaseUtil dataBaseUtil = new DataBaseUtil();
		 dataBaseUtil.connectMariaDB();
		HashMap<String, String> data = dataBaseUtil.getResultSet("select * from topic");
		 System.out.println(data);
		 ArrayList<String> dataList = dataBaseUtil.getResultList("select * from topic");
		System.out.println(dataList);
		HashMap<String, ArrayList<String>> dataMap = dataBaseUtil.getMultipleResultData("select * from topic");
		for( Entry<String, ArrayList<String>> set :dataMap.entrySet())
		{
			System.out.println(set.getKey());
			System.out.println(set.getValue().get(0));
		}
		
		System.out.println(dataMap);
		
		dataBaseUtil.closeDB();
		
	}

}
