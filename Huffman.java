
public class Huffman {
	String dico;
	String fichier_a_decoder ;
	//constructeur
	//deux fichiers texte sont necessaire : le dctionnaire est le fichier à décoder
	public Huffman(String dico,String f) {
		this.dico=dico;
		this.fichier_a_decoder=f;
	}
	public void decodage() {
		//on crée un arbre vide
		Arbre a = new Arbre("racine", null, null);
		//on ouvre le dictionnaire
		Fichier f= new Fichier(this.dico);
		//on crée l'arbre grace au dictionnaire
		a.construction(f.lecturedico());
		//on ouvre le fichier a decoder
		Fichier f2= new Fichier(this.fichier_a_decoder);
		//on crée le tableau de la forme {1,0,0,1,0,1,0,...}
		String[] liste=f2.lecturefichier();
		//on crée une chaine vide
		String c="";
		//on appelle la fonction décodage sur l'arbre 
		Arbre.decode(a, liste, c);
		System.out.println("un fichier résultat.txt a été créé dans votre répertoire de travail");
	}
}
