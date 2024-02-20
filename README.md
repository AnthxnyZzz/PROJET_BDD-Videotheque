<h1>PROJET VIDEOTHEQUE</h1> </br>

<b>Groupe :</b>
- PAMPHILE Anthony
- ROSEAULIN Grâce
- TONY Jonathan


READ-ME

<b>Lancement du programme : </b></br></br>
Il faut lancer la fonction Main.java se trouvant dans le package « main ».</br>
Le programme alors, vous ouvrira une fenêtre de connexion où il faut entrer un nom d’utilisateur et un mot de passe présent dans la table user de videothèque.</br>
<i>(Exemple : user : adupont ; mdp : tsunami123*)</i></br>
Le programme vérifie que les deux entrées sont remplies avant d’effectuer la connexion. Le programme ne gère pas l’injection SQL. 
Une fois connecté, vous avez accès à l’application « FlexFlix », qui vous permettra de gérer la base de données videothèque.</br>
Vous avez à disposition 6 boutons :
    
    - Rechercher un film
    - Ajouter un film
    - Supprimer un film
    - Modifier un film (Pas fonctionnel totalement)
    - Chercher un acteur
    - Chercher un réalisateur

    
<h2>Rechercher un film</h2> </br>
En appuyant sur « Rechercher », même sans entrer le nom d’un film en particulier, la liste de tous les films ayant un titre semblable à ce que vous aurez entrés dans la zone de texte seront affichés avec leur id, leur titre, l’année, le nom du réalisateur, la note du film et le nombre de votants suivis des différents acteurs ayant joué dans le film.
On n’est pas obligé de rentrer le nom du film en entier, car le programme recherche une titre ressemblant à ce que vous avez écrit.
La fonction fonctionne de la même manière pour les boutons « Chercher un acteur » et « Chercher un réalisateur ».


<h2>Ajouter un film</h2> </br>
Pour « Ajouter un film », il faudra d’abord entrer le titre ainsi que l’année.</br>
Si le film existe déjà dans la base de données, le programme vous le fera savoir.</br>
Pour l’exemple, on va ajouter « Fast & Furious 10 »</br>
On peut voir que dans un panneau à droite, est résumé toute les informations qu’on a déjà validé, il y a en bas de la page un bouton « Annuler » : qui permet de revenir à une nouvelle page d’ajout vierge, et un bouton « Valider » grisé, qui sera fonctionnel que quand on aura entré au moins un acteur.
Donc on entre le nom et prénom du réalisateur. (Louis Leterrier) Puis on clique sur continuer.</br>
Le programme demande alors le score du film et le nombre de votant. Donc on va rentrer pour score 5.8 et 104 000 pour nombre de votants. Puis on clique sur continuer.</br>
On appuie sur le bouton « Ajouter Acteur », et 3 champs de texte s’afficheront pour pouvoir entrer le nom, prénom et le rang de l’acteur.</br>
Après avoir rempli, les 3 zones de saisies, vous pourrez ajouter un autre acteur et les champs de texte de l’acteur précédent ne seront pas modifiable.</br>
Le nom des acteurs déjà entrés s’affichent eux aussi dans le résumé à droite.</br>
Quand vous appuyez sur « Valider », le programme vérifie si le réalisateur et les acteurs existe dans la base de données, s’il existe leur id déjà attribués seront associé au film sinon, le programme les créera dans la base de données.
À la fin, un petit message vous informe, si oui ou non, votre film a bien été créé avec son id.</br>
On peut alors vérifier dans « Rechercher un film » pour voir :</br>
</t> Il a bien été créé.


<h2>Supprimer un film</h2> </br>
Pour supprimer un film, il suffit de rentrer l’id du film qu’on veut supprimer. On peut avoir l’id en cherchant le film dans l’onglet « Rechercher un film »</br>
Si l’id du film entré n’existe pas dans la base de données, le programme vous affichera ce message.</br>
Si vous entrez un id d’un film qui existe, vous aurez un message de confirmation, pour être sûr de votre choix, avec écrit le nom du film dont vous avez entré l’id.</br>
On va supprimer l’exemple « Fast & Furious 10 » qu’on a crée un peu plus tôt avec son id ‘1810’.</br>
En appuyant sur « Oui » si la requête a bien été exécutée vous aurez ce message :
On peut maintenant vérifier dans l’onglet « Recherche d’un film » pour voir s’il a bien été supprimé, en relançant la même recherche qu’on a faite plus haut.
Et nous pouvons voir que le film a bien été supprimé.
