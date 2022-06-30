package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//���⸦ �ٲ��ָ� �ٿ�޴� ��ΰ� �ٲ�
		String savePath = "upload";
		//�ִ� ���ε� ���� ũ�� 5MB�� ����
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "utf-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("�������� ���� ���丮");
		System.out.println(uploadFilePath);
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, 
					uploadFilePath,
					uploadFileSizeLimit,
					encType,
					new DefaultFileRenamePolicy());
			
			String fileName = multi.getFilesystemName("uploadFile");
			
			if(fileName == null) {
				System.out.println("���� ���ε� ���� �ʾ���");
			}else {
				out.println("<br>�۾��� : "+multi.getParameter("name"));
				out.println("<br>��&nbsp;�� : "+multi.getParameter("title"));
				out.println("<br>���ϸ� : "+fileName);
			}
		} catch (Exception e) {
			System.out.print("���� �߻�"+e);
		}
	
	}

}
