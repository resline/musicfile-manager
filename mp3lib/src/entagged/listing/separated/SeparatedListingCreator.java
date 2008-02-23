/*
 *  ********************************************************************   **
 *  Copyright notice                                                       **
 *  **																	   **
 *  (c) 2003 Entagged Developpement Team				                   **
 *  http://www.sourceforge.net/projects/entagged                           **
 *  **																	   **
 *  All rights reserved                                                    **
 *  **																	   **
 *  This script is part of the Entagged project. The Entagged 			   **
 *  project is free software; you can redistribute it and/or modify        **
 *  it under the terms of the GNU General Public License as published by   **
 *  the Free Software Foundation; either version 2 of the License, or      **
 *  (at your option) any later version.                                    **
 *  **																	   **
 *  The GNU General Public License can be found at                         **
 *  http://www.gnu.org/copyleft/gpl.html.                                  **
 *  **																	   **
 *  This copyright notice MUST APPEAR in all copies of the file!           **
 *  ********************************************************************
 */
package entagged.listing.separated;

import entagged.audioformats.AudioFile;
import entagged.audioformats.Tag;
import entagged.listing.Lister;

/**
 * This class creates a Listing with a separator specified during construction.
 * <br>
 * Default separator is a tab.
 * 
 * @author Christian Laireiter
 */
public class SeparatedListingCreator implements Lister {
    /**
     * This constant holds the default separator.
     */
    public final static String DEFAULT_SEPARATOR = "\t";

    /**
     * This field will store the content which is generated by this class.
     */
    private StringBuffer content;

    /**
     * Stores the separator which is used for listing generation.
     */
    private String separator;

    /**
     * Creates an instance using {@link #DEFAULT_SEPARATOR}as separator.
     */
    public SeparatedListingCreator() {
        this(DEFAULT_SEPARATOR);
    }

    /**
     * Creates an instance using the given separator for generation.
     * 
     * @param valueSeparator
     *                   the value separator which should be used.
     */
    public SeparatedListingCreator(String valueSeparator) {
        if (valueSeparator == null) {
            throw new IllegalArgumentException("Argument must not be null.");
        }
        this.separator = valueSeparator;
        this.content = new StringBuffer(4096);
    }

    /**
     * (overridden)
     * 
     * @see entagged.listing.Lister#addFile(java.lang.String)
     */
    public void addFile(String fileName) {
        content.append(fileName).append("\n");
    }

    /**
     * This method appends the given tag to the listing.
     * 
     * @param audioFile
     *                   The file which should be listed.
     * @param fileName
     *                   The filename (path) of the file <code>tag</code> comes from.
     */
    public void addFile(AudioFile audioFile, String fileName) {
        content.append(fileName);
        Tag tag = audioFile.getTag();

        content.append(tag.getFirstArtist()).append(separator);
        content.append(tag.getFirstAlbum()).append(separator);
        content.append(tag.getFirstTrack()).append(separator);
        content.append(tag.getFirstTitle()).append(separator);
        content.append(tag.getFirstGenre()).append(separator);
        content.append(tag.getFirstYear()).append(separator);
        content.append(tag.getFirstComment()).append("\n");
    }

    /**
     * (overridden)
     * 
     * @see entagged.listing.Lister#close()
     */
    public void close() {
        // Nothing todo for this type of listing.
    }

    /**
     * (overridden)
     * 
     * @see entagged.listing.Lister#getContent()
     */
    public String getContent() {
        return content.toString();
    }
}