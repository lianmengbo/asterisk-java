package com.atlian;

import org.asteriskjava.manager.AuthenticationFailedException;

import org.asteriskjava.manager.DefaultManagerConnection;
import org.asteriskjava.manager.TimeoutException;

import org.asteriskjava.manager.internal.ManagerConnectionImpl;

import java.io.IOException;

/**
 * @ClassName Main
 * @Description TODO
 * @Author mengbo
 * @Date 2023/3/1 14:31
 * @Version 1.0
 */

//
public class Main {

	public static void main(String[] args) {
		ManagerConnectionImpl managerConnection = new ManagerConnectionImpl();
		managerConnection.setHostname("114.240.52.103");
		managerConnection.setPassword("admin");
		managerConnection.setUsername("freepbx_amp111");
		managerConnection.setPort(50380);
		try {
			managerConnection.login();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}


	}
}
