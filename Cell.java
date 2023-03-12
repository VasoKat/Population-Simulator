//Vasiliki Katogianni 
import java.util.ArrayList;
import java.util.Random;
class Cell{
	private ArrayList<Cell> neighbors = new ArrayList<Cell>();
	private Animal animal=null;
	private int or;
	private int ka;
	public Cell(int or,int ka){
		this.or=or;
		this.ka=ka;
	}
	public Cell(){
	}	
	public String toString(){
		return or+" "+ka;
	}	
	public ArrayList<Cell> getNeighbors(){ 
		return neighbors;
	}
	public void addNeighbor(Cell cell){
		neighbors.add(cell);
	}
	public Cell getRandomNeighbor(){ 
		Random rnd=new Random(); 
		int random=rnd.nextInt(4);
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				if(i==0 || i==19 || j==0 || j==19){
					if(random>=neighbors.size()){
						return null;
					}
				}
			}
		}
		return neighbors.get(random);
	}
	public void removeAnimal(){
		this.animal=null;
	}
	public boolean isEmpty(){
		if(animal==null){
			return true;
		}
		return false;
	}
	public boolean containsRabbit(){
		if(animal!=null && animal.isRabbit()){
			return true;
		}
		return false;
	}
	public Animal getAnimal(){
		return animal;
	}
	public void setAnimal(Animal animal){
		this.animal=animal;
	}	
}	