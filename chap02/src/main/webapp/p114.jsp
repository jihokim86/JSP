<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="p114_RadioServlet">
		<label>성별 :</label>
		<input type="radio" name="gender" id="gender" value="남자" checked>남자
		<input type="radio" name="gender" id="gender" value="여자">여자
		<br>
		<label>메일 정보 수진 여부 :</label>
		<input type="radio" name="chk_mail" id="chk_mail" value="yes" checked>수신
		<input type="radio" name="chk_mail" id="chk_mail" value="no">거부
		<br>
		<label>간단한 가입 인사를 적어주세요.</label>
		<br>
		<textarea name="content" id="content" rows="3" cols="35"></textarea>
		<br>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>