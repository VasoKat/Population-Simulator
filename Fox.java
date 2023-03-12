//Vasiliki Katogianni 
class Fox extends Animal{
	private int eatsteps=0;
	public boolean isRabbit(){
		return false;
	}
	public boolean timeToBreed(){
		if(getSteps()%8==0 && getSteps()>7){
			return true;
		}
		return false;
	}
	public Animal giveBirth(){
		Animal anim=new Fox();
		return anim;
	}
	public void move(){
		boolean value=true;
		for(Cell c:getC().getNeighbors()){
			if(c.containsRabbit()==true){
				Rabbit a=(Rabbit) c.getAnimal(); 
				a.becomeEaten(true);
				c.removeAnimal();
				this.getC().removeAnimal();
				c.setAnimal(this);
				c.getAnimal().setC(c);
				survived();
				eatsteps=0;
				value=false;
				break;	
			}
		}
		if(value==true){
			for(Cell c:getC().getNeighbors()){
				if(c.containsRabbit()==false){
					randomMove();
					survived();
					eatsteps++;
					break;
				}	
			}
		}	
	}
	public boolean starve(){
		if(eatsteps==3){
			getC().removeAnimal();
			return true;
		}
		return false;
	}
	public String toString(){
		return "X";
	}	
}	