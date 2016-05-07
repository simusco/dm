package com.moma.dawnlove.xml;

import java.io.Serializable;

public class Frame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6497492308845349693L;
	private String key;
	private String aliases;
	private String spriteColorRect;
	private String spriteOffset;
	private String spriteSize;
	private String spriteSourceSize;
	private String spriteTrimmed;
	private String textureRect;
	private String textureRotated;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAliases() {
		return aliases;
	}

	public void setAliases(String aliases) {
		this.aliases = aliases;
	}

	public String getSpriteColorRect() {
		return spriteColorRect;
	}

	public void setSpriteColorRect(String spriteColorRect) {
		this.spriteColorRect = spriteColorRect;
	}

	public String getSpriteOffset() {
		return spriteOffset;
	}

	public void setSpriteOffset(String spriteOffset) {
		this.spriteOffset = spriteOffset;
	}

	public String getSpriteSize() {
		return spriteSize;
	}

	public void setSpriteSize(String spriteSize) {
		this.spriteSize = spriteSize;
	}

	public String getSpriteSourceSize() {
		return spriteSourceSize;
	}

	public void setSpriteSourceSize(String spriteSourceSize) {
		this.spriteSourceSize = spriteSourceSize;
	}

	public String getSpriteTrimmed() {
		return spriteTrimmed;
	}

	public void setSpriteTrimmed(String spriteTrimmed) {
		this.spriteTrimmed = spriteTrimmed;
	}

	public String getTextureRect() {
		return textureRect;
	}

	public void setTextureRect(String textureRect) {
		this.textureRect = textureRect;
	}

	public String getTextureRotated() {
		return textureRotated;
	}

	public void setTextureRotated(String textureRotated) {
		this.textureRotated = textureRotated;
	}

	@Override
	public String toString() {
		return "Frame [key=" + key + ", aliases=" + aliases + ", spriteColorRect=" + spriteColorRect + ", spriteOffset="
				+ spriteOffset + ", spriteSize=" + spriteSize + ", spriteSourceSize=" + spriteSourceSize
				+ ", spriteTrimmed=" + spriteTrimmed + ", textureRect=" + textureRect + ", textureRotated="
				+ textureRotated + "]";
	}

}
