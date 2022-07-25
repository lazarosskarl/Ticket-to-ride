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
public class BigCitiesCard extends PointCards{
    private String cityName;
    private int p1visits;
    private int p2visits;
    
    /**
     * Constructor.
     * Postcondition:Creates a bigcity card with points and a city name.
     * @param points
     * @param cityName
     * @param image
     */
    public BigCitiesCard(int points,String cityName,String image){
       super(points,image);
       this.cityName=cityName;
       this.p1visits=0;
       this.p2visits=0;
    }
    
    /**
     * Transformer.
     * Postcondition:sets the city name of the card
     * @param cityName
     */
    public void setCityName(String cityName){
        this.cityName=cityName;
    }
    
    /**
     * Accessor.
     * Postcondition:the citys name is return
     * @return big city name
     */
    public String getCityName(){
        return this.cityName;
    }
    
    /**
     * Accessor.
     * Postcondition:The number of p1 visits is returned
     * @return p1visits value
     */
    public int getP1visits(){
        return this.p1visits;
    }
    
    /**
     * Transformer.
     * Postcondition:increases p1visits by 1
     */
    public void P1visits(){
        this.p1visits=this.p1visits+1;
    }
    
    /**
     * Accessor.
     * Postcondition:The number of p2 visits is returned
     * @return p2visits value
     */
    public int getP2visits(){
        return this.p2visits;
    }
    
    /**
     * Transformer.
     * Postcondition:increases p2visits by 1
     */
    public void P2visits(){
        this.p2visits = this.p2visits+1;
    }
    
    /**
     * Accessor.
     * Postcondition:returns the string representation of a card
     * @return string representation of a card
     */
    @Override
    public String toString(){
        return("City name: " + getCityName() + " points:" + getPoints());
    }
    
}
