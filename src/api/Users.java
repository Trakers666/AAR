package api;

import org.json.JSONException;
import org.json.JSONObject;

import BD.BDUser;

public class Users {

	public static JSONObject addUser(String prenom, String nom, String login, String password){
		if (prenom == null || nom == null || login == null || password == null)
		{
			return Tools.erreur("Parametre manquant");//retourne un objet JSON avec un champ erreur ayant pour valeur "parametre manquant"
		}
		else if (BDUser.userExists(login))//on verra ça plus tard
		{
			return Tools.erreur("Login deja existant");
		}
		else{
			BDUser.insertUser(prenom, nom, login, password);
			JSONObject json = new JSONObject();
			try {
				json.put ("output" ,"OK" );
			} catch ( JSONException e ) {
				return Tools.erreur(e.getMessage());
			}
			return json;
		}
	}

	public static JSONObject connectUser(String login, String password){
		if (BDUser.verifLoginPassword(login, password)){
			JSONObject json = new JSONObject();
			try {
				json.put ("output" ,"OK" );
			} catch ( JSONException e ) {
				return Tools.erreur(e.getMessage());
			}
			return json;
		}
		else
			return Tools.erreur("Login ou mot de pass incorrect");
	}

	public static JSONObject addFriend(String key, String id_friend) {
		if (key == null || id_friend == null)
		{
			return Tools.erreur("Parametre manquant");//retourne un objet JSON avec un champ erreur ayant pour valeur "parametre manquant"
		}
		else{
			BDUser.addFriend(key, id_friend);
			JSONObject json = new JSONObject();
			try {
				json.put ("output" ,"OK" );
			} catch ( JSONException e ) {
				return Tools.erreur(e.getMessage());
			}
			return json;
		}
	}

	public static JSONObject removeFriend(String key, String id_friend) {
		if (key == null || id_friend == null)
		{
			return Tools.erreur("Parametre manquant");//retourne un objet JSON avec un champ erreur ayant pour valeur "parametre manquant"
		}
		else{
			BDUser.removeFriend(key, id_friend);
			JSONObject json = new JSONObject();
			try {
				json.put ("output" ,"OK" );
			} catch ( JSONException e ) {
				return Tools.erreur(e.getMessage());
			}
			return json;
		}
	}

	public static JSONObject Logout() {
		JSONObject json = new JSONObject();
		try {
			json.put ("output" ,"OK" );
		} catch ( JSONException e ) {
			return Tools.erreur(e.getMessage());
		}
		return json;
	}
	
}
