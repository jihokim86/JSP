package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 인터페이스의 목적
// 생각해보자!! 이 게시판의 성격이 1개의 servlet으로 모든걸 컨트롤 하려고 한다.
// 필요한게 무엇일까? 중요한건 "forward"를 어디서 주관할것인가? 이다.
// 이전에는 각각의 servlet에서 담당했었다. 지금은 1개의 servlet을 이용하고자 하니
// 각각의 view를 보여줄 모델(클래스)을 만들어야한다.
// 이 챕터에서는 커맨트패턴과 팩토리패턴이 사용했다.(작성자 마음임)

// 커맨드패턴
// 퀘리 스트링 방식 , 커맨드패턴 = 특정 이름(command)에 명령어 정보를 담아서 전달하여 각 명령어에 따른 로직을 처리하는 코드를 별로의 클래스로 작성하는 것
// controller는 "요청 파라미터"로 원하는 작업을 위한 명령을 전달하는 방식을 택함
// ex) BoardServlet?command=board_list
// https://k0102575.github.io/articles/2020-02/command-pattern

// 팩토리패턴
// 컨트롤러에서 직접 모델(액션객체,클래스)을 생성하지 않는 대신 액션객체(인터페이스를 구현하는 클래스)를 생성해 내는 팩토리 역활을 하는 클래스를 통해 생성
// 액션객체 : 인터페이스를 상속받아서 구현하는 클래스(객체)를 말함.
// 

// 각가의 view를 보여줄 모델(액션객체,클래스)를 생성해야하는데. 
// 각각의 기능별 jsp로 forward하기 위해서 각각의 액션객체를 생성해야하는데~ 결국 비슷한 기능을 하므로~
// 인터페이스를 만들고 액션객체에서 기능에 맞게 구현해서 사용하는 형식이다.
// 각각의 액션객체는 어떻게 구현하나? 팩토리패턴을 사용한다. command의 입력값에 따라 각기 다른 객체가 생성되는 패턴이다.

// 기존의 방법보다 이 방법의 장점은 무엇일까??
public interface Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
