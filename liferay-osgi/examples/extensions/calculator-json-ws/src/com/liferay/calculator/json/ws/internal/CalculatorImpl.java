package com.liferay.calculator.json.ws.internal;

import com.liferay.calculator.json.ws.Calculator;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Miguel Pastor
 */
@Component(
	property = {
		"json.web.service.context.name=calculator",
		"json.web.service.context.path=ws"
	},
	immediate = true, service = Object.class
)
@JSONWebService
public class CalculatorImpl implements Calculator {
	@Override
	public long plus(int x, int y) {
		return x + y;
	}

	@Override
	public long minus(int x, int y) {
		return x - y;
	}

}
