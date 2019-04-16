package io.course.springbootstarter.hanldeException;

import java.util.Date;

public class ErrorDetail {

	private Date timestamp;
	private String message;
	private String details;
	private String check;

	public ErrorDetail(Date timestamp, String message, String details, String check) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.check = check;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

}
