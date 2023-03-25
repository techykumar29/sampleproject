package demo;

public class StudentProxy extends Student{

	public StudentProxy(String name, Attendance attendance) {
		super(name, attendance);
	}

	@Override
	public void attendLession() {
		if(super.getAttendance().isPresent()) {
			super.attendLession();
		}else {
			throw new RuntimeException(super.getName() + " is not present.");
		}
		
	}
	
	

}
