##Présentation et Précaution

Le code ci-dessus permet de faire le décdage d'Huffman. Afin de le lancer il faut 2 fichiers : le dictionnaire aini que le fichier à décoder.
Le code ne permet pas de traiter les retour chariots. Il est faut donc remplacer le retour chariot par "\\" si vous voulez qu'il soit traiter.

##Structure du code : 

La classe Fichier s'occupe de traiter les fichiers et de construire des tableaux.
La classe Arbre permet la création de l'arbre ( fonction construction) à partir d'un tableau ainsi que de décoder un code (fonction décode).
La classe Huffman s'occupe de regrouper les deux classes ci dessus, ainsi dans le main seulement la classe Huffman est utiliser.

Pour lancer le code il suffit alors de lancer la fonction decodage de la fonction Huffman avec les deux fichiers voulu comme dans le main.
