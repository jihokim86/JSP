<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>단일 파일 업로드</title>
</head>
<body>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		글쓴이 : <input type="text" name="name"/><br>
		제&nbsp;목: <input type="text" name="title"/><br>
		파일저장하기: <input type="file" name="uploadFile"/><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>