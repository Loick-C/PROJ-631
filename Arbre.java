import java.io.File;
import java.io.FileWriter;

public class Arbre {
	String valeur ;
	Arbre sag;
	Arbre sad; 
	//constructeur
	public Arbre(String val,Arbre sg,Arbre sd) {
		this.valeur=val;
		this.sag = sg;
		this.sad = sd;
	}
	
	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public Arbre getSag() {
		return sag;
	}

	public void setSag(Arbre sag) {
		this.sag = sag;
	}

	public Arbre getSad() {
		return sad;
	}

	public void setSad(Arbre sad) {
		this.sad = sad;
	}
	
	public boolean estfeuille() {
		return(this.getSad()==null && this.getSag()==null);
	}

	public void construction(String[] liste) {
		//permet la construction de l'arbre
		for (int indice = 1 ; indice <= liste.length ;indice+=2) {
			//on parcours le tableau deux par deux pour récupérer seuelemnt le code
			//le tableau est de la forme {a,0101,b,0011,c,1100,....}
			String code= liste[indice];
			String val= null;
			Arbre arbrecourant=this;
			//ici on parcours le code binaire
			for (int i = 0 ; i < code.length() ;i++) {
			   //si le caractère est un '1' on part gauche
			   if(code.charAt(i)=='1') {
				   //soit on crée la partie gauche et on se place dedans 
				   //soit si elle existe déjà on se place dedans
				   if (arbrecourant.getSag()==null) {
					   if (i+1==code.length()) {
						   val= liste[indice-1];
					   }
					   Arbre sag=new Arbre(val,null,null);
					   arbrecourant.setSag(sag);
				   }
				   arbrecourant=arbrecourant.getSag();   
			   }
			   //cas similaire si la caractère est un '0' mais à doite
			   if(code.charAt(i)=='0') {
				   if (arbrecourant.getSad()==null) {
					   if (i+1==code.length()) {
						   val= liste[indice-1];
					   }
					   Arbre sad=new Arbre(val,null,null);
					   arbrecourant.setSad(sad);
				   }
				   arbrecourant=arbrecourant.getSad();  
			   }
			}
		}
	}
	//fonction récursive permettant le décodage
	//ici le tableau est de la forme {1,0,1,1,0,0,...} et la chaine est null
	//l'arbre est l'arbe générer gràce à la fonction ci dessus
	static void decode(Arbre a, String[] liste,String chaine) {
		//condition d'arret si la liste est vide
		if (liste.length==0) {
			try{
				//création du fihier
				File fichier=new File("resultat.txt");
				fichier.createNewFile();
				FileWriter fw=new FileWriter(fichier);
				//on écrit les espaces et les retours chariot dans la chaine
				chaine=chaine.replace("///"," ");
				chaine=chaine.replace("\\","\n");
				//écriture de la chaine dans le fihier
				fw.write(chaine);
				fw.close();
				} catch (Exception e) {}
			return ; 
		}
		else {
			//notre arbre courant est la racine
			//ce point de départ est le même à chaque récursion
			Arbre arbrecourant=a;
			//on parcours le tableau
			for (int indice = 0 ; indice < liste.length ;indice++) {
				//si on a un '1' on se place a gauche
				if (liste[indice].equals("1") ) {
					arbrecourant = arbrecourant.getSag();
				}
				//si on a un '0'on se place a droite
				if (liste[indice].equals("0")) {
					arbrecourant=arbrecourant.getSad();
				}
				//si l'on tombe on se trouve sur une feuille
				//on récupère la valeur (le caractère)
				if (arbrecourant.estfeuille()==true) {
					chaine+=arbrecourant.getValeur();
					//ici on initialise la nouvelle liste sur laquelle on fera la récursivité
					String[] newliste= new String[liste.length-(indice+1)];
					//la nouvelle liste est une copie de l'ancienne avec les premiers caractère déjà traité
					System.arraycopy(liste, indice+1, newliste, 0,liste.length-(indice+1) );					
					//récursivité
					decode(a,newliste,chaine);
					break;
				}
			}
		}
	}
	
}
