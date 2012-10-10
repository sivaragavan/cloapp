package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class UserController extends Controller {

	public static Result index() throws Exception {
		return ok(views.html.index.render());
	}

}
