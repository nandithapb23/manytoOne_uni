package manytoone_uni2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Bank {
@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)	
private int id;
private String name;
private String headOffice;
private String ceo;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getHeadOffice() {
	return headOffice;
}
public void setHeadOffice(String headOffice) {
	this.headOffice = headOffice;
}
public String getCeo() {
	return ceo;
}
public void setCeo(String ceo) {
	this.ceo = ceo;
}
@Override
public String toString() {
	return "Bank [id=" + id + ", name=" + name + ", headOffice=" + headOffice + ", ceo=" + ceo + "]";
}

}
