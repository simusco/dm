package com.moma.dawnlove.xml;

public class FrameAdaper {

	private String key;
	private String[] aliases;
	private int[] spriteColorRect;
	private int[] spriteOffset;
	private int[] spriteSize;
	private int[] spriteSourceSize;
	private boolean spriteTrimmed;
	private int[] textureRect;
	private boolean textureRotated;
	
	public static void main(String[] args) {
		String xx = "{{277, 507}, {102, 68}}";
		xx = xx.replaceAll("\\{", "").replaceAll("\\}", "");
		String[] xxs = xx.split(",");
		
		int[] ii = new int[xxs.length];
		for(int i=0;i<xxs.length;i++){
			ii[i] = Integer.valueOf(xxs[i].trim());
		}
	}
	
	public int[] toInt(String value){
		String scr = value;
		if(scr != null){
			scr = scr.replaceAll("\\{", "").replaceAll("\\}", "");
			String[] xxs = scr.split(",");
			
			int[] ii = new int[xxs.length];
			for(int i=0;i<xxs.length;i++){
				ii[i] = Integer.valueOf(xxs[i].trim());
			}
			
			return ii;
		}
		
		return null;
	}

	public FrameAdaper(Frame frame) {
		
		//转换数据
		this.key = frame.getKey();
		String a = frame.getAliases();
		if(a != null){
			aliases = a.split(",");
		}
		
		this.spriteColorRect = toInt(frame.getSpriteColorRect());
		this.spriteOffset = toInt(frame.getSpriteOffset());
		this.spriteSize = toInt(frame.getSpriteSize());
		this.spriteSourceSize = toInt(frame.getSpriteSourceSize());
		this.textureRect = toInt(frame.getTextureRect());
		this.spriteTrimmed = "true".equals(frame.getSpriteTrimmed()) ? true : false;
		this.textureRotated = "true".equals(frame.getTextureRotated()) ? true : false;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String[] getAliases() {
		return aliases;
	}

	public void setAliases(String[] aliases) {
		this.aliases = aliases;
	}

	public int[] getSpriteColorRect() {
		return spriteColorRect;
	}

	public void setSpriteColorRect(int[] spriteColorRect) {
		this.spriteColorRect = spriteColorRect;
	}

	public int[] getSpriteOffset() {
		return spriteOffset;
	}

	public void setSpriteOffset(int[] spriteOffset) {
		this.spriteOffset = spriteOffset;
	}

	public int[] getSpriteSize() {
		return spriteSize;
	}

	public void setSpriteSize(int[] spriteSize) {
		this.spriteSize = spriteSize;
	}

	public int[] getSpriteSourceSize() {
		return spriteSourceSize;
	}

	public void setSpriteSourceSize(int[] spriteSourceSize) {
		this.spriteSourceSize = spriteSourceSize;
	}

	public boolean isSpriteTrimmed() {
		return spriteTrimmed;
	}

	public void setSpriteTrimmed(boolean spriteTrimmed) {
		this.spriteTrimmed = spriteTrimmed;
	}

	public int[] getTextureRect() {
		return textureRect;
	}

	public void setTextureRect(int[] textureRect) {
		this.textureRect = textureRect;
	}

	public boolean isTextureRotated() {
		return textureRotated;
	}

	public void setTextureRotated(boolean textureRotated) {
		this.textureRotated = textureRotated;
	}

}
