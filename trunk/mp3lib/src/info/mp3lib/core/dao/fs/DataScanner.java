package info.mp3lib.core.dao.fs;

import info.mp3lib.core.Album;
import info.mp3lib.core.Artist;
import info.mp3lib.core.Library;
import info.mp3lib.core.Track;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * Builds all the Album objects from the physical tree and stores them in a unique
 * Artist object
 */

public class DataScanner {

	/** the unique instance of the singleton */
	private static DataScanner instance = null;

	private static final long serialVersionUID = -1963252596917406454L;

	private final static Logger LOGGER = Logger.getLogger(DataScanner.class.getName());

	/** the unique artist in which store all the retrieved album */
	private Artist scanList;

	/** static access to the singleton */
	public static DataScanner getInstance() {
		if (instance == null) {
			instance = new DataScanner();
		}
		return instance;
	}

	/**
	 * Private Constructor.
	 */
	private DataScanner() {
		scanList = Library.getInstance().getArtist(Library.DEFAULT_UNKNOWN_ELT_NAME);
	}

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
		Album album = null;

		// erreur d'initialisation
		if (!path.isDirectory())
			return;

		// - For each entry in this rootPath folder
		File[] fileList = path.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isDirectory() == false) // files
			{
				// creates new Container if first.
				if (album == null)
					album = new Album(fileList[i].getParentFile().getName());

				// constructs new ScanMusicData from this File.
				try {
					// adds MusicData to its Container.
					album.add(new Track(fileList[i]));
				} catch (IllegalArgumentException e) {
					LOGGER.debug("the given file is not in a supported audio format : ".concat(fileList[i].getAbsolutePath()));
				}
			} else // sub folders
			{
				// recursively check sub directories
				this.read(fileList[i]);
			}
		}

		// store new unknown Album to scanList (unknown Artist)
		if (album != null)
			scanList.add(album);
	}

	/**
	 * retrieves the default unknown artist containing all unsorted music files read from the file system
	 * @return the scanList
	 */
	public Artist getScanList() {
		return scanList;
	}

}
