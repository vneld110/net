package net.swing;	

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LottoUI extends JFrame implements ActionListener{
	Lotto lotto;
	JButton btn;
	JPanel pan_nth,pan_sth;// �г��߿��� ����, ����
	ImageIcon icon;
	List<JButton>btns;
	
	public LottoUI() {
		init();
		/*
		 * ������ �ҽ��� �Ϻη� ������ �޼ҵ�� ó���ؼ�
		 * ����� ��ġ�� ������� ȣ����� ����� �����ϵ��� �ϴ� ��
		 * : �ڹٽ�ũ��Ʈ�� ȣ�̽�Ʈ���� ����.
		 */
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(btns.size()==0){
			makeBtns();
		}
		lotto.setLotto();
		showLotto();
	}
	private void showLotto() {
		int[] arr = lotto.getlotto();
		for(int i=0; i<arr.length; i++){
			btns.get(i).setIcon(getIcon(arr[i]));
		}
	}
	private void makeBtns() {
		JButton tmp = null;
		for(int i=0; i<6; i++){
			tmp = new JButton();
			btns.add(tmp);
			pan_sth.add(tmp);
		}
	}
	private Icon getIcon(int i){
		String imgPath ="src/images/"+Integer.toString(i)+".gif";
		// �̹��� ��θ� ���ϴ� ���� ����
		return new ImageIcon(imgPath);
	}
	private void init(){
		/*
		 * �����г� �����г� �����ؼ� �����ӿ� ����.
		 * ��ư���� �̺�Ʈ�� �Ҵ�.. 
		 * btn.addActionListener(this);
		 * ���� �гο� ��ư ����
		 * ���� �гο� BorderLayout���� ���ʿ� ��ġ.
		 * ���� �г��� ���ʿ� ��ġ.
		 * ������ ������� 1200,300�ȼ�
		 * x , y ��ǥ�� 300,400
		 * ������ ������� Ȯ��Ұ���.. �ٲ� �� ����
		 */
		setTitle("�ζǻ�����");
		lotto = new Lotto(); // ������ ����ϴ� Ŭ������ Lotto�� �����ڿ� ����.
		btns = new ArrayList<JButton>();
		pan_nth = new JPanel();
		pan_sth = new JPanel();
		btn = new JButton("������");
		/* 
		 * this �� LottoUI �� �ؾ��ϴ�
		 * AxtionListner�� �޼ҵ���
		 * actionPerformed(ActionEvent e) ��
		 * ��ư���� �ο��ϴ� ���̴�.
		*/
		btn.addActionListener(this);
		pan_nth.add(btn);
		add(BorderLayout.NORTH,pan_nth);
		add(BorderLayout.SOUTH,pan_sth);
		
		setBounds(300, 400, 1200, 300);
		setResizable(false);
		setVisible(true);
	}
	
}
