package info.mp3lib.core.types;

import java.io.File;

import org.w3c.dom.Node;

import entagged.audioformats.Tag;

/**
 * All objects corresponding to a music file (It includes directory containing music files)
 * Irrespective of the file music format (see ITaggedMusicFile for this aspect)
 * @author Gabriel Pala
 * 
 * -- AudioFile
 * -- AbstractMusicFile
 * -- ITaggedMusicFile
 */
public abstract class IMusicData {
	
	/**
	 * retrieves the java absolute path (using / as separator) of the current music file.
	 * @return the file path
	 */
	abstract public String getAbsolutePath();
	
	/**
	 * retrieves the file size (in KB) of the current music file.
	 * @return the file size
	 */
	abstract public long getFileSize();
	
	/**
	 * retrieves the name of the current music file.
	 * @return the file name
	 */
	abstract public String getFileName();
	
	/**
	 * retrieves the zicFile node associated to the current music file
	 * @return the node
	 */
	abstract public Node getNode();
	
	/**
	 * retrieves the File associated to the current music file
	 * @return the File if it exists, else return null
	 */
	abstract public File getFile();
	
	/**
	 * Retrieves the music TagInfos associated to the current music file
	 * @return music TagInfos if exists, else return null
	 */
	abstract public Tag getTag();
	
	/**
	 * Abstract Method used for writing Music data to any source,
	 * in the implemented format.
	 */
	abstract void write();
}