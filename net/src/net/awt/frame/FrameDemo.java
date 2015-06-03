package net.awt.frame;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

public class FrameDemo {
	public static void main(String[] args) {
		/*
		 * [1] 컴포넌트의 생성
		 */
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// toolkit 객체 생성 >> new 아닌 메소드 리턴방식으로 객체 생성.
		Dimension dim = toolkit.getScreenSize();
		
		/*
		 * [2] 컴포넌트의 구체화
		 */
		frame.setLocation(dim.width/3, dim.height/3);
		// 전체 화면에서 절반,절반의 위치.
		// 특정 사이즈를 정하는 것보다 위에처럼 dim을 사용하면
		// 보여지는 화면에 따라 동적으로 적용되어 중앙부근에 위치하게 됨.
		frame.setVisible(true);
		
		
		
	}
}
