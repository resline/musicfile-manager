package info.mp3lib.core.business.scan;

import info.mp3lib.core.business.IBusinessPlan;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;


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
	
	ArrayList<ScanDataContainer> scanList = new ArrayList<ScanDataContainer>();
	
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
		ScanData mData = null;
		ScanDataContainer mCont = null;
		File pFile = null;

		// erreur d'initialisation
		if (path.isDirectory() == false)
			return;
		
		// - For each entry in this rootPath
		//FileInputStream fis = new FileInputStream(path);
		//while (....pFile = fis.nextFileInDirectory()....)
		{
			if (pFile.isDirectory() == false)
			{
				// create new Container if first.
				if (mCont == null)
					mCont = new ScanDataContainer();

				// construct new ScanMusicData from this File.
				mData = new ScanData(pFile);
				
				// add MusicData to its Container.
				mCont.getContainer().add(mData);
			}
			else
			{
				// recursively check sub directories
				this.read(pFile);
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

	/**
	 * Write ScanList Results
	 * 
	 */
	public void write()
	{
		Iterator<ScanDataContainer> iter = scanList.iterator();
		ScanDataContainer mCont = null;
		
		while (iter.hasNext())
		{
			mCont = iter.next();
			mCont.write();
		}
	}

	
	
}

