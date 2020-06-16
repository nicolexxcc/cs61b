import java.util.ArrayList;

public class NBody{
	public static double readRadius(String fileName){
		In in = new In(fileName);

		int N = in.readInt();
		double R = in.readDouble();
		return R;	
	}

	public static Planet[] readPlanets(String fileName){
		In in = new In(fileName);
		int N = in.readInt();
		double R = in.readDouble();

		Planet[] planets = new Planet[N];
		for(int i=0; i<N; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
	        double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			planets[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
		}
		return planets;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");


//		Create a time variable and set it to 0. Set up a loop to loop until this time variable is T.
//		For each time through the loop, do the following:
//		Create an xForces array and yForces array.
//		Calculate the net x and y forces for each planet, storing these in the xForces and yForces arrays respectively.
//		Call update on each of the planets. This will update each planet’s position, velocity, and acceleration.
//				Draw the background image.
//				Draw all of the planets.
//		Show the offscreen buffer (see the show method of StdDraw).
//		Pause the animation for 10 milliseconds (see the pause method of StdDraw). You may need to tweak this on your computer.
//				Increase your time variable by dt.
		StdDraw.enableDoubleBuffering();

		for (int t = 0; t <= T; t += dt){
			Double[] xForces = new Double[planets.length];
			Double[] yForces = new Double[planets.length];
			for (int i = 0; i < planets.length; i++){
				xForces[i] = planets[i].calcForceExertedByX(planets[i]);
				yForces[i] = planets[i].calcForceExertedByY(planets[i]);
			}

			for (int i = 0; i < planets.length; i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			for (int i = 0; i < planets.length; i++) {
				planets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
					planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}

	}
}