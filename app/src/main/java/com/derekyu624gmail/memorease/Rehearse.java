package com.derekyu624gmail.memorease;

import java.text.BreakIterator;
import java.util.Locale;

public class Rehearse {
	
	private String inputText;
	private BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.CANADA);
	private int numSentences = sentenceCount(iterator, inputText);;
	private String [] sentences = new String[numSentences];
	private String [] words;
	
	public Rehearse(){
		inputText = "";
	}
	
	public Rehearse(String inputText){
		this.inputText = inputText;
	}
	
	
	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	public BreakIterator getIterator() {
		return iterator;
	}

	public void setIterator(BreakIterator iterator) {
		this.iterator = iterator;
	}

	public int getNumSentences() {
		return numSentences;
	}

	public void setNumSentences(int numSentences) {
		this.numSentences = numSentences;
	}

	public String[] getSentences() {
		return sentences;
	}

	public void setSentences(String[] sentences) {
		this.sentences = sentences;
	}
	
	public void sentenceArrayMaker(){
		int arrayIndex = 0;
		iterator.setText(inputText);
		int lastIndex = iterator.first();
		while(lastIndex != BreakIterator.DONE){
			int firstIndex = lastIndex;
			lastIndex = iterator.next();
			if (lastIndex != BreakIterator.DONE){
				String sentence = inputText.substring(firstIndex, lastIndex);
				sentences[arrayIndex] = sentence;
				arrayIndex++;
			}
		}
	}

	private int sentenceCount(BreakIterator bi, String text){
		int counter = 0;
		bi.setText(text);
		
		int lastIndex = bi.first();
		while(lastIndex != BreakIterator.DONE){
			int firstIndex = lastIndex;
			lastIndex = bi.next();
			counter++;				
			}
		
		return counter;
	}
	
	public void wordArrayMaker(String phrase){
		words = phrase.split(" ");
	}
	
	public double compare(String [] firstSet, String [] secondSet){
		int counter = 0;
		for (int i = 0; i < firstSet.length; i++){
			for (int j = 0; j < firstSet.length; j++){
				if (secondSet[j].equals(firstSet[i])){
					counter++;
					break;
				}
			}
		}
		double percentage = ((double)counter/firstSet.length)*100;
		return percentage;
	}
}
	
	

