package com.vaccinefinder;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.CentersList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FindByDistrict {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) {

		OkHttpClient client = new OkHttpClient();

		SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("dd-MM-yyyy");

		// Setting the time zone
		dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("GMT"));

		ArrayList dateList = new ArrayList<>();
		dateList.add(dateTimeInGMT.format(new Date()).toString());
		Date date;

		try {
			date = dateTimeInGMT.parse(dateTimeInGMT.format(new Date()).toString());

			final Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			dateList.add(dateTimeInGMT.format(calendar.getTime()));
			calendar.add(Calendar.DAY_OF_YEAR, 2);
			dateList.add(dateTimeInGMT.format(calendar.getTime()));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		ArrayList<String> centersListFind = new ArrayList<String>();

// 		Thane
		centersListFind.add("392");

//		Mumbai
		centersListFind.add("395");

//		Raigadh
		centersListFind.add("393");

//		Pune
//		centersListFind.add("363");

//		North Goa
		centersListFind.add("151");

		centersListFind.add("796");

		while (true) {

			System.out.println(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a").format(new Date()));

			for (int datelistit = 0; datelistit < 3; datelistit++) {

				for (int centersListcnt = 0; centersListcnt < centersListFind.size(); centersListcnt++) {

					
					
					Request request = new Request.Builder()
							.url("https://cdn-api.co-vin.in/api/v2/appointment/sessions/calendarByDistrict?district_id="
									+ centersListFind.get(centersListcnt) + "&date=" + dateList.get(datelistit))
							.build(); // defaults to GET

					Response response;
					try {
						response = client.newCall(request).execute();

						CentersList centersList;
						try {
							centersList = mapper.readValue(response.body().byteStream(), CentersList.class);
							ArrayList centersArrayList = centersList.centersList();

							for (int i = 0; i < centersArrayList.size(); i++) {
								LinkedHashMap centersLinked1 = (LinkedHashMap) centersArrayList.get(i);

								ArrayList sessions = (ArrayList) centersLinked1.get("sessions");

								for (int j = 0; j < sessions.size(); j++) {

									LinkedHashMap session = (LinkedHashMap) sessions.get(j);

									if (0 < Integer.parseInt(session.get("available_capacity").toString())) {

//										if (18 == Integer.parseInt(session.get("min_age_limit").toString())) {

//											if ("COVAXIN".equalsIgnoreCase(session.get("vaccine").toString())) {

										System.out.println("######################################");

										System.out.println("Center" + centersListFind.get(centersListcnt));
										System.out.println("Date:" + dateList.get(datelistit));
										System.out.println("center_id:" + centersLinked1.get("center_id"));
										System.out.println("name:" + centersLinked1.get("name"));
										System.out.println("vaccine:" + session.get("vaccine"));
										System.out.println("available_capacity:" + session.get("available_capacity"));
									}
								}
							}
//								}
//							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (JsonParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
			}
		}
	}
}
