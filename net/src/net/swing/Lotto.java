package net.swing;

import java.util.Arrays;

public class Lotto {
	int[] lotto = new int[6];
	public int[] getlotto(){
		return lotto;
	}
	
	public void setLotto() {
		
		for(int i=0; i<lotto.length; i++){
			int ran = (int)(Math.random()*45)+1;
			if(i>0){
				for(int j=0; j<lotto.length; j++){
					if(lotto[i-1]==lotto[i]){
						i--;
						break;
					}
				}
				lotto[i] = ran;
			}
		}
		/*for(int i=0; i<lotto.length; i++){
			int ran = (int)(Math.random()*45)+1;
			boolean exist = false;
			
			for(int j=0; j<lotto.length; j++){
				exist = false;
				if(exist){
					i--;
					continue;
				}else{
					lotto[i] = ran;
					
				}
			}
		}*/
		
		Arrays.sort(lotto);
	}
}
