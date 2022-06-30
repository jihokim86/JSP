<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<script type = "text/javascript" src="script/member.js"></script> <!-- 유효성검사를 위한 js -->
</head>
<body>
   <h2>로그인</h2>
   <form action="login.do" method="post" name="frm"> <!-- submit할때 post 방식으로login.do로 이동 frm은 js경로때문에 필요함 -->
      <table>
         <tr>
            <td>아이디</td>
            <td><input type="text" name="userid" value="${userid}"></td> <!-- value="${userid}"  어떻게 연결되지?-->
         </tr>
                  <tr>
            <td>암 호</td>
            <td><input type="password" name="pwd" ></td>
         </tr>
         <tr>
            <td colspan="2" align = "center">					
            													
               <input type = "submit" value="로그인" onclick = "return loginCheck()">&nbsp;&nbsp; 
               <!-- loginCheck()가 false를 리턴하면 양식이 제출되지 않음 -->
               <!-- return이 없으면 submit함수가 작업을 수행하며 반환된 결과가 참/거짓에 관계없이 다음 지정된 페이지로 리디렉션 -->
               <!-- 리턴이 없으면 submit이 작동하여 loginservlet으로 이동하여 "존재하지 않는 회원입니다 출력 -->"
               <input type = "reset" value="취소" onclick = "return loginCheck()">&nbsp;&nbsp;
               <input type = "button" value="회원 가입" onclick = "location.href='join.do'">
            </td>
         </tr>
         <tr><td colspan ="2">${message}</td></tr>
      </table>
   </form>
</body>
</html>