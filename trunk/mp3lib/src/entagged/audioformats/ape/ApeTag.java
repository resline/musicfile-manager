/*
 * Entagged Audio Tag library
 * Copyright (c) 2003-2005 Rapha�l Slinckx <raphael@slinckx.net>
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *  
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package entagged.audioformats.ape;

import entagged.audioformats.ape.util.ApeTagTextField;
import entagged.audioformats.generic.AbstractTag;
import entagged.audioformats.generic.TagField;

public class ApeTag extends AbstractTag {
	
	protected String getArtistId() {
	    return "Artist";
	}
    protected String getAlbumId() {
	    return "Album";
	}
    protected String getTitleId() {
	    return "Title";
	}
    protected String getTrackId() {
	    return "Track";
	}
    protected String getYearId() {
	    return "Year";
	}
    protected String getCommentId() {
	    return "Comment";
	}
    protected String getGenreId() {
	    return "Genre";
	}
    
    protected TagField createArtistField(String content) {
        return new ApeTagTextField("Artist", content);
    }
    protected TagField createAlbumField(String content) {
        return new ApeTagTextField("Album", content);
    }
    protected TagField createTitleField(String content) {
        return new ApeTagTextField("Title", content);
    }
    protected TagField createTrackField(String content) {
        return new ApeTagTextField("Track", content);
    }
    protected TagField createYearField(String content) {
        return new ApeTagTextField("Year", content);
    }
    protected TagField createCommentField(String content) {
        return new ApeTagTextField("Comment", content);
    }
    protected TagField createGenreField(String content) {
        return new ApeTagTextField("Genre", content);
    }
    
    protected boolean isAllowedEncoding(String enc) {
        return enc.equals("UTF-8");
    }
    
	public String toString() {
		return "APE "+super.toString();
	}
}

