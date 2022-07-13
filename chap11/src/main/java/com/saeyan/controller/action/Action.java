package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// �������̽��� ����
// �����غ���!! �� �Խ����� ������ 1���� servlet���� ���� ��Ʈ�� �Ϸ��� �Ѵ�.
// �ʿ��Ѱ� �����ϱ�? �߿��Ѱ� "forward"�� ��� �ְ��Ұ��ΰ�? �̴�.
// �������� ������ servlet���� ����߾���. ������ 1���� servlet�� �̿��ϰ��� �ϴ�
// ������ view�� ������ ��(Ŭ����)�� �������Ѵ�.
// �� é�Ϳ����� Ŀ��Ʈ���ϰ� ���丮������ ����ߴ�.(�ۼ��� ������)

// Ŀ�ǵ�����
// ���� ��Ʈ�� ��� , Ŀ�ǵ����� = Ư�� �̸�(command)�� ��ɾ� ������ ��Ƽ� �����Ͽ� �� ��ɾ ���� ������ ó���ϴ� �ڵ带 ������ Ŭ������ �ۼ��ϴ� ��
// controller�� "��û �Ķ����"�� ���ϴ� �۾��� ���� ����� �����ϴ� ����� ����
// ex) BoardServlet?command=board_list
// https://k0102575.github.io/articles/2020-02/command-pattern

// ���丮����
// ��Ʈ�ѷ����� ���� ��(�׼ǰ�ü,Ŭ����)�� �������� �ʴ� ��� �׼ǰ�ü(�������̽��� �����ϴ� Ŭ����)�� ������ ���� ���丮 ��Ȱ�� �ϴ� Ŭ������ ���� ����
// �׼ǰ�ü : �������̽��� ��ӹ޾Ƽ� �����ϴ� Ŭ����(��ü)�� ����.
// 

// ������ view�� ������ ��(�׼ǰ�ü,Ŭ����)�� �����ؾ��ϴµ�. 
// ������ ��ɺ� jsp�� forward�ϱ� ���ؼ� ������ �׼ǰ�ü�� �����ؾ��ϴµ�~ �ᱹ ����� ����� �ϹǷ�~
// �������̽��� ����� �׼ǰ�ü���� ��ɿ� �°� �����ؼ� ����ϴ� �����̴�.
// ������ �׼ǰ�ü�� ��� �����ϳ�? ���丮������ ����Ѵ�. command�� �Է°��� ���� ���� �ٸ� ��ü�� �����Ǵ� �����̴�.

// ������ ������� �� ����� ������ �����ϱ�??
public interface Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
