package net.awt.menu;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;

public class MenuDemo {
	public static void main(String[] args) {
		/*
		 * [1] ������Ʈ�� ����
		 */
		Frame frame = new Frame("�޸���");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		MenuBar menuBar = new MenuBar();
		Menu menuFile = new Menu("File");// �޴��� File�̶�� ��Ÿ��.
		
		MenuItem itemNew = new MenuItem("New");
		MenuItem itemOpen = new MenuItem("Open");
		Menu subMenu = new Menu("Others");
		MenuItem itemExit = new MenuItem("Exit");
		
		MenuItem subMenuPrint = new MenuItem("Print");
		MenuItem subMenuPreview = new MenuItem("Preview");
		MenuItem subMenuSetup = new MenuItem("PrintSetup");
		
		// [2] ������Ʈ ����
		subMenu.add(subMenuPrint);
		subMenu.add(subMenuPreview);
		subMenu.add(subMenuSetup);

		Menu menuEdit = new Menu("Edit");
		Menu menuView = new Menu("View");
		Menu menuHelp = new Menu("Help");
		
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(subMenu);
		menuFile.addSeparator();// �޴����� �и���
		menuFile.add(itemExit);
		
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuView);
		menuBar.add(menuHelp);
		//menuBar.setHelpMenu(menuHelp);
		
		frame.setMenuBar(menuBar);
		
		/*
		 * [2] ������Ʈ�� ��üȭ
		 */
		frame.setLocation(dim.width/3, dim.height/3);
		frame.setVisible(true);
		
	}
}
