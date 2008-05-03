package info.mp3lib.core.business.scan;

import info.mp3lib.core.business.IBusinessPlan;
import info.mp3lib.core.xom.Album;
import info.mp3lib.core.xom.Artist;
import info.mp3lib.core.xom.Track;

import java.io.File;


/**
 * Class/Interface d�finissant les principales fonctions du package de SCAN
 * -> lecture Drive
 * -> validation / tags
 * -> �criture XML
 * 
 * @author AkS
 */
public class Scan implements IBusinessPlan {

	private static final long serialVersionUID = -1963252596917406454L;
	
	Artist scanList = new Artist("unknown");
	
	/**
	 * Parcours r�cursivement une arborescence de r�pertoires :
	 * -> quand il contient des fichiers musicaux,
	 * 			- on cr�� un nouveau container de MusicData
	 * 			- on ajoute les fichiers au container
	 * 			- on ajoute le container � la liste scanList
	 * -> quand il ne contient que des r�pertoire, il traite
	 *    successivement (et r�cursivement) les sous r�pertoires pr�sents.
	 * @param rootPath Point d'entr�e du Scan de l'arborescence. 
	 */
	
	public void read(File path) //throws BusinessException
	{
		Track mData = null;
		Album mCont = null;

		// erreur d'initialisation
		if (path.isDirectory() == false)
			return;
		
		// - For each entry in this rootPath folder
		File[] fs = path.listFiles();
		for (int i = 0; i < fs.length; i++)
		{
			if (fs[i].isDirectory() == false)	// files
			{
				// create new Container if first.
				if (mCont == null)
					mCont = new Album(path);

				// construct new ScanMusicData from this File.
				mData = new Track(fs[i]);
				
				// add MusicData to its Container.
				mCont.add(mData);
			}
			else								// sub folders
			{
				// recursively check sub directories
				this.read(fs[i]);
			}
		}
		
		// store new MusicDataContainer to scanList
		if (mCont != null)
			scanList.add(mCont);
	}
	
	/**
	 * Implements some more validation tests, before writing data :
	 * 
	 * -> not necessary during Scan Process ..
	 */
	public void validate()
	{
		// not necessary here
	}
	
	@Override
	public void manage() {
		// not necessary here
	}
}

