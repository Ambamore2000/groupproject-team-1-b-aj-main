package project;

import acm.program.GraphicsProgram;

public class ProjectGraphics extends GraphicsProgram {

	public static final int RESOLUTION_X = 1920;
	public static final int RESOLUTION_Y = 1080;
	
	public void initializeApplet() {
		setSize(RESOLUTION_X, RESOLUTION_Y);
	}
	
}
