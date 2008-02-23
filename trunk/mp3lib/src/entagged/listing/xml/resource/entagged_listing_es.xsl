<?xml version="1.0" encoding="UTF-8"?>
<!--
/*  XSL for the creation of a Spanish html.
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
-->
<xsl:stylesheet version="1.0" 
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xalan="http://xml.apache.org/xslt">

	<xsl:output method="html" 
              encoding="UTF-8"
              indent="yes" 
              xalan:use-url-escaping="yes"
              xalan:indent-amount="2"/>

	<xsl:template match="/">
		<HTML>
			<HEAD>
				<TITLE>ENTAGGED</TITLE>
			</HEAD>
			<BODY>
				<xsl:apply-templates />
			</BODY>
		</HTML>
	</xsl:template>

	<xsl:template match="audiolist">
		<table border="1" width="100%">
			<tr>
				<th>Archivo</th>
				<th>Int&#233;rprete</th>
				<th>&#193;lbum</th>
				<th>Pista</th>
				<th>T&#237;tulo</th>
				<th>G&#233;nero</th>
				<th>A&#241;o</th>
				<th>Comentarios</th>
			</tr>
			<xsl:for-each select="/audiolist/file">
				<tr>
					<td>
						<xsl:value-of select="@name" />
					</td>
					<td>
						<xsl:value-of select="tag/artist" />
					</td>
					<td>
						<xsl:value-of select="tag/album" />
					</td>
					<td>
						<xsl:value-of select="tag/track" />
					</td>
					<td>
						<xsl:value-of select="tag/title" />
					</td>
					<td>
						<xsl:value-of select="tag/genre" />
					</td>
					<td>
						<xsl:value-of select="tag/year" />
					</td>
					<td>
						<xsl:value-of select="tag/comment" />
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>

</xsl:stylesheet>