package GeneticAI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import GeneticAI.GeneticAlgorithm.Organism;
import br.ol.smb.infra.Game;
import br.ol.smb.infra.Time;
import br.ol.smb.infra.Game.GameState;

public class RunAI {

	private static int[] genes = null;
	private static boolean x = true;

	public static void setGenes(int[] genes2) {
		genes = genes2;
	}

	public static void NextMario() {
		x = false;
	}

	public static int runRobot(Organism o) {
		int count = 0;
		x = true;
		setGenes(o.genotype.genes);
		int fitness = -1;
		Robot r;

		try {
			r = new Robot();
			// r.delay(4000);
			// r.delay(15000);
			while (Game.getGameState() != GameState.PLAYING) {
				r.delay(4000 * 60 / Time.fps);
			}
			while (x) {

				// System.out.println("Generation number" + GeneticAlgorithm.generationNumber+ "
				// Organism #: "+ organism);

				if (genes[count] == 0) {
					r.keyPress(KeyEvent.VK_RIGHT);
					r.delay(250 * 60 / Time.fps);
					r.keyRelease(KeyEvent.VK_RIGHT);
					// System.out.println("right - "+(250*60/Time.fps));
				}

				if (genes[count] == 1) {
					r.keyPress(KeyEvent.VK_RIGHT);
					r.keyPress(KeyEvent.VK_X);
					r.delay(350 * 60 / Time.fps);
					r.keyRelease(KeyEvent.VK_RIGHT);
					r.keyPress(KeyEvent.VK_X);
					// System.out.println("jump - "+(350*60/Time.fps));
				}

				if (genes[count] == 2) {
					r.keyPress(KeyEvent.VK_X);
					r.delay(350 * 60 / Time.fps);
					r.keyRelease(KeyEvent.VK_X);
					// System.out.println("jump - "+(350*60/Time.fps));
				}

				if (genes[count] == 3) {
					r.keyPress(KeyEvent.VK_RIGHT);
					r.keyPress(KeyEvent.VK_Z);
					r.delay(130 * 60 / Time.fps);
					r.keyRelease(KeyEvent.VK_Z);
					r.keyRelease(KeyEvent.VK_RIGHT);
					// System.out.println("FireBALL!! - "+(130*60/Time.fps));
				}

				// r.delay(100*60/Time.fps);
				// System.out.println("r.delay - "+(100*60/Time.fps));
				count++;
				fitness = Time.getxAfterDeath();
				// System.out.println("fitness: "+fitness);

			}

		} catch (AWTException e) {
			e.printStackTrace();
		}
		return fitness;
	}
}