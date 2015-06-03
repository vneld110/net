package net.socket;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingChatClient extends JFrame implements ActionListener, Runnable {
	JPanel cardPane, connectionPane, chatPane;
	JLabel msg;
	JButton btnConnect, btnSend, btnExit;
	JTextField txtServer, txtName, txtInput;
	JTextArea txtList;
	CardLayout card;
	
	String ipTxt;
	Socket socket;
	final int PORT = 7500;
	PrintWriter pw = null;
	BufferedReader in = null;
	OutputStream os = null;
	
	public SwingChatClient(){
		super("채팅 : 클라이언트");
		connectPane(); // 메소드(기능)는 동사로, 속성은 명사로
		// card...
		cardPane = new JPanel();
		cardPane.setLayout(new CardLayout()); 
		//CardLayout은  LayoutManager 중 tab과 비슷한 기능.
		cardPane.add(connectionPane,"접속창");
		cardPane.add(chatPane,"채팅창");
		cardPane.add(cardPane,"접속창");
		//-------card
		
		add(cardPane);
		setBounds(200,200,400,300);
		setVisible(true);
		
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		btnConnect.addActionListener(this);
		btnExit.addActionListener(this);
		btnSend.addActionListener(this);
		txtInput.addActionListener(this);
		
	}
	
	private void connectPane() {
		connectionPane = new JPanel();
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		msg = new JLabel("IP와 대화명을 입력하시오.");
		msg.setFont(new Font("굴림체",Font.BOLD,15));
		msg.setForeground(Color.PINK);
		
		JLabel lb1 = new JLabel("서버 IP : ");
		txtServer = new JTextField("127.0.0.1",15);
		//127.0.0.1 = localhost 로 자기 아이피 주소
		panel1.add(lb1);
		panel1.add(txtServer);
		
		JLabel lb2 = new JLabel("대화명 : ");
		txtName = new JTextField("hong",15);
		panel2.add(lb2);
		panel2.add(txtName);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(msg);
		
		btnConnect = new JButton("연 결");
		connectionPane.setBorder(BorderFactory.createTitledBorder("다음채팅화면"));
		connectionPane.setLayout(new BorderLayout());
		connectionPane.add(btnConnect,"South");
		
		
	}
	public void chatPane(){
		chatPane = new JPanel();
		JPanel panel = new JPanel();
		txtList = new JTextArea();
		txtInput = new JTextField("",20);
		// "" 텍스트 필드를 비워두고 20글자 입력칸 생성.
		btnSend = new JButton("전 송");
		btnExit = new JButton("종 료");
		
		panel.setBorder(BorderFactory.createTitledBorder("==대화하기=="));
		chatPane.setBorder(BorderFactory.createTitledBorder("==채팅내용=="));
		panel.add(txtInput);
		panel.add(btnSend);
		panel.add(btnExit);
		
		chatPane.setLayout(new BorderLayout());
		chatPane.add(txtList,"Center");
		chatPane.add(panel, "South");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btnConnect){
			card.show(cardPane, "채팅창");
			ipTxt = txtServer.getText();
			/*
			 * 이 클래스 WsingChatClient가 Runnable을 구현(implements) 하였으므로
			 * 인터페이스를 구현한 클래스 객체를 Thread 생성자의 파라미터로
			 * 전달한다는 문법에 따라 this로 주었다. 
			 */
			Thread thr = new Thread(this);
			thr.start();
		}
		if(obj==btnSend){
			send();
		}
		if(obj==txtInput){
			send();
		}
		if(obj==btnExit){
			System.exit(0);
		}
		
	}

	private void send() {
		String text = txtInput.getText();
		txtList.append(text+"\n");
		txtInput.setText("");//인풋창의 글자 지우고 초기화.
		txtInput.requestFocus();// 입력창에 글자 없어서, 커서만 깜빡깜빡
		pw.println();// pw는 PrintWriter 의 객체로 화면에 글자를 뿌려라.
		pw.flush();// 물내림 : pw 에게 가지고있는 데이터를 전부 삭제하라는 뜻
	}

}
