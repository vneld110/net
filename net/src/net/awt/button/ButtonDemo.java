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
	 * [1] ������Ʈ�� ����
	 */
		Frame frame = new Frame("�޸���");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		
		Button button = new Button("Ȯ��");
		button.setSize(100, 100);
		button.setLocation(100, 75);
		/*
		 * [2] ������Ʈ�� ���� 
		 */
		frame.setLayout(null);
		frame.add(button);
		/*
		 * [3] ������Ʈ �����ֱ�
		 */
		frame.setLocation(dim.width/3, dim.height/3);
		frame.setVisible(true);
		
	}
}
