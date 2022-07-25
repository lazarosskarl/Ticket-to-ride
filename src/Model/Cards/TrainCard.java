/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Cards;

/**
 *
 * @author User
 */
public class TrainCard extends Card{
    private Color color;
    
    /**
     *  Transformer.
     * Postcondition:the color of the card is set.
     * @param color
     */
    public void setColor(Color color){
        this.color=color;
    }
    
    /**
     *  Accessor.
     * Postcondition:the color of the card is returned
     * @return card color
     */
    public Color getColor(){
        return this.color;
    }

    /**
     *  Constructor.
     * Postcondition:Creates a Card with Color color
     * @param color
     * @param image
     */
    public TrainCard(Color color,String image){
        super(image);
        this.color=color;
    }
    
    /**
     * Accessor.
     * Postcondition:returns the string representation of a traincard
     * @return string representation of a card
     */
    @Override
    public String toString(){
        return("TrainCard with color: " + color.name());
    }
    
}
