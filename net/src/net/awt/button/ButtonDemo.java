package net.awt.button;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;

public class ButtonDemo {
public static void main(String[] args) {
	/*
	 * [1] 컴포넌트의 생성
	 */
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		
		Button button = new Button("확인");
		button.setSize(100, 100);
		button.setLocation(100, 75);
		/*
		 * [2] 컴포넌트의 조립 
		 */
		frame.setLayout(null);
		frame.add(button);
		/*
		 * [3] 컴포넌트 보여주기
		 */
		frame.setLocation(dim.width/3, dim.height/3);
		frame.setVisible(true);
		
	}
}
