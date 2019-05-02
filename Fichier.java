import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Fichier {
	String fichier;
	//constructeur
	public Fichier(String f) {
		this.fichier=f;
	}
	//lecture du dictionnaire
	public String[] lecturedico() {
		//initialisation d'une chaine de caractère à nul et pareil pour un tableau
		String[] liste = null;
		String chaine="";
		  //lecture du fichier texte 
		  try{
		   InputStream ips=new FileInputStream(this.fichier); 
		   InputStreamReader ipsr=new InputStreamReader(ips);
		   BufferedReader br=new BufferedReader(ipsr);
		   String ligne;
		   //tant que la ligne n'est pas nulle
		   while ((ligne=br.readLine())!=null){
			   //cas particulier de l'espace
			    if (ligne.charAt(0)==' '){
			    	ligne = ligne.substring(0, 0) + "///" + ligne.substring(0+1);
			    }
			   
			   chaine+=ligne+" ";
		   }
		   //creation du tableau a partir de la chaine
		   //format du tableau : {a,1010,b,110,///,111,...}
		   liste=chaine.split(" ");
		   br.close(); 
		  }
		  catch (Exception e){
		   System.out.println(e.toString());
		  }
		return liste;
	}
	//lecture du fichier a decoder
	public String[] lecturefichier() {
		//initialisation d'une chaine de caractère à nul et pareil pour un tableau
		String[] liste = null;
		String chaine="";
		  //lecture du fichier texte 
		  try{
		   InputStream ips=new FileInputStream(this.fichier); 
		   InputStreamReader ipsr=new InputStreamReader(ips);
		   BufferedReader br=new BufferedReader(ipsr);
		   String ligne;
		   while ((ligne=br.readLine())!=null){
		    chaine+=ligne;
		   }
		   //création du tableau de la forme : {1,0,1,1,1,0,1,0,1,...}
		   liste=chaine.split("");
		   br.close(); 
		  }
		  catch (Exception e){
		   System.out.println(e.toString());
		  }
		return liste;
	}
	
	
}
