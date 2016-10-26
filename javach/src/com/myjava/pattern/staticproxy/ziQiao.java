package com.myjava.pattern.staticproxy;

//定义导演吕子乔，有很多导演要找一菲拍电影，电视剧，一菲很忙，没时间，所有导演得找她的经纪人，需要找宛瑜磋商
//导演 director
public class ziQiao {

	public static void main(String[] args) {
		//导演先找到宛瑜,同意了一菲接拍
		wanYu wy=new wanYu();//调用的是无参构造方法
		wy.movie();
		wy.teleplay();//看着是宛瑜在拍电影，拍电视剧，但实际上是一菲在做
		
		System.out.println("-----------------");
		//悠悠知道宛瑜很有名，就让宛瑜做自己的经纪人,悠悠顺利的接拍了电影和电视剧
		youYou yy =new youYou();
		wanYu w=new  wanYu(yy);//调用的是有参构造方法
		w.movie();
		w.teleplay();//实际是悠悠在拍电影和电视剧
	}
	
}
