/**
 * AuthCode.java 2018 下午4:40:18
 * Flemming
 * com.flm.util TODO
 */
package cn.edu.cuit.study.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 登陆时的验证码
 * @author Flemming
 *
 */
public class AuthCode {
	
	public static final int AUTHCODE_LENGTH = 5;   //验证码长度
	public static final int SINGLECODE_WIDTH = 15;  //单个验证码宽度
	public static final int SINGLECODE_HEIGHT = 40;  //单个验证码高度
	public static final int SINGLECODE_GAP = 4;  //单个验证码之间的间距
	public static final int IMG_WIDTH = AUTHCODE_LENGTH *(SINGLECODE_WIDTH+SINGLECODE_GAP);
	public static final int IMG_HEIGHT = SINGLECODE_HEIGHT;
	
	
	//生成验证码的随机数字
	public static String getAuthCode(){
		String authCode = "";
		for(int i = 0; i < AUTHCODE_LENGTH ; i++){
			authCode += new Random().nextInt(10);
		}
		return authCode;
	}
	//生成图片
	public static BufferedImage getAuthImg(String authCode){
		BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
		//得到画笔
		Graphics g = image.getGraphics();
		//设置画笔颜色，用来填背景
		g.setColor(Color.GREEN);
		//填充矩形
		g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
		//设置画笔颜色，用来写字
		g.setColor(Color.BLACK);
		g.setFont(new Font("黑体", Font.PLAIN, SINGLECODE_HEIGHT + 5));
		
		//输出数字
		char c;
		for(int i = 0; i < authCode.toCharArray().length; i++){
			c = authCode.charAt(i);
			g.drawString(c+"", i * (SINGLECODE_WIDTH+SINGLECODE_GAP) + SINGLECODE_GAP/2, IMG_HEIGHT);
			System.out.println(c);
		}
		
		//干扰素  划线
		Random random = new Random();
		for(int i = 0; i < 20; i++){
			//起始坐标
			int x = random.nextInt(IMG_WIDTH);
			int y = random.nextInt(IMG_HEIGHT);
			//结束坐标
			int x1 = random.nextInt(IMG_WIDTH);
			int y1 = random.nextInt(IMG_HEIGHT);
			g.drawLine(x, y, x+x1, y+y1);
		}
		
		return image;
	}
	
}
