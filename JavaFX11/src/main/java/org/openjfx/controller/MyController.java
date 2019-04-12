package org.openjfx.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MyController {
	@FXML
	private Button tj;
	
	@FXML
	private TextField textConnectionName;
	
	@FXML
	private TextField textIp;
	
	@FXML
	private TextField textPort;
	
	@FXML
	private TextField dataBasic;
	
	@FXML
	private TextField textUser;
	
	@FXML
	private TextField textPass;
	
	@FXML
	private TextArea test_a;
	
	public void eventButton(){
        String ip = textIp.getText();//获取文本框输入的内容
        String port = textPort.getText();//获取文本框输入的内容
        String user = textUser.getText();//获取文本框输入的内容
        String pass = textPass.getText();//获取文本框输入的内容
        String data = dataBasic.getText();
        Connection connect = null;
        try {
			Driver driver = new Driver();
			String url = String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Hongkong", ip, port, data);
			System.out.println(url);
			Properties properties = new Properties();
			properties.setProperty("user", user);
			properties.setProperty("password", pass);
			connect = driver.connect(url, properties);
			boolean closed = connect.isClosed();
			boolean valid = connect.isValid(30000);
			test_a.setText("数据库连接是否关闭：" + closed + ",数据库连接是否有效：" + valid);
		} catch (SQLException e) {
			test_a.autosize();
			test_a.setText("数据库连接错误：" + e.getMessage());
			for (Iterator<Throwable> iterator = e.iterator(); iterator.hasNext();) {
				Throwable next = (Throwable) iterator.next();
				test_a.appendText(next.getMessage());
			}
		}finally {
			try {
				if (null != connect) {
					connect.close();
				}
			} catch (SQLException e) {
			}
		}
    }

}
