package GeneticAI;

import java.util.Random;

public class GeneticAlgorithm {

	// String answer="levelCleared" ;
	// casey is finding out how to represent this with x distance
	int genotypeSize = 10;
	int maxGenerations = 1000;
	int fitnessThreshold = 10;
	int generationSize = 100;
	int numberOfParents = 2;
	double mutationRate = 0.03;

	class Organism {
		Genotype genotype;
		int fitness;
	}

	public static class Genotype {
		int[] genes;
		
		Genotype(int[] genes){
			this.genes = genes;
		}
		
		
		
	}
	public static Organism CreateGenes() {
		int genes[] = new int[1200];
		System.out.println("Creating genes");
		for (int i = 0; i < genes.length; i++) {
			// do the for in the row according to the column size
			System.out.println("");
			System.out.println("Printing the genenome of of the " + i + " organism:");
			
			genes[i] = ((int) (Math.random() * 4));
			System.out.print(genes[i]);
		}
		Organism test= new Organism();
		test.genotype.genes = genes;
	}

	void geneticAlgorithm() {
		Organism[] generation = new Organism[generationSize];
		for (int i = 0; i <= generationSize; i++) {
			generation[i] = Organism.CreateGenes();
			// and organism with a randomly generated genotype
			// randomly generate java.util.random with the about genes array
		}
		for (int g = 0; g <= maxGenerations; g++) {
			if (generation[0].fitness >= fitnessThreshold)
				break;
			for (int o; o <= generation.length; o++) {
				
				for (int i = 0; i < generation.length; i++) {
					Organism a = generation[i];
					Organism b = generation[i + 1];
					// swap if the organism a is smaller than b so that it will be largest to
					// smallest
					// obviously we cant compare the Organisms we need to give them fitness score
					// then compare
					if (a < b) {
						Organism temp;
						temp = a;
						a = b;
						b = temp;
					}
				}

			}

			Organism[] parents = new Organism[numberOfParents];
			// size of numberOfParents

			for (int i = 0; i < numberOfParents; i++) {
				// copy the array of organism over into parents in order of fitness.sorting
				// descending
				generation[i] = parents[i];

			}
			Organism[] nextGeneration = new Organism[generationSize];
			for (int i = 0; i <= generationSize; i++) {
				nextGeneration[i] = breed(parents);
			}
			for (int o; o <= nextGeneration.length; o++) {
				mutate(o);// ?
			}
			generation = nextGeneration;

		}
	}
	
	void evaluate(Organism o) {
		// ******Casey******* I think you said you were going to figure out how to find
		// this distance?
		// take the length of the x axis and take that difference and subtract by an
		// arbitrarily large number
		// 1000-x of mario to goal
		// that number is not the fitness score of that organism

		int fitnessScore = evaluate(o);
	}

	Organism breed(Organism[] parents) {
		int[] genes = new int[genotypeSize];
		Random r = new Random();
		for (int i = 0; i <= genotypeSize; i++) {

			Organism parentToInheritFrom = parents[r.nextInt(numberOfParents)];
			genes[i] = parentToInheritFrom.genotype.genes[i];
		}
		Genotype genotype= new Genotype(genes);
	}

	void mutate(Organism o) {
		for(int i=0; i<=genotypeSize; i++) {
			if(Math.random()< mutationRate) {
				//o.genotype.genes[i]= random genes so like up down left rights;
				o.genotype.genes[i]=Genotype.CreateGenes();
			}
				
		}
	}

}// end GenAlgo class
