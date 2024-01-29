package com.bar.model.request;

public class Request {

	private Long id;
	private int Q;

	public Request() {
	}

	public Request(Long id, int q) {
		super();
		this.id = id;
		Q = q;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQ() {
		return Q;
	}

	public void setQ(int q) {
		Q = q;
	}

}
