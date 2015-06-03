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
	JPanel pan_nth,pan_sth;// 패널중에서 북쪽, 남쪽
	ImageIcon icon;
	List<JButton>btns;
	
	public LottoUI() {
		init();
		/*
		 * 복잡한 소스를 하부로 보내고 메소드로 처리해서
		 * 선언된 위치에 관계없이 호출로의 기능을 수행하도록 하는 것
		 * : 자바스크립트의 호이스트같은 개념.
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
		// 이미지 경로를 구하는 것은 직접
		return new ImageIcon(imgPath);
	}
	private void init(){
		/*
		 * 북쪽패널 남쪽패널 생성해서 프레임에 붙임.
		 * 버튼에는 이벤트를 할당.. 
		 * btn.addActionListener(this);
		 * 북쪽 패널에 버튼 붙임
		 * 북쪽 패널에 BorderLayout에서 북쪽에 배치.
		 * 남쪽 패널은 남쪽에 배치.
		 * 프레임 사이즈는 1200,300픽셀
		 * x , y 좌표는 300,400
		 * 프레임 사이즈는 확장불가로.. 바꿀 수 없게
		 */
		setTitle("로또생성기");
		lotto = new Lotto(); // 로직을 담당하는 클래스인 Lotto를 생성자에 붙임.
		btns = new ArrayList<JButton>();
		pan_nth = new JPanel();
		pan_sth = new JPanel();
		btn = new JButton("생성기");
		/* 
		 * this 는 LottoUI 가 해야하는
		 * AxtionListner의 메소드인
		 * actionPerformed(ActionEvent e) 를
		 * 버튼에서 부여하는 것이다.
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
