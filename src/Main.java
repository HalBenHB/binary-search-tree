import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Tree BST1 = new Tree(); // for ID
        Tree BST2 = new Tree(); // for the combination of Name and Surname

        String csvFile = "random_data.csv"; // Replace with the path to your large CSV file
        // List<Student> students = new ArrayList<>();

        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // Skip the header

            while ((line = br.readLine()) != null) {

                String[] fields = line.split(","); // Split lines by comma

                int id = Integer.parseInt(fields[0].trim());
                String name = fields[1].trim();
                String surname = fields[2].trim();
                int age = Integer.parseInt(fields[3].trim());
                double gpa = Double.parseDouble(fields[4].trim());

                Student student = new Student(id, name, surname, age, gpa);

                // students.add(student);

                BST1.iterativeInsert(new TreeNode(student.getID()));
                BST2.iterativeInsert(new TreeNode(student.getSurnameandName()));
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Delete
        BST1.delete2(456122);
        BST2.delete2("Harris Joel Williams");

        // Search
        int eSearchInt=966224;
        System.out.println("Exact Search result for " + eSearchInt + " is : " + BST1.exactSearch(eSearchInt).getData());

        eSearchInt=31;
        System.out.println("Exact Search result for " + eSearchInt + " is : " + BST1.exactSearch(eSearchInt).getData());

        String eSearchStr="Henry Amy Adams";
        System.out.println("Exact Search result for " + eSearchStr + " is : " + BST2.exactSearch(eSearchStr).getData());

        eSearchStr="Barış Manço";
        System.out.println("Exact Search result for " + eSearchStr + " is : " + BST2.exactSearch(eSearchStr).getData());


        int iSearchLower=797774;
        int iSearchUpper=797781;


        System.out.println("Interval Search results between " + iSearchLower + " and " + iSearchUpper + ":");
        for (TreeNode treeNode : BST1.intervalSearch(iSearchLower, iSearchUpper)) {
            System.out.println("Data: " + treeNode.getData());
        }


        iSearchLower=999871;
        iSearchUpper=999999;

        System.out.println("Interval Search results between " + iSearchLower + " and " + iSearchUpper + ":");
        for (TreeNode treeNode : BST1.intervalSearch(iSearchLower, iSearchUpper)) {
            System.out.println("Data: " + treeNode.getData());
        }

        iSearchLower=314107;
        iSearchUpper=314110;

        System.out.println("Interval Search results between " + iSearchLower + " and " + iSearchUpper + ":");
        for (TreeNode treeNode : BST1.intervalSearch(iSearchLower, iSearchUpper)) {
            System.out.println("Data: " + treeNode.getData());
        }

        String iSearchLowerString="Johnson Chris Garrett";
        String iSearchUpperString="Johnson Christine Tate";

        System.out.println("Interval Search results between " + iSearchLowerString + " and " + iSearchUpperString + ":");
        for (TreeNode treeNode : BST2.intervalSearch(iSearchLowerString, iSearchUpperString)) {
            System.out.println("Names: " + treeNode.getData());
        }

        iSearchLowerString="Richardson David Cox";
        iSearchUpperString="Richardson David Moore";

        System.out.println("Interval Search results between " + iSearchLowerString + " and " + iSearchUpperString + ":");
        for (TreeNode treeNode : BST2.intervalSearch(iSearchLowerString, iSearchUpperString)) {
            System.out.println("Names: " + treeNode.getData());
        }

        iSearchLowerString="Zuniga Arash";
        iSearchUpperString="Zuniga Arda";

        System.out.println("Interval Search results between " + iSearchLowerString + " and " + iSearchUpperString + ":");
        for (TreeNode treeNode : BST2.intervalSearch(iSearchLowerString, iSearchUpperString)) {
            System.out.println("Names: " + treeNode.getData());
        }
    }
}