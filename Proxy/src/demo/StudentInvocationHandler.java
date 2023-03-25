package demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudentInvocationHandler implements InvocationHandler{
	
	Student student;
	
	public StudentInvocationHandler(Student student) {
		this.student = student;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		if(student.getAttendance().isPresent()) {
			method.invoke(student, args);
		}else {
			throw new RuntimeException(student.getName() + "is not present.");
		}
		return null;
	}

}
