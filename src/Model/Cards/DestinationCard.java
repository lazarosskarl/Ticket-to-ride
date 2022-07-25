
package Model.Cards;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author User
 */
public class DestinationCard extends PointCards{
    private String fromcity;
    private String tocity;
    private int numofcolors;
    private ArrayList<Color> colors = new ArrayList<>();
    

    /**
     * Accessor.
     * Postcondition:Returns the colors arraylist
     * @return colors arraylist
     */
    public ArrayList<Color> getPrice(){
        return this.colors;
    }
    
    /**
     *  Transformer.
     * Postcondition:sets the fromcity of the card(afetiria)
     * @param fromcity
     */
    public void setFrom(String fromcity){
        this.fromcity=fromcity;
    }
    
    /**
     *  Accessor.
     * Postcondition:the fromcity of a dst card is returned
     * @return fromcity of a card
     */
    public String getFrom(){
        return this.fromcity;
    }
    
    /**
     **  Transformer.
     * Postcondition:sets the tocity of the card(proorismos)
     * @param tocity
     */
    public void setTo(String tocity){
        this.tocity=tocity;
    }
     /**
     *  Accessor.
     * Postcondition:the tocity of a dst card is returned
     * @return tocity of a card
     */
    public String getTo(){
        return this.tocity;
    }
    
    
    /**
     *  Accessor.
     * Postcondition:the list of colors dst demands to be bought is returned
     * @return the list of colors dst demands to be bought
     */
    public ArrayList<Color> getColors(){
        return this.colors;
    }
    
    
    /**
     *  Transformer.
     *  Postcondition:sets the numeber of colors dst demands to be bought
     * @param numofcolors
     */
    public void setNumOfColors(int numofcolors){
        this.numofcolors=numofcolors;
    }
    
    /**
     *  Accessor.
     * Postcondition:the numeber of colors dst demands to be bought is returned
     * @return the numeber of colors dst demands to be bought
     */
    public int getNumOfColors(){
        return this.numofcolors;
    }

    /**
     * Constructor
     * Postcondition:Creates a dst card with fromcity,tocity,points and demanding
     * 1 color
     * @param fromcity
     * @param tocity
     * @param points
     * @param c1
     * @param image
     */
    public DestinationCard(String fromcity,String tocity,int points,Color c1,String image){
        super(points,image);
        this.fromcity=fromcity;
        this.tocity=tocity;
        colors.add(c1);
        this.numofcolors=1;
    }
    
    /**
     * Constructor
     * Postcondition:Creates a dst card with fromcity,tocity,points and demanding
     * 2 colors
     * @param fromcity
     * @param tocity
     * @param points
     * @param c1
     * @param c2
     * @param image
     */
    public DestinationCard(String fromcity,String tocity,int points,Color c1,Color c2,String image){
        super(points,image);
        this.fromcity=fromcity;
        this.tocity=tocity;
        colors.add(c1);
        colors.add(c2);
        this.numofcolors=2;
    }
    
    /**
     * Constructor
     * Postcondition:Creates a dst card with fromcity,tocity,points and demanding
     * 3 colors
     * @param fromcity
     * @param tocity
     * @param points
     * @param c1
     * @param c2
     * @param c3
     * @param image
     */
    public DestinationCard(String fromcity,String tocity,int points,Color c1,Color c2,Color c3,String image){
        super(points,image);
        this.fromcity=fromcity;
        this.tocity=tocity;
        colors.add(c1);
        colors.add(c2);
        colors.add(c3);
        this.numofcolors=3;
    }
    
    /**
     *Constructor
     * Postcondition:Creates a dst card with fromcity,tocity,points and demanding
     * 4 colors
     * @param fromcity
     * @param tocity
     * @param points
     * @param c1
     * @param c2
     * @param c3
     * @param c4
     * @param image
     */
    public DestinationCard(String fromcity,String tocity,int points,Color c1,Color c2,Color c3,Color c4,String image){
        super(points,image);
        this.fromcity=fromcity;
        this.tocity=tocity;
        colors.add(c1);
        colors.add(c2);
        colors.add(c3);
        colors.add(c4);
        this.numofcolors=4;
    }
    
    /**
     *Constructor
     * Postcondition:Creates a dst card with fromcity,tocity,points and demanding
     * 5 colors
     * @param fromcity
     * @param tocity
     * @param points
     * @param c1
     * @param c2
     * @param c3
     * @param c4
     * @param c5
     * @param image
     */
    public DestinationCard(String fromcity,String tocity,int points,Color c1,Color c2,Color c3,Color c4,Color c5,String image){
        super(points,image);
        this.fromcity=fromcity;
        this.tocity=tocity;
        colors.add(c1);
        colors.add(c2);
        colors.add(c3);
        colors.add(c4);
        colors.add(c5);
        this.numofcolors=5;
    }
    
    /**
     * Accessor.
     * Postcondition:returns the string representation of a card
     * @return string representation of a card
     */
    @Override
    public String toString(){
        return ("DestinationCard from:"+this.fromcity +" to: " +this.tocity);
    }

}
