package net.awt.font;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;

public class FontDemo {
	public static void main(String[] args) {
		// [1] 컴포넌트의 생성
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
				
			
		Label labId = new Label(" Hello AWT ");
		labId.setBounds(50, 50, 30, 10);
		
		Font plain = new Font("Serif",Font.PLAIN,20);
		Font italic = new Font("Serif",Font.ITALIC,20);
		Font bold = new Font("Serif",Font.BOLD,20);
		Font boldItalic = new Font("Serif",Font.BOLD+Font.ITALIC,20);
		// [2] 컴포넌트 조립
		labId.setFont(boldItalic);
		frame.setLayout(new FlowLayout());
		frame.add(labId);
		
		// [3] 컴포넌트의 구체화
		frame.setLocation(dim.width/3, dim.height/3);
		frame.setVisible(true);
	}
}
