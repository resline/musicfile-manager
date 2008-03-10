package info.mp3lib.core.business.order;

public interface IFillData {

	/**
	 * Retrieve PreScanned Data from a source (XML).
	 */
	public void getScanData();
	/**
	 * Retrieve CDDBData Result options for a file List 
	 */
	public void getCDDBData();
	/**
	 * Retrieve some clues about pertinent names from Directory Context
	 */
	public void getContextData();
	
	/**
	 * R�gles de gestion & validation des donn�es
	 * -> Gere les appels aux diff�rentes sources de donn�es,
	 * -> d�termine la pertinence des infos
	 * -> fixe un indice qualit� (si necessaire)..
	 */
	public void validate();
	
	/**
	 * Set validated filelist to an existing XML source.  
	 */
	public void fillXmlData();
	
	
}
