package texture;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Texture {
	protected BufferedImage image;
	protected int[] imageDimensions = new int[2];
	protected int[] subImageDimensions = new int[2];
	
	public Texture() {}
	public Texture(BufferedImage image, int[] imageDimensions, int[] subImageDimensions) {
		this.image = image;
		try {
			this.imageDimensions = imageDimensions;
			this.subImageDimensions = subImageDimensions;
		}catch(Exception e) {
			System.out.println(e);
		} 
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public BufferedImage getImage() {
		return this.image;
	}
	public int[] getImageDimensions() {
		return imageDimensions;
	}
	public void setImageDimensions(int[] imageDimensions) {
		this.imageDimensions = imageDimensions;
	}
	public int[] getSubImageDimensions() {
		return subImageDimensions;
	}
	public void setSubImageDimensions(int[] subImageDimensions) {
		this.subImageDimensions = subImageDimensions;
	}
	
	@Override
	public String toString() {
		return "Texture [image=" + image + ", imageDimensions=" + Arrays.toString(imageDimensions)
				+ ", subImageDimensions=" + Arrays.toString(subImageDimensions) + "]";
	}
}