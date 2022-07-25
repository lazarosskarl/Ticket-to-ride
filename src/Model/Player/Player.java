/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Player;

import Model.Cards.*;
import Model.OnTheTrack.OnTheTrack;
import Model.RailYard.RailYard;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Player {
    private ArrayList<TrainCard> pTrainCards;
    private ArrayList<DestinationCard> pDstCards;
    private ArrayList<DestinationCard> boughtDstCards;
    private RailYard pRailYard;
    private OnTheTrack pOnTheTrack;
    private int score;
    private int id;
    private int bcVisited;

    public Player(int id){
        this.score=0;
        this.pDstCards=new ArrayList<>();
        this.boughtDstCards=new ArrayList<>();
        this.pTrainCards=new ArrayList<>();
        this.pRailYard=new RailYard();
        this.pOnTheTrack=new OnTheTrack();
        this.id=id;
        this.bcVisited=0;
    }
    
    public void bcVisited(){
        this.bcVisited = bcVisited + 1;
    }
    
    public int getBcVisited(){
        return this.bcVisited;
    }
    
    public void setID(int id){
        this.id=id;
    }
    
    public int getID(){
        return this.id;
    }
    
    public void addScore(int score){
        this.score=this.score+score;
    }
    
    public int getScore(){
        return this.score;
    }
    
    public void addTcard(TrainCard tcard){
        getTcard().add(tcard);
    }
    
    public ArrayList<TrainCard> getTcard(){
        return this.pTrainCards;
    }
    
    public void addDstCard(DestinationCard dstcard){
        getDstCard().add(dstcard);
    }
    
    public ArrayList<DestinationCard> getDstCard(){
        return this.pDstCards;
    }
    
    public ArrayList<DestinationCard> getBoughtDstCard(){
        return this.boughtDstCards;
    }
    
    public RailYard getPlayerRailyard(){
        return this.pRailYard;
    }
    
    public OnTheTrack getPlayerOnTheTrack(){
        return this.pOnTheTrack;
    }
    
    @Override
    public String toString(){
        return("");
    }
}
