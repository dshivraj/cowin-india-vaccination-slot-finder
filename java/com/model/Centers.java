package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Centers {

	public final String center_id;
	public final String name;
	public final String address;
	public final String state_name;
	public final String district_name;
	public final String block_name;
	public final String pincode;
	public final String longs;
	public final String lat;
	public final String from;
	public final String to;
	public final String fee_type;

	public Centers(@JsonProperty("center_id") String center_id, @JsonProperty("name") String name,
			@JsonProperty("address") String address, @JsonProperty("state_name") String state_name,
			@JsonProperty("district_name") String district_name, @JsonProperty("block_name") String block_name,
			@JsonProperty("pincode") String pincode, @JsonProperty("longs") String longs,
			@JsonProperty("lat") String lat, @JsonProperty("from") String from, @JsonProperty("to") String to,
			@JsonProperty("fee_type") String fee_type) {

		this.center_id = center_id;
		this.name = name;
		this.address = address;
		this.state_name = state_name;
		this.district_name = district_name;
		this.block_name = block_name;
		this.pincode = pincode;
		this.longs = longs;
		this.lat = lat;
		this.from = from;
		this.to = to;
		this.fee_type = fee_type;
	}
}
