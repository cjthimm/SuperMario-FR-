package br.ol.smb.infra;

import GeneticAI.RunAI;
import br.ol.smb.entity.Actor;
import br.ol.smb.entity.Mario;
import br.ol.smb.infra.Game.GameState;

/**
 * Time class.
 * 
 *@author Leonardo Ono (ono.leo@gmail.com)
 */
public class Time {
	public static int nextMove;
	public static boolean startCounter;
	public static int fps = 60;
    //my code
    
    private static int fixedFrames;
    // note: all time in seconds
    private static double deltaTime;
    private static double currentTime;
    private static double previousTime;
    private static double unprocessedTime;
    private static double fixedDeltaTime = 1.0 / fps;
    private static int fixedUpdateCount;
    public static boolean dead;
    public static int xValue;

    public static boolean getDead() {
    	return dead;
    }
    public static int getX() {
    	return xValue;
    }
    
    public static int getFixedFrames() {
        return fixedFrames;
    }

    public static double getCurrentTime() {
        return currentTime;
    }

    public static double getDeltaTime() {
        return deltaTime;
    }

    public static double getFixedDeltaTime() {
        return fixedDeltaTime;
    }
    
    static void start() {
        currentTime = System.nanoTime() * 0.000000001;
        previousTime = currentTime - fixedDeltaTime;
    }
    
    static void update() {
        currentTime = System.nanoTime() * 0.000000001;
        deltaTime = currentTime - previousTime;
        unprocessedTime += deltaTime;
        while (unprocessedTime >= fixedDeltaTime) {
            unprocessedTime -= fixedDeltaTime;
            fixedUpdateCount++;
            fixedFrames++;
            if(Game.getGameState() == GameState.PLAYING&&!Mario.marioIsDead()) {
                if(fixedFrames%15==0) {
                    nextMove++;
                	System.out.println("*****Index for next move = "+ nextMove);
                	System.out.println("X value = "+Actor.getMinX());// 1/4 SECONDS*******
                    if(Mario.marioIsDead()) {
                    	//startCounter = false;
                		dead = true;
                		xValue = Actor.getMinX();
                	}
                    else{
                    	dead = false;
                    }
                }
            }
        }
        previousTime = currentTime;	
    }
    
    static boolean needsFixedUpdate() {
        if (fixedUpdateCount > 0) {
            fixedUpdateCount--;
            return true;
        }
        return false;
    }
    
}
