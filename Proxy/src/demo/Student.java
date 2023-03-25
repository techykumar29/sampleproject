package demo;

public class Student implements DailySession{
	
	private String name;
	private Attendance attendance;

	public Student(String name, Attendance attendance) {
		this.name = name;
		this.attendance = attendance;
	}
	

	public String getName() {
		return name;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	@Override
	public void attendLession() {
		System.out.println(name+" is present and attending the lessions");
		
	}
	
	
}
