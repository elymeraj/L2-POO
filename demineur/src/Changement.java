/******************************** Changement ********************************
*																		    *
* La classe <<Changement>> est utilisée pour pour éffectuer la découverte   *
* d'une case.						       									*
****************************************************************************/

public class Changement{
	
	/********************* La méthode Changements ***************************
	*																		*
	* Découvre la case donné à la position donné.							*
	* Si la case en question n'a pas de bombe autour, alors la méthode se   *
	* rappelle récursivement sur les 8 case allentour.						*
	*                                                                       *
	* @param l      : le numéro ligne de la case							*
	* @param c      :le numéro colones de la case							*
	* @param grille : la grille de jeux										*
	*************************************************************************/

	public void Changements(int l, int c, Partie grille)
	{
		grille.setPartie(l,c);
		grille.Cont(l,c);
		if (grille.getBomb(l,c) == 0) 
		{
			for (int i=-1; i<2; i++) 
			{
				if((i+l)>=0 && (i+l)<grille.getLignes())
				{
					for (int k=-1; k<2; k++) 
					{
						if ((k+c)>=0 && (k+c)<grille.getColonnes() && grille.getPartie(l+i,c+k)==0) 
						{
							int x, y;
							x=i+l;
							y=k+c;
							Changements(x,y,grille);
						}
					}
				}
			}
		}
	}
}