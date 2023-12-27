package app;

public class Student {
    
    
    private String name;
    private int korean; // 국어점수
    private int math; // 수학점수 
    private int english; // 영어점수

    public Student(){}

    public Student(String name, int korean, int math, int english) {
        this.name = name;
        this.korean = korean;
        this.math = math;
        this.english = english;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getKorean() {
        return korean;
    }
    public void setKorean(int korean) {
        this.korean = korean;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public int getEnglish() {
        return english;
    }
    public void setEnglish(int english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", korean=" + korean + ", math=" + math + ", english=" + english + "]";
    }
}
