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
		super("ä�� : Ŭ���̾�Ʈ");
		connectPane(); // �޼ҵ�(���)�� �����, �Ӽ��� ����
		// card...
		cardPane = new JPanel();
		cardPane.setLayout(new CardLayout()); 
		//CardLayout��  LayoutManager �� tab�� ����� ���.
		cardPane.add(connectionPane,"����â");
		cardPane.add(chatPane,"ä��â");
		cardPane.add(cardPane,"����â");
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
		
		msg = new JLabel("IP�� ��ȭ���� �Է��Ͻÿ�.");
		msg.setFont(new Font("����ü",Font.BOLD,15));
		msg.setForeground(Color.PINK);
		
		JLabel lb1 = new JLabel("���� IP : ");
		txtServer = new JTextField("127.0.0.1",15);
		//127.0.0.1 = localhost �� �ڱ� ������ �ּ�
		panel1.add(lb1);
		panel1.add(txtServer);
		
		JLabel lb2 = new JLabel("��ȭ�� : ");
		txtName = new JTextField("hong",15);
		panel2.add(lb2);
		panel2.add(txtName);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(msg);
		
		btnConnect = new JButton("�� ��");
		connectionPane.setBorder(BorderFactory.createTitledBorder("����ä��ȭ��"));
		connectionPane.setLayout(new BorderLayout());
		connectionPane.add(btnConnect,"South");
		
		
	}
	public void chatPane(){
		chatPane = new JPanel();
		JPanel panel = new JPanel();
		txtList = new JTextArea();
		txtInput = new JTextField("",20);
		// "" �ؽ�Ʈ �ʵ带 ����ΰ� 20���� �Է�ĭ ����.
		btnSend = new JButton("�� ��");
		btnExit = new JButton("�� ��");
		
		panel.setBorder(BorderFactory.createTitledBorder("==��ȭ�ϱ�=="));
		chatPane.setBorder(BorderFactory.createTitledBorder("==ä�ó���=="));
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
			card.show(cardPane, "ä��â");
			ipTxt = txtServer.getText();
			/*
			 * �� Ŭ���� WsingChatClient�� Runnable�� ����(implements) �Ͽ����Ƿ�
			 * �������̽��� ������ Ŭ���� ��ü�� Thread �������� �Ķ���ͷ�
			 * �����Ѵٴ� ������ ���� this�� �־���. 
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
		txtInput.setText("");//��ǲâ�� ���� ����� �ʱ�ȭ.
		txtInput.requestFocus();// �Է�â�� ���� ���, Ŀ���� ��������
		pw.println();// pw�� PrintWriter �� ��ü�� ȭ�鿡 ���ڸ� �ѷ���.
		pw.flush();// ������ : pw ���� �������ִ� �����͸� ���� �����϶�� ��
	}

}
