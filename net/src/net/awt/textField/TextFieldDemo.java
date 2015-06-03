package net.awt.textField;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

public class TextFieldDemo {
	public static void main(String[] args) {
		/*
		 * [1] 컴포넌트의 생성
		 */
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// toolkit 객체 생성 >> new 아닌 메소드 리턴방식으로 객체 생성.
		Dimension dim = toolkit.getScreenSize();
		
		Label labId = new Label(" ID :");
		labId.setBounds(50, 50, 30, 10);// 50,50 은 위치, 30,10 은 가로 세로
		Label labPwd = new Label(" Password :");
		labPwd.setBounds(50, 65, 100, 10);
		
		TextField txtId = new TextField(10); // 10글자를 입력할 수 있는 공간.
		TextField txtPwd = new TextField(10);
		txtPwd.setEchoChar('*'); // 내부가 char 타입이라 ''
		
		frame.setLayout(new FlowLayout());
		frame.add(labId);
		frame.add(txtId);
		frame.add(labPwd);
		frame.add(txtPwd);
		
		
		// [3] 컴포넌트의 구체화
	
		frame.setLocation(dim.width/3, dim.height/3);
		frame.setVisible(true);
	}
}
