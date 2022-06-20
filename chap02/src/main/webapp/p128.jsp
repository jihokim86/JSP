<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
	<style>
	
        label{
            display: inline-block;
            width: 120px;
        }
   
	</style>
	
</head>
<body>
	<div id="#" >
	<form action="p128Servlet" method="get">
	<fieldset>
	 <label>이름</label>
	 <input type="text" name="name" id="username"><br>
	 
	 <label>주민등록번호</label>
	 <input type="text" name="number" id="usernumber1">&nbsp;&nbsp;-&nbsp;&nbsp;<input type="text" name="number" id="usernumber2"><br>
	 
	 <label>아이디</label>
	 <input type="text" name="id" id="userid"><br>
	 
	 <label>비밀번호</label>
	 <input type="password" name="password1" id="userpassword1"><br>
	 
	 <label>비밀번호&nbsp;확인</label>
	 <input type="password" name="password2" id="userpassword2"><br>
	 
	 <label>이메일</label>
	 <input type="email" name="eamil1" id="useremail1">&nbsp;@&nbsp;
	 <input type="email" name="eamil2" id="useremail2">
	 <select name="eamil3" id="useremail3" size="1">
	 	<option value="">선택하세요</option>
	 	<option value="naver.com">naver.com</option>
	 	<option value="nate.com">nate.com</option>
	 </select><br>
	 
	 <label>우편번호</label>
	 <input type="text" name="zipcode" id="userzipcode" ><br>
	 
	 <label>주소</label>
	 <input type="text" name="useradress1" id="adress" >&nbsp;&nbsp;<input type="text" name="useradress2" id="adress" ><br>
	 
	 <label>핸드폰번호</label>
	 <input type="text" name="zipcode" id="userzipcode" ><br>
	 
	 <label>직업</label>
	 <select name="job" id="userjob" size="1">
	 	<option value="">선택하세요</option>
	 	<option value="학생">학생</option>
	 	<option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
	 	<option value="언론">언론</option>
	 	<option value="공무원">공무원</option>
	 	<option value="군인">군인</option>
	 	<option value="서비스업">서비스업</option>
	 	<option value="교육">교육</option>
	 </select>
	 </fieldset>
	</form>
	</div>
	<input type="submit" value="전송">
	
	  
</body>
</html>