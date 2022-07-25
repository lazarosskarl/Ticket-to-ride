/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.RailYard;
import Model.Cards.*;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class RailYard {
    private ArrayList<TrainCard> red;
    private ArrayList<TrainCard> black;
    private ArrayList<TrainCard> blue;
    private ArrayList<TrainCard> yellow;
    private ArrayList<TrainCard> purple;
    private ArrayList<TrainCard> green;
    private ArrayList<TrainCard> orange;
    private ArrayList<TrainCard> white;
    private boolean trainrob=false;

    /**
     *
     */
    public RailYard() {
        this.white = new ArrayList<>();
        this.orange = new ArrayList<>();
        this.green = new ArrayList<>();
        this.purple = new ArrayList<>();
        this.yellow = new ArrayList<>();
        this.blue = new ArrayList<>();
        this.black = new ArrayList<>();
        this.red = new ArrayList<>();
    }
    
    /**
     * Accessor
     * Postcondition:Returns true if there is train robbing situation
     * @return trainrob
     */
    public boolean getTrainRob(){
        return this.trainrob;
    }
    
     /**
     * Transformer
     * Postcondition:The value of trainrob is updated
     * @param trainrob
     */
    public void setTrainRob(boolean trainrob){
        this.trainrob=trainrob;
    }
    /**
     *  Accessor.
     *  Postcondition:Returns the redcards on players railyard
     * @return arraylist red
     */
    public ArrayList<TrainCard> getRed(){
        return this.red;
    }
    
    /**
     *  Accessor.
     *  Postcondition:Returns the bluecards on players railyard
     * @return arraylist blue
     */
    public ArrayList<TrainCard> getBlue(){
        return this.blue;
    }
        
    /**
     *  Accessor.
     *  Postcondition:Returns the white cards on players railyard
     * @return arraylist white
     */
    public ArrayList<TrainCard> getWhite(){
        return this.white;
    }
            
    /**
     *  Accessor.
     *  Postcondition:Returns the orange cards on players railyard
     * @return arraylist orange
     */
    public ArrayList<TrainCard> getOrange(){
        return this.orange;
    }
                
    /**
     *  Accessor.
     *  Postcondition:Returns the green cards on players railyard
     * @return arraylist green
     */
    public ArrayList<TrainCard> getGreen(){
        return this.green;
    }
        
    /**
     *  Accessor.
     *  Postcondition:Returns the yellowcards on players railyard
     * @return arraylist yellow
     */
    public ArrayList<TrainCard> getYellow(){
        return this.yellow;
    }
            
    /**
     *  Accessor.
     *  Postcondition:Returns the purple cards on players railyard
     * @return arraylist purple
     */
    public ArrayList<TrainCard> getPurple(){
        return this.purple;
    }
        
     /**
     *  Accessor.
     *  Postcondition:Returns the blackcards on players railyard
     * @return arraylist black
     */
    public ArrayList<TrainCard> getBlack(){
        return this.black;
    }

    /**
     *  Observer.
     * Postcondition:checks if a collection of cards can be player and returns true or false
     * @param cardsToPlay
     * @param opRailYard
     * @return true if it can,else false
     */
    public boolean isPlayable(ArrayList<TrainCard> cardsToPlay,RailYard opRailYard){
        int lococounter=0;
        int bluecounter=0;
        int redcounter=0;
        int blackcounter=0;
        int greencounter=0;
        int purplecounter=0;
        int whitecounter=0;
        int yellowcounter=0;
        int orangecounter=0;
        
        for(int i=0; i<cardsToPlay.size(); i++){
            if (cardsToPlay.get(i).getColor() == Color.black) blackcounter++;
            else if(cardsToPlay.get(i).getColor() == Color.blue) bluecounter++;
            else if(cardsToPlay.get(i).getColor() == Color.green)greencounter++;
            else if(cardsToPlay.get(i).getColor() == Color.locomotive)lococounter++;
            else if(cardsToPlay.get(i).getColor() == Color.orange)orangecounter++;
            else if(cardsToPlay.get(i).getColor() == Color.purple)purplecounter++;
            else if(cardsToPlay.get(i).getColor() == Color.red)redcounter++;
            else if(cardsToPlay.get(i).getColor() == Color.white)whitecounter++;
            else if(cardsToPlay.get(i).getColor() == Color.yellow)yellowcounter++;
        }
        //check if cards to play conist of only locomotives
        int loc=0;
        for(int i=0; i<cardsToPlay.size(); i++){
            if(cardsToPlay.get(i).getColor() == Color.locomotive){
                loc++;
            }
        }
        if(cardsToPlay.isEmpty()) return false;
        
        //check if cards to9 play conist of only locomotives
        else if(loc == cardsToPlay.size()){
                return false;
        }
        //3 cards differnt color each one and no locomotives
        else if(cardsToPlay.size() == 3 &&
                cardsToPlay.get(0).getColor() != Color.locomotive && 
                (cardsToPlay.get(0).getColor()!=cardsToPlay.get(1).getColor())&&
                (cardsToPlay.get(0).getColor()!=cardsToPlay.get(2).getColor())&&
                (cardsToPlay.get(1).getColor() != Color.locomotive) && 
                (cardsToPlay.get(1).getColor()!=cardsToPlay.get(0).getColor())&&
                (cardsToPlay.get(1).getColor()!=cardsToPlay.get(2).getColor())&&
                (cardsToPlay.get(2).getColor() != Color.locomotive) && 
                (cardsToPlay.get(2).getColor()!=cardsToPlay.get(0).getColor())&&
                (cardsToPlay.get(2).getColor()!=cardsToPlay.get(1).getColor())){
            System.out.println("Tsekarw an 3 kartes diaforetikou xromatos mporoun na paixtoun");
                    if(cardsToPlay.get(0).getColor()==Color.black ){
                        if((!this.black.isEmpty()) || (!opRailYard.getBlack().isEmpty())){
                            return false;
                        }
                        
                    }
                    else if(cardsToPlay.get(0).getColor()==Color.blue){
                        if((!this.blue.isEmpty()) || (!opRailYard.getBlue().isEmpty())){
                            return false;
                        }
                    }
                    else if(cardsToPlay.get(0).getColor()==Color.red){
                        if((!this.red.isEmpty()) || (!opRailYard.getRed().isEmpty())){
                            return false;
                        }
                    }
                 
                    else if(cardsToPlay.get(0).getColor()==Color.green){
                        if((!this.green.isEmpty()) || (!opRailYard.getGreen().isEmpty())){
                           
                            return false;
                        }
                    }

                    else if(cardsToPlay.get(0).getColor()==Color.yellow){
                        if((!this.yellow.isEmpty()) || (!opRailYard.getYellow().isEmpty())){
                            return false;
                        }
                    }
                    
                    else if(cardsToPlay.get(0).getColor()==Color.purple){
                        if((!this.purple.isEmpty()) || (!opRailYard.getPurple().isEmpty())){
                            return false;
                        }
                    }
                    
                    else if(cardsToPlay.get(0).getColor()==Color.orange){
                        if((!this.orange.isEmpty()) || (!opRailYard.getOrange().isEmpty())){
                           
                            return false;
                        }
                    }
                    
                    else if(cardsToPlay.get(0).getColor()==Color.white){
                        if((!this.white.isEmpty()) || (!opRailYard.getWhite().isEmpty())){
                            return false;
                        }
                    }
                    
                    if(cardsToPlay.get(1).getColor()==Color.black ){
                            System.out.println("perasa apo black 2 ekswteriko");
                        
                        if((!this.black.isEmpty()) || (!opRailYard.getBlack().isEmpty())){
                            System.out.println("perasa apo black 2 eswteriko");
                            return false;
                        }
                    }
                    else if(cardsToPlay.get(1).getColor()==Color.blue){
                        if((!this.blue.isEmpty()) || (!opRailYard.getBlue().isEmpty())){
                            return false;
                        }
                    }
                    else if(cardsToPlay.get(1).getColor()==Color.red){
                        if((!this.red.isEmpty()) || (!opRailYard.getRed().isEmpty())){
                            return false;
                        }
                    }
                 
                    else if(cardsToPlay.get(1).getColor()==Color.green){
                        if((!this.green.isEmpty()) || (!opRailYard.getGreen().isEmpty())){
                            return false;
                        }
                    }

                    else if(cardsToPlay.get(1).getColor()==Color.yellow){
                        if((!this.yellow.isEmpty()) || (!opRailYard.getYellow().isEmpty())){
                            return false;
                        }
                    }
                    
                    else if(cardsToPlay.get(1).getColor()==Color.purple){
                        if((!this.purple.isEmpty()) || (!opRailYard.getPurple().isEmpty())){
                            return false;
                        }
                    }
                    
                    else if(cardsToPlay.get(1).getColor()==Color.orange){
                        if((!this.orange.isEmpty()) || (!opRailYard.getOrange().isEmpty())){
                            return false;
                        }
                    }
                    
                    else if(cardsToPlay.get(1).getColor()==Color.white){
                        if((!this.white.isEmpty()) || (!opRailYard.getWhite().isEmpty())){
                            return false;
                        }
                    }
                    
                    if(cardsToPlay.get(2).getColor()==Color.black ){
                        if((!this.black.isEmpty()) || (!opRailYard.getBlack().isEmpty())){
                            return false;
                        }
                    }
                    else if(cardsToPlay.get(2).getColor()==Color.blue){
                        if((!this.blue.isEmpty() || !opRailYard.getBlue().isEmpty())){
                            return false;
                        }
                    }
                    else if(cardsToPlay.get(2).getColor()==Color.red){
                        if((!this.red.isEmpty() || !opRailYard.getRed().isEmpty())){
                            return false;
                        }
                    }
                 
                    else if(cardsToPlay.get(2).getColor()==Color.green){
                        if((!this.green.isEmpty()) || (!opRailYard.getGreen().isEmpty())){
                            return false;
                        }
                    }

                    else if(cardsToPlay.get(2).getColor()==Color.yellow){
                        if((!this.yellow.isEmpty()) || (!opRailYard.getYellow().isEmpty())){
                            return false;
                        }
                    }
                    
                    else if(cardsToPlay.get(2).getColor()==Color.purple){
                        if((!this.purple.isEmpty()) || (!opRailYard.getPurple().isEmpty())){
                            return false;
                        }
                    }
                    
                    else if(cardsToPlay.get(2).getColor()==Color.orange){
                        if((!this.orange.isEmpty()) || (!opRailYard.getOrange().isEmpty())){
                            return false;
                        }
                    }
                    
                    else if(cardsToPlay.get(2).getColor()==Color.white){
                        if((!this.white.isEmpty()) || (!opRailYard.getWhite().isEmpty())){
                            return false;
                        }
                    }
                    
                    
                    System.out.println("3 kartes diaforetikou xromatos mporoun na paixtoun");
                    return true;
                    
            }
        
        else  if(blackcounter != 0 && bluecounter==0 && greencounter==0 && orangecounter==0 && purplecounter==0 &&
                 redcounter==0 && whitecounter==0 && yellowcounter==0 && (blackcounter+lococounter)>=2){
                if(this.black.isEmpty() && opRailYard.getBlack().isEmpty()){
                 return true;
                }
                else if(this.black.isEmpty() && (blackcounter+lococounter)>opRailYard.getBlack().size()){
                     this.trainrob=true;
                    return true;
                }
        }
        
        else if(blackcounter == 0 && bluecounter!=0 && greencounter==0 && orangecounter==0 && purplecounter==0 &&
                 redcounter==0 && whitecounter==0 && yellowcounter==0 && (bluecounter+lococounter)>=2){
             if(this.blue.isEmpty() && opRailYard.getBlue().isEmpty()){
                 return true;
             }
             else if(this.blue.isEmpty() && (bluecounter+lococounter)>opRailYard.getBlue().size()){
                 this.trainrob=true;
                 return true;
             }
        }
        
        else if(blackcounter == 0 && bluecounter==0 && greencounter!=0 && orangecounter==0 && purplecounter==0 &&
                 redcounter==0 && whitecounter==0 && yellowcounter==0 && (greencounter+lococounter)>=2){
             if(this.green.isEmpty() && opRailYard.getGreen().isEmpty()){
                 return true;
             }
             else if(this.green.isEmpty() && (greencounter+lococounter)>opRailYard.getGreen().size()){
                 this.trainrob=true;
                 return true;
             }
        }
        
        else if(blackcounter == 0 && bluecounter==0 && greencounter==0 && orangecounter!=0 && purplecounter==0 &&
                 redcounter==0 && whitecounter==0 && yellowcounter==0 && (orangecounter+lococounter)>=2){
             if(this.orange.isEmpty() && opRailYard.getOrange().isEmpty()){
                 return true;
             }
             else if(this.orange.isEmpty() && (orangecounter+lococounter)>opRailYard.getOrange().size()){
                 this.trainrob=true;
                 return true;
             }
        }
        
        else if(blackcounter == 0 && bluecounter==0 && greencounter==0 && orangecounter==0 && purplecounter!=0 &&
                 redcounter==0 && whitecounter==0 && yellowcounter==0 && (purplecounter+lococounter)>=2){
             if(this.purple.isEmpty() && opRailYard.getPurple().isEmpty()){
                 return true;
             }
             else if(this.purple.isEmpty() && (purplecounter+lococounter)>opRailYard.getPurple().size()){
                 this.trainrob=true;
                 return true;
             }
        }
        
        else if(blackcounter == 0 && bluecounter==0 && greencounter==0 && orangecounter==0 && purplecounter==0 &&
                 redcounter!=0 && whitecounter==0 && yellowcounter==0 && (redcounter+lococounter)>=2){
             if(this.red.isEmpty() && opRailYard.getRed().isEmpty()){
                 return true;
             }
             else if(this.red.isEmpty() && (redcounter+lococounter)>opRailYard.getRed().size()){
                 this.trainrob=true;
                 return true;
             }
        }
        
        else if(blackcounter == 0 && bluecounter==0 && greencounter==0 && orangecounter==0 && purplecounter==0 &&
                 redcounter==0 && whitecounter!=0 && yellowcounter==0 && (whitecounter+lococounter)>=2){
             if(this.white.isEmpty() && opRailYard.getWhite().isEmpty()){
                 return true;
             }
             else if(this.white.isEmpty() && (whitecounter+lococounter)>opRailYard.getWhite().size()){
                 this.trainrob=true;
                 return true;
             }
        }
        
        else if(blackcounter == 0 && bluecounter==0 && greencounter==0 && orangecounter==0 && purplecounter==0 &&
                 redcounter==0 && whitecounter==0 && yellowcounter!=0 && (yellowcounter+lococounter)>=2){
             if(this.yellow.isEmpty() && opRailYard.getYellow().isEmpty()){
                 return true;
             }
             else if(this.yellow.isEmpty() && (yellowcounter+lococounter)>opRailYard.getYellow().size()){
                 this.trainrob=true;
                 return true;
             }
        }
        
        return false;
    }
    
    /**
     *  Transformer.
     * Precondition:cardstoplay are playable
     * Postcondition:moves given cards from players hand to railyard.
     * @param cardsToPlay
     * @param opRailYard
     */
    public void PlayCards(ArrayList<TrainCard> cardsToPlay,RailYard opRailYard){
        int lococounter=0;
        int bluecounter=0;
        int redcounter=0;
        int blackcounter=0;
        int greencounter=0;
        int purplecounter=0;
        int whitecounter=0;
        int yellowcounter=0;
        int orangecounter=0;
        
            if(cardsToPlay.size() == 3 &&
                cardsToPlay.get(0).getColor() != Color.locomotive && 
                cardsToPlay.get(0).getColor()!=cardsToPlay.get(1).getColor()&&
                cardsToPlay.get(0).getColor()!=cardsToPlay.get(2).getColor()&&
                cardsToPlay.get(1).getColor() != Color.locomotive && 
                cardsToPlay.get(1).getColor()!=cardsToPlay.get(0).getColor()&&
                cardsToPlay.get(1).getColor()!=cardsToPlay.get(2).getColor()&&
                cardsToPlay.get(2).getColor() != Color.locomotive && 
                cardsToPlay.get(2).getColor()!=cardsToPlay.get(0).getColor()&&
                cardsToPlay.get(2).getColor()!=cardsToPlay.get(1).getColor()){
                
                for(int i=0; i<cardsToPlay.size(); i++){
                    TrainCard tc1=cardsToPlay.get(i);
                    if(tc1.getColor() == Color.black){
                        this.black.add(tc1);
                    }
                    else if(tc1.getColor() == Color.blue){
                        this.blue.add(tc1);
                    }
                    else if(tc1.getColor() == Color.green){
                        this.green.add(tc1);
                    }
                    else if(tc1.getColor() == Color.orange){
                        this.orange.add(tc1);
                    }
                    else if(tc1.getColor() == Color.purple){
                        this.purple.add(tc1);
                    }
                    else if(tc1.getColor() == Color.red){
                        this.red.add(tc1);
                    }
                    else if(tc1.getColor() == Color.white){
                        this.white.add(tc1);
                    }
                    else if(tc1.getColor() == Color.yellow){
                        this.yellow.add(tc1);
                    }
                }
            }
            else{
                for(int i=0; i<cardsToPlay.size(); i++){
                    if (cardsToPlay.get(i).getColor() == Color.black) blackcounter++;
                    else if(cardsToPlay.get(i).getColor() == Color.blue) bluecounter++;
                    else if(cardsToPlay.get(i).getColor() == Color.green)greencounter++;
                    else if(cardsToPlay.get(i).getColor() == Color.locomotive)lococounter++;
                    else if(cardsToPlay.get(i).getColor() == Color.orange)orangecounter++;
                    else if(cardsToPlay.get(i).getColor() == Color.purple)purplecounter++;
                    else if(cardsToPlay.get(i).getColor() == Color.red)redcounter++;
                    else if(cardsToPlay.get(i).getColor() == Color.white)whitecounter++;
                    else if(cardsToPlay.get(i).getColor() == Color.yellow)yellowcounter++;
                }
                
                if(blackcounter != 0 && bluecounter==0 && greencounter==0 && orangecounter==0 && purplecounter==0 &&
                 redcounter==0 && whitecounter==0 && yellowcounter==0){
                    if(trainrob==true){
                        TrainRobbing(opRailYard.getBlack());
                        trainrob=false;
                    }
                    for (int i=0; i<cardsToPlay.size(); i++){
                        TrainCard tc = cardsToPlay.get(i);
                        if(tc.getColor()==Color.locomotive){
                            this.black.add(tc);
                        }
                        else if(this.black.isEmpty()){
                            this.black.add(tc);
                        }
                        else{
                            int loco=this.black.size()-1;
                            while(loco>0 && this.black.get(loco).getColor()==Color.locomotive){
                                loco--;
                            }
                            this.black.add(loco,tc);
                        }
                    }
                }
                
                else if(blackcounter == 0 && bluecounter!=0 && greencounter==0 && orangecounter==0 && purplecounter==0 &&
                 redcounter==0 && whitecounter==0 && yellowcounter==0){
                    if(trainrob==true){
                        TrainRobbing(opRailYard.getBlue());
                        trainrob=false;
                    }
                    for (int i=0; i<cardsToPlay.size(); i++){
                        TrainCard tc = cardsToPlay.get(i);
                        if(tc.getColor()==Color.locomotive){
                            this.blue.add(tc);
                        }
                        else if(this.blue.isEmpty()){
                            this.blue.add(tc);
                        }
                        else{
                            int loco=this.blue.size()-1;
                            while(loco>0 && this.blue.get(loco).getColor()==Color.locomotive){
                                loco--;
                            }
                            this.blue.add(loco,tc);
                        }
                    }
                }
                
                else if(blackcounter == 0 && bluecounter==0 && greencounter!=0 && orangecounter==0 && purplecounter==0 &&
                 redcounter==0 && whitecounter==0 && yellowcounter==0){
                    if(trainrob==true){
                        TrainRobbing(opRailYard.getGreen());
                        trainrob=false;
                    }
                    for (int i=0; i<cardsToPlay.size(); i++){
                        TrainCard tc = cardsToPlay.get(i);
                        if(tc.getColor()==Color.locomotive){
                            this.green.add(tc);
                        }
                        else if(this.green.isEmpty()){
                            this.green.add(tc);
                        }
                        else{
                            int loco=this.green.size()-1;
                            while(loco>0 && this.green.get(loco).getColor()==Color.locomotive){
                                loco--;
                            }
                            this.green.add(loco,tc);
                        }
                    }
                }
                
                else if(blackcounter == 0 && bluecounter==0 && greencounter==0 && orangecounter!=0 && purplecounter==0 &&
                 redcounter==0 && whitecounter==0 && yellowcounter==0){
                    if(trainrob==true){
                        TrainRobbing(opRailYard.getOrange());
                        trainrob=false;
                    }
                    for (int i=0; i<cardsToPlay.size(); i++){
                        TrainCard tc = cardsToPlay.get(i);
                        if(tc.getColor()==Color.locomotive){
                            this.orange.add(tc);
                        }
                        else if(this.orange.isEmpty()){
                            this.orange.add(tc);
                        }
                        else{
                            int loco=this.orange.size()-1;
                            while(loco>0 && this.orange.get(loco).getColor()==Color.locomotive){
                                loco--;
                            }
                            this.orange.add(loco,tc);
                        }
                    }
                }
                
                else if(blackcounter == 0 && bluecounter==0 && greencounter==0 && orangecounter==0 && purplecounter!=0 &&
                 redcounter==0 && whitecounter==0 && yellowcounter==0){
                    if(trainrob==true){
                        TrainRobbing(opRailYard.getPurple());
                        trainrob=false;
                    }
                    for (int i=0; i<cardsToPlay.size(); i++){
                        TrainCard tc = cardsToPlay.get(i);
                        if(tc.getColor()==Color.locomotive){
                            this.purple.add(tc);
                        }
                        else if(this.purple.isEmpty()){
                            this.purple.add(tc);
                        }
                        else{
                            int loco=this.purple.size()-1;
                            while(loco>0 && this.purple.get(loco).getColor()==Color.locomotive){
                                loco--;
                            }
                            this.purple.add(loco,tc);
                        }
                    }
                }
                
                else if(blackcounter == 0 && bluecounter==0 && greencounter==0 && orangecounter==0 && purplecounter==0 &&
                 redcounter!=0 && whitecounter==0 && yellowcounter==0){
                    if(trainrob==true){
                        TrainRobbing(opRailYard.getRed());
                        trainrob=false;
                    }
                    for (int i=0; i<cardsToPlay.size(); i++){
                        TrainCard tc = cardsToPlay.get(i);
                        if(tc.getColor()==Color.locomotive){
                            this.red.add(tc);
                        }
                        else if(this.red.isEmpty()){
                            this.red.add(tc);
                        }
                        else{
                            int loco=this.red.size()-1;
                            while(loco>0 && this.red.get(loco).getColor()==Color.locomotive){
                                loco--;
                            }
                            this.red.add(loco,tc);
                        }
                    }
                }
                
                else if(blackcounter == 0 && bluecounter==0 && greencounter==0 && orangecounter==0 && purplecounter==0 &&
                 redcounter==0 && whitecounter!=0 && yellowcounter==0){
                    if(trainrob==true){
                        TrainRobbing(opRailYard.getWhite());
                        trainrob=false;
                    }
                    for (int i=0; i<cardsToPlay.size(); i++){
                        TrainCard tc = cardsToPlay.get(i);
                        if(tc.getColor()==Color.locomotive){
                            this.white.add(tc);
                        }
                        else if(this.white.isEmpty()){
                            this.white.add(tc);
                        }
                        else{
                            int loco=this.white.size()-1;
                            while(loco>0 && this.white.get(loco).getColor()==Color.locomotive){
                                loco--;
                            }
                            this.white.add(loco,tc);
                        }
                    }
                }
                
                else if(blackcounter == 0 && bluecounter==0 && greencounter==0 && orangecounter==0 && purplecounter==0 &&
                 redcounter==0 && whitecounter==0 && yellowcounter!=0){
                    if(trainrob==true){
                        TrainRobbing(opRailYard.getYellow());
                        trainrob=false;
                    }
                    for (int i=0; i<cardsToPlay.size(); i++){
                        TrainCard tc = cardsToPlay.get(i);
                        if(tc.getColor()==Color.locomotive){
                            this.yellow.add(tc);
                        }
                        else if(this.yellow.isEmpty()){
                            this.yellow.add(tc);
                        }
                        else{
                            int loco=this.yellow.size()-1;
                            while(loco>0 && this.yellow.get(loco).getColor()==Color.locomotive){
                                loco--;
                            }
                            this.yellow.add(loco,tc);
                        }
                    }
                }
            }
    }
    
    /**
     *  Transformer.
     * Postcondition:removes all cards of opponents given list
     * @param cardsToRob
     */
    public void TrainRobbing(ArrayList<TrainCard> cardsToRob){
        cardsToRob.clear();
    }

}
