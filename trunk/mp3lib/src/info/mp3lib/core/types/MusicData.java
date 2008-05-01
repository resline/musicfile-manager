package info.mp3lib.core.types;

import java.io.File;

import org.w3c.dom.Node;

import entagged.audioformats.Tag;

public class MusicData extends IMusicData {

	private static final long serialVersionUID = 1L;
	protected Tag tag = null;
	protected File file = null;
	protected Node node = null;

	
	
	public MusicData(File file){
		this.file = file;
	}
	
	protected MusicData(Tag tag) {
		this.tag = tag;
	}
	
	protected MusicData(File file, Tag tag) {
		this.file = file;
		this.tag = tag;
	}
	
	@Override
	public String getAbsolutePath() {
		return file.getAbsolutePath();
	}

	@Override
	public File getFile() {
		return file;
	}

	@Override
	public String getFileName() {
		return file.getName();
	}

	@Override
	public long getFileSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Node getNode() {
		// TODO Auto-generated method stub
		return node;
	}

	@Override
	public Tag getTag() {
		return tag;
	}

	@Override
	public void write() {
		
	}
	
}