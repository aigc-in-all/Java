package designpatterns.mvc;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:40:26
 * @version V1.0
 */
public class MVCPatternDemo {
    public static void main(String[] args) {

        // fetch student record based on his roll no from the database
        Student model = retriveStudentFromDatabase();

        // Create a view : to write student details on console
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        // update model data
        controller.setStudentName("John");

        controller.updateView();
    }

    private static Student retriveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
