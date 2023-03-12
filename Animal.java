//Vasiliki Katogianni 
import java.util.Random;
public abstract class Animal{
	private Cell c=new Cell();
	private int steps=0;
	public abstract boolean isRabbit();
	public abstract boolean timeToBreed();
	public abstract Animal giveBirth();
	public abstract void move();
	public Cell getC(){
		return c;
	}
	public void setC(Cell c){
		this.c=c;
	}
	public int getSteps(){
		return steps;
	}
	public void setSteps(int steps){
		this.steps=steps;
	}
	public void survived(){
		steps++;
	}
	public void randomMove(){
		Cell newcell=c.getRandomNeighbor();	
		if(newcell!=null && newcell.isEmpty()==true){
			c.removeAnimal();
			newcell.setAnimal(this);
			newcell.getAnimal().setC(newcell);
			newcell=c;
		}
	}
	public Animal breed(){ 
		if(timeToBreed()==true){                                         
			for(Cell el:c.getNeighbors()){         
				if(el.isEmpty()==true){
					Animal b=giveBirth();
					el.setAnimal(b);
					b.setC(el);
					return b;
				}
			}
		}
		return null;
	}	
}			