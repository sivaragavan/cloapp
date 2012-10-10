package controllers;

import java.io.File;

import models.Artifact;
import models.Project;
import models.User;

import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import plugins.MongoPlugin;
import plugins.S3Plugin;
import utils.CodeFSConstants;
import utils.Mailer;
import views.html.upload;
import views.html.emails.projectcreated;
import views.html.emails.useradded;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class Application extends Controller {

	// Views

	public static Result index() throws Exception {
		return ok(views.html.index.render());
	}

	public static Result dashboard(String projectId) throws Exception {
		Project project = MongoPlugin.ds.find(Project.class).field("_id")
				.equal(new ObjectId(projectId)).get();

		return ok(views.html.dashboard.render(project));
	}

	// APIs

	public static Result createUser(String email, String username,
			String password) throws Exception {

		User u = MongoPlugin.ds.find(User.class).field("emailId").equal(email)
				.get();
		if (u == null) {
			u = new User(email, username, password);
			MongoPlugin.ds.save(u);
		}

		// Mailer.sendMail(CodeFSConstants.project_created,
		// projectcreated.render(project).toString(), "Project Created", u);

		return ok(u.toString());
	}
}