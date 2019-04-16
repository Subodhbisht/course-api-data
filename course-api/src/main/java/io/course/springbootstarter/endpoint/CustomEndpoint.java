package io.course.springbootstarter.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.actuate.endpoint.Endpoint;

public class CustomEndpoint implements Endpoint<List<String>> {

	@Override
	public String getId() {
		return "customEndpoint";
	}

	@Override
	public List<String> invoke() {
		// Custom logic to build the output
        List<String> messages = new ArrayList<String>();
        messages.add("This is message 1");
        messages.add("This is message 2");
        return messages;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isSensitive() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}