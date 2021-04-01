package biz;

import java.util.HashMap;
import java.util.Set;

import dao.*;
import entity.*;
import view.MainUI;

public class CourseBiz {	
	CourseDao courseDao;
	private Course course;
	
	public void addCourse(String studentNo,
			              String courseNo,
			              String courseName,  
			              int courseGrade) {
		course = new Course();
		course.setCourseNo(courseNo);     //���γ���Ϣ����
		course.setCourseName(courseName);
		course.setCourseGrade(courseGrade);
		courseDao = CourseDao.getInstance();
		courseDao.insert(course);
		System.out.println(course.getCourseName()+"�γ�ע��ɹ���");
		save();
		MainUI.show(studentNo);
	}
	private void save() {
		CourseDao dbutil = CourseDao.getInstance();
		dbutil.update();
	}
	public void showAllCourse() {
		// TODO Auto-generated method stub
		courseDao = (CourseDao)CourseDao.getInstance();
		HashMap<String, IEntity> courses=courseDao.getAllEntities();
		Set<String> courseSet=courses.keySet();
		System.out.println("�γ̺�	�γ���	 �γ�ѧ��");
	   	 for(String courseNo:courseSet) {
	   		course=(Course)courses.get(courseNo);
			System.out.println(course.getCourseNo()+":   "+
								course.getCourseName()+":   "+
								course.getCourseGrade());
	   	 }
	}
	public Course lookupCourse(String courseNo) {
		courseDao = (CourseDao)CourseDao.getInstance();
		HashMap<String, IEntity> courses = new HashMap<String, IEntity>();
		courses=courseDao.getAllEntities();
		course=(Course)courses.get(courseNo);
		if(course==null) {
			System.out.println("û������γ�");
		}else {
			System.out.println(course.getCourseNo()+course.getCourseName()+course.getCourseGrade());
		}
		return course;
	}
}
