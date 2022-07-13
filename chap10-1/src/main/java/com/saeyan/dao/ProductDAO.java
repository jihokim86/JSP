package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;

import util.DBManager;

public class ProductDAO {
	  private ProductDAO() {
	   }

	   private static ProductDAO instance = new ProductDAO();

	   public static ProductDAO getInstance() {
	      return instance;
	   }
	   
	   //c Read u d
	   public List<ProductVO> selectAllProducts(){
		   //최근 등록한 상품 먼저 출력하기
		   String sql = "select * from product order by code desc";
		   List<ProductVO> list = new ArrayList<ProductVO>();
		   Connection conn = null;
		   PreparedStatement pstmt = null;   
		   ResultSet rs = null;
		   
		   try {
			   conn=DBManager.getConnection();
			   pstmt = conn.prepareStatement(sql);
			   rs = pstmt.executeQuery();
			   
			   while(rs.next()) {
				   ProductVO pVo = new ProductVO();
				   pVo.setCode(rs.getInt("code"));
				   pVo.setName(rs.getString("name"));
				   pVo.setPrice(rs.getInt("price"));
				   pVo.setPictureUrl(rs.getString("pictureUrl"));
				   pVo.setDescription(rs.getString("description"));
				   list.add(pVo);
			   }
		   } catch (Exception e) {
			   e.printStackTrace();
		   }finally {
			   DBManager.close(conn, pstmt, rs);
		   }
		   return list;
	   }
	   
	   
	   
	   //상품등록을 위한 메소드 추가하기
	   //Create r u d
	   public void insertProduct(ProductVO pVo) {
		   String sql = "insert into product values(product_seq.nextval,?,?,?,?)";
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureUrl());
			pstmt.setString(4, pVo.getDescription());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	   }
	   //상품 등록을 위한 메소드 추가하기
	   
	   public ProductVO selectProductByCode(String code) {
		   String sql = "select * from product where code=?";
		   
		   ProductVO pVo=null;
		   try {
			Connection conn =null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					pVo = new ProductVO();
					pVo.setCode(rs.getInt("code"));
					pVo.setName(rs.getString("name"));
					pVo.setPrice(rs.getInt("price"));
					pVo.setPictureUrl(rs.getString("pictureUrl"));
					pVo.setDescription(rs.getString("description"));
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		   return pVo;
	   }
	   
	   //상품정보 수정을 위한 메소드 추가
	   
	   public void updateProduct(ProductVO pVo) {
		   String sql = "update product set name=?,price=?,pictureUrl=?,description=? where code=?";
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureUrl());
			pstmt.setString(4, pVo.getDescription());
			pstmt.setInt(5, pVo.getCode());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	   }
	   
	   //삭제를 위한 메소드 추가하기
	   
	   public void deleteProduct(String code) {
		   String sql = "delete product where code=?";
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   
		   try {
			   conn = DBManager.getConnection();
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, code);
			   pstmt.executeUpdate();
		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
			   DBManager.close(conn, pstmt);
		   }
	   }
}//end of ProductDAO
