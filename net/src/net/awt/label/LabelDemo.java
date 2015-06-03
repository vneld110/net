package net.awt.label;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;

public class LabelDemo {
	public static void main(String[] args) {
		/*
		 * [1] ������Ʈ�� ����
		 */
		Frame frame = new Frame("�޸���");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		Label labId = new Label(" ID :");
		labId.setBounds(50, 50, 30, 10);// 50,50 �� ��ġ, 30,10 �� ���� ����
		Label labPwd = new Label(" Password :");
		labPwd.setBounds(50, 65, 100, 10);
		/*
		 * [2] ������Ʈ�� ����
		 */
		//frame.setLayout(new FlowLayout());
		frame.setLayout(null); // ���̾ƿ� �������� �ʰ� ��ǥ����� ��Ÿ���� null.
		// LayoutManager �߿��� FlowLayout ���
		frame.add(labId);
		frame.add(labPwd);
		
		/*
		 * [3] ������Ʈ�� ��üȭ
		 */
		frame.setLocation(dim.width/3, dim.height/3);
		
		frame.setVisible(true);
		
	}
}
