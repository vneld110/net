package net.awt.panel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;

public class PanelDemo {
	public static void main(String[] args) {
		/*
		 * [1] ������Ʈ�� ����
		 */
		Frame frame = new Frame("�޸���");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();

		Panel panel = new Panel();
		
		panel.setBackground(Color.GREEN);
		panel.setSize(100,100);
		panel.setLocation(50, 50);
		
		Button ok = new Button("OK");
		/*
		 * [3] ������Ʈ�� ���� 
		 */
		panel.add(ok);
		frame.add(panel);
		/*
		 * [2] ������Ʈ�� ��üȭ
		 */
		
		frame.setLocation(dim.width/3, dim.height/3);
		frame.setVisible(true);
		
	}
}
