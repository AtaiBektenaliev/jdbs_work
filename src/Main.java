import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int countOfStudents = main.getStudentsCount();

        System.out.println("Количество студентов равен: " + countOfStudents);

        System.out.println("Студенты с буквой а: " + main.getStudentsNameA());

        System.out.println("Общий средний балл стулентов: " + main.getAverageMark());

        System.out.println("Максимальный возраст среди студентов: " + main.getOlderStudent());

        System.out.println("Минимальный возраст среди студентов: " + main.getYoungerStudent());

        System.out.println("Общяя сумма стипендий студентов: " + main.getStudentsScholarship());
    }


    private final String URL = "jdbc:postgresql://localhost:5432/jdbs_work";
    private final String USER = "postgres";
    private final String PASSWORD = "postgres";


    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public int getStudentsCount() {
        String SQL = "SELECT count(*) FROM students";
        int count = 0;
        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }


    public int getStudentsNameA() {
        String SQL = "SELECT count(*) FROM students where name like '%a%'";
        int count = 0;
        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }


    public double getAverageMark() {
        String SQL = "SELECT AVG(average_mark) FROM students";
        double count = 0;
        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            count = rs.getDouble(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }


    public int getOlderStudent() {
        String SQL = "SELECT Max(age) FROM students";
        int count = 0;
        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }


    public int getYoungerStudent() {
        String SQL = "SELECT MIN(age) FROM students";
        int count = 0;
        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }


    public int getStudentsScholarship() {
        String SQL = "SELECT SUM(scholarship) FROM students";
        int count = 0;
        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
}