package controllers;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Siswa;
import play.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	static Form<Siswa> siswaForm = Form.form(Siswa.class);
	
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    
    public static Result post(){
    	Form<Siswa> boundSiswa = siswaForm.bindFromRequest();
    	if(boundSiswa.hasErrors()){
    		return badRequest("error inserting data");
    	}
    	else {
    		Siswa siswa = boundSiswa.get();
    		siswa.save();
    		return ok("success insert data");
    	}
    }
    
    public static Result show(){
    	List<Siswa> listSiswa =Siswa.find.all();
    	return ok(Json.toJson(listSiswa));
    }
    
    public static Result formInsert(){
    	return ok(siswa.render(siswaForm));
    }
    
    public static Result insertJson(){
    	JsonNode json = request().body().asJson();
    	if(json == null){
    		ObjectNode node = Json.newObject();
    		node.put("status", "404");
    		node.put("message", "error");
    		return badRequest(node);
    	}
    	else{
    		Siswa siswa = Json.fromJson(json, Siswa.class);
    		return ok();
    	}
    	
    }

}
