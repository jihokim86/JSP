<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>설문 조사</h2>
<form method="get" action="p186_research.jsp">
	<table>
		<tr>
		 <td>이름 :</td><td><input type="text" name="name" size="20"></td>
		</tr>
		
		<tr>
		 <td>성별 :</td>
		 <td>
		 <input type="radio" value="남자" name="gender" checked="checked">남자
		 <input type="radio" value="여자" name="gender">여자
		 </td>
		</tr>
		
		<tr>
			<td>좋아하는 계절:</td>
			<td>
			<input type="checkbox" name="seasom" value="1">봄
			<input type="checkbox" name="seasom" value="2">여름
			<input type="checkbox" name="seasom" value="3">가을
			<input type="checkbox" name="seasom" value="4">겨울
			</td>
		</tr>
		
		<tr align="center">
			<td><input type="submit" value="전송"></td>
			<td><input type="reset" value="취소"></td>
		</tr>
	</table>
</form>
</body>
</html>