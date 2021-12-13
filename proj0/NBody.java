public class NBody{

//	return universe radius
	public static double readRadius(String data){
		In in = new In(data);
		int first = in.readInt();
		double res = in.readDouble();
		return res;
	}


//	return planets arrary by file
	public static Planet[] readPlanets(String data){
		In in = new In(data);
		int num = in.readInt();
		double res = in.readDouble();
		Planet[] planets = new Planet[num];
		for(int i = 0; i < num; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
		}
		return planets;
	}

	public static void main(String[] args){
		double T =  Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius  = readRadius(filename);
		
		Planet[] planets;
		planets = readPlanets(filename);
		StdDraw.enableDoubleBuffering();

		/** Sets up the universe so it goes from*/
		StdDraw.setScale(-radius, radius);

		StdDraw.clear();

		
		double time = 0;
		
		
		for(time = 0; time < T; time = time + dt){
                    double[] xForces = new double[planets.length];
		    double[] yForces = new double[planets.length];
			for(int i = 0; i < planets.length; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);

			}

			for(int i =0; i < planets.length; i++){
				planets[i].update(time,xForces[i],yForces[i]);

			}
			
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for(int i = 0; i<planets.length; i++){
				planets[i].draw();
			}
                        StdDraw.show();
			StdDraw.pause(10);
			
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i += 1) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
		                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}
	}
}
