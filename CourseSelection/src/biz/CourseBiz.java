package biz;

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
}
