package net.awt.listener;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerDemo {
	public static void main(String[] args) {
		// [1] ������Ʈ�� ����
		Frame frame = new Frame("�޸���");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		// [2] ������Ʈ�� ��üȭ
		frame.setLocation(dim.width/3, dim.height/3);
		frame.addWindowListener(new EventHandler());
		// �̺�Ʈ�� ���ս�Ŵ
		frame.setVisible(true);
	}
}
class EventHandler implements WindowListener {

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		//TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// ������ �ݱ� ��ư�� Ŭ������ �� ȣ��
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0); // 0�� �Ƹ� ���ᰪ..
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
