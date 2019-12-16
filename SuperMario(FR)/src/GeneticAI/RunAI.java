package GeneticAI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RunAI implements Runnable {

	private static int[][] genes;
	//private static int count = 0;
	
	
//	static Robot r;
//	
//	public RunAI(){
//		try {
//			r = new Robot();
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	public static void StartAI() throws AWTException {
//			
//			genes = GeneGenerator.CreateGenes();
//			Robot r = new Robot();
//			for (int i = 0; i < genes.length; i++) {
//				for (int j = 0; j < genes[i].length; j++) {	
//					if(genes[i][j] == 0) {
//						r.keyPress(KeyEvent.VK_RIGHT);
//						System.out.println("right");
//					}
//					
//					if(genes[i][j] == 1) {
//						r.keyPress(KeyEvent.VK_RIGHT);
//						System.out.println("right");
//					}
//					
//					if(genes[i][j] == 2) {
//						r.keyPress(KeyEvent.VK_X);
//						System.out.println("jump");
//					}
//
//					r.delay(1000);
//				}
//			}
//
//	}
////	public static void RunNextInput() {
////
////		if(genes[0][count] == 0) {
////			r.keyPress(KeyEvent.VK_RIGHT);
////			System.out.println("right");
////		}
////		
////		if(genes[0][count] == 1) {
////			r.keyPress(KeyEvent.VK_RIGHT);
////			System.out.println("right");
////		}
////		
////		if(genes[0][count] == 2) {
////			r.keyPress(KeyEvent.VK_X);
////			System.out.println("jump");
////		}
////
////		count++;
////	}
//	public static void main(String args[]) {
//		try {
//			StartAI();
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}


	@Override
	public void run() {
		genes = GeneGenerator.CreateGenes();
		Robot r;
		try {
			r = new Robot();
		
		for (int i = 0; i < genes.length; i++) {
			for (int j = 0; j < genes[i].length; j++) {	
				if(genes[i][j] == 0) {
					r.keyPress(KeyEvent.VK_RIGHT);
					System.out.println("right");
				}
				
				if(genes[i][j] == 1) {
					r.keyPress(KeyEvent.VK_RIGHT);
					System.out.println("right");
				}
				
				if(genes[i][j] == 2) {
					r.keyPress(KeyEvent.VK_X);
					System.out.println("jump");
				}

				r.delay(1000);
			}
		}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
