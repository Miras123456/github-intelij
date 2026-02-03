package database;

import model.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public boolean insertMember(Member m) {
        String sql = "INSERT INTO member(name, age, membership_type) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.getName());
            ps.setInt(2, m.getAge());
            ps.setString(3, m.getMembershipType());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Member> getAllMembers() {
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM member";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Member(
                        rs.getInt("member_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("membership_type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Member getMemberById(int id) {
        String sql = "SELECT * FROM member WHERE member_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Member(
                        rs.getInt("member_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("membership_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateMember(int id, String newType) {
        String sql = "UPDATE member SET membership_type=? WHERE member_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newType);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMember(int id) {
        String sql = "DELETE FROM member WHERE member_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Member> searchByName(String name) {
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM member WHERE LOWER(name) LIKE LOWER(?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Member(
                        rs.getInt("member_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("membership_type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Member> searchByAgeRange(int min, int max) {
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM member WHERE age BETWEEN ? AND ? ORDER BY age DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, min);
            ps.setInt(2, max);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Member(
                        rs.getInt("member_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("membership_type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Member> searchByMinAge(int minAge) {
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM member WHERE age >= ? ORDER BY age DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, minAge);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Member(
                        rs.getInt("member_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("membership_type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
