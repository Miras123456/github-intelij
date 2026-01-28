package database;

import model.Member;
import java.sql.*;

public class MemberDAO {

    public void insertMember(Member member) {
        String sql = "INSERT INTO member(name, age, membership_type) VALUES (?, ?, ?)";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, member.getName());
            ps.setInt(2, member.getAge());
            ps.setString(3, member.getMembershipType());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Member saved to DB ✅");

            ps.close();
        } catch (SQLException e) {
            System.out.println("Insert failed ❌");
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }
    }

    public void getAllMembers() {
        String sql = "SELECT * FROM member";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- MEMBERS FROM DATABASE ---");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("member_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Membership: " + rs.getString("membership_type"));
                System.out.println("---------------------");
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Select failed ❌");
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }
    }
}
