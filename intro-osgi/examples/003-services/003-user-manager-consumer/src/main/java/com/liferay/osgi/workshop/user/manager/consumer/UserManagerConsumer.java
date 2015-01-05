package com.liferay.osgi.workshop.user.manager.consumer;

import com.liferay.osgi.workshop.user.manager.provider.UserManagerProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component (immediate = true)
public class UserManagerConsumer {

	public List<String> listUsers() {
		return _userManagerProvider.users();
	}

	@Activate
	protected void activate() {
		System.out.println("Number of registered users: " + _userManagerProvider.users().size());
	}

	@Reference
	protected void setUserManagerProvider(UserManagerProvider userManagerProvider) {
		_userManagerProvider = userManagerProvider;
	}

	protected void unsetUserManagerProvider(UserManagerProvider userManagerProvider) {
		_userManagerProvider = null;
	}

	private UserManagerProvider _userManagerProvider;

}