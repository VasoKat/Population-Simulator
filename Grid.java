//Vasiliki Katogianni 
import java.util.Random;
class Grid{
	private final int SIZE=20;
	private Cell[][] ar=new Cell[SIZE][SIZE];
	public Grid(){
		for(int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				ar[i][j]=new Cell();
				if(i>0){
					ar[i-1][j].addNeighbor(ar[i][j]);
					ar[i][j].addNeighbor(ar[i-1][j]);
				}
				if(j>0){
					ar[i][j-1].addNeighbor(ar[i][j]);
					ar[i][j].addNeighbor(ar[i][j-1]);
				}	
			}
		}
	}
	public void addRandomly(Animal animals){                                
		Random rnd=new Random(); 
		int xrandom=rnd.nextInt(20);
		int yrandom=rnd.nextInt(20);
		while(ar[xrandom][yrandom].isEmpty()==false){
			xrandom=rnd.nextInt(20);
			yrandom=rnd.nextInt(20);
		}	
		ar[xrandom][yrandom].setAnimal(animals);
		animals.setC(ar[xrandom][yrandom]);	
	}
	public String toString(){
		String string="";
		for(int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				if(ar[i][j].isEmpty()==true){
					string+="_ ";
					if(j==19){
						string+="\n";
					}	
				}else{
					string+=ar[i][j].getAnimal().toString()+" ";
					if(j==19){
						string+="\n";
					}
				}
			}
		}
		return string;
	}
}	
