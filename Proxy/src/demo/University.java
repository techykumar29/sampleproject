package demo;

import java.lang.reflect.Proxy;
import java.util.Date;

public class University {

	public static void main(String[] args) {
		
		Attendance attendance = new Attendance(new Date(), false);
		Student s1 = new Student("Prabhakar Kumar", attendance);
		//s1.attendLession();
		
		StudentInvocationHandler stuInvocationHandler = new StudentInvocationHandler(s1);
		DailySession student = (DailySession)Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[] {DailySession.class}, stuInvocationHandler);
		
		student.attendLession();
		
		
		
	}
}
