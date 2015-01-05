package com.liferay.osgi.workshop.user.manager.consumer;

import com.liferay.osgi.workshop.user.manager.provider.UserManagerProvider;

import java.util.List;

public class UserManagerConsumer {

	public List<String> listUsers() {
		return _userManagerProvider.users();
	}

	private UserManagerProvider _userManagerProvider = new UserManagerProvider();

}