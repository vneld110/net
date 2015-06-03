package net.awt.textArea;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.Toolkit;

public class TextAreaDemo {
	public static void main(String[] args) {
		// [1] ������Ʈ�� ����
		Frame frame = new Frame("�޸���");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		TextArea area = new TextArea("�����Է¶�..",20,50);
		area.selectAll(); // �Է��� ���� ��ü ���� > �Է��ϸ� ������.
		// [2] ������Ʈ ����
		
		frame.setLayout(new FlowLayout());
		frame.add(area);
		
		
		// [3] ������Ʈ�� ��üȭ
		frame.setLocation(dim.width/3, dim.height/3);
		frame.setVisible(true);
		
	}
}
