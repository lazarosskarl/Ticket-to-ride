/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.OnTheTrack;

import Model.Cards.*;
import Model.Player.Player;
import Model.RailYard.RailYard;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class OnTheTrack {
    private ArrayList<Card> red;
    private ArrayList<Card> black;
    private ArrayList<Card> blue;
    private ArrayList<Card> yellow;
    private ArrayList<Card> purple;
    private ArrayList<Card> green;
    private ArrayList<Card> orange;
    private ArrayList<Card> white;
    private ArrayList<Card> locomotive;
    
    
    
    public OnTheTrack() {
        this.white = new ArrayList<>();
        this.orange = new ArrayList<>();
        this.green = new ArrayList<>();
        this.purple = new ArrayList<>();
        this.yellow = new ArrayList<>();
        this.blue = new ArrayList<>();
        this.black = new ArrayList<>();
        this.red = new ArrayList<>();
        this.locomotive = new ArrayList<>();
    }
     /**
     *  Accessor.
     *  Postcondition:Returns the redcards on the track for player
     * @return arraylist red
     */
    public ArrayList<Card> getRed(){
        return this.red;
    }
     /**
     *  Accessor.
     *  Postcondition:Returns the bluecards on the track for player
     * @return arraylist blue
     */
    public ArrayList<Card> getBlue(){
        return this.blue;
    }
    /**
     *  Accessor.
     *  Postcondition:Returns the whitecards on the track for player
     * @return arraylist white
     */
    public ArrayList<Card> getWhite(){
        return this.white;
    }
     /**
     *  Accessor.
     *  Postcondition:Returns the orangecards on the track for player
     * @return arraylist orange
     */
    public ArrayList<Card> getOrange(){
        return this.orange;
    }
    /**
     *  Accessor.
     *  Postcondition:Returns the greencards on the track for player
     * @return arraylist green
     */
    public ArrayList<Card> getGreen(){
        return this.green;
    }
     /**
     *  Accessor.
     *  Postcondition:Returns the yellowcards on the track for player
     * @return arraylist yellow
     */
    public ArrayList<Card> getYellow(){
        return this.yellow;
    }
     /**
     *  Accessor.
     *  Postcondition:Returns the purplecards on the track for player
     * @return arraylist purple
     */       
    public ArrayList<Card> getPurple(){
        return this.purple;
    }
    /**
     *  Accessor.
     *  Postcondition:Returns the blackcards on the track for player
     * @return arraylist black
     */   
    public ArrayList<Card> getBlack(){
        return this.black;
    }
    /**
     *  Accessor.
     *  Postcondition:Returns the balandercards on the track for player
     * @return arraylist locomotive
     */
    public ArrayList<Card> getLocomotive(){
        return this.locomotive;
    }
    /**
     *  Transformer.
     *  Postcondition:moves the last card of each railyard list on the track
     * @param railyard
     */
    public void CollectFromRailYard(RailYard railyard){
        if(!railyard.getBlack().isEmpty() && railyard.getBlack().get(railyard.getBlack().size()-1).getColor()==Color.locomotive){
            this.locomotive.add(railyard.getBlack().get(railyard.getBlack().size()-1));
            railyard.getBlack().remove(railyard.getBlack().get(railyard.getBlack().size()-1));
        }
        else if(!railyard.getBlack().isEmpty() &&railyard.getBlack().get(railyard.getBlack().size()-1).getColor()==Color.black){
            this.black.add(railyard.getBlack().get(railyard.getBlack().size()-1));
            railyard.getBlack().remove(railyard.getBlack().size()-1);
        }
        
        if(!railyard.getBlue().isEmpty() &&railyard.getBlue().get(railyard.getBlue().size()-1).getColor()==Color.locomotive){
            this.locomotive.add(railyard.getBlue().get(railyard.getBlue().size()-1));
            railyard.getBlue().remove(railyard.getBlue().size()-1);
        }
        else if(!railyard.getBlue().isEmpty() &&railyard.getBlue().get(railyard.getBlue().size()-1).getColor()==Color.blue){
            this.blue.add(railyard.getBlue().get(railyard.getBlue().size()-1));
            railyard.getBlue().remove(railyard.getBlue().size()-1);
        }
        
        if(!railyard.getGreen().isEmpty() &&railyard.getGreen().get(railyard.getGreen().size()-1).getColor()==Color.locomotive){
            this.locomotive.add(railyard.getGreen().get(railyard.getGreen().size()-1));
            railyard.getGreen().remove(railyard.getGreen().size()-1);
        }
        else if(!railyard.getGreen().isEmpty() &&railyard.getGreen().get(railyard.getGreen().size()-1).getColor()==Color.green){
            this.green.add(railyard.getGreen().get(railyard.getGreen().size()-1));
            railyard.getGreen().remove(railyard.getGreen().size()-1);
        }
        
        if(!railyard.getOrange().isEmpty() &&railyard.getOrange().get(railyard.getOrange().size()-1).getColor()==Color.locomotive){
            this.locomotive.add(railyard.getOrange().get(railyard.getOrange().size()-1));
            railyard.getOrange().remove(railyard.getOrange().get(railyard.getOrange().size()-1));
        }
        else if(!railyard.getOrange().isEmpty() &&railyard.getOrange().get(railyard.getOrange().size()-1).getColor()==Color.orange){
            this.orange.add(railyard.getOrange().get(railyard.getOrange().size()-1));
            railyard.getOrange().remove(railyard.getOrange().size()-1);
        }
        
        if(!railyard.getPurple().isEmpty() &&railyard.getPurple().get(railyard.getPurple().size()-1).getColor()==Color.locomotive){
            this.locomotive.add(railyard.getPurple().get(railyard.getPurple().size()-1));
            railyard.getPurple().remove(railyard.getPurple().size()-1);
        }
        else if(!railyard.getPurple().isEmpty() &&railyard.getPurple().get(railyard.getPurple().size()-1).getColor()==Color.purple){
            this.purple.add(railyard.getPurple().get(railyard.getPurple().size()-1));
            railyard.getPurple().remove(railyard.getPurple().size()-1);
        }
        
        if(!railyard.getRed().isEmpty() &&railyard.getRed().get(railyard.getRed().size()-1).getColor()==Color.locomotive){
            this.locomotive.add(railyard.getRed().get(railyard.getRed().size()-1));
            railyard.getRed().remove(railyard.getRed().size()-1);
        }
        else if(!railyard.getRed().isEmpty() &&railyard.getRed().get(railyard.getRed().size()-1).getColor()==Color.red){
            this.red.add(railyard.getRed().get(railyard.getRed().size()-1));
            railyard.getRed().remove(railyard.getRed().size()-1);
        }
        
        if(!railyard.getWhite().isEmpty() &&railyard.getWhite().get(railyard.getWhite().size()-1).getColor()==Color.locomotive){
            this.locomotive.add(railyard.getWhite().get(railyard.getWhite().size()-1));
            railyard.getWhite().remove(railyard.getWhite().size()-1);
        }
        else if(!railyard.getWhite().isEmpty() &&railyard.getWhite().get(railyard.getWhite().size()-1).getColor()==Color.white){
            this.white.add(railyard.getWhite().get(railyard.getWhite().size()-1));
            railyard.getWhite().remove(railyard.getWhite().size()-1);
        }
        
        if(!railyard.getYellow().isEmpty() &&railyard.getYellow().get(railyard.getYellow().size()-1).getColor()==Color.locomotive){
            this.locomotive.add(railyard.getYellow().get(railyard.getYellow().size()-1));
            railyard.getYellow().remove(railyard.getYellow().size()-1);
        }
        else if(!railyard.getYellow().isEmpty() &&railyard.getYellow().get(railyard.getYellow().size()-1).getColor()==Color.yellow){
            this.yellow.add(railyard.getYellow().get(railyard.getYellow().size()-1));
            railyard.getYellow().remove(railyard.getYellow().size()-1);
        }
    }
    
    /**
     *  Observer.
     * Postcondition:checks if a card can be bought and returns true or false
     * @param dst
     * @param player
     * @return true if yes,else false
     */
    public boolean IsBuyable(DestinationCard dst,Player player){
        OnTheTrack onthetrack=player.getPlayerOnTheTrack();
        int blackcounter=onthetrack.getBlack().size();
        int bluecounter=onthetrack.getBlue().size();
        int greencounter=onthetrack.getGreen().size();
        int redcounter=onthetrack.getRed().size();
        int yellowcounter=onthetrack.getYellow().size();
        int orangecounter=onthetrack.getOrange().size();
        int purplecounter=onthetrack.getPurple().size();
        int whitecounter=onthetrack.getWhite().size();
        int lococounter=onthetrack.getLocomotive().size();
        
        int numofcolors=dst.getNumOfColors();
        
        for(int i=0; i<numofcolors; i++){
            Color color = dst.getColors().get(i);
            if(color == Color.black){
                if(blackcounter!=0){
                    blackcounter--;
                }
                else if(blackcounter==0 && lococounter!=0){
                    lococounter--;
                }

                else{
                    JOptionPane.showMessageDialog(null, "Not enough black Cards!","OOPS",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            
            else if(color == Color.blue){
                if(bluecounter!=0){
                    bluecounter--;
                }
                else if(bluecounter==0 && lococounter!=0){
                    lococounter--;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough blue Cards!","OOPS",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            
            else if(color == Color.green){
                if(greencounter!=0){
                    greencounter--;
                }
                else if(greencounter==0 && lococounter!=0){
                    lococounter--;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough green Cards!","OOPS",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            
            else if(color == Color.red){
                if(redcounter!=0){
                    redcounter--;
                }
                else if(redcounter==0 && lococounter!=0){
                    lococounter--;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough red Cards!","OOPS",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            
            else if(color == Color.yellow){
                if(yellowcounter!=0){
                    yellowcounter--;
                }
                else if(yellowcounter==0 && lococounter!=0){
                    lococounter--;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough yellow Cards!","OOPS",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            
            else if(color == Color.orange){
                if(orangecounter!=0){
                    orangecounter--;
                }
                else if(orangecounter==0 && lococounter!=0){
                    lococounter--;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough orange Cards!","OOPS",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            
            else if(color == Color.purple){
                if(purplecounter!=0){
                    purplecounter--;
                }
                else if(purplecounter==0 && lococounter!=0){
                    lococounter--;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough purple Cards!","OOPS",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            
            else if(color == Color.white){
                if(whitecounter!=0){
                    whitecounter--;
                }
                else if(whitecounter==0 && lococounter!=0){
                    lococounter--;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough white Cards!","OOPS",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     *  Transformer.
     * Precondition:card is buyable
     * Postcondition:removes apropriate cards from the track an sets the new score
     * @param dst
     * @param player
     */
    public void BuyDestinationCard(DestinationCard dst,Player player){
        OnTheTrack onthetrack=player.getPlayerOnTheTrack();
        int numofcolors=dst.getNumOfColors();
        
        for(int i=0; i<numofcolors; i++){
            Color color = dst.getColors().get(i);
            if(color == Color.black){
                if(!onthetrack.getBlack().isEmpty()){
                    onthetrack.getBlack().remove(0);
                }
                else if(onthetrack.getBlack().isEmpty()){
                    onthetrack.getLocomotive().remove(0);
                }
                
            }
            
            else if(color == Color.blue){
                if(!onthetrack.getBlue().isEmpty()){
                    onthetrack.getBlue().remove(0);
                }
                else if(onthetrack.getBlue().isEmpty()){
                    onthetrack.getLocomotive().remove(0);
                }
                
            }
            
            else if(color == Color.green){
                if(!onthetrack.getGreen().isEmpty()){
                    onthetrack.getGreen().remove(0);
                }
                else if(onthetrack.getGreen().isEmpty()){
                    onthetrack.getLocomotive().remove(0);
                }
               
            }
            
            else if(color == Color.red){
                if(!onthetrack.getRed().isEmpty()){
                    onthetrack.getRed().remove(0);
                }
                else if(onthetrack.getRed().isEmpty()){
                    onthetrack.getLocomotive().remove(0);
                }
               
            }
            
            else if(color == Color.yellow){
                if(!onthetrack.getYellow().isEmpty()){
                    onthetrack.getYellow().remove(0);
                }
                else if(onthetrack.getYellow().isEmpty()){
                    onthetrack.getLocomotive().remove(0);
                }
                
            }
            
            else if(color == Color.orange){
                if(!onthetrack.getOrange().isEmpty()){
                    onthetrack.getOrange().remove(0);
                }
                else if(onthetrack.getOrange().isEmpty()){
                    onthetrack.getLocomotive().remove(0);
                }
                
            }
            
            else if(color == Color.purple){
                if(!onthetrack.getPurple().isEmpty()){
                    onthetrack.getPurple().remove(0);
                }
                else if(onthetrack.getPurple().isEmpty()){
                    onthetrack.getLocomotive().remove(0);
                }
                
            }
            
            else if(color == Color.white){
                if(!onthetrack.getWhite().isEmpty()){
                    onthetrack.getWhite().remove(0);
                }
                else if(onthetrack.getWhite().isEmpty()){
                    onthetrack.getLocomotive().remove(0);
                }
                
            }
        }
        player.addScore((dst.getPoints())*2);
        player.getBoughtDstCard().add(dst);
    }
    
    /**
     *  Accessor
     * @return string representation of onthetrack
     */
    @Override
    public String toString(){
        return "";
    }
    
}
