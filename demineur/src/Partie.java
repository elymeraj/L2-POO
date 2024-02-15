/************************************ Partie **************************************
*									                                              *
* La classe <<Partie>> est utilisée pour commencer et gérer une partie en cours.  *						                *
* 						       												      *                              *
***********************************************************************************/

public class Partie {
	
	private int[][] grille_bombe;
	private int[][] grille_partie;
	private int lignes;
	private int colonnes;
	private int nbbombes;
	private int case_libre;
	private int drapeaux;

	private Affichage affiche;

	/**************************** La méthode Partie *************************
	*																		*
	* Constructeur destiné à la création de certaines constantes publiques. *           												*
	*																		*	
	* @param l : nombre de lignes souhaité. (entre 4 et 30).				*
	* @param c : nombre de colonnes souhaité. (entre 4 et 30).				*		
	* @param b : nombre de bombes souhaité.									*
	*																		*
	*************************************************************************/

	public Partie(int l, int c, int b) {
		grille_bombe = new int[l][c];
		grille_partie = new int[l][c];
		lignes=l;
		colonnes=c;
		nbbombes=b;
		case_libre=(lignes*colonnes)-nbbombes;
		drapeaux=0;
		this.Zéro();
		this.Place_Bomb();
		affiche = new Affichage(this);
		
	}

	/**************************** La méthode Partie *************************
	*																		*
	* Constructeur destiné à la création de certaines constantes publiques  *
	* à partir d'une sauvegarde. 								           	*							
	*																		*
	*************************************************************************/


	public Partie()
	{
		new Load(this);
		affiche = new Affichage(this);
	}

	/*****************************************
	* Initialise à 0 les valeurs du tableau  *
	******************************************/

	private void Zéro(){
		for (int i=0; i<lignes; i++) {
			for (int y=0; y<colonnes; y++) {
				grille_bombe[i][y]=0;
				grille_partie[i][y]=0;
			}
		}
	}

	/******************* getLignes *********************
	* 												   *
	* Renvoie le nombre de lignes (entre 4 et 30)      *
	****************************************************/

	public int getLignes()
	{
		return lignes;
	}

	/******************* getColonnes *******************
	* 												   *
	* Renvoie le nombre de colonnes (entre 4 et 30)    *
	****************************************************/
	public int getColonnes()
	{
		return colonnes;
	}

	/******************* getNbBombes *******************
	* 												   *
	* Renvoie le nombre bombes.						   *
	****************************************************/
	public int getNbbombes()
	{
		return nbbombes;
	}


	/******************* getBomb *************************
	* 												     *
	* Renvoie le nombre de bombes autour de cette case.  *
    *													 *
	* @param l : le numéro ligne de la case.			 *
	* @param c : le numéro colonnes de la case.			 *
	******************************************************/
	public int getBomb(int l, int c)
	{
		return grille_bombe[l][c];
	}

	/******************* getPartie ***********************
	* 												     *
	* Renvoie l'index si la case et caché, révélé ou 	 *
	* avec un marqueur.  								 *
    *													 *
	* @param l : le numéro ligne de la case.			 *
	* @param c : le numéro colonnes de la case.			 *
	******************************************************/

	public int getPartie(int l, int c)
	{
		return grille_partie[l][c];
	}

	/************getCase_libre **************
	* 										*
	* Renvoie le nombre de la case libre 	*
	*****************************************/

	public int getCase_libre()
	{
		return case_libre;
	}

	/**************getDrapeaux **************
	* 										*
	* Renvoie le nombre de drapeaux		 	*
	*****************************************/

	public int getDrapeaux()
	{
		return drapeaux;
	}

	/************** setLignes ***************
	* 										*
	* Initilise le nombre de lignes.		*
	*										*
	* @param l le nombre de lignes		 	*
	*****************************************/
	public void setLignes(int l)
	{
		lignes=l;
	}

	/************** setColonnes ***************
	* 										  *
	* Initilise le nombre de colonnes.		  *
	*										  *
	* @param c le nombre de colonnes.		  *
	******************************************/
	public void setColonnes(int c)
	{
		colonnes=c;
	}

	/*************** setTables ****************
	* 										  *
	* Initilise la taille des tableaux.		  *
	******************************************/
	public void setTables()
	{
		grille_bombe = new int[lignes][colonnes];
		grille_partie = new int[lignes][colonnes];
	}

	/********************** setPartie ***********************
	* 										  				*
	* Change la valeur de la case de caché à révélé.	  	*
	*										  				*
	* @param l le nombre de lignes.			  				*
	* @param c le nombre de colonnes.						*
	*********************************************************/

	public void setPartie(int l, int c)
	{
		grille_partie[l][c]=1;
	}

