package net.awt.label;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;

public class LabelDemo {
	public static void main(String[] args) {
		/*
		 * [1] 컴포넌트의 생성
		 */
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		Label labId = new Label(" ID :");
		labId.setBounds(50, 50, 30, 10);// 50,50 은 위치, 30,10 은 가로 세로
		Label labPwd = new Label(" Password :");
		labPwd.setBounds(50, 65, 100, 10);
		/*
		 * [2] 컴포넌트의 조립
		 */
		//frame.setLayout(new FlowLayout());
		frame.setLayout(null); // 레이아웃 지정하지 않고 좌표값대로 나타낼때 null.
		// LayoutManager 중에서 FlowLayout 사용
		frame.add(labId);
		frame.add(labPwd);
		
		/*
		 * [3] 컴포넌트의 구체화
		 */
		frame.setLocation(dim.width/3, dim.height/3);
		
		frame.setVisible(true);
		
	}
}
