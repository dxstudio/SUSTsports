package modules;

public class SportsMan extends GenericUser {
	private String SportorId;
	private float Weight; //kg
	private float Height;
	private int Age;
	private int Grade;
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getGrade() {
		return Grade;
	}
	public void setGrade(int grade) {
		Grade = grade;
	}
	public float getHeight() {
		return Height;
	}
	public void setHeight(float height) {
		Height = height;
	}
	public String getSportorId() {
		return SportorId;
	}
	public void setSportorId(String sportorId) {
		SportorId = sportorId;
	}
	public float getWeight() {
		return Weight;
	}
	public void setWeight(float weight) {
		Weight = weight;
	}
	
}
