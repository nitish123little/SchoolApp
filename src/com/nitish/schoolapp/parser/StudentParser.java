package com.nitish.schoolapp.parser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.nitish.schoolapp.bean.StudentBean;

import com.opencsv.*;

public class StudentParser {

	public static void main(String[] args) throws IOException {
		
		List<StudentBean> temp =parseStudentInformation(); 
		
		System.out.println(temp);

	}
	
	private static List<StudentBean> parseStudentInformation() throws IOException
	{
		@SuppressWarnings("deprecation")
		
		CSVReader student = new CSVReader(new FileReader("student.csv"),',');
		
		List<StudentBean> studentBean = new ArrayList<StudentBean>();
		
		// reading all the records at once
		List<String[]> records = student.readAll();
		
		Iterator<String[]> iterator = records.iterator();
		
		// ignore the header
		
		iterator.next();
		
		while(iterator.hasNext())
		{
			String[] record = iterator.next();
			StudentBean tempBean = new StudentBean();
			
			tempBean.setFirstName(record[0]);
			tempBean.setMiddleName(record[1]);
			tempBean.setLastName(record[2]);
			tempBean.setAge(record[3]);// need automation
			tempBean.setDob(record[4]);
			tempBean.setHeight(record[5]);
			tempBean.setWeight(record[6]);
			tempBean.setRollNo(record[7]);
			tempBean.setStudentID(record[8]);// needs automation
			
			studentBean.add(tempBean);
		}
		
		student.close();
		
		return studentBean;
		
	}

}
