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
public abstract class PointCards extends Card{
    private int points;
    
    /**
     * Transformer.
     * Postcondition:sets the cards points
     * @param points
     */
    public void setPoints(int points){
        this.points=points;
    }

    /**
     *  Accessor.
     * Postcondiotion:the cards points are returned
     * @return cardpoints
     */
    public int getPoints(){
        return this.points;
    }
    
    /**
     *  Constructor.
     * Creates a new poincard with points = points
     * @param points
     * @param image
     */
    public PointCards(int points,String image){
        super(image);
        this.points=points;
    }
     /**
     * Accessor.
     * Postcondition:returns the string representation of a card
     * @return string representation of a card
     */
    @Override
    public abstract String toString();
}