	/********************** setPartie ***********************
	* 										  				*
	* Change la valeur de la case de caché à révélé ou 	  	*
	* avec un marqueur.						 				*
	*														*
	* @param l le nombre de lignes.			  				*
	* @param c le nombre de colonnes.						*
	* @param val état de la case.							*
	*********************************************************/
	public void setPartie(int l, int c,int val)
	{
		grille_partie[l][c]=val;
	}

	/*********************** setBombs ***********************
	* 										  				*
	* Change le nombre de bombe des case alentour.			*
	*														*
	* @param l le nombre de lignes.			  				*
	* @param c le nombre de colonnes.						*
	* @param val le nombre de bombes souhaités.				*
	*********************************************************/
	
	public void setBombs(int l, int c,int val)
	{
		grille_bombe[l][c]=val;
	}

	/******************** setCase_libre *********************
	* 										  				*
	* Change le nombre de cases libres.						*
	*														*
	* @param val le nombre de case libre.					*
	*********************************************************/

	public void setCase_libre(int val)
	{
		case_libre=val;
	}

	/********************* setNbbombes **********************
	* 										  				*
	* Change le nombre de  bombes.							*
	*														*
	* @param val le nombre de bombes.						*
	*********************************************************/

	public void setNbbombes(int val)
	{
		nbbombes=val;
	}

	/********************* setDrapeaux **********************
	* 										  				*
	* Change le nombre de  drapeaux.						*
	*														*
	* @param val le nombre de drapeaux.						*
	*********************************************************/

	public void setDrapeaux(int val)
	{
		drapeaux=val;
	}

	/************** Place_Bomb ****************
	* 										  *
	* place les bombes dans la grille_bombe	  *
	*******************************************/

	private void Place_Bomb(){
		double y;
		int l,c;
		java.util.Random x = new java.util.Random();
		for (int i=0; i<nbbombes; i++) {
			y = x.nextDouble(); //génération du nombre aléatoire
			y = y*lignes;
			l = (int)y;
			y = x.nextDouble();
			y = y*colonnes;
			c = (int)y;

			if (grille_bombe[l][c] == 9)
			{
				i--;
			}else
			{
				grille_bombe[l][c] = 9; //code des bombes
				for (int k=-1;k<2; k++) 
				{
					if ((l+k)>=0 && (l+k)<lignes) 
					{
						for (int m=-1;m<2; m++) 
						{
							if ((c+m)>=0 && (c+m)<colonnes) 
							{
								if (grille_bombe[l+k][c+m]!=9) 
								{
									grille_bombe[l+k][c+m]++;		//incrémente le nombre de bombe au alentoure
								}
							}
						}
					}
				}
			}
		}
	}


	private void Afficher_consol(){
		System.out.println("nbcolonnes : "+colonnes);
		System.out.println("nblignes : "+lignes);
		System.out.println("case libre : "+case_libre);
		
		System.out.println("");
		for (int i=0; i<lignes;i++) {
			for (int k=0;k<colonnes ;k++ ) {
				System.out.print(grille_bombe[i][k]+" ");
			}
			System.out.println("");
		}
		System.out.println("\n");
		for (int i=0; i<lignes;i++) {
			for (int k=0;k<colonnes ;k++ ) {
				System.out.print(grille_partie[i][k]+" ");
			}
			System.out.println("");
		}
	}
	
	/********************* Cont ***********************
	* 										  		  *
	* Vérifie si on à gagné ou perdu.				  *
	*												  *
	* @param l le numéro de lignes.					  *
	* @param c le numéro de colonnes.				  *
	***************************************************/

	public void Cont(int l, int c)
	{
		if (grille_bombe[l][c]==9) 
		{
			grille_partie[l][c]=4;
			this.Perdu();
			affiche.setFin();
			affiche.MenuFin(true);
		}else
		{
			case_libre--;
			if (case_libre == 0) 
			{
				affiche.setFin();
				affiche.MenuFin(false);
			}
		}
		
	}


	private void Perdu()
	{
		for (int i=0; i<lignes; i++) {
			for (int k=0; k<colonnes; k++) {
				if (grille_partie[i][k]!=4 && grille_bombe[i][k]==9 && grille_partie[i][k]!=2) {
					grille_partie[i][k]=1;
				}else if (grille_partie[i][k]==2 && grille_bombe[i][k]!=9) {
					grille_partie[i][k]=5;
				}
			}
		}
	}

	public void Drapeau(int l, int c)
	{
		if (grille_partie[l][c]==0) {
			grille_partie[l][c]=2;
			drapeaux++;
		}else if (grille_partie[l][c]==2) {
			grille_partie[l][c]=3;
			drapeaux--;
		}else
		{
			grille_partie[l][c]=0;
		}
		affiche.Menu(nbbombes-drapeaux);
	}


}

	