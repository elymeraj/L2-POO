import javax.swing.*;
import java.io.*;

/********************************* Load *************************************
*																		    *
* La classe <<Load>> est utilisée pour pour éffectuer le chargement d'une   *
* partie sauvegardé ultérieurement.   										*
* 						       												*
****************************************************************************/

public class Load {

	/**************************** La méthode Load ***************************
	*																		*
	* Constructeur charge la partie sauvegarder ulterieurement.             *
	*																		*	
	* @param grille : la grille de jeu. 									*
	*																		*
	* @throws FileNotFoundException : si fichier non trouvé.				*
	* @throws IOException 			: si problème lors de l'écriture.		*
	*************************************************************************/

	public Load(Partie grille)
	{
		try
		{
			DataInputStream flux = new DataInputStream(new FileInputStream(new File("foo.bin")));
			try
			{
				
				grille.setLignes(flux.readInt());
				grille.setColonnes(flux.readInt());
				grille.setCase_libre(flux.readInt());
				grille.setNbbombes(flux.readInt());
				grille.setDrapeaux(flux.readInt());

				grille.setTables();

				//sauvegarde pos bombe
				for (int i=0; i<grille.getLignes(); i++) 
				{
					for (int k=0; k<grille.getColonnes(); k++) 
					{
						grille.setBombs(i,k,flux.readInt());
					}
				}

				//sauvegarde état partie
				for (int i=0; i<grille.getLignes(); i++) 
				{
					for (int k=0; k<grille.getColonnes(); k++)
					{
						grille.setPartie(i,k,flux.readInt());
					}
				}
				flux.close();
			}catch(IOException exception)
			{
				Object[] choix = {"Ok"};
 
				int reponse = JOptionPane.showOptionDialog(null,
				"Erreur lors de la lecture\n"+exception.getMessage(),
				"Erreur",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				choix,
				null);
				if (reponse == 0)
				{
					System.exit(0);
				}
			}

			
		}catch(FileNotFoundException exception)
		{
			Object[] choix = {"Ok"};
 
			int reponse = JOptionPane.showOptionDialog(null,
			"Fichier non trouver\n"+exception.getMessage(),
			"Erreur",
			JOptionPane.DEFAULT_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			choix,
			null);
			if (reponse == 0)
			{
				System.exit(0);
			}
		}
	}

}