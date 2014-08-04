package controllers;

import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http.RequestBody;
import play.mvc.Result;

public class BodyParserRes extends Controller {
	public static Result exBody(){
		RequestBody body = request().body();
		  return ok("Got body: " + body);
	}
	@BodyParser.Of(BodyParser.Json.class)
	public static Result json() {
	  RequestBody body = request().body();
	  return ok("Got json: " + body.asJson());
	}
}
