package com.liferay.osgi.workshop.user.manager.provider;

import java.util.Collections;
import java.util.List;

public class UserManagerProvider {

	public List<String> users() {
		return Collections.singletonList("migue");
	}
}