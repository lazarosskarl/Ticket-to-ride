/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cards.*;
import Model.Deck.*;
import Model.OnTheTrack.*;
import Model.Player.*;
import Model.RailYard.*;
import View.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class Controller {
    private Player player1,player2;
    private Deck deck;
    private ArrayList<TrainCard> cardsToPlay;
    GraphicUI view;
    private boolean turn; //determines which player plays.
    private boolean phaseB=false; //determines if a player can play-draw-buy cards
    private int tdrawcounter=0;
    
    public Controller(){
        this.player1=new Player(1);
        this.player2=new Player(2);
        this.deck=new Deck();
        this.cardsToPlay=new ArrayList<>();
        turn = (new Random()).nextBoolean();
        this.view = new GraphicUI();
        view.setVisible(true);
        this.initialize();
    }
    
    /**
     * Transformer
     * Initializes the game and sets listeners
     */
    public void initialize(){
        
        
        initCards();
        view.initCards(player1.getTcard(),player2.getTcard(),deck.getTcardsDeck(),player1.getDstCard(),player2.getDstCard());
        updateView();
        setlisteners();

    }
    
    /**
     *  Transformer
     *  Sets Listeners for buttons
     */
    private void setlisteners(){
        ButtonListener buttonlistener = new ButtonListener();
        TcardDeckListener Tcardlistener = new TcardDeckListener();
        TcardHand1Listener tHand1Listener = new TcardHand1Listener();
        TcardHand2Listener tHand2Listener = new TcardHand2Listener();
        DstListener1 dstListener1 = new DstListener1();
        DstListener2 dstListener2 = new DstListener2();
        view.playCard1.addMouseListener(buttonlistener);
        view.MVonTheTrack1.addMouseListener(buttonlistener);
        view.MyBC1.addMouseListener(buttonlistener);
        view.MyBC2.addMouseListener(buttonlistener);
        view.MyDst1.addMouseListener(buttonlistener);
        view.MyDst2.addMouseListener(buttonlistener);
        view.MVonTheTrack2.addMouseListener(buttonlistener);
        view.playCard2.addMouseListener(buttonlistener);
        view.tDeck.addMouseListener(buttonlistener);
        view.dstDeck.addMouseListener(buttonlistener);
        view.getDstCards1().get(0).addMouseListener(dstListener1);
        view.getDstCards2().get(0).addMouseListener(dstListener2);
        for(int i=0; i<5; i++){
            view.getDeckTcards().get(i).addMouseListener(Tcardlistener);
        }
        
        for (int i=0; i<8; i++){
            view.getCards2().get(i).addMouseListener(tHand2Listener);
        }
        
        for (int i=0; i<8; i++){
            view.getCards1().get(i).addMouseListener(tHand1Listener);
        }
        
    }
    
     /**
     *  Transformer
     *  Gives every player their starting cards and lays 5 cards on the deck.
     */
    private void initCards(){
        deck.createCards();
        player1.addTcard(deck.getTcardCollection().get(deck.getTcardCollection().size()-1));
        deck.getTcardCollection().remove(deck.getTcardCollection().size()-1);
        player2.addTcard(deck.getTcardCollection().get(deck.getTcardCollection().size()-1));
        deck.getTcardCollection().remove(deck.getTcardCollection().size()-1);
        Collections.shuffle(deck.getTcardCollection());
        Collections.shuffle(deck.getdstCardsCollection());
        player1.addDstCard(deck.getdstCardsCollection().get(deck.getdstCardsCollection().size()-1));
        player1.addScore(-(deck.getdstCardsCollection().get(deck.getdstCardsCollection().size()-1).getPoints()));
        deck.getdstCardsCollection().remove(deck.getdstCardsCollection().size()-1);
        player2.addDstCard(deck.getdstCardsCollection().get(deck.getdstCardsCollection().size()-1));
        player2.addScore(-(deck.getdstCardsCollection().get(deck.getdstCardsCollection().size()-1).getPoints()));
        deck.getdstCardsCollection().remove(deck.getdstCardsCollection().size()-1);

        for(int i =0; i<7; i++){
            player1.addTcard(deck.getTcardCollection().get(deck.getTcardCollection().size()-1));
            deck.getTcardCollection().remove(deck.getTcardCollection().size()-1);
        }
        
        for(int i =0; i<7; i++){
            player2.addTcard(deck.getTcardCollection().get(deck.getTcardCollection().size()-1));
            deck.getTcardCollection().remove((deck.getTcardCollection().size())-1);
        }
        
        for(int i=0; i<5; i++){
            deck.getTcardsDeck().add(deck.getTcardCollection().get(deck.getTcardCollection().size()-1));
            deck.getTcardCollection().remove((deck.getTcardCollection().size())-1);

        }
    }
    
    /**
     * Accessor
     * Postcondition Determines whose turn it is
     * @return player1 or player2
     */
    public Player getTurn() {
        if (this.turn) {
            return player1; //as in player 1
        } else {
            return player2; //as in player 2
        }
    }

    /** 
     * Transformer
     * Postcondition: Switches turn
     */
    public void endTurn() {
        phaseB=false;
        turn = !turn;
        updateView();
    }
    
    /** 
     * Observer
     * Postcondition True if a player reached 100 points or traincards from deck are finished
     * @return boolean true if the game has ended
     */
    public boolean isFinished() {
        return true;
    }
    
    /** 
     * Accessor
     * Precondition The game has finished
     * Postcondition Returns the winner
     * @return The winner
     */
    public String getWinner(){
        return"lala";
    }
    
    /**
     * Transformer
     * Postcondition updates the information displayed on screen
     */
    public void updateView(){
        view.updateInfo(player1, player2, getTurn().getID(), deck);

    }
    //------------------------------------MAIN-----------------------------------------
    

    public static void main(String[] argc) {
        Controller c = new Controller();

    }

    //---------------------------------LISTENERS---------------------------------------
    
    /**
     * Class that handles all actions caused by tcardbuttons on player1 hand
     */
     private class TcardHand1Listener implements MouseListener {
         @Override
        public void mouseClicked(MouseEvent e) {
            if(getTurn()==player1){
                if(phaseB==true){
                    if(tdrawcounter==1){
                        JOptionPane.showMessageDialog(null, "You have to draw another card!","OOPS",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                    TcardHand1Listener tHand1Listener = new TcardHand1Listener();
                    JButton but = ((JButton) e.getSource());
                    int index = Integer.valueOf(but.getName());
                    TrainCard c = player1.getTcard().get(index);
                    cardsToPlay.add(c);
                    }
                }
                else if(phaseB==false){
                    JOptionPane.showMessageDialog(null, "You haven't moved cards on the Track","OOPS",JOptionPane.ERROR_MESSAGE);
                }
            }
            else JOptionPane.showMessageDialog(null, "It's not Your turn!","OOPS",JOptionPane.ERROR_MESSAGE);
        }
         @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }
        
     }
     /**
     * Class that handles all actions caused by tcardbuttons on player2 hand
     */
     private class TcardHand2Listener implements MouseListener {
         
        @Override
        public void mouseClicked(MouseEvent e) {
            if(getTurn()==player2){
                if(phaseB==true){
                    if(tdrawcounter==1){
                        JOptionPane.showMessageDialog(null, "You have to draw another card!","OOPS",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                    TcardHand2Listener tHand2Listener = new TcardHand2Listener();
                    JButton but = ((JButton) e.getSource());
                    int index = Integer.valueOf(but.getName());
                    TrainCard c = player2.getTcard().get(index);
                    cardsToPlay.add(c);
                    }
                }
                else if(phaseB==false){
                    JOptionPane.showMessageDialog(null, "You haven't moved cards on the Track","OOPS",JOptionPane.ERROR_MESSAGE);
                }
            }
            else JOptionPane.showMessageDialog(null, "It's not Your turn!","OOPS",JOptionPane.ERROR_MESSAGE);
        }
         @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }
        
     }
     
     /**
     * Class that handles all actions caused by tcardbuttons open on deck
     */
     private class TcardDeckListener implements MouseListener {
        int index;
        Player player;
        JButton but;

         @Override
        public void mouseClicked(MouseEvent e) {
           if(phaseB==true){
                player=getTurn();
                JButton but = ((JButton) e.getSource());
                int index = Integer.valueOf(but.getName());
                TrainCard c = deck.getTcardsDeck().get(index);
                player.getTcard().add(c);
                view.UpdatePlayerTrainCards(player.getTcard(), player);
                deck.getTcardsDeck().remove(index);
                if(player == player2){
                    TcardHand2Listener tHand2Listener = new TcardHand2Listener();
                    for(int i=0; i<view.getCards2().size(); i++){
                        view.getCards2().get(i).addMouseListener(tHand2Listener);
                    }
                }
                else if(player == player1){
                    TcardHand1Listener tHand1Listener = new TcardHand1Listener();
                    for(int i=0; i<view.getCards1().size(); i++){
                        view.getCards1().get(i).addMouseListener(tHand1Listener);
                    }
                }
                tdrawcounter++;
            

                if(tdrawcounter == 2){
                   endTurn();
                  tdrawcounter=0;
                }

                for(int i=0; i<4; i++){
                    deck.getTcardCollection().add(deck.getTcardsDeck().get(i));
                }
           
                deck.getTcardsDeck().clear();
                Collections.shuffle(deck.getTcardCollection());
               
                for(int i=0; i<5; i++){
                    deck.getTcardsDeck().add(deck.getTcardCollection().get(deck.getTcardCollection().size()-1));
                    deck.getTcardCollection().remove((deck.getTcardCollection().size())-1);

                }
                view.updateTdeck(deck.getTcardsDeck());
                updateView();
                   
                TcardDeckListener Tcardlistener = new TcardDeckListener();
                for(int i=0; i<5; i++){
                view.getDeckTcards().get(i).addMouseListener(Tcardlistener);
                }
            }
           else {JOptionPane.showMessageDialog(null, "You haven't moved cards on Track","OOPS",JOptionPane.ERROR_MESSAGE);}
 
            
        }
        
        
        
         @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }
        
     }
     
     /**
     * Class that handles all actions caused by dstcard buttons of player1
     */
     private class DstListener1 implements MouseListener {
         @Override
        public void mouseClicked(MouseEvent e) {
            if(getTurn()==player1){
                if(phaseB==true){
                    if(tdrawcounter==1){
                        JOptionPane.showMessageDialog(null, "You have to draw another card!","OOPS",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        JButton but = ((JButton) e.getSource());
                        int index = Integer.valueOf(but.getName());
                        DestinationCard c = player1.getDstCard().get(index);
                        if(player1.getPlayerOnTheTrack().IsBuyable(c, player1)){
                            player1.getPlayerOnTheTrack().BuyDestinationCard(c, player1);
                            player1.getDstCard().remove(c);
                            view.updateDestinationCards(player1.getDstCard(), player1);
                            view.updateRailYard(player1.getPlayerRailyard(), player1);
                            view.updateBoughtDst(player1.getBoughtDstCard(), player1);
                            if(c.getTo().equals("Chicago")){
                                deck.getChicago().P1visits();
                                if(deck.getChicago().getP1visits()==3 && deck.getChicago().getP2visits()<3){
                                    view.UpdateBcCards("Chicago");
                                    view.updateBCwindows("Chicago", player1);
                                    player1.addScore(deck.getChicago().getPoints());
                                }
                            }
                            else if(c.getTo().equals("Dallas")){
                                deck.getDallas().P1visits();
                                if(deck.getDallas().getP1visits()==3 && deck.getDallas().getP2visits()<3){
                                    view.UpdateBcCards("Dallas");
                                    view.updateBCwindows("Dallas", player1);
                                    player1.addScore(deck.getDallas().getPoints());

                                }
                            }
                            else if(c.getTo().equals("Los Angeles")){
                                deck.getLosAngeles().P1visits();
                                if(deck.getLosAngeles().getP1visits()==3 && deck.getLosAngeles().getP2visits()<3){
                                    view.UpdateBcCards("Los Angeles");
                                    view.updateBCwindows("Los Angeles", player1);
                                    player1.addScore(deck.getLosAngeles().getPoints());
                                }
                            }
                            else if(c.getTo().equals("Miami")){
                                deck.getMiami().P1visits();
                                if(deck.getMiami().getP1visits()==3 && deck.getMiami().getP2visits()<3){
                                    view.UpdateBcCards("Miami");
                                    view.updateBCwindows("Miami", player1);
                                    player1.addScore(deck.getMiami().getPoints());
                                }
                            }
                            
                            else if(c.getTo().equals("New York")){
                                deck.getNewYork().P1visits();
                                if(deck.getNewYork().getP1visits()==3 && deck.getNewYork().getP2visits()<3){
                                    view.UpdateBcCards("New York");
                                    view.updateBCwindows("New York", player1);
                                    player1.addScore(deck.getNewYork().getPoints());
                                }
                            }
                            
                            else if(c.getTo().equals("Seattle")){
                                deck.getSeattle().P1visits();
                                if(deck.getSeattle().getP1visits()==3 && deck.getSeattle().getP2visits()<3){
                                    view.UpdateBcCards("Seattle");
                                    view.updateBCwindows("Seattle", player1);
                                    player1.addScore(deck.getSeattle().getPoints());
                                }
                            }
                            
                            endTurn();
                        }
                    }
                }
                else if(phaseB==false){
                    JOptionPane.showMessageDialog(null, "You haven't moved cards on the Track","OOPS",JOptionPane.ERROR_MESSAGE);
                }
            }
            else JOptionPane.showMessageDialog(null, "It's not Your turn!","OOPS",JOptionPane.ERROR_MESSAGE);
        
        }
         @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }
        
     }
     private class DstListener2 implements MouseListener {
         @Override
        public void mouseClicked(MouseEvent e) {
            if(getTurn()==player2){
                if(phaseB==true){
                    if(tdrawcounter==1){
                        JOptionPane.showMessageDialog(null, "You have to draw another card!","OOPS",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        JButton but = ((JButton) e.getSource());
                        int index = Integer.valueOf(but.getName());
                        DestinationCard c = player2.getDstCard().get(index);
                        if(player2.getPlayerOnTheTrack().IsBuyable(c, player2)){
                            player2.getPlayerOnTheTrack().BuyDestinationCard(c, player2);
                            player2.getDstCard().remove(c);
                            view.updateDestinationCards(player2.getDstCard(), player2);
                            view.updateRailYard(player2.getPlayerRailyard(), player2);
                            view.updateBoughtDst(player2.getBoughtDstCard(), player2);
                            
                            if(c.getTo().equals("Chicago")){
                                deck.getChicago().P2visits();
                                if(deck.getChicago().getP2visits()==3 && deck.getChicago().getP1visits()<3){
                                    view.UpdateBcCards("Chicago");
                                    view.updateBCwindows("Chicago", player2);
                                    player2.addScore(deck.getChicago().getPoints());
                                }
                            }
                            else if(c.getTo().equals("Dallas")){
                                deck.getDallas().P2visits();
                                if(deck.getDallas().getP2visits()==3 && deck.getDallas().getP1visits()<3){
                                    view.UpdateBcCards("Dallas");
                                    view.updateBCwindows("Dallas", player2);
                                    player2.addScore(deck.getDallas().getPoints());


                                }
                            }
                            else if(c.getTo().equals("Los Angeles")){
                                deck.getLosAngeles().P2visits();
                                if(deck.getLosAngeles().getP2visits()==3 && deck.getLosAngeles().getP1visits()<3){
                                    view.UpdateBcCards("Los Angeles");
                                    view.updateBCwindows("Los Angeles", player2);
                                    player2.addScore(deck.getLosAngeles().getPoints());
                                }
                            }
                            else if(c.getTo().equals("Miami")){
                                deck.getMiami().P2visits();
                                if(deck.getMiami().getP2visits()==3 && deck.getMiami().getP1visits()<3){
                                    view.UpdateBcCards("Miami");
                                    view.updateBCwindows("Miami", player2);
                                    player2.addScore(deck.getMiami().getPoints());
                                }
                            }
                            
                            else if(c.getTo().equals("New York")){
                                deck.getNewYork().P2visits();
                                if(deck.getNewYork().getP2visits()==3 && deck.getNewYork().getP1visits()<3){
                                    view.UpdateBcCards("New York");
                                    view.updateBCwindows("New York", player2);
                                    player2.addScore(deck.getNewYork().getPoints());
                                }
                            }
                            
                            else if(c.getTo().equals("Seattle")){
                                deck.getSeattle().P2visits();
                                if(deck.getSeattle().getP2visits()==3 && deck.getSeattle().getP1visits()<3){
                                    view.UpdateBcCards("Seattle");
                                    view.updateBCwindows("Seattle", player2);
                                    player2.addScore(deck.getSeattle().getPoints());
                                }
                            }

                            endTurn();
                        }
                    }
                }
                else if(phaseB==false){
                    JOptionPane.showMessageDialog(null, "You haven't moved cards on the Track","OOPS",JOptionPane.ERROR_MESSAGE);
                }
            }
            else JOptionPane.showMessageDialog(null, "It's not Your turn!","OOPS",JOptionPane.ERROR_MESSAGE);
        }
         @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }
        
     }
     /**
     * Class that handles all actions caused by integrated buttons
     */
     private class ButtonListener implements MouseListener {
         @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == view.playCard1){
                if(getTurn()==player1){
                    System.out.println("=========================================");
                    System.out.println("Blue : " + player1.getPlayerRailyard().getBlue().size());
                    System.out.println("Black : " + player1.getPlayerRailyard().getBlack().size());
                    System.out.println("Green : " + player1.getPlayerRailyard().getGreen().size());
                    System.out.println("Yellow : " + player1.getPlayerRailyard().getYellow().size());
                    System.out.println("Red : " + player1.getPlayerRailyard().getRed().size());
                    System.out.println("Purple : " + player1.getPlayerRailyard().getPurple().size());
                    System.out.println("White : " + player1.getPlayerRailyard().getWhite().size());
                    System.out.println("Orange : " + player1.getPlayerRailyard().getOrange().size());
                    System.out.println("toplay : " + cardsToPlay.size());


                    if(phaseB==true){
                        if(player1.getPlayerRailyard().isPlayable(cardsToPlay,player2.getPlayerRailyard())){
                            player1.getPlayerRailyard().PlayCards(cardsToPlay, player2.getPlayerRailyard());
                                for(int i=0; i<cardsToPlay.size(); i++){
                                    player1.getTcard().remove(cardsToPlay.get(i));
                                }
                            view.UpdatePlayerTrainCards(player1.getTcard(), player1);
                            view.updateRailYard(player1.getPlayerRailyard(), player1);
                            view.updateRailYard(player2.getPlayerRailyard(), player2);
                            cardsToPlay.clear();
                            TcardHand1Listener tHand1Listener = new TcardHand1Listener();
                        
                            for(int i=0; i<view.getCards1().size(); i++){
                                view.getCards1().get(i).addMouseListener(tHand1Listener);
                            }
                            endTurn();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Cards can't be played!!","OOPS",JOptionPane.ERROR_MESSAGE);
                            cardsToPlay.clear();
                        }
                    }
                    
                    else {
                        JOptionPane.showMessageDialog(null, "You haven't moved cards on Track","OOPS",JOptionPane.ERROR_MESSAGE);
                    }

                }
                else 
                {JOptionPane.showMessageDialog(null, "It's not your turn!","NOT SO FAST",JOptionPane.ERROR_MESSAGE);}
            }
            
            else if (e.getSource() == view.playCard2){
                if(getTurn()==player2){
                    System.out.println("=========================================");
                    System.out.println("Blue : " + player2.getPlayerRailyard().getBlue().size());
                    System.out.println("Black : " + player2.getPlayerRailyard().getBlack().size());
                    System.out.println("Green : " + player2.getPlayerRailyard().getGreen().size());
                    System.out.println("Yellow : " + player2.getPlayerRailyard().getYellow().size());
                    System.out.println("Red : " + player2.getPlayerRailyard().getRed().size());
                    System.out.println("Purple : " + player2.getPlayerRailyard().getPurple().size());
                    System.out.println("White : " + player2.getPlayerRailyard().getWhite().size());
                    System.out.println("Orange : " + player2.getPlayerRailyard().getOrange().size());
                    System.out.println("toplay : " + cardsToPlay.size());


                    if(phaseB==true){
                        if(player2.getPlayerRailyard().isPlayable(cardsToPlay,player1.getPlayerRailyard())){
                            player2.getPlayerRailyard().PlayCards(cardsToPlay, player1.getPlayerRailyard());
                                for(int i=0; i<cardsToPlay.size(); i++){
                                    player2.getTcard().remove(cardsToPlay.get(i));
                                }
                            view.UpdatePlayerTrainCards(player2.getTcard(), player2);
                            view.updateRailYard(player2.getPlayerRailyard(), player2);
                            view.updateRailYard(player1.getPlayerRailyard(), player1);
                            
                            cardsToPlay.clear();
                            TcardHand2Listener tHand2Listener = new TcardHand2Listener();
                        
                            for(int i=0; i<view.getCards2().size(); i++){
                                view.getCards2().get(i).addMouseListener(tHand2Listener);
                            }
                            endTurn();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Cards can't be played!!","OOPS",JOptionPane.ERROR_MESSAGE);
                            cardsToPlay.clear();
                        }
                    }
                    
                    else {
                        JOptionPane.showMessageDialog(null, "You haven't moved cards on Track","OOPS",JOptionPane.ERROR_MESSAGE);
                    }

                }
                else 
                {JOptionPane.showMessageDialog(null, "It's not your turn!","NOT SO FAST",JOptionPane.ERROR_MESSAGE);}
            }
            
            else if(e.getSource() == view.MVonTheTrack1){
                if(getTurn()==player1 && phaseB == false){
                    player1.getPlayerOnTheTrack().CollectFromRailYard(getTurn().getPlayerRailyard());
                    updateView();
                    view.updateRailYard(player1.getPlayerRailyard(), player1);
                    phaseB=true;
                }
                else 
                {JOptionPane.showMessageDialog(null, "It's not your turn!","NOT SO FAST",JOptionPane.ERROR_MESSAGE);}
            }
            
            else if(e.getSource() == view.MVonTheTrack2){
                if(getTurn()==player2 && phaseB ==false){
                    player2.getPlayerOnTheTrack().CollectFromRailYard(getTurn().getPlayerRailyard());
                    updateView();
                    view.updateRailYard(player2.getPlayerRailyard(), player2);
                    phaseB=true;
                }
                else 
                {JOptionPane.showMessageDialog(null, "It's not your turn!","NOT SO FAST",JOptionPane.ERROR_MESSAGE);}
            }
            
            else if(e.getSource() == view.MyBC1){
                view.togglebc1window();
            }
            
            else if(e.getSource() == view.MyBC2){
                view.togglebc2window();
            }
            
            else if(e.getSource() == view.MyDst1){
                view.toggledst1window();
            }
            
            else if(e.getSource() == view.MyDst2){
                view.toggledst2window();
            }
            
            else if(e.getSource() == view.tDeck){
                if(getTurn()==player1){
                updateView();
                    if(phaseB== true){
                        player1.addTcard(deck.getTcardCollection().get(deck.getTcardCollection().size()-1));
                        deck.getTcardCollection().remove(deck.getTcardCollection().size()-1);
                        tdrawcounter++;
                        updateView();
                        view.UpdatePlayerTrainCards(player1.getTcard(), player1);
                        TcardHand1Listener tHand1Listener = new TcardHand1Listener();
                        
                        for(int i=0; i<view.getCards1().size(); i++){
                            view.getCards1().get(i).addMouseListener(tHand1Listener);
                        }    
                        
                        if(tdrawcounter==2){
                                tdrawcounter=0;
                                endTurn();
                            }
                    }
                    else {JOptionPane.showMessageDialog(null, "You haven't moved cards on Track","OOPS",JOptionPane.ERROR_MESSAGE);}

                }
                
                else if(getTurn()==player2){
                updateView();
                    if(phaseB== true){
                        player2.addTcard(deck.getTcardCollection().get(deck.getTcardCollection().size()-1));
                        deck.getTcardCollection().remove(deck.getTcardCollection().size()-1);
                        tdrawcounter++;
                        updateView();
                        view.UpdatePlayerTrainCards(player2.getTcard(), player2);
                        TcardHand2Listener tHand2Listener = new TcardHand2Listener();
                        
                        for(int i=0; i<view.getCards2().size(); i++){
                            view.getCards2().get(i).addMouseListener(tHand2Listener);
                        }
                
                        if(tdrawcounter==2){
                            tdrawcounter=0;
                            endTurn();
                        }
                    }
                    else {JOptionPane.showMessageDialog(null, "You haven't moved cards on Track","OOPS",JOptionPane.ERROR_MESSAGE);}
                }
            }
            else if(e.getSource() == view.dstDeck){
                if(getTurn()==player1){
                updateView();
                    if(phaseB== true){
                        if(tdrawcounter == 1){
                            JOptionPane.showMessageDialog(null, "You have to draw one more Tcard","OOPS",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            player1.addDstCard(deck.getdstCardsCollection().get(deck.getdstCardsCollection().size()-1));
                            player1.addScore(-(deck.getdstCardsCollection().get(deck.getdstCardsCollection().size()-1).getPoints()));
                            deck.getdstCardsCollection().remove(deck.getdstCardsCollection().size()-1);
                            updateView();
                            view.updateDestinationCards(player1.getDstCard(), player1);
                            DstListener1 dstListener = new DstListener1();
                        
                            for(int i=0; i<view.getDstCards1().size(); i++){
                                view.getDstCards1().get(i).addMouseListener(dstListener);
                            }
                            endTurn();
                        }
                            
                    }
                    else {JOptionPane.showMessageDialog(null, "You haven't moved cards on Track","OOPS",JOptionPane.ERROR_MESSAGE);}

                }
                
                else if(getTurn()==player2){
                updateView();
                    if(phaseB== true){
                        if(tdrawcounter == 1){
                            JOptionPane.showMessageDialog(null, "You have to draw one more Tcard","OOPS",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            player2.addDstCard(deck.getdstCardsCollection().get(deck.getdstCardsCollection().size()-1));
                            player2.addScore(-(deck.getdstCardsCollection().get(deck.getdstCardsCollection().size()-1).getPoints()));
                            deck.getdstCardsCollection().remove(deck.getdstCardsCollection().size()-1);
                            updateView();
                            view.updateDestinationCards(player2.getDstCard(), player2);
                            DstListener2 dstListener = new DstListener2();
                            for(int i=0; i<view.getDstCards2().size(); i++){
                                view.getDstCards2().get(i).addMouseListener(dstListener);
                            }
                            endTurn();
                        }
                            
                    }
                    else {JOptionPane.showMessageDialog(null, "You haven't moved cards on Track","OOPS",JOptionPane.ERROR_MESSAGE);}

                }
            }
        }
         @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }
        
     }
     

}
