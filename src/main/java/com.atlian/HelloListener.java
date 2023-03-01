package com.atlian;

import org.asteriskjava.live.*;
import org.asteriskjava.live.internal.AsteriskAgentImpl;

public class HelloListener implements AsteriskServerListener {

	@Override
	public void onNewAsteriskChannel(AsteriskChannel channel) {
		System.out.println("------onNewAsteriskChannel---------------------" + channel);
	}

	@Override
	public void onNewMeetMeUser(MeetMeUser user) {
		System.out.println("------onNewMeetMeUser---------------------" + user);
	}

	@Override
	public void onNewAgent(AsteriskAgent agent) {
		System.out.println("------agent---------------------" + agent);
	}

	@Override
	public void onNewQueueEntry(AsteriskQueueEntry entry) {
		System.out.println("------onNewQueueEntry---------------------" + entry);
	}
}