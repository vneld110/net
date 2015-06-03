package net.awt.frame;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

public class FrameDemo {
	public static void main(String[] args) {
		/*
		 * [1] ������Ʈ�� ����
		 */
		Frame frame = new Frame("�޸���");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// toolkit ��ü ���� >> new �ƴ� �޼ҵ� ���Ϲ������ ��ü ����.
		Dimension dim = toolkit.getScreenSize();
		
		/*
		 * [2] ������Ʈ�� ��üȭ
		 */
		frame.setLocation(dim.width/3, dim.height/3);
		// ��ü ȭ�鿡�� ����,������ ��ġ.
		// Ư�� ����� ���ϴ� �ͺ��� ����ó�� dim�� ����ϸ�
		// �������� ȭ�鿡 ���� �������� ����Ǿ� �߾Ӻαٿ� ��ġ�ϰ� ��.
		frame.setVisible(true);
		
		
		
	}
}
