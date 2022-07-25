/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Deck;

import Model.Cards.*;
import Model.Player.Player;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Deck {
    private ArrayList<TrainCard>tCardsCollection;
    private ArrayList<DestinationCard>dstCardsCollection;
    private ArrayList<TrainCard>tCardsDeck;
    private BigCitiesCard chicago;
    private BigCitiesCard dallas;
    private BigCitiesCard losangeles;
    private BigCitiesCard miami;
    private BigCitiesCard newyork;
    private BigCitiesCard seattle;

    public Deck(){
        this.dstCardsCollection = new ArrayList<>();
        this.tCardsCollection = new ArrayList<>();
        this.tCardsDeck = new ArrayList<>(5);
    }
    /**
     * Accessor.
     * Postcondition:Chicago BCcard is returned
     * @return Chicago BC card
     */
    public BigCitiesCard getChicago(){
        return this.chicago;
    }
    /**
     * Accessor.
     * Postcondition:dallas BCcard is returned
     * @return dallas BC card
     */
    public BigCitiesCard getDallas(){
        return this.dallas;
    }
    /**
     * Accessor.
     * Postcondition:la BCcard is returned
     * @return la BC card
     */
    public BigCitiesCard getLosAngeles(){
        return this.losangeles;
    }
    /**
     * Accessor.
     * Postcondition:Miami BCcard is returned
     * @return miami BC card
     */
    public BigCitiesCard getMiami(){
        return this.miami;
    }
    /**
     * Accessor.
     * Postcondition:NewYork BCcard is returned
     * @return New York BC card
     */
    public BigCitiesCard getNewYork(){
        return this.newyork;
    }
    /**
     * Accessor.
     * Postcondition:Seattle BCcard is returned
     * @return Seattle BC card
     */
    public BigCitiesCard getSeattle(){
        return this.seattle;
    }
    
    /**
     * Accessor.
     * Postcondition:arraylist of games tcards is returned
     * @return arraylist tcardscollection
     */
    public ArrayList<TrainCard> getTcardCollection(){
        return this.tCardsCollection;
    }
     /**
     * Accessor.
     * Postcondition:arraylist of games dstcards is returned
     * @return arraylist dstcardscollection
     */
    public ArrayList<DestinationCard> getdstCardsCollection(){
        return this.dstCardsCollection;
    }
     /**
     * Accessor.
     * Postcondition:arraylist of games tcards open on the deck
     * @return arraylist tcardsdeck
     */
    public ArrayList<TrainCard> getTcardsDeck(){
        return this.tCardsDeck;
    }
     
    /**
     * Transformer.
     * postcondition:
     * creates all the cards and puts them in the tCardsCollection and dstCardsCollection
     */
    public void createCards(){
       for (int i=0; i<10; i++){
        TrainCard red = new TrainCard(Color.red,"resources/images/trainCards/red.jpg");
        tCardsCollection.add(red);
       }
        
       for (int i=0; i<10; i++){
        TrainCard black = new TrainCard(Color.black,"resources/images/trainCards/black.jpg");
        tCardsCollection.add(black);
       }
       
       for (int i=0; i<10; i++){
        TrainCard blue = new TrainCard(Color.blue,"resources/images/trainCards/blue.jpg");
        tCardsCollection.add(blue);
       }
       
       for (int i=0; i<10; i++){
        TrainCard green = new TrainCard(Color.green,"resources/images/trainCards/green.jpg");
        tCardsCollection.add(green);
       }
       
       for (int i=0; i<10; i++){
        TrainCard purple = new TrainCard(Color.purple,"resources/images/trainCards/purple.jpg");
        tCardsCollection.add(purple);
       }
       
       for (int i=0; i<10; i++){
        TrainCard white = new TrainCard(Color.white,"resources/images/trainCards/white.jpg");
        tCardsCollection.add(white);
       }
       
       for (int i=0; i<10; i++){
        TrainCard yellow = new TrainCard(Color.yellow,"resources/images/trainCards/yellow.jpg");
        tCardsCollection.add(yellow);
       }
       
       for (int i=0; i<10; i++){
        TrainCard orange = new TrainCard(Color.orange,"resources/images/trainCards/orange.jpg");
        tCardsCollection.add(orange);
       }
       
       for (int i=0; i<16; i++){
        TrainCard locomotive = new TrainCard(Color.locomotive,"resources/images/trainCards/locomotive.jpg");
        tCardsCollection.add(locomotive);
       }
       DestinationCard dc1 = new DestinationCard("Chicago","New York",5,Color.yellow,"resources/images/destination_Tickets/desCard1.jpg");
       DestinationCard dc2 = new DestinationCard("New York","Chicago",5,Color.blue,"resources/images/destination_Tickets/desCard2.jpg");
       DestinationCard dc3 = new DestinationCard("Chicago","Dallas",6,Color.yellow,Color.green,"resources/images/destination_Tickets/desCard3.jpg");
       DestinationCard dc4 = new DestinationCard("New York","Sault Sainte",6,Color.yellow,Color.blue,"resources/images/destination_Tickets/desCard4.jpg");
       DestinationCard dc5 = new DestinationCard("Chicago","Montreal",7,Color.yellow,Color.blue,"resources/images/destination_Tickets/desCard5.jpg");
       DestinationCard dc6 = new DestinationCard("Chicago","Charleston",7,Color.yellow,Color.red,"resources/images/destination_Tickets/desCard6.jpg");
       DestinationCard dc7 = new DestinationCard("Dallas","Raleigh",8,Color.green,Color.red,"resources/images/destination_Tickets/desCard7.jpg");
       DestinationCard dc8 = new DestinationCard("Dallas","Miami",9,Color.green,Color.red,"resources/images/destination_Tickets/desCard8.jpg");
       DestinationCard dc9 = new DestinationCard("Seattle","LosAngeles",9,Color.black,Color.white,"resources/images/destination_Tickets/desCard9.jpg");
       DestinationCard dc10 = new DestinationCard("Chicago","Santa Fe",9,Color.yellow,Color.green,"resources/images/destination_Tickets/desCard10.jpg");
       DestinationCard dc11 = new DestinationCard("New York","Kansas City",9,Color.green,Color.blue,"resources/images/destination_Tickets/desCard11.jpg");
       DestinationCard dc12 = new DestinationCard("Chicago","Miami",10,Color.yellow,Color.red,"resources/images/destination_Tickets/desCard12.jpg");
       DestinationCard dc13 = new DestinationCard("New York","Miami",10,Color.blue,Color.red,"resources/images/destination_Tickets/desCard13.jpg");
       DestinationCard dc14 = new DestinationCard("Seattle","Denver",10,Color.black,Color.green,"resources/images/destination_Tickets/desCard14.jpg");
       DestinationCard dc15 = new DestinationCard("Los Angeles","Dallas",10,Color.white,Color.green,"resources/images/destination_Tickets/desCard15.jpg");
       DestinationCard dc16 = new DestinationCard("Los Angeles","Vancouver",10,Color.black,Color.white,"resources/images/destination_Tickets/desCard16.jpg");
       DestinationCard dc17 = new DestinationCard("Dallas","Kelena",10,Color.black,Color.green,"resources/images/destination_Tickets/desCard17.jpg");
       DestinationCard dc18 = new DestinationCard("Dallas","Washington",10,Color.green,Color.blue,"resources/images/destination_Tickets/desCard18.jpg");
       DestinationCard dc19 = new DestinationCard("New York","New Orleans",10,Color.blue,Color.red,"resources/images/destination_Tickets/desCard19.jpg");
       DestinationCard dc20 = new DestinationCard("Dallas","New York",11,Color.green,Color.blue,Color.orange,"resources/images/destination_Tickets/desCard20.jpg");
       DestinationCard dc21 = new DestinationCard("Dallas","Winnipeg",11,Color.yellow,Color.green,Color.purple,"resources/images/destination_Tickets/desCard21.jpg");
       DestinationCard dc22 = new DestinationCard("Miami","Omaha",11,Color.yellow,Color.red,Color.purple,"resources/images/destination_Tickets/desCard22.jpg");
       DestinationCard dc23 = new DestinationCard("Los Angeles","Houston",11,Color.white,Color.green,Color.orange,"resources/images/destination_Tickets/desCard23.jpg");
       DestinationCard dc24 = new DestinationCard("Miami","Boston",12,Color.blue,Color.red,Color.orange,"resources/images/destination_Tickets/desCard24.jpg");
       DestinationCard dc25 = new DestinationCard("Seattle","Phoenix",12,Color.black,Color.white,Color.orange,"resources/images/destination_Tickets/desCard25.jpg");
       DestinationCard dc26 = new DestinationCard("Miami","El Paso",13,Color.green,Color.red,Color.orange,"resources/images/destination_Tickets/desCard26.jpg");
       DestinationCard dc27 = new DestinationCard("Dallas","San Fransisco",13,Color.white,Color.green,Color.purple,"resources/images/destination_Tickets/desCard27.jpg");
       DestinationCard dc28 = new DestinationCard("Chicago","Calgary",13,Color.black,Color.yellow,Color.purple,"resources/images/destination_Tickets/desCard28.jpg");
       DestinationCard dc29 = new DestinationCard("Seattle","Saint Louis",14,Color.black,Color.yellow,Color.purple,"resources/images/destination_Tickets/desCard29.jpg");
       DestinationCard dc30 = new DestinationCard("Los Angeles","Nashville",14,Color.white,Color.red,Color.orange,"resources/images/destination_Tickets/desCard30.jpg");
       DestinationCard dc31 = new DestinationCard("Los Angeles","Duluth",14,Color.white,Color.yellow,Color.purple,"resources/images/destination_Tickets/desCard31.jpg");
       DestinationCard dc32 = new DestinationCard("Seattle","Chicago",15,Color.black,Color.yellow,Color.yellow,"resources/images/destination_Tickets/desCard32.jpg");
       DestinationCard dc33 = new DestinationCard("Los Angeles","Chicago",15,Color.white,Color.yellow,Color.orange,"resources/images/destination_Tickets/desCard33.jpg");
       DestinationCard dc34 = new DestinationCard("Seattle","Dallas",16,Color.black,Color.black,Color.green,Color.orange,"resources/images/destination_Tickets/desCard34.jpg");
       DestinationCard dc35 = new DestinationCard("Chicago","San Fransisco",16,Color.white,Color.yellow,Color.purple,Color.orange,"resources/images/destination_Tickets/desCard35.jpg");
       DestinationCard dc36 = new DestinationCard("Miami","Salt Lake City",17,Color.black,Color.red,Color.purple,Color.orange,"resources/images/destination_Tickets/desCard36.jpg");
       DestinationCard dc37 = new DestinationCard("Seattle","Atlanta",17,Color.black,Color.green,Color.red,Color.orange,"resources/images/destination_Tickets/desCard37.jpg");
       DestinationCard dc38 = new DestinationCard("Seattle","Toronto",17,Color.black,Color.blue,Color.purple,Color.purple,"resources/images/destination_Tickets/desCard38.jpg");
       DestinationCard dc39 = new DestinationCard("Los Angeles","Pittsburgh",18,Color.white,Color.blue,Color.blue,Color.purple,"resources/images/destination_Tickets/desCard39.jpg");
       DestinationCard dc40 = new DestinationCard("Los Angeles","Miami",19,Color.white,Color.red,Color.orange,Color.orange,"resources/images/destination_Tickets/desCard40.jpg");
       DestinationCard dc41 = new DestinationCard("New York","Las Vegas",19,Color.white,Color.blue,Color.purple,Color.orange,"resources/images/destination_Tickets/desCard41.jpg");
       DestinationCard dc42 = new DestinationCard("Miami","Las Vegas",20,Color.white,Color.red,Color.purple,Color.orange,"resources/images/destination_Tickets/desCard42.jpg");
       DestinationCard dc43 = new DestinationCard("Seattle","New York",20,Color.black,Color.blue,Color.blue,Color.purple,"resources/images/destination_Tickets/desCard43.jpg");
       DestinationCard dc44 = new DestinationCard("Los Angeles","New York",20,Color.white,Color.white,Color.blue,Color.blue,"resources/images/destination_Tickets/desCard44.jpg");
       DestinationCard dc45 = new DestinationCard("New York","Portland",21,Color.black,Color.yellow,Color.blue,Color.purple,Color.purple,"resources/images/destination_Tickets/desCard45.jpg");
       DestinationCard dc46 = new DestinationCard("Seattle","Miami",22,Color.black,Color.white,Color.red,Color.red,Color.orange,"resources/images/destination_Tickets/desCard46.jpg");
        
       dstCardsCollection.add(dc1);
       dstCardsCollection.add(dc2);
       dstCardsCollection.add(dc3);
       dstCardsCollection.add(dc4);
       dstCardsCollection.add(dc5);
       dstCardsCollection.add(dc6);
       dstCardsCollection.add(dc7);
       dstCardsCollection.add(dc8);
       dstCardsCollection.add(dc9);
       dstCardsCollection.add(dc10);
       dstCardsCollection.add(dc11);
       dstCardsCollection.add(dc12);
       dstCardsCollection.add(dc13);
       dstCardsCollection.add(dc14);
       dstCardsCollection.add(dc15);
       dstCardsCollection.add(dc16);
       dstCardsCollection.add(dc17);
       dstCardsCollection.add(dc18);
       dstCardsCollection.add(dc19);
       dstCardsCollection.add(dc20);
       dstCardsCollection.add(dc21);
       dstCardsCollection.add(dc22);
       dstCardsCollection.add(dc23);
       dstCardsCollection.add(dc24);
       dstCardsCollection.add(dc25);
       dstCardsCollection.add(dc26);
       dstCardsCollection.add(dc27);
       dstCardsCollection.add(dc28);
       dstCardsCollection.add(dc29);
       dstCardsCollection.add(dc30);
       dstCardsCollection.add(dc31);
       dstCardsCollection.add(dc32);
       dstCardsCollection.add(dc33);
       dstCardsCollection.add(dc34);
       dstCardsCollection.add(dc35);
       dstCardsCollection.add(dc36);
       dstCardsCollection.add(dc37);
       dstCardsCollection.add(dc38);
       dstCardsCollection.add(dc39);
       dstCardsCollection.add(dc40);
       dstCardsCollection.add(dc41);
       dstCardsCollection.add(dc42);
       dstCardsCollection.add(dc43);
       dstCardsCollection.add(dc44);
       dstCardsCollection.add(dc45);
       dstCardsCollection.add(dc46);
       
       
       BigCitiesCard bc1 = new BigCitiesCard(8,"Miami","resources/images/bigCitiesCards/Miami.jpg");
       BigCitiesCard bc2 = new BigCitiesCard(8,"Seattle","resources/images/bigCitiesCards/Seattle.jpg");
       BigCitiesCard bc3 = new BigCitiesCard(10,"Dallas","resources/images/bigCitiesCards/Dallas.jpg");
       BigCitiesCard bc4 = new BigCitiesCard(12,"Chicago","resources/images/bigCitiesCards/Chicago.jpg");
       BigCitiesCard bc5 = new BigCitiesCard(12,"Los Angeles","resources/images/bigCitiesCards/LosAngeles.jpg");
       BigCitiesCard bc6 = new BigCitiesCard(15,"New York","resources/images/bigCitiesCards/NewYork.jpg");
       this.miami=bc1;
       this.seattle=bc2;
       this.dallas=bc3;
       this.chicago=bc4;
       this.losangeles=bc5;
       this.newyork=bc6;
       
    }
    /**
     *  Transformer.
     *  postcondition:Draws a card from TcardCollection and moves it to the player hand
     * @param player
     */
    public void DrawTcardFromCollection(Player player){
        
    }
    
    /**
     *  Transformer.
     *  postcondition:
     *  Draws a card from the 5 train cards on the deck,puts them back on the
     *  collection and put  5 new
     * @param player
     */
    public void DrawTcardFromDeck(Player player){
        
    }
    
    /**
     * 
     * @param player
     * @param dstcards
     */
    public void DrawDstCard(Player player,ArrayList<DestinationCard> dstcards){
        
    }
    
    /**
     *  if its the 3rd time a player visits a big city he takes the card
     * @param card
     */
    public void getBcCard(BigCitiesCard card){
        
    }
    /**
     * Acessor.
     * Postcondition:returns a string repsentation of deck
     * @return string representation of deck
     */
    @Override
    public String toString(){
        return "";
    }
    
}
