//Vasiliki Katogianni 
class Rabbit extends Animal{
	private boolean eaten=false;
	public boolean isRabbit(){
		return true;	
	}
	public boolean timeToBreed(){
		if(getSteps()%3==0 && getSteps()>2){
			return true;                            
		}                                        
		return false;
	}
	public Animal giveBirth(){
		Animal an=new Rabbit();
		return an;
	}	
	public void move(){
		randomMove();
		survived();	
	}	
	public void becomeEaten(boolean eaten){
		this.eaten=eaten;
	}
	public boolean isEaten(){
		return eaten;
	}
	public String toString(){
		return "o";
	}
}	