/*
 * Entagged Audio Tag library
 * Copyright (c) 2004-2005 Christian Laireiter <liree@web.de>
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
package entagged.audioformats.asf.util;

import java.util.Comparator;

import entagged.audioformats.asf.data.Chunk;

/**
 * This class is needed for ordering all types of
 * {@link entagged.audioformats.asf.data.Chunk}s ascending by their Position.
 * <br>
 * 
 * @author Christian Laireiter
 */
public class ChunkPositionComparator implements Comparator {

	/**
	 * (overridden)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Object o1, Object o2) {
		int result = 0;
		if (o1 instanceof Chunk && o2 instanceof Chunk) {
			Chunk c1 = (Chunk) o1;
			Chunk c2 = (Chunk) o2;
			result = (int) (c1.getPosition() - c2.getPosition());
		}
		return result;
	}

}