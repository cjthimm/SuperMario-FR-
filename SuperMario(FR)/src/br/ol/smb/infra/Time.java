package br.ol.smb.infra;

import GeneticAI.RunAI;
import br.ol.smb.entity.Actor;

/**
 * Time class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 */
public class Time {
	public static int nextMove;
	public static boolean startCounter;
    //my code
    
    private static int fixedFrames;
    // note: all time in seconds
    private static double deltaTime;
    private static double currentTime;
    private static double previousTime;
    private static double unprocessedTime;
    private static double fixedDeltaTime = 1.0 / 60.0;
    private static int fixedUpdateCount;

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
            if(startCounter) {
                if(fixedFrames%15==0) {
                    nextMove++;
                	System.out.println("Index for next move = "+ nextMove+"\nX value ="+Actor.getMinX());// 1/4 SECONDS*******
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
