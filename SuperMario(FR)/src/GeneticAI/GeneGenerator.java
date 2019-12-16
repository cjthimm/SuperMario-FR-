package GeneticAI;

public class GeneGenerator {

	public static int[][] CreateGenes(){
		int values[][] = new int[20][1200];
		System.out.println("Creating genes");
	    for (int i = 0; i < values.length; i++) {
	        // do the for in the row according to the column size
	    	System.out.println("");
			System.out.println("Printing the genenome of of the "+i+" organism:");
	        for (int j = 0; j < values[i].length; j++) {
	            // multiple the random by 10 and then cast to in
	            values[i][j] = ((int) (Math.random() * 4));
	            System.out.print(values[i][j]);
	        }
	        // add a new line
	    }
	    
	    System.out.println("Done");
	    return values;
	}
	
	//Testing main
//	public static void main(String args[]) {
//		int[][] genes = CreateGenes();
//		for (int i = 0; i < genes.length; i++) {

//			System.out.println("");
//			System.out.println("Printing the genenome of of the "+i+" organism:");
//			
//	        for (int j = 0; j < genes[i].length; j++) {	        	
//	        	System.out.print(genes[i][j]);
//	        }
//		}
//	}
	
	
}//End of class
