package com.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CentersList {

	public final ArrayList<Centers> centers;

	public CentersList(@JsonProperty("centers") ArrayList<Centers> centers) {

		this.centers = centers;
	}

	public ArrayList<Centers> centersList() {
		return this.centers;
	}

	
}
