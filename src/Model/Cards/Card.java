/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Cards;

import Model.Player.Player;

/**
 *
 * @author User
 */
public abstract class Card {
    private String image;
    
    /**
     *  Constructor
     * Postcndition:creates a card with an image
     * @param image
     */
    public Card(String image){
        this.image=image;
    }
    /**
     *  Transformer.
     *  Postcondition:sets the image of the card.
     *  @param image
     */
    public void setImage(String image){
        this.image = image;
    }
    
    /**
     *  Accessor.
     *  Postcondition:returns the image of the card.
     * @return image url
     */
    public String getImage(){
        return this.image;
    }
    
    /**
     * Accessor.
     * Postcondition:returns the string representation of a card
     * @return string representation of a card
     */
    @Override
    abstract public String toString();
}
