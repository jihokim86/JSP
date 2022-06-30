package com.saeyan.dao;

import java.sql.Connection; // 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;

public class MemberDAO {
   private MemberDAO() {
   }

   private static MemberDAO instance = new MemberDAO();

   public static MemberDAO getInstance() {
      return instance;
   }

   public Connection getConnection() throws Exception {
      Connection conn = null;
      Context initContext = new InitialContext();
      Context envContext = (Context) initContext.lookup("java:/comp/env");
      DataSource ds = (DataSource) envContext.lookup("jdbc/oracle");
      conn = ds.getConnection();
      return conn;
   }

   // ����� ������ ����ϴ� �޼ҵ�
   public int userCheck(String userid, String pwd) {
      int result = -1;
      String sql = "select pwd from member where userid=?"; //pstmt.setString(1, userid);
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, userid);
         rs = pstmt.executeQuery();
         if (rs.next()) {
            if (rs.getString("pwd") != null && rs.getString("pwd").equals(pwd)) {
               result = 1;
            } else {
               result = 0;
            }
         } else {
            result = -1;
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (rs != null)
               rs.close();
            if (pstmt != null)
               pstmt.close();
            if (conn != null)
               conn.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      return result;
   }

   // ���̵�� ȸ�������� �������� �޼ҵ�
   public MemberVO getMember(String userid) {
      MemberVO mVo = null;
      String sql = "select * from member where userid =?";
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, userid);
         rs = pstmt.executeQuery();
         if (rs.next()) {
            mVo = new MemberVO();
            mVo.setName(rs.getString("name"));
            mVo.setUserid(rs.getString("userid"));
            mVo.setPwd(rs.getString("pwd"));
            mVo.setEmail(rs.getString("email"));
            mVo.setPhone(rs.getString("phone"));
            mVo.setAdmin(rs.getInt("admin"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (rs != null)
               rs.close();
            if (pstmt != null)
               pstmt.close();
            if (conn != null)
               conn.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      return mVo;
   }

   //�ߺ��Ǵ� ���� ����
   public int confirmID(String userid) {
      int result = -1;
      String sql = "select userid from member where userid=?";
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, userid);
         rs = pstmt.executeQuery();
         if (rs.next()) {
            result = 1;
         } else {
            result = -1;
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (rs != null)
               rs.close();
            if (pstmt != null)
               pstmt.close();
            if (conn != null)
               conn.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      return result;
   }

   //ȸ�� ������ DB�� �߰��ϱ� ���� �޼ҵ� �߰��ϱ�
   public int insertMember(MemberVO mVo) {
      int result = -1;
      String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
      Connection conn = null;
      PreparedStatement pstmt = null;
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mVo.getName());
         pstmt.setString(2, mVo.getUserid());
         pstmt.setString(3, mVo.getPwd());
         pstmt.setString(4, mVo.getEmail());
         pstmt.setString(5, mVo.getPhone());
         pstmt.setInt(6, mVo.getAdmin());
         result = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (pstmt != null)
               pstmt.close();
            if (conn != null)
               conn.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      return result;
   }
   
   public int updateMember(MemberVO mVo) {
      int result = -1;
      String sql = "update member set pwd=?, email=?," + "phone=?, admin=? where userid=?";
      Connection conn = null;
      PreparedStatement pstmt = null;
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mVo.getPwd());
         pstmt.setString(2, mVo.getEmail());
         pstmt.setString(3, mVo.getPhone());
         pstmt.setInt(4, mVo.getAdmin());
         pstmt.setString(5, mVo.getUserid());
         result = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (pstmt != null)
               pstmt.close();
            if (conn != null)
               conn.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      return result;
   }
   
}
