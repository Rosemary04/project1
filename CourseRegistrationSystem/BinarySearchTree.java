class BinarySearchTree {
    Node root;

    BinarySearchTree() { 
        root = null; 
    }

    void insert(Course course) {
        root = insertRec(root, course);
    }

    Node insertRec(Node root, Course course) {
        if (root == null) {
            root = new Node(course);
            return root;
        }
        if (course.courseId < root.course.courseId) {
            root.left = insertRec(root.left, course);
        } else if (course.courseId > root.course.courseId) {
            root.right = insertRec(root.right, course);
        }
        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println("Course ID: " + root.course.courseId + ", Name: " + root.course.courseName + ", Credits: " + root.course.credits);
            inorderRec(root.right);
        }
    }

    Node search(Node root, int courseId) {
        if (root == null || root.course.courseId == courseId)
            return root;
        if (root.course.courseId > courseId)
            return search(root.left, courseId);
        return search(root.right, courseId);
    }

    void deleteCourse(int courseId) {
        root = deleteRec(root, courseId);
    }

    Node deleteRec(Node root, int courseId) {
        if (root == null) return root;

        if (courseId < root.course.courseId)
            root.left = deleteRec(root.left, courseId);
        else if (courseId > root.course.courseId)
            root.right = deleteRec(root.right, courseId);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.course = minValue(root.right).course;
            root.right = deleteRec(root.right, root.course.courseId);
        }

        return root;
    }

    Node minValue(Node root) {
        Node minv = root;
        while (root.left != null) {
            minv = root.left;
            root = root.left;
        }
        return minv;
    }
}
