package view;
import java.*;
import java.util.Scanner;
import biz.*;
public class CourseSelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginUI.show();
		//show();
	}
	/*
	 * ѡ�β���
	 */
	public static void show(String studentNo) {
		// TODO Auto-generated method stub
		SCBiz scbiz = new SCBiz();
		scbiz.judge(studentNo);
	}
	/*
	 * ��ӿγ̲���
	 */
	public static void addcourse(String studentNo) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������γ̺ţ�");
		String courseNo = scanner.nextLine();
		System.out.println("������γ����ƣ�");
		String courseName = scanner.nextLine();
		System.out.println("������ɼ���");
		int courseGrade = Integer.parseInt(scanner.nextLine());
		CourseBiz cb = new CourseBiz();
		cb.addCourse(studentNo,
				courseNo,
				courseName, 
				courseGrade);
	}

}
