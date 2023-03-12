//Vasiliki Katogianni 
import java.util.Scanner;
class Simulation{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		PopulationSimulator p=new PopulationSimulator();
		System.out.println("Give the number of steps:");
		int answer=input.nextInt();
		System.out.println();
		p.simulate(answer);
	}
}	