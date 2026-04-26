package event;  //パッケージは任意

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		//オーバーライドする 
		//WEBアプリケーションの開始直後に 
		//サーブレットコンテナから呼び出される
		System.out.println("dgj:akgal;:wg;:wejgl;:smlkadjglwk;ejfgal;jglkngal;kjgval;dwlkadlkwfgalkwdl;kal;ksadl;ksgaljwda;ljwekjg:adhgalwnvaoipevnrpbgvaowmgqoavaobnv;oea");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
		 //オーバーライドする
		 //WEBアプリケーションの終了直前に
		 //サーブレットコンテナから呼び出される
	}
} 