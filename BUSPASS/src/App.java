import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("create table press 1");
        System.out.println("insert table press 2");
        System.out.println("update table press 3");
        System.out.println("delete table press 4");
        System.out.println("read table press 5");
        System.out.println("press other number");
        boolean flag = true;
        Database db = new Database();
        while (flag) {

            int num = sc.nextInt();

            if (num == 1) {
                db.createtable();
            } else if (num == 2) {
                System.out.println("id");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("name");
                String name = sc.nextLine();
                System.out.print("year ");
                int year = sc.nextInt();
                db.insert(id, name, year);
            } else if (num == 3) {
                System.out.println("id");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("name ");
                String name = sc.nextLine();
                sc.nextLine();
                db.update(id, name);
            } else if (num == 4) {
                System.out.println("id");
                int id = sc.nextInt();
                db.delete(id);
            } else if (num == 5) {
                db.read();
            } else {
                flag = false;
            }

        }
        sc.close();

    }
}
