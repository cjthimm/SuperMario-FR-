package br.ol.smb.infra;
​
import java.util.Random;
​
public class GenAlgo {
	
	//String answer="levelCleared" ;
	//casey is finding out how to represent this with x distance
	int genotypeSize= 10;
	int maxGenerations= 1000;
	int fitnessThreshold=10;
	int generationSize=100;
	int numberOfParents=2;
	double mutationRate=0.03;
	
	class Organism{
		Genotype genotype;
		int fitness;
	}
	
	class Genotype{
		char[] genes;
		//array of the four commands to make mario move
		/////********Tanner********
		//we also need a constructor for genes to make a radom genotype down on line 74
	}
	
	void geneticAlgorithm() {
		Organism[] generation= new Organism[generationSize];
		for(int i=0; i<=generationSize;i++) {
			generation[i]=new Genotype[];//and organism with a randomly generated genotype
			//randomly generate java.util.random with the about genes array
		}
		for(int g=0; g<=maxGenerations;g++) {
			if(generation[0].fitness >= fitnessThreshold)
				break;
			for(int o; o<=generation.length; o++) {
				evaluate(o);//how do you evalute
				//******Casey******* I think you said you were going to figure out how to find this distance?
				//take the length of the x axis and take that difference and subtract by an arbitrarily large number
				//1000-x of mario to goal
				//that number is not the fitness score of that organism
				//sort the organism array from most fit to least(descening order)
			}
			Organism[] parents= new Organism[numberOfParents];
			//size of numberOfParents
			
			for(int i=0; i<numberOfParents;i++) {
				//copy the array of organism over into parents in order of fitness.sorting descending
				Organism[i]=parents[i];
				
			}
			Organism[] nextGeneration= new Organism[generationSize];
			for(int i=0; i<=generationSize;i++) {
				nextGeneration[i]= breed(parents);
			}
			for(int o; o<=nextGeneration.length;o++) {
				mutate(o);//?
			}
			generation= nextGeneration;
			
		}
		o.fitness=number of correct characters in the Organisms genotype;//how do you find this
	}
	
	Organism breed(Organism[]parents) {
		char[]genes= new char[genotypeSize];
		Random r= new Random();
		for(int i=0; i<=genotypeSize;i++) {
			
			Organism parentToInheritFrom= parent[r.nextInt(numberOfParents)];
			genes[i]= parentToInheritFrom.genotype.genes[i];
		}
		return new Genotype(genes);
		//we need a genotype constructor
	
	}
	
	void mutate(Organism o) {
		for(int i=0; i<=genotypeSize; i++) {
			if(Math.random()< mutationRate)
				//o.genotype.genes[i]= random genes so like up down left rights;
		}
	}
		
				
​
}//end GenAlgo class