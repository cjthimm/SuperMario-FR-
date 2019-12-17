package GeneticAI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RunAI implements Runnable {

	private static int[][] genes;
	private static int organism =0;
	private static int count = 0;

	
	public static void NextGeneration() {
		organism = 0;
	}
	
	public static void NextMario() {
		System.out.println("Move to next organism");
		organism++;
	}


	@Override
	public void run() {
		
		genes = GeneGenerator.CreateGenes();
		Robot r;
		int preorg = 0;
		try {
			r = new Robot();
			r.delay(15000);
			 while (true) {
				 System.out.println("organism: "+organism + "|| preorg: " + preorg);
				 if(preorg < organism)
					 r.delay(3000);
				 
				 preorg = organism;
				 System.out.println(organism);
				
				 if(genes[organism][count] == 0) {
					r.keyPress(KeyEvent.VK_RIGHT);
				 	r.delay(150);
					r.keyRelease(KeyEvent.VK_RIGHT);
					System.out.println("right");
				}
				
				if(genes[organism][count] == 1) {
					r.keyPress(KeyEvent.VK_LEFT);
					r.delay(150);
					r.keyRelease(KeyEvent.VK_LEFT);
					System.out.println("jump");
				}
				
				if(genes[organism][count] == 2) {
					r.keyPress(KeyEvent.VK_X);
					r.delay(150);
					r.keyRelease(KeyEvent.VK_X);
					System.out.println("jump");
				}
				
				if(genes[organism][count] == 3) {
					r.keyPress(KeyEvent.VK_Z);
					r.delay(150);
					r.keyRelease(KeyEvent.VK_Z);
					System.out.println("FireBALL!!");
				}

				r.delay(250);
				count++;
			
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
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
}