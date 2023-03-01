package com.atlian;


import org.asteriskjava.live.internal.AsteriskServerImpl;
import org.asteriskjava.manager.*;



import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.event.NewStateEvent;


import java.util.EventListener;

public class HelloManager implements EventListener {
	public static void main(String[] args) throws Exception {
		DefaultManagerConnection defaultManagerConnection = new DefaultManagerConnection("114.240.52.103", 50380,"admin", "freepbx_amp111");



		OriginateAction originateAction = new OriginateAction();
			originateAction.setChannel("SIP/801");
			originateAction.setExten("804");
			originateAction.setContext("from-internal");
			originateAction.setPriority(1);
			originateAction.setTimeout(300000);
			originateAction.setCallerId("15713759701");
			originateAction.setAsync(true);
			defaultManagerConnection.login();

			ManagerEvent  newStateEvent = new NewStateEvent(defaultManagerConnection);

			newStateEvent.setPrivilege("call,all");
			newStateEvent.setSequenceNumber(1070);
			newStateEvent.setFile("manager_channels.c");
			newStateEvent.setLine(741);
			newStateEvent.setFunc("channel_snapshot_update");
			newStateEvent.setCallerIdName("SIP/801-00000011");
			newStateEvent.setChannelState(0);
			newStateEvent.setChannelStateDesc("Down");
			newStateEvent.setCallerIdNum("801");
			newStateEvent.setCallerIdName("device");
			newStateEvent.setConnectedLineNum("<unknown>");
			newStateEvent.setConnectedLineName("<unknown>");
			newStateEvent.setContext("from-internal");
			newStateEvent.setExten("s");

			ManagerEventListener managerEventListener = new AsteriskServerImpl();
			managerEventListener.onManagerEvent(newStateEvent);
		defaultManagerConnection.addEventListener(managerEventListener);

		try {
			


			ResponseEvents responseEvents = defaultManagerConnection.sendEventGeneratingAction(originateAction);

			System.out.println(responseEvents);
			} catch (TimeoutException e) {
				e.printStackTrace();
			}


		}


}