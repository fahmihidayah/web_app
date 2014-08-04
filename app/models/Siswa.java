package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Siswa extends Model{
	@Required
	@Id
	public String nim;
	@Required
	public String name;
	@Required
	public String address;
	
	public static Finder<Long, Siswa> find = new Finder<Long, Siswa>(Long.class, Siswa.class);

}
