package biz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import java.util.Scanner;

import dao.CourseDao;
import dao.SCDao;
import dao.StudentDao;
import entity.Course;
import entity.SC;
import entity.Student;
import view.MainUI;

public class SCBiz {
	static StudentDao studentDao;
	static CourseDao coursedao;
	static SCDao scDao;
	private SC sc;
	private static Student student;
	private ArrayList<String> al;
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void judge(String studentNo){
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);

			System.out.println("1-ѡ�Σ�2-��ѡ��3-��ѡ�γ�����鿴��0-����������");
			System.out.println("���������ѡ��");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();
			if("1".equals(s) || "2".equals(s)) {
			switch (s) {
			case "1": //ѡ�β���
			   CourseBiz.selection(studentNo);
			   break;
			case "2": //��ѡ����
				CourseBiz.exitRace(studentNo);
			}
		  }else if("3".equals(s)) {   //3-��ѡ�γ�����鿴
			  File file = new File("sc1.txt"); 
			  CourseBiz.getTxt(file,studentNo);
		  }else if("0".equals(s)) {
			  MainUI.show(studentNo); 
		  }
	}
}
