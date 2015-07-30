package designpatterns.mvc;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:39:51
 * @version V1.0
 */
public class StudentView {
    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}
