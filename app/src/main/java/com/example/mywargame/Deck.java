package com.example.mywargame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {

    private Stack<Card> cards = new Stack<>();

    public Deck(){
       this.cards = new Stack<>();
//        createDeck();
    }



//    private void createDeck() {
//        for (Suit s : Suit.values()) {
//            for (Rank r : Rank.values()) {
//                cards.push(new Card(r, s));
//            }
//        }
//    }


//    public void shuffleDeck() {
//        Collections.shuffle(this.cards);
//    }

    public int getCardsCount() {
        return this.cards.size();
    }

    public void addCard(List<Card> card) {
        this.cards.addAll(card);
    }



    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }

    public Card getCard(){
        return cards.pop();
    }

    public int deckIsEmpty(){
        if(cards.empty()){
            return 0;
        }
        return 1;
    }



    @Override
    public String toString() {
        return this.cards.toString();
    }
}
