package GeneticAI;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import br.ol.smb.infra.Time;


public class GeneticAlgorithm implements Runnable {

	int genotypeSize = 1200;
	int maxGenerations = 1000;
	int fitnessThreshold = 3043;
	int generationSize = 4; //Changed lower temperaroly
	int numberOfParents = 2;
	double mutationRate = 0.03;

	class Organism {
		Genotype genotype;
		int fitness;

		public Organism(Genotype genotype) {
			this.genotype = genotype;
		}
	}

	public static class Genotype {
		int[] genes;

		Genotype(int[] genes) {
			this.genes = genes;
		}

	}

	public Organism CreateOrganism() {
		int genes[] = new int[genotypeSize];
			for (int i = 0; i < genes.length; i++) {
				genes[i] = ((int) (Math.random() * 4));
		}
		System.out.println(Arrays.toString(genes));
		Organism test = new Organism(new Genotype(genes));
		return test;
	}

	void geneticAlgorithm() {
		Organism[] generation = new Organism[generationSize];
		for (int i = 0; i < generationSize; i++) {
			generation[i] = CreateOrganism();
		}
		for (int g = 0; g < maxGenerations; g++) {
			if (generation[0].fitness >= fitnessThreshold)
				break;
			for (int o = 0; o < generation.length; o++) {
				evaluate(generation[o]);
			}

			for (int i = 0; i < generation.length-1; i++) {
				int a = generation[i].fitness;
				int b = generation[i + 1].fitness;
				if (a < b) {
					int temp;
					temp = a;
					a = b;
					b = temp; 
				}
			}
			// selection
			Organism[] parents = new Organism[numberOfParents];

			for (int i = 0; i < numberOfParents; i++) {
				// copy the array of organism over into parents in order of fitness.sorting
				// descending
				parents[i]=generation[i];
			}
			Organism[] nextGeneration = new Organism[generationSize];
			for (int i = 0; i < generationSize; i++) {
				nextGeneration[i] = breed(parents);
			}
			for (int o = 0; o < nextGeneration.length; o++) {
				mutate(nextGeneration[o]);
			}
			generation = nextGeneration;
			PrintWriter out;
			
			try {
				out = new PrintWriter("genotype.txt");
				out.println("The two fittest organisms were:\n " + Arrays.toString(parents[0].genotype.genes)
						+ "\nWith a fitness score of: " + parents[0].fitness + "\nand \n"
						+ Arrays.toString(parents[1].genotype.genes) + "\nWith a fitness score of:\n"
						+ parents[1].fitness);
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
	}// end void geneticAlgorithm

	void evaluate(Organism o) {
		o.fitness = RunAI.runRobot(o);
		System.out.println("Fitness:  "+o.fitness);
	}

	Organism breed(Organism[] parents) {
		int[] genes = new int[genotypeSize];
		Random r = new Random();
		for (int i = 0; i < genotypeSize; i++) {
			Organism parentToInheritFrom = parents[r.nextInt(numberOfParents)];
			System.out.println(i);
			System.out.println(parentToInheritFrom);
			System.out.println(genes.length); 
			//Exception Occured below
			genes[i] = parentToInheritFrom.genotype.genes[i];
		}
		Genotype genotype = new Genotype(genes);
		return new Organism(genotype);
	}

	void mutate(Organism o) {
		Random r = new Random();
		for (int i = 0; i <genotypeSize; i++) {
			if (Math.random() < mutationRate) {
				o.genotype.genes[i] = r.nextInt(4);
			}

		}

	}// end GenAlgo class

	@Override
	public void run() {
		geneticAlgorithm();
	}

}
