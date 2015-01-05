package com.liferay.osgi.workshop.user.manager.internal;

import com.liferay.osgi.workshop.user.manager.provider.UserManagerProvider;
import org.osgi.service.component.annotations.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserManagerProviderImpl implements UserManagerProvider {

	public List<String> users() {
		return Collections.singletonList("migue");
	}

}