import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nCourse Registration System:");
            System.out.println("1. Add Course");
            System.out.println("2. Search Course");
            System.out.println("3. Delete Course");
            System.out.println("4. Display Courses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Course ID: ");
                    int courseId = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Course Credits: ");
                    int credits = scanner.nextInt();
                    bst.insert(new Course(courseId, courseName, credits));
                    break;
                case 2:
                    System.out.print("Enter Course ID to search: ");
                    int searchId = scanner.nextInt();
                    Node result = bst.search(bst.root, searchId);
                    if (result != null) {
                        System.out.println("Course found: ID: " + result.course.courseId + ", Name: " + result.course.courseName + ", Credits: " + result.course.credits);
                    } else {
                        System.out.println("Course not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter Course ID to delete: ");
                    int deleteId = scanner.nextInt();
                    bst.deleteCourse(deleteId);
                    break;
                case 4:
                    System.out.println("Courses:");
                    bst.inorder();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}
