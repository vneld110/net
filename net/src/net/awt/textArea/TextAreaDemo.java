package net.awt.textArea;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.Toolkit;

public class TextAreaDemo {
	public static void main(String[] args) {
		// [1] 컴포넌트의 생성
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		TextArea area = new TextArea("글자입력란..",20,50);
		area.selectAll(); // 입력한 글자 전체 선택 > 입력하면 지워짐.
		// [2] 컴포넌트 결합
		
		frame.setLayout(new FlowLayout());
		frame.add(area);
		
		
		// [3] 컴포넌트의 구체화
		frame.setLocation(dim.width/3, dim.height/3);
		frame.setVisible(true);
		
	}
}
