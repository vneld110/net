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
		 * [1] 컴포넌트의 생성
		 */
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		MenuBar menuBar = new MenuBar();
		Menu menuFile = new Menu("File");// 메뉴에 File이라고 나타남.
		
		MenuItem itemNew = new MenuItem("New");
		MenuItem itemOpen = new MenuItem("Open");
		Menu subMenu = new Menu("Others");
		MenuItem itemExit = new MenuItem("Exit");
		
		MenuItem subMenuPrint = new MenuItem("Print");
		MenuItem subMenuPreview = new MenuItem("Preview");
		MenuItem subMenuSetup = new MenuItem("PrintSetup");
		
		// [2] 컴포넌트 조립
		subMenu.add(subMenuPrint);
		subMenu.add(subMenuPreview);
		subMenu.add(subMenuSetup);

		Menu menuEdit = new Menu("Edit");
		Menu menuView = new Menu("View");
		Menu menuHelp = new Menu("Help");
		
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(subMenu);
		menuFile.addSeparator();// 메뉴에서 분리선
		menuFile.add(itemExit);
		
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuView);
		menuBar.add(menuHelp);
		//menuBar.setHelpMenu(menuHelp);
		
		frame.setMenuBar(menuBar);
		
		/*
		 * [2] 컴포넌트의 구체화
		 */
		frame.setLocation(dim.width/3, dim.height/3);
		frame.setVisible(true);
		
	}
}
