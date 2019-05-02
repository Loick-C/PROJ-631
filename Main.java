
public class Main {

	public static void main(String[] args) {
		//on crée l'objet huffman avec le dico et le fichier a decoder
		Huffman huffman = new Huffman("example_dico.dat", "example_huffCode.dat");
		//on appelle la fonction decodage
		huffman.decodage();
	}
}