package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sessions {

	public final String session_id;
	public final String date;
	public final String available_capacity;
	public final String min_age_limit;
	public final String vaccine;

	public Sessions(@JsonProperty("session_id") String session_id, @JsonProperty("date") String date,
			@JsonProperty("available_capacity") String available_capacity,
			@JsonProperty("min_age_limit") String min_age_limit, @JsonProperty("vaccine") String vaccine) {

		this.session_id = session_id;
		this.date = date;
		this.available_capacity = available_capacity;
		this.min_age_limit = min_age_limit;
		this.vaccine = vaccine;
	}
}
