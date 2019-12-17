package GeneticAI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import GeneticAI.GeneticAlgorithm.Organism;
import br.ol.smb.infra.Time;

public class RunAI {

	private static int[] genes =null;
	private static int organism =0;
	private static int count = 0;
	private static boolean x = true;

	public static void setGenes(int[] genes2) {
		genes = genes2;
	}
	public static void NextGeneration() {
		organism = 0;
	}
	
	public static void NextMario() {
		System.out.println("Move to next organism");
		organism++;
		x = false;
	}

 
	public static int runRobot(Organism o) {
		int count = 0;
		x= true;
		setGenes(o.genotype.genes);
		//genes = GeneGenerator.CreateGenes();
		int fitness = -1;
		Robot r;
		//int preorg = 0;
		try {
			r = new Robot();
			//r.delay(15000);
			 while (x) {
				 
				 System.out.print(genes[0]);
				 System.out.print(genes[1]);
				 System.out.print(genes[2]);
				 System.out.print(genes[3]);
				 System.out.print(genes[4]);
				
				 
				 //if(genes[count][organism] == 0) {
				 if(genes[count] == 0) {
					r.keyPress(KeyEvent.VK_RIGHT);
				 	r.delay(150);
					r.keyRelease(KeyEvent.VK_RIGHT);
					System.out.println("right");
				}
				
//				if(genes[count] == 1) {
//					r.keyPress(KeyEvent.VK_LEFT);
//					r.delay(150);
//					r.keyRelease(KeyEvent.VK_LEFT);
//					System.out.println("jump");
//				}
				
				if(genes[count] == 2) {
					r.keyPress(KeyEvent.VK_X);
					r.delay(150);
					r.keyRelease(KeyEvent.VK_X);
					System.out.println("jump");
				}
				
				if(genes[count] == 3) {
					r.keyPress(KeyEvent.VK_Z);
					r.delay(150);
					r.keyRelease(KeyEvent.VK_Z);
					System.out.println("FireBALL!!");
				}

				r.delay(250);
				count++;
				fitness = Time.getX();
				System.out.println("fitness: "+fitness);
			
			}
			 
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fitness;
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
//					r.delay(1000);l
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