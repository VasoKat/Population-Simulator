//Vasiliki Katogianni 
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;
class PopulationSimulator{
	private Grid grid=new Grid();;
	private HashSet<Rabbit> rabbits = new HashSet<Rabbit>();
	private HashSet<Fox> foxes = new HashSet<Fox>();
	private int NUM_OF_FOXES=5;
	private int NUM_OF_RABBITS=100;
	private ArrayList<Fox> fnew = new ArrayList<Fox>();
	private ArrayList<Fox> fold = new ArrayList<Fox>();
	private ArrayList<Rabbit> rnew = new ArrayList<Rabbit>();
	private ArrayList<Rabbit> rold = new ArrayList<Rabbit>();
	private void populateGrid(){
		for(int n=0;n<NUM_OF_FOXES;n++){
			Fox f=new Fox();
			grid.addRandomly(f);
			foxes.add(f);
		}
		for(int n=0;n<NUM_OF_RABBITS;n++){
			Rabbit r=new Rabbit();
			grid.addRandomly(r);
			rabbits.add(r);
		}
	}
	private void handleFoxes(){
		for(Fox fx:foxes){
			fx.move();
			if(fx.starve()==false){
				Animal child=fx.breed();  
				if(child!=null){
					Fox children=(Fox)child;
					fnew.add(children);
				}	
			}else{
				fold.add(fx);
			}	
		}
		for(Fox fx:fold){
			foxes.remove(fx);
		}
		for(Fox fx:fnew){
			foxes.add(fx);
		}
		fold = new ArrayList<Fox>();
		fnew = new ArrayList<Fox>();
	}
	private void handleRabbits(){
		for(Rabbit rb:rabbits){
			if(rb.isEaten()==false){
				rb.move();
				Animal child=rb.breed();  
				if(child!=null){
					Rabbit children=(Rabbit)child;
					rnew.add(children);
				}
			}else if(rb.isEaten()==true){	
				rold.add(rb);
			}	
		}
		for(Rabbit rb:rold){
			rabbits.remove(rb);	
		}
		for(Rabbit rb:rnew){
			rabbits.add(rb);
		}
		rnew = new ArrayList<Rabbit>();
		rold = new ArrayList<Rabbit>();
	}
	public void simulate(int nsteps){
		populateGrid();
		System.out.println(grid);
		System.out.println(rabbits.size()+" rabbits and "+foxes.size()+" foxes");
		for(int n=0;n<nsteps;n++){
			Scanner input = new Scanner(System.in);
			String an=input.nextLine();
			if(an.equals("")){
				handleFoxes();
				handleRabbits();
				System.out.println(grid);
				System.out.println(rabbits.size()+" rabbits and "+foxes.size()+" foxes");
			}	
		}
	}	
}	