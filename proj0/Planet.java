import java.math.*;
public class Planet{
	private static final Double G = 6.67e-11;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

//  tow planet distance
	public double calcDistance(Planet p){
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		double res = Math.pow(dx,2) + Math.pow(dy,2);
		return Math.sqrt(res);

	}

//	total force
	public double calcForceExertedBy(Planet p){
		double res = G*(this.mass)*p.mass/Math.pow(calcDistance(p),2);
		return res;

	}

//	x dirction force
	public double calcForceExertedByX(Planet p){
		double dx = p.xxPos - this.xxPos;
		
		double res = calcForceExertedBy(p) * dx / calcDistance(p);
		return res;

	}

//	y dirction force
	public double calcForceExertedByY(Planet p){
		double dy = p.yyPos - this.yyPos;
		
		
		double res = calcForceExertedBy(p) * dy / calcDistance(p);
		return res;

	}

//	all planets x dirction force
	public double calcNetForceExertedByX(Planet[] allPlanets){
		double res = 0;
		int num = allPlanets.length;
		for(int i = 0; i<num; i++){
			if(!this.equals(allPlanets[i])){
				res += calcForceExertedByX(allPlanets[i]);
			}
		}
		
		return res;

	}

// 	all planets y dirction force
	public double calcNetForceExertedByY(Planet[] allPlanets){
		double res = 0;
		int num = allPlanets.length;
		for(int i = 0; i<num; i++){
			if(!this.equals(allPlanets[i])){
				res += calcForceExertedByY(allPlanets[i]);
			}
		}
		
		return res;

	}


//	xxVel yyVel xxPos yyPos change
	public void update(double dt, double fX, double fY){
		double aX = fX / this.mass;
		double aY = fY / this.mass;
		this.xxVel = this.xxVel + aX * dt;
		this.yyVel = this.yyVel + aY * dt;
		this.xxPos = this.xxPos + dt * xxVel;
		this.yyPos = this.yyPos + dt * yyVel;
	}

//	draw planet
	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
	}
}