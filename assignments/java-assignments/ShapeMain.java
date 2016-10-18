abstract class Shape{
	abstract void draw();
}

class MyPoint extends Shape{
	void draw(){
		System.out.println("Mypoint.Shape");
	}
}

class MyCube extends Shape{
	void draw(){
		System.out.println("MyCube.Shape");
	}
}

class MyRect extends Shape{
	void draw(){
		System.out.println("Myrect.Shape");
	}
}

class MyLine extends Shape{
	void draw(){
		System.out.println("Myline.Shape");
	}
}

public class ShapeMain{
	public static void main(String args[]){
		Shape s[] = new Shape[4];
		s[0] = new MyCube();
		s[1] = new MyRect();
		s[2] = new MyPoint();
		s[3] = new MyLine();
		for(int i= 0 ;i<s.length;i++){
			s[i].draw();
		}
	}
}