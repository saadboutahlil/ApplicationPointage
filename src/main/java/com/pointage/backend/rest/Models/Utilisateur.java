package com.pointage.backend.rest.Models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Utilisateur {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public long utilisateurId;
@Column
public String nom;
@Column
public String prenom;
@Column
public Date dateNaissance;
@Column
public String telephone;
@Column
public String email;
@Column
public String login;
@Column
public String password;


public long getId() {
	return utilisateurId;
}
public void setId(long id) {
	this.utilisateurId = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public Date getDateNaissance() {
	return dateNaissance;
}
public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
