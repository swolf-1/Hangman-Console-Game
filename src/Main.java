
import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		//Kataskevi antikeimenwn random kai scanner
		
		Random number = new Random();
		Scanner read = new Scanner(System.in);
		
		//Dilosi metavlitwn
		
		char c;
		int GamesPlayed =0,Wins = 0,CorrcetGuesses = 0,exit =0;

		//Epanalipsi paixnidiou mexri o xristis epileksei exodo
		
		do{	
			
		   //Elegxos egirotitas gia to MENU
			
			do{
				
				System.out.print("      MAIN MENU\n"
							   + "- Start a new Game (N)\n"
							   + "- Statistics (S)\n"
							   + "- Exit (E)\n"
							   + "Please enter your choice: ");

				c = read.next().charAt(0);
				
		  		//Elegxos gia mikra grammata kai an yparxoun metatropi se kefalaia(to idio ginete kai stis grammes 70 kai 71) 
				
				if(Character.isLowerCase(c))
					 c = Character.toUpperCase(c);

				if (c != 'N' && c != 'S' && c != 'E')
					System.out.println("WRONG!!!!Select one of the following");
						
				} while(c != 'N' && c != 'S' && c != 'E');
			
		    //Kirios paixnidi an o xristis eisagei apo to plikrologio to gramma n
			
			if(c == 'N'){
				
				//Kathe fora pou kanei enarksi neou gyrou oi enapominades zwes arxikopoiounte se 8
				
				int guesses = 8;
				
				//Metritis pou apothikevi ta paixnidia pou exoun paixti(gia to statistic)
				
				GamesPlayed++;
				
				//Dimiourgia antikeimenou d1 apo thn klasi Dictionary wste na kalesoume thn methodo getWord
				//kai na tis persoume ws orisma to antikeimeno number gia thn paragogi tyxaiou arithmou
				
			    Dictionary d1 = new Dictionary ();
			    String word = d1.getWord(number.nextInt(20));
			    
			    //Dimiourgia enos pinaka size me megethos iso me to plithos ton xaraktirwn tis tixeas leksis
			    
			    char [] size = new char[word.length()];
			    
			    int i=0;
			    
			    //Eisagwgi ston pinaka size "-" gia na provlithei ston xristi
			    
			    while (i<word.length()) {
			    	size[i]='-';
			    	i++;
			    }
			    
			    //Elegxos gia tis "zwes" pou exei akoma o xristis
			    
			    while (guesses>0) {
			    	
			    	//Enimerotika minimata
			    	
			    	System.out.print("The random word is now:");
			    	System.out.println(size);
			    	System.out.println("You have " + guesses + " guesses left.");
			    	System.out.print("Your guess:");
			        
			    	//Apothikefsi grammatos pou eisagei o xristis
			    	
			    	char letter = read.next().charAt(0);
			    	  	
			    	if(Character.isLowerCase(letter))
			    		letter = Character.toUpperCase(letter);
			    	
			    	//Elegxos an to gramma pou eisigage o xristis yparxei kai an nai to antikathista stis theseis pou vrethike kai provalei enimerotiko minima
			    	
			    	if(word.contains(letter + "")){
			    	
			    		for(int x=0;x<word.length();x++){			    		

			    			if(word.charAt(x)==letter)   			   
			    			
			    				size[x]=letter;    	
			    			}
			    	
			    		System.out.println("The guess is CORRECT!");
			    		CorrcetGuesses++;
			    	
			    		}
			    	
			        //An to gramma den yparxei emfanizei enimerotiko minima kai mioni tis zwes kata 1
			    	
			    	else{

			    		guesses--;
			    		System.out.println("There are no " + letter +"'s in the word.");
			    		
			    		}	
			    	
			    	//Elegxos an h leksi exei simplirothi olokriki kai an nai afksanei tis nikes kata 1
			    	
			    	if (word.equals(String.copyValueOf(size))){
			    	
			    		System.out.print("Congratulations! You guessed the word:");
			    		System.out.println(size);	
			    		Wins++;
			    		break;
			    		}
			  	
			    	}
			   
			    if (guesses == 0)
			    	
			    	// An o xristis teleiosei oles tis zwes toy to programa ton enimeronei oti exase
			    	
			    	System.out.println("You Lost");
			    else
			    	
			    	//An oi zwes dn teleiosan akoma enimeroni gia tis enapominades
			    	
			    	System.out.println("You made " + CorrcetGuesses +  " correct guesses and " + (8-guesses) + " wrong guesses.");
			    
				}
			
			//Statistika paixnidiou an o xristis epileksi to gramma "S"
			
			else if(c == 'S') {
				
				//Enimerotika minimata gia oles tis periptwseis statistikwn
				
				if(GamesPlayed == 0)
					System.out.println("You have played no games yet!");
				else if(GamesPlayed == 1 && Wins !=0)
					System.out.println("You have played " + GamesPlayed +" game.You won it!");
				else if(GamesPlayed == 1 && Wins ==0)
					System.out.println("You have played " + GamesPlayed +" game.You lost it!");
				else if(GamesPlayed > 1 && Wins == 0)
					System.out.println("You have played " + GamesPlayed +" games.You lost them all!" );
				else if(GamesPlayed == 2 && Wins == 1)
					System.out.println("You have played " + GamesPlayed +" games.You won 1 time and lost 1 time!");
				else if (GamesPlayed > 2 && Wins == 1)
					System.out.println("You have played " + GamesPlayed +" games.You won 1 time and lost " + (GamesPlayed - Wins) + " times!");
				else if (GamesPlayed==Wins)
					System.out.println("You have played " + GamesPlayed +" games.You won them all!");
				else
					System.out.println("You have played " + GamesPlayed +" games.You won " + Wins + " times and lost " + (GamesPlayed - Wins) + " times!");
			
				}
			
			//Eksodos apo to paixnidi an o xristis epileksi to gramma"S"
			
			else
				
				//Metavliti tupou flag
				
				exit=1;
			
			 }while(exit == 0);
			
	}

}
