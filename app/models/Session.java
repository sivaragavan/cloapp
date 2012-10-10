package models;

import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity("sessions")
public class Session {

	@Id
	public ObjectId id;
	public String username;

	public Session() {

	}

	public Session(String username) {
		this.username = username;
	}

	public String toString() {
		JSONObject response = new JSONObject();
		try {
			response.put("id", id);
			response.put("username", username);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return response.toString();
	}

}
