

public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;		

	public Planet(double xP,double yP,double xV,double yV,double m,String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		return Math.sqrt((this.xxPos-p.xxPos) * (this.xxPos-p.xxPos)
			            + (this.yyPos-p.yyPos) * (this.yyPos-p.yyPos));
	}

	public double calcForceExertedBy(Planet p){
		double G = 6.67E-11;
		return (G*this.mass*p.mass)/(this.calcDistance(p)*this.calcDistance(p));
	}

	public double calcForceExertedByX(Planet p){
		return this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
	}

	public double calcForceExertedByY(Planet p){
		return this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] Ps){
		int i = 0;
		double Fx = 0;
		while (i < Ps.length){
			if(!this.equals(Ps[i])){
				Fx = Fx + this.calcForceExertedByX(Ps[i]);
			}
			i = i + 1;
		}
		return Fx;
	}

	public double calcNetForceExertedByY(Planet[] Ps){
		int i = 0;
		double Fy = 0;
		while (i < Ps.length){
			if(!this.equals(Ps[i])){
				Fy = Fy + this.calcForceExertedByY(Ps[i]);
			}
			i = i + 1;
		}
		return Fy;
	}

	public void update(double dt, double fX, double fY){
		double aX = fX / this.mass;
		double aY = fY / this.mass;

		this.xxVel = this.xxVel + dt * aX;
		this.yyVel = this.yyVel + dt * aY;

		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}

}