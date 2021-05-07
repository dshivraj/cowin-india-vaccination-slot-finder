package com.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CentersList {

	public final ArrayList centers;

	public CentersList(@JsonProperty("centers") ArrayList centers) {

		this.centers = centers;
	}

	public ArrayList centersList() {
		return this.centers;
	}

}
