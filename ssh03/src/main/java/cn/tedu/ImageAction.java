package cn.tedu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class ImageAction {
	
  private InputStream image;

    public InputStream getImage() {
	 return image;
    }

	public void setImage(InputStream image) {
		this.image = image;
	}

	public String doImage() throws IOException{
		  //����ͼƬ
		  BufferedImage img = new BufferedImage(100,60,BufferedImage.TYPE_3BYTE_BGR);
		  //��ȡ����
		  Graphics2D g = img.createGraphics();
		  //��ͼƬ�ϻ�ͼ
		  g.setColor(Color.white);
		  g.drawString("Hello World", 30, 20);
		  //��ͼƬת�����ֽ�����
		  ByteArrayOutputStream out = new ByteArrayOutputStream();
		  ImageIO.write(img, "png", out);
		  out.close();
		  //���ֽ�����ת��Ϊ�ֽ���
		  byte[] data = out.toByteArray();
		  image = new ByteArrayInputStream(data);
		  return "success";
	}
}
