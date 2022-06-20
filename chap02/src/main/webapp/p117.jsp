<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿</title>
</head>
<body>
	<form method="get" action="p117_checkbox">
		<h2>악세서리</h2>
		<label>관심항목을 선택하세요.</label>
		<hr>
		<input type="checkbox" name="item" id="item" value="신발">신발
		<input type="checkbox" name="item" id="item" value="가방">가방
		<input type="checkbox" name="item" id="item" value="벨트">벨트
		<input type="checkbox" name="item" id="item" value="모자">모자
		<input type="checkbox" name="item" id="item" value="시계">시계
		<input type="checkbox" name="item" id="item" value="쥬얼리">쥬얼리
		<input type="submit" value="전송">
	</form>
</body>
</html>