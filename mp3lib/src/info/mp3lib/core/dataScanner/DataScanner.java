package info.mp3lib.core.dataScanner;

import info.mp3lib.core.Album;
import info.mp3lib.core.Artist;
import info.mp3lib.core.Track;

import java.io.File;

/**
 * Builds all the Album objects from the physical tree and stores them in a unique
 * Artist object
 */

public class DataScanner {
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
		Track track = null;
		Album album = null;

		// erreur d'initialisation
		if (!path.isDirectory())
			return;

		// - For each entry in this rootPath folder
		File[] fs = path.listFiles();
		for (int i = 0; i < fs.length; i++) {
			if (fs[i].isDirectory() == false) // files
			{
				// create new Container if first.
				if (album == null)
					album = new Album();

				// construct new ScanMusicData from this File.
				track = new Track(fs[i]);

				// add MusicData to its Container.
				album.add(track);
			} else // sub folders
			{
				// recursively check sub directories
				this.read(fs[i]);
			}
		}

		// store new unknown Album to scanList (unknown Artist)
		if (album != null)
			scanList.add(album);
	}

}
