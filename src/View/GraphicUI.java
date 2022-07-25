/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Cards.DestinationCard;
import Model.Cards.TrainCard;
import Model.Deck.Deck;
import Model.Player.Player;
import Model.RailYard.RailYard;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;

/**
 *
 * @author User
 */
public class GraphicUI  extends JFrame{
    JLayeredPane p1THand,p1RailYard,p1DSTHand,p1OnTheTrack,p1Scoreboard,
            p2THand,p2RailYard,p2DSTHand,p2OnTheTrack,p2Scoreboard,mainpanel,p1pane,p2pane,dst1pane,dst2pane,bc1pane,bc2pane;
    public JButton tDeck,dstDeck,playCard1,MVonTheTrack1,playCard2,MVonTheTrack2,MyDst1,MyDst2,MyBC1,MyBC2;
//----------------------------player labels--------------------------------------------------------------------------
    JLabel blue1info,yellow1info,black1info,red1info,green1info,purple1info,
            white1info,orange1info,loco1info,blue1,yellow1,black1,red1,green1,purple1,white1,orange1,loco1
            ,blue2info,yellow2info,black2info,red2info,green2info,purple2info,white2info,
            orange2info,loco2info,blue2,yellow2,black2,red2,green2,purple2,white2,orange2,loco2
            ,score1,score2;
//---------------------------------------jframe for toggling windows--------------------------------------------------
    JFrame dst1window,bc1window,dst2window,bc2window;
//--------------------------deck labels-------------------------------------------------------------------------------
   JLabel turn,TcardCollection,DstCardCollection,chicago1,dallas1,losangeles1,miami1,newyork1
           ,seattle1,chicago2,dallas2,losangeles2,miami2,newyork2,seattle2,
           chicago1info,dallas1info,losangeles1info,miami1info,newyork1info
           ,seattle1info,chicago2info,dallas2info,losangeles2info,miami2info,newyork2info,seattle2info,
           chicago,dallas,losangeles,miami,newyork,seattle;
//-------------------------------------------------------------------------------------------------------    
    JFrame Dst1,Dst2,BC1,BC2;
    private ArrayList<JButton>Cards1 = new ArrayList<>();
    private ArrayList<JButton>Cards2 = new ArrayList<>();
    private ArrayList<JButton>dstCards1 = new ArrayList<>();
    private ArrayList<JButton>dstCards2 = new ArrayList<>();
    private ArrayList<JButton>dstCardsCollection = new ArrayList<>();

    ArrayList<JButton> RailBlue1 = new ArrayList<>();
    ArrayList<JButton> RailBlue2 = new ArrayList<>();
    ArrayList<JButton> RailBlack1 = new ArrayList<>();
    ArrayList<JButton> RailBlack2 = new ArrayList<>();
    ArrayList<JButton> RailRed1 = new ArrayList<>();
    ArrayList<JButton> RailRed2 = new ArrayList<>();
    ArrayList<JButton> RailYellow1 = new ArrayList<>();
    ArrayList<JButton> RailYellow2 = new ArrayList<>();
    ArrayList<JButton> RailOrange1 = new ArrayList<>();
    ArrayList<JButton> RailOrange2 = new ArrayList<>();
    ArrayList<JButton> RailWhite1 = new ArrayList<>();
    ArrayList<JButton> RailWhite2 = new ArrayList<>();
    ArrayList<JButton> RailPurple1 = new ArrayList<>();
    ArrayList<JButton> RailPurple2 = new ArrayList<>();
    ArrayList<JButton> RailGreen1 = new ArrayList<>();
    ArrayList<JButton> RailGreen2 = new ArrayList<>();
    ArrayList<JButton> p1Bought = new ArrayList<>();
    ArrayList<JButton> p2Bought = new ArrayList<>();
    private ArrayList<JButton>MainPanelTcards = new ArrayList<>(5);
    Image image;
    private ClassLoader cldr;
    
    public ArrayList<JButton> getCards1(){
        return this.Cards1;
    }
    
    public ArrayList<JButton> getCards2(){
        return this.Cards2;
    }
    
    public ArrayList<JButton> getDstCards1(){
        return this.dstCards1;
    }
    
    public ArrayList<JButton> getDstCards2(){
        return this.dstCards2;
    }
    
    public ArrayList<JButton> getDstCardsCollection(){
        return this.dstCardsCollection;
    }
    
    public ArrayList<JButton> getDeckTcards(){
        return this.MainPanelTcards;
    }
    /**
     *  Constructor.
     *  Creates a new Window and initializes some buttons and panels
     */
    public GraphicUI(){
        cldr = this.getClass().getClassLoader();
        this.setResizable(false);
        this.setTitle("Game");
        this.setSize(new Dimension(1197, 700));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.initComponents();
        this.initButtons();
        initWindows();

    }

    /**
     *  Transformer.
     *  Postcondition:All 4 toggling windows are initialized
     */
    public void initWindows(){
        URL chicagoURL = cldr.getResource("resources/images/bigCitiesCards/Chicago.jpg"); //image
        Image chicagoimage = new ImageIcon(chicagoURL).getImage();
        Image chicagogray = grayImage(chicagoimage.getScaledInstance(100, 200, java.awt.Image.SCALE_SMOOTH));
        URL dallasURL = cldr.getResource("resources/images/bigCitiesCards/Dallas.jpg"); //image
        Image dallasimage = new ImageIcon(dallasURL).getImage();
        Image dallasgray = grayImage(dallasimage.getScaledInstance(100, 200, java.awt.Image.SCALE_SMOOTH));
        URL laURL = cldr.getResource("resources/images/bigCitiesCards/LosAngeles.jpg"); //image
        Image laimage = new ImageIcon(laURL).getImage();
        Image lagray = grayImage(laimage.getScaledInstance(100, 200, java.awt.Image.SCALE_SMOOTH));
        URL miamiURL = cldr.getResource("resources/images/bigCitiesCards/Miami.jpg"); //image
        Image miamiimage = new ImageIcon(miamiURL).getImage();
        Image miamigray = grayImage(miamiimage.getScaledInstance(100, 200, java.awt.Image.SCALE_SMOOTH));
        URL newyorkURL = cldr.getResource("resources/images/bigCitiesCards/NewYork.jpg"); //image
        Image newyorkimage = new ImageIcon(newyorkURL).getImage();
        Image newyorkgray = grayImage(newyorkimage.getScaledInstance(100, 200, java.awt.Image.SCALE_SMOOTH));
        URL seattleURL = cldr.getResource("resources/images/bigCitiesCards/Seattle.jpg"); //image
        Image seattleimage = new ImageIcon(seattleURL).getImage();
        Image seattlegray = grayImage(seattleimage.getScaledInstance(100, 200, java.awt.Image.SCALE_SMOOTH));
        chicago1 = new JLabel();
        chicago1.setIcon(new ImageIcon(chicagogray));
        chicago1.setBounds(0, 0, 100, 200);
        bc1pane.add(chicago1);
        dallas1 = new JLabel();
        dallas1.setIcon(new ImageIcon(dallasgray));
        dallas1.setBounds(101, 0, 100, 200);
        bc1pane.add(dallas1);
        losangeles1 = new JLabel();
        losangeles1.setIcon(new ImageIcon(lagray));
        losangeles1.setBounds(202, 0, 100, 200);
        bc1pane.add(losangeles1);
        miami1 = new JLabel();
        miami1.setIcon(new ImageIcon(miamigray));
        miami1.setBounds(303, 0, 100, 200);
        bc1pane.add(miami1);
        newyork1 = new JLabel();
        newyork1.setIcon(new ImageIcon(newyorkgray));
        newyork1.setBounds(404, 0, 100, 200);
        bc1pane.add(newyork1);
        seattle1 = new JLabel();
        seattle1.setIcon(new ImageIcon(seattlegray));
        seattle1.setBounds(505, 0, 100, 200);
        bc1pane.add(seattle1);
        chicago2 = new JLabel();
        chicago2.setIcon(new ImageIcon(chicagogray));
        chicago2.setBounds(0, 0, 100, 200);
        bc2pane.add(chicago2);
        dallas2 = new JLabel();
        dallas2.setIcon(new ImageIcon(dallasgray));
        dallas2.setBounds(101, 0, 100, 200);
        bc2pane.add(dallas2);
        losangeles2 = new JLabel();
        losangeles2.setIcon(new ImageIcon(lagray));
        losangeles2.setBounds(202, 0, 100, 200);
        bc2pane.add(losangeles2);
        miami2 = new JLabel();
        miami2.setIcon(new ImageIcon(miamigray));
        miami2.setBounds(303, 0, 100, 200);
        bc2pane.add(miami2);
        newyork2 = new JLabel();
        newyork2.setIcon(new ImageIcon(newyorkgray));
        newyork2.setBounds(404, 0, 100, 200);
        bc2pane.add(newyork2);
        seattle2 = new JLabel();
        seattle2.setIcon(new ImageIcon(seattlegray));
        seattle2.setBounds(505, 0, 100, 200);
        bc2pane.add(seattle2);
        
    }
    /**
     * Transformer.
     * Postcondition.Initializes the gui and some componenents of the
     * game
     */
    public void initComponents(){
        
        p1pane = new JLayeredPane();
        p1pane.setBounds(0, 0, 1190, 255);
        p1pane.setBackground(Color.WHITE);
        p1pane.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        p1pane.setOpaque(true);
        this.add(p1pane);
        
        p1THand = new JLayeredPane();
        p1THand.setBounds(5, 5, 580, 111);
        p1THand.setBackground(Color.WHITE);
        p1THand.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        p1THand.setOpaque(true);
        p1pane.add(p1THand);
        
        
        p1RailYard = new JLayeredPane();
        p1RailYard.setBounds(5, 121, 580, 131);
        p1RailYard.setBackground(Color.WHITE);
        p1RailYard.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        p1RailYard.setOpaque(true);
        p1pane.add(p1RailYard);
        
                 
        p1DSTHand = new JLayeredPane();
        p1DSTHand.setBounds(590, 5, 400, 111);
        p1DSTHand.setBackground(Color.WHITE);
        p1DSTHand.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        p1DSTHand.setOpaque(true);
        p1pane.add(p1DSTHand);
        
        p1OnTheTrack = new JLayeredPane();
        p1OnTheTrack.setBounds(590, 121, 300, 131);
        p1OnTheTrack.setBackground(Color.WHITE);
        p1OnTheTrack.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        p1OnTheTrack.setOpaque(true);
        p1pane.add(p1OnTheTrack);       
        
        p1Scoreboard = new JLayeredPane();
        p1Scoreboard.setBounds(1000,5, 170, 246);
        p1Scoreboard.setBackground(Color.WHITE);
        p1Scoreboard.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        p1Scoreboard.setOpaque(true);
        JLabel p1s = new JLabel();
        p1s.setText("Player1 Scoreboard");
        p1s.setBounds(5,5,250,15);
        p1Scoreboard.add(p1s);
        p1pane.add(p1Scoreboard);
        
        p2pane = new JLayeredPane();
        p2pane.setBounds(0, 415, 1190, 255);
        p2pane.setBackground(Color.WHITE);
        p2pane.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        p2pane.setOpaque(true);
        this.add(p2pane);
        
        p2THand = new JLayeredPane();
        p2THand.setBounds(5, 5, 580, 111);
        p2THand.setBackground(Color.WHITE);
        p2THand.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        p2THand.setOpaque(true);
        p2pane.add(p2THand);
        
        
        p2RailYard = new JLayeredPane();
        p2RailYard.setBounds(5, 121, 580, 131);
        p2RailYard.setBackground(Color.WHITE);
        p2RailYard.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        p2RailYard.setOpaque(true);
        p2pane.add(p2RailYard);
        
                 
        p2DSTHand = new JLayeredPane();
        p2DSTHand.setBounds(590, 5, 400, 111);
        p2DSTHand.setBackground(Color.WHITE);
        p2DSTHand.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        p2DSTHand.setOpaque(true);
        p2pane.add(p2DSTHand);
        
        p2OnTheTrack = new JLayeredPane();
        p2OnTheTrack.setBounds(590, 121, 300, 131);
        p2OnTheTrack.setBackground(Color.WHITE);
        p2OnTheTrack.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        p2OnTheTrack.setOpaque(true);
        p2pane.add(p2OnTheTrack);       
        
        p2Scoreboard = new JLayeredPane();
        p2Scoreboard.setBounds(1000,5, 170, 246);
        p2Scoreboard.setBackground(Color.WHITE);
        p2Scoreboard.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        p2Scoreboard.setOpaque(true);
        JLabel p2s = new JLabel();
        p2s.setText("Player2 Scoreboard");
        p2s.setBounds(5,5,250,15);
        p2Scoreboard.add(p2s);
        p2pane.add(p2Scoreboard);
        
        URL imageURL = cldr.getResource("resources/images/background.jpg"); //image
        Image image = new ImageIcon(imageURL).getImage();
        mainpanel = new JExtension(image);
        mainpanel.setBounds(0,260,1296,160);
        this.add(mainpanel);
        
        dst1window = new JFrame();
        dst1window.setTitle("P1:Cards You Bought");
        dst1window.setBounds(600,5,1100, 200);
        dst1window.setVisible(false);
        dst1window.setResizable(false);
        dst1pane = new JLayeredPane();
        dst1pane.setBounds(0, 0, 1100, 200);
        dst1pane.setBackground(Color.white);
        dst1pane.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        dst1pane.setOpaque(true);
        dst1window.add(dst1pane);
        
        dst2window = new JFrame();
        dst2window.setTitle("P2:Cards You Bought");
        dst2window.setBounds(600,5,1100, 200);
        dst2window.setVisible(false);
        dst2window.setResizable(false);
        dst2pane = new JLayeredPane();
        dst2pane.setBounds(0, 0, 1100, 200);
        dst2pane.setBackground(Color.white);
        dst2pane.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        dst2pane.setOpaque(true);
        dst2window.add(dst2pane);
        
        bc1window = new JFrame();
        bc1window.setTitle("P1:Big Cities Cards");
        bc1window.setBounds(600,5,605, 200);
        bc1window.setVisible(false);
        bc1window.setResizable(false);
        bc1pane = new JLayeredPane();
        bc1pane.setBounds(0, 0, 605, 200);
        bc1pane.setBackground(Color.white);
        bc1pane.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        bc1pane.setOpaque(true);
        bc1window.add(bc1pane);
        
        bc2window = new JFrame();
        bc2window.setTitle("P1:Big Cities Cards");
        bc2window.setBounds(600,5,605, 200);
        bc2window.setVisible(false);
        bc2window.setResizable(false);
        bc2pane = new JLayeredPane();
        bc2pane.setBounds(0, 0, 605, 200);
        bc2pane.setBackground(Color.white);
        bc2pane.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        bc2pane.setOpaque(true);
        bc2window.add(bc2pane);
        
        
    }
    
    /**
     *  Transformer.
     * Postcondition:Sets some buttons and labels for an new game
     */
    public void initButtons(){
        playCard1 = new JButton();
        playCard1.setBounds(478, 85, 78, 20);
        playCard1.setText("Play Cards");
        playCard1.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 10));
        p1THand.add(playCard1);
        
        MVonTheTrack1 = new JButton();
        MVonTheTrack1.setBounds(456, 105, 110, 20);
        MVonTheTrack1.setText("Move On-the-track");
        MVonTheTrack1.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 10));
        p1RailYard.add(MVonTheTrack1);
        
        MyDst1 = new JButton();
        MyDst1.setBounds(5, 130, 160, 40);
        MyDst1.setText("My Destination Tickets");
        MyDst1.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 12));
        p1Scoreboard.add(MyDst1);
        
        MyBC1 = new JButton();
        MyBC1.setBounds(5, 180, 160, 60);
        MyBC1.setText("My Big Cities Bonus Cards");
        MyBC1.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 10));
        p1Scoreboard.add(MyBC1);
        
        score1 = new JLabel();
        score1.setText("Player1 Score: ");
        score1.setBounds(5,25,285,20);
        p1Scoreboard.add(score1);
        
        red1 = new JLabel();
        red1.setBounds(7,20, 65, 25);
        URL urlred = cldr.getResource("resources/images/RtrainCards/red.jpg");
        Image imagered = new ImageIcon(urlred).getImage();
        imagered = imagered.getScaledInstance(65, 25,java.awt.Image.SCALE_SMOOTH);
        red1.setIcon(new ImageIcon(imagered));
        p1OnTheTrack.add(red1);
        
        red1info = new JLabel();
        red1info.setBounds(7,-2, 65, 25);
        red1info.setText("red : 0");
        p1OnTheTrack.add(red1info);

        black1 = new JLabel();
        black1.setBounds(80,20, 65, 25);
        URL urlblack = cldr.getResource("resources/images/RtrainCards/black.jpg");
        Image imageblack = new ImageIcon(urlblack).getImage();
        imageblack = imageblack.getScaledInstance(65, 25,java.awt.Image.SCALE_SMOOTH);
        black1.setIcon(new ImageIcon(imageblack));
        p1OnTheTrack.add(black1);
        
        black1info = new JLabel();
        black1info.setBounds(80,-2, 65, 25);
        black1info.setText("black : 0");
        p1OnTheTrack.add(black1info);
        
        blue1 = new JLabel();
        blue1.setBounds(153,20,65, 25);
        URL urlblue = cldr.getResource("resources/images/RtrainCards/blue.jpg");
        Image imageblue = new ImageIcon(urlblue).getImage();
        imageblue = imageblue.getScaledInstance(65, 25,java.awt.Image.SCALE_SMOOTH);
        blue1.setIcon(new ImageIcon(imageblue));
        p1OnTheTrack.add(blue1);
        
        blue1info = new JLabel();
        blue1info.setBounds(153,-2, 65, 25);
        blue1info.setText("blue : 0");
        p1OnTheTrack.add(blue1info);
        
        green1 = new JLabel();
        green1.setBounds(225,20, 65, 25);
        URL urlgreen = cldr.getResource("resources/images/RtrainCards/green.jpg");
        Image imagegreen = new ImageIcon(urlgreen).getImage();
        imagegreen = imagegreen.getScaledInstance(65, 25,java.awt.Image.SCALE_SMOOTH);
        green1.setIcon(new ImageIcon(imagegreen));
        p1OnTheTrack.add(green1);
        
        green1info = new JLabel();
        green1info.setBounds(225,-2, 65, 25);
        green1info.setText("green : 0");
        p1OnTheTrack.add(green1info);
        
        purple1 = new JLabel();
        purple1.setBounds(7,65, 65, 25);
        URL urlpurple = cldr.getResource("resources/images/RtrainCards/purple.jpg");
        Image imagepurple = new ImageIcon(urlpurple).getImage();
        imagepurple = imagepurple.getScaledInstance(65, 25,java.awt.Image.SCALE_SMOOTH);
        purple1.setIcon(new ImageIcon(imagepurple));
        p1OnTheTrack.add(purple1);
        
        purple1info = new JLabel();
        purple1info.setBounds(7,43, 65, 25);
        purple1info.setText("purple : 0");
        p1OnTheTrack.add(purple1info);
        
        white1 = new JLabel();
        white1.setBounds(80,65, 65, 25);
        URL urlwhite = cldr.getResource("resources/images/RtrainCards/white.jpg");
        Image imagewhite = new ImageIcon(urlwhite).getImage();
        imagewhite = imagewhite.getScaledInstance(65, 25,java.awt.Image.SCALE_SMOOTH);
        white1.setIcon(new ImageIcon(imagewhite));
        p1OnTheTrack.add(white1);
        
        white1info = new JLabel();
        white1info.setBounds(80,43, 65, 25);
        white1info.setText("white : 0");
        p1OnTheTrack.add(white1info);
        
        yellow1 = new JLabel();
        yellow1.setBounds(153,65,65, 25);
        URL urlyellow = cldr.getResource("resources/images/RtrainCards/yellow.jpg");
        Image imageyellow = new ImageIcon(urlyellow).getImage();
        imageyellow = imageyellow.getScaledInstance(65, 25,java.awt.Image.SCALE_SMOOTH);
        yellow1.setIcon(new ImageIcon(imageyellow));
        p1OnTheTrack.add(yellow1);
        
        yellow1info = new JLabel();
        yellow1info.setBounds(153,43, 65, 25);
        yellow1info.setText("yellow : 0");
        p1OnTheTrack.add(yellow1info);
        
        orange1= new JLabel();
        orange1.setBounds(225,65, 65, 25);
        URL urlorange = cldr.getResource("resources/images/RtrainCards/orange.jpg");
        Image imageorange = new ImageIcon(urlorange).getImage();
        imageorange = imageorange.getScaledInstance(65,25,java.awt.Image.SCALE_SMOOTH);
        orange1.setIcon(new ImageIcon(imageorange));
        p1OnTheTrack.add(orange1);
        
        orange1info = new JLabel();
        orange1info.setBounds(225,43, 65, 25);
        orange1info.setText("orange : 0");
        p1OnTheTrack.add(orange1info);
        
        loco1 = new JLabel();
        loco1.setBounds(225,102, 65, 25);
        URL urlloco = cldr.getResource("resources/images/RtrainCards/locomotive.jpg");
        Image imageloco = new ImageIcon(urlloco).getImage();
        imageloco = imageloco.getScaledInstance(65, 25,java.awt.Image.SCALE_SMOOTH);
        loco1.setIcon(new ImageIcon(imageloco));
        p1OnTheTrack.add(loco1);
        
        loco1info = new JLabel();
        loco1info.setBounds(130,105,90, 25);
        loco1info.setText("locomotive : 0");
        p1OnTheTrack.add(loco1info);
        
        
 
//-------------------------------------p2 buttons and labels-----------------------------------------------
        playCard2 = new JButton();
        playCard2.setBounds(478, 85, 78, 20);
        playCard2.setText("Play Cards");
        playCard2.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 10));
        p2THand.add(playCard2);
        
        MVonTheTrack2 = new JButton();
        MVonTheTrack2.setBounds(456, 105, 110, 20);
        MVonTheTrack2.setText("Move On-the-track");
        MVonTheTrack2.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 10));
        p2RailYard.add(MVonTheTrack2);
        
        MyDst2 = new JButton();
        MyDst2.setBounds(5, 130, 160, 40);
        MyDst2.setText("My Destination Tickets");
        MyDst2.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 12));
        p2Scoreboard.add(MyDst2);
        
        MyBC2 = new JButton();
        MyBC2.setBounds(5, 180, 160, 60);
        MyBC2.setText("My Big Cities Bonus Cards");
        MyBC2.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 10));
        p2Scoreboard.add(MyBC2);
        
        score2 = new JLabel();
        score2.setText("Player2 Score: ");
        score2.setBounds(5,25,285,20);
        p2Scoreboard.add(score2);
        
        red2 = new JLabel();
        red2.setBounds(7,20, 65, 25);
        red2.setIcon(new ImageIcon(imagered));
        p2OnTheTrack.add(red2);
        
        red2info = new JLabel();
        red2info.setBounds(7,-2, 65, 25);
        red2info.setText("red : 0");
        p2OnTheTrack.add(red2info);

        black2 = new JLabel();
        black2.setBounds(80,20, 65, 25);
        black2.setIcon(new ImageIcon(imageblack));
        p2OnTheTrack.add(black2);
        
        black2info = new JLabel();
        black2info.setBounds(80,-2, 65, 25);
        black2info.setText("black : 0");
        p2OnTheTrack.add(black2info);
        
        blue2 = new JLabel();
        blue2.setBounds(153,20,65, 25);
        blue2.setIcon(new ImageIcon(imageblue));
        p2OnTheTrack.add(blue2);
        
        blue2info = new JLabel();
        blue2info.setBounds(153,-2, 65, 25);
        blue2info.setText("blue : 0");
        p2OnTheTrack.add(blue2info);
        
        green2 = new JLabel();
        green2.setBounds(225,20, 65, 25);
        green2.setIcon(new ImageIcon(imagegreen));
        p2OnTheTrack.add(green2);
        
        green2info = new JLabel();
        green2info.setBounds(225,-2, 65, 25);
        green2info.setText("green : 0");
        p2OnTheTrack.add(green2info);
        
        purple2 = new JLabel();
        purple2.setBounds(7,65, 65, 25);
        purple2.setIcon(new ImageIcon(imagepurple));
        p2OnTheTrack.add(purple2);
        
        purple2info = new JLabel();
        purple2info.setBounds(7,43, 65, 25);
        purple2info.setText("purple : 0");
        p2OnTheTrack.add(purple2info);
        
        white2 = new JLabel();
        white2.setBounds(80,65, 65, 25);
        white2.setIcon(new ImageIcon(imagewhite));
        p2OnTheTrack.add(white2);
        
        white2info = new JLabel();
        white2info.setBounds(80,43, 65, 25);
        white2info.setText("white : 0");
        p2OnTheTrack.add(white2info);
        
        yellow2 = new JLabel();
        yellow2.setBounds(153,65,65, 25);
        yellow2.setIcon(new ImageIcon(imageyellow));
        p2OnTheTrack.add(yellow2);
        
        yellow2info = new JLabel();
        yellow2info.setBounds(153,43, 65, 25);
        yellow2info.setText("yellow : 0");
        p2OnTheTrack.add(yellow2info);
        
        orange2= new JLabel();
        orange2.setBounds(225,65, 65, 25);
        orange2.setIcon(new ImageIcon(imageorange));
        p2OnTheTrack.add(orange2);
        
        orange2info = new JLabel();
        orange2info.setBounds(225,43, 65, 25);
        orange2info.setText("orange : 0");
        p2OnTheTrack.add(orange2info);
        
        loco2 = new JLabel();
        loco2.setBounds(225,102, 65, 25);
        loco2.setIcon(new ImageIcon(imageloco));
        p2OnTheTrack.add(loco2);
        
        loco2info = new JLabel();
        loco2info.setBounds(130,105,90, 25);
        loco2info.setText("locomotive : 0");
        p2OnTheTrack.add(loco2info);
        
//-------------------------Deck buttons and labels---------------------------------------------------
        tDeck = new JButton();
        tDeck.setBounds(5,260,70,100);
        URL urtDeck = cldr.getResource("resources/images/trainCards/trainBackCard.jpg");
        Image imagetDeck = new ImageIcon(urtDeck).getImage();
        imagetDeck = imagetDeck.getScaledInstance(70, 100,java.awt.Image.SCALE_SMOOTH);
        tDeck.setIcon(new ImageIcon(imagetDeck));
        mainpanel.add(tDeck);
        
        TcardCollection = new JLabel();
        TcardCollection.setBounds(5,365,100,10);
        TcardCollection.setText("Train Deck : ");
        mainpanel.add(TcardCollection);
        
        DstCardCollection = new JLabel();
        DstCardCollection.setBounds(110,365,120,10);
        DstCardCollection.setText("Destination Deck : ");
        mainpanel.add(DstCardCollection);
        
        turn = new JLabel();
        turn.setBounds(5, 385 , 150 , 10);
        turn.setText("Turn : ");
        mainpanel.add(turn);

        
        dstDeck = new JButton();
        dstDeck.setBounds(120,260,70,100);
        URL urdstDeck = cldr.getResource("resources/images/destination_Tickets/desBackCard.jpg");
        Image imagedstDeck = new ImageIcon(urdstDeck).getImage();
        imagedstDeck = imagedstDeck.getScaledInstance(70, 100,java.awt.Image.SCALE_SMOOTH);
        dstDeck.setIcon(new ImageIcon(imagedstDeck));
        mainpanel.add(dstDeck);

//-----------------------------------Deck Bc Labels-------------------------------------------------
        URL chicagoURL = cldr.getResource("resources/images/bigCitiesCards/Chicago.jpg"); //image
        Image chicagoimage = new ImageIcon(chicagoURL).getImage();
        chicagoimage = chicagoimage.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH);
        URL dallasURL = cldr.getResource("resources/images/bigCitiesCards/Dallas.jpg"); //image
        Image dallasimage = new ImageIcon(dallasURL).getImage();
        dallasimage = dallasimage.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH);
        URL laURL = cldr.getResource("resources/images/bigCitiesCards/LosAngeles.jpg"); //image
        Image laimage = new ImageIcon(laURL).getImage();
        laimage = laimage.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH);
        URL miamiURL = cldr.getResource("resources/images/bigCitiesCards/Miami.jpg"); //image
        Image miamiimage = new ImageIcon(miamiURL).getImage();
        miamiimage = miamiimage.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH);
        URL newyorkURL = cldr.getResource("resources/images/bigCitiesCards/NewYork.jpg"); //image
        Image newyorkimage = new ImageIcon(newyorkURL).getImage();
        newyorkimage = newyorkimage.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH);
        URL seattleURL = cldr.getResource("resources/images/bigCitiesCards/Seattle.jpg"); //image
        Image seattleimage = new ImageIcon(seattleURL).getImage();
        seattleimage = seattleimage.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH);
        
        chicago = new JLabel();
        chicago.setIcon(new ImageIcon(chicagoimage));
        chicago.setBounds(740, 260, 70, 100);
        chicago1info = new JLabel();
        chicago1info.setText("P1 Visits : 0");
        chicago1info.setBounds(740, 365, 70, 10);
        mainpanel.add(chicago1info);
        chicago2info = new JLabel();
        chicago2info.setText("P2 Visits : 0");
        chicago2info.setBounds(740, 385, 70, 10);
        mainpanel.add(chicago2info);
        mainpanel.add(chicago);
        dallas = new JLabel();
        dallas.setIcon(new ImageIcon(dallasimage));
        dallas.setBounds(810, 260, 70, 100);
        dallas1info = new JLabel();
        dallas1info.setText("P1 Visits : 0");
        dallas1info.setBounds(810, 365, 70, 10);
        mainpanel.add(dallas1info);
        dallas2info = new JLabel();
        dallas2info.setText("P2 Visits : 0");
        dallas2info.setBounds(810, 385, 70, 10);
        mainpanel.add(dallas2info);
        mainpanel.add(dallas);
        losangeles = new JLabel();
        losangeles.setIcon(new ImageIcon(laimage));
        losangeles.setBounds(880, 260, 70, 100);
        losangeles1info = new JLabel();
        losangeles1info.setText("P1 Visits : 0");
        losangeles1info.setBounds(880, 365, 70, 10);
        mainpanel.add(losangeles1info);
        losangeles2info = new JLabel();
        losangeles2info.setText("P2 Visits : 0");
        losangeles2info.setBounds(880, 385, 70, 10);
        mainpanel.add(losangeles2info);
        mainpanel.add(losangeles);
        miami = new JLabel();
        miami.setIcon(new ImageIcon(miamiimage));
        miami.setBounds(950, 260, 70, 100);
        miami1info = new JLabel();
        miami1info.setText("P1 Visits : 0");
        miami1info.setBounds(950, 365, 70, 10);
        mainpanel.add(miami1info);
        miami2info = new JLabel();
        miami2info.setText("P2 Visits : 0");
        miami2info.setBounds(950, 385, 70, 10);
        mainpanel.add(miami2info);
        mainpanel.add(miami);
        newyork = new JLabel();
        newyork.setIcon(new ImageIcon(newyorkimage));
        newyork.setBounds(1020, 260, 70, 100);
        newyork1info = new JLabel();
        newyork1info.setText("P1 Visits : 0");
        newyork1info.setBounds(1020, 365, 70, 10);
        mainpanel.add(newyork1info);
        newyork2info = new JLabel();
        newyork2info.setText("P2 Visits : 0");
        newyork2info.setBounds(1020, 385, 70, 10);
        mainpanel.add(newyork2info);
        mainpanel.add(newyork);
        seattle = new JLabel();
        seattle.setIcon(new ImageIcon(seattleimage));
        seattle.setBounds(1090, 260, 70, 100);
        seattle1info = new JLabel();
        seattle1info.setText("P1 Visits : 0");
        seattle1info.setBounds(1090, 365, 70, 10);
        mainpanel.add(seattle1info);
        seattle2info = new JLabel();
        seattle2info.setText("P2 Visits : 0");
        seattle2info.setBounds(1090, 385, 70, 10);
        mainpanel.add(seattle2info);
        mainpanel.add(seattle);
        
    }
    
    /**
     * Transformer.
     * Postcondition:initializes all starting cards
     * @param cards1
     * @param cards2
     * @param deck
     * @param dst1
     * @param dst2
     */
    public void initCards(ArrayList<TrainCard> cards1,ArrayList<TrainCard> cards2,ArrayList<TrainCard> deck,ArrayList<DestinationCard> dst1,ArrayList<DestinationCard> dst2){
        for(int i=0; i<8; i++){
            JButton p1Card = new JButton();
            p1Card.setName(Integer.toString(i));
            p1Card.setBounds(10 + i * 35, 10, 55, 75);
            URL ur = cldr.getResource(cards1.get(i).getImage());
            Image image2 = new ImageIcon(ur).getImage();
            image2 = image2.getScaledInstance(55, 75, java.awt.Image.SCALE_SMOOTH);
            p1Card.setIcon(new ImageIcon(image2));
            Cards1.add(i, p1Card);
            p1THand.add(Cards1.get(i));
        }
        
        for(int i=0; i<8; i++){
            JButton p2Card = new JButton();
            p2Card.setName(Integer.toString(i));
            p2Card.setBounds(10 + i * 35, 10, 55, 75);
            URL ur = cldr.getResource(cards2.get(i).getImage());
            Image image2 = new ImageIcon(ur).getImage();
            image2 = image2.getScaledInstance(55, 75, java.awt.Image.SCALE_SMOOTH);
            p2Card.setIcon(new ImageIcon(image2));
            Cards2.add(i, p2Card);
            p2THand.add(Cards2.get(i));
        }
        
        for(int i=0; i<5; i++){
            JButton dCard = new JButton();
            dCard.setName(Integer.toString(i));
            dCard.setBounds(300 + i * 75, 260, 70, 100);
            URL ur = cldr.getResource(deck.get(i).getImage());
            Image image2 = new ImageIcon(ur).getImage();
            image2 = image2.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH);
            dCard.setIcon(new ImageIcon(image2));
            MainPanelTcards.add(i,dCard);
            mainpanel.add(MainPanelTcards.get(i));
        }
        
        for(int i=0; i<=dst1.size()-1; i++){
            JButton dst1Card = new JButton();
            dst1Card.setName(Integer.toString(i));
            dst1Card.setBounds(1 + i * 35, 1, 85, 108);
            URL ur = cldr.getResource(dst1.get(i).getImage());
            Image image2 = new ImageIcon(ur).getImage();
            image2 = image2.getScaledInstance(85, 108, java.awt.Image.SCALE_SMOOTH);
            dst1Card.setIcon(new ImageIcon(image2));
            dstCards1.add(i, dst1Card);
            p1DSTHand.add(dstCards1.get(i));
        }
        
        for(int i=0; i<=dst2.size()-1; i++){
            JButton dst2Card = new JButton();
            dst2Card.setName(Integer.toString(i));
            dst2Card.setBounds(1 + i * 35, 1, 85, 108);
            URL ur = cldr.getResource(dst2.get(i).getImage());
            Image image2 = new ImageIcon(ur).getImage();
            image2 = image2.getScaledInstance(85, 108, java.awt.Image.SCALE_SMOOTH);
            dst2Card.setIcon(new ImageIcon(image2));
            dstCards2.add(i, dst2Card);
            p2DSTHand.add(dstCards2.get(i));
        }
        
        for(int i=0; i<43; i++){
            JButton dstCard = new JButton();
            dstCardsCollection.add(dstCard);
        }
    }
    
    /**
     * Transformer.
     * PostCondition:Updates trainCards on player hands on screen
     * @param cards
     * @param player
     */
    public void UpdatePlayerTrainCards(ArrayList<TrainCard> cards,Player player){
        if(player.getID()==1){
            for(int i=0; i<Cards1.size(); i++){
                p1THand.remove(Cards1.get(i));
            }
            Cards1.clear();
            this.repaint();
            for(int i=0; i<player.getTcard().size(); i++){
                JButton p1Card = new JButton();
                p1Card.setName(Integer.toString(i));
                p1Card.setBounds(10 + i * 35, 10, 55, 75);
                URL ur = cldr.getResource(cards.get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(55, 75, java.awt.Image.SCALE_SMOOTH);
                p1Card.setIcon(new ImageIcon(image2));
                Cards1.add(i, p1Card);
                p1THand.add(Cards1.get(i));
            }
        }
        
        if(player.getID()==2){
            for(int i=0; i<Cards2.size(); i++){
                p2THand.remove(Cards2.get(i));
            }
            Cards2.clear();
            this.repaint();
            for(int i=0; i<player.getTcard().size(); i++){
                JButton p2Card = new JButton();
                p2Card.setName(Integer.toString(i));
                p2Card.setBounds(10 + i * 35, 10, 55, 75);
                URL ur = cldr.getResource(cards.get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(55, 75, java.awt.Image.SCALE_SMOOTH);
                p2Card.setIcon(new ImageIcon(image2));
                Cards2.add(i, p2Card);
                p2THand.add(Cards2.get(i));
            }
        }
    }
    
    /**
     *  Transformer
     * Postcondition:updates dst card of player on screen
     * @param cards
     * @param player
     */
    public void updateDestinationCards(ArrayList<DestinationCard> cards,Player player){
        if(player.getID()==1){
            for(int i=0; i<dstCards1.size(); i++){
                p1DSTHand.remove(dstCards1.get(i));
            }
            dstCards1.clear();
            this.repaint();
            for(int i=0; i<=cards.size()-1; i++){
            JButton dst1Card = new JButton();
            dst1Card.setName(Integer.toString(i));
            dst1Card.setBounds(1 + i * 35, 1, 85, 108);
            URL ur = cldr.getResource(cards.get(i).getImage());
            Image image2 = new ImageIcon(ur).getImage();
            image2 = image2.getScaledInstance(85, 108, java.awt.Image.SCALE_SMOOTH);
            dst1Card.setIcon(new ImageIcon(image2));
            dstCards1.add(i, dst1Card);
            p1DSTHand.add(dstCards1.get(i));
            }
            
        }
        if(player.getID()==2){
            for(int i=0; i<dstCards2.size(); i++){
                p2DSTHand.remove(dstCards2.get(i));
            }
            dstCards2.clear();
            this.repaint();
            for(int i=0; i<=cards.size()-1; i++){
            JButton dst2Card = new JButton();
            dst2Card.setName(Integer.toString(i));
            dst2Card.setBounds(1 + i * 35, 1, 85, 108);
            URL ur = cldr.getResource(cards.get(i).getImage());
            Image image2 = new ImageIcon(ur).getImage();
            image2 = image2.getScaledInstance(85, 108, java.awt.Image.SCALE_SMOOTH);
            dst2Card.setIcon(new ImageIcon(image2));
            dstCards2.add(i, dst2Card);
            p2DSTHand.add(dstCards2.get(i));
        }
        }
    }
    public void updateTdeck(ArrayList<TrainCard> deck){
        for(int i=0; i<5; i++){
            mainpanel.remove(MainPanelTcards.get(i));
        }
        MainPanelTcards.clear();
        this.repaint();
        for(int i=0; i<5; i++){
            JButton dCard = new JButton();
            dCard.setName(Integer.toString(i));
            dCard.setBounds(300 + i * 75, 260, 70, 100);
            URL ur = cldr.getResource(deck.get(i).getImage());
            Image image2 = new ImageIcon(ur).getImage();
            image2 = image2.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH);
            dCard.setIcon(new ImageIcon(image2));
            MainPanelTcards.add(i,dCard);
            mainpanel.add(MainPanelTcards.get(i));
        }
    }
    
    /**
     *  Transformer
     * Postcondition:updates the railyardof the player on the screen
     * @param railyard
     * @param player
     */
    public void updateRailYard(RailYard railyard,Player player){
        if(player.getID()==1){
            for(int i=0; i< RailBlue1.size(); i++){
                p1RailYard.remove(RailBlue1.get(i));
            }
            RailBlue1.clear();
            
            for(int i=0; i<railyard.getBlue().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(5,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getBlue().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailBlue1.add(i, rCard);
                p1RailYard.add(RailBlue1.get(i));
            }
            for(int i=0; i< RailBlack1.size(); i++){
                p1RailYard.remove(RailBlack1.get(i));
            }
            RailBlack1.clear();
            
            for(int i=0; i<railyard.getBlack().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(70,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getBlack().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailBlack1.add(i, rCard);
                p1RailYard.add(RailBlack1.get(i));
            }
        
            for(int i=0; i< RailRed1.size(); i++){
                p1RailYard.remove(RailRed1.get(i));
            }
            RailRed1.clear();
            for(int i=0; i<railyard.getRed().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(140,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getRed().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailRed1.add(i, rCard);
                p1RailYard.add(RailRed1.get(i));
            }
            for(int i=0; i< RailYellow1.size(); i++){
                p1RailYard.remove(RailYellow1.get(i));
            }
            RailYellow1.clear();
            for(int i=0; i<railyard.getYellow().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(210,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getYellow().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailYellow1.add(i, rCard);
                p1RailYard.add(RailYellow1.get(i));
            }
        
            for(int i=0; i< RailOrange1.size(); i++){
                p1RailYard.remove(RailOrange1.get(i));
            }
            RailOrange1.clear();
            for(int i=0; i<railyard.getOrange().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(280,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getOrange().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailOrange1.add(i, rCard);
                p1RailYard.add(RailOrange1.get(i));
            }
            for(int i=0; i< RailGreen1.size(); i++){
                p1RailYard.remove(RailGreen1.get(i));
            }
            RailGreen1.clear();
            for(int i=0; i<railyard.getGreen().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(350,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getGreen().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailGreen1.add(i, rCard);
                p1RailYard.add(RailGreen1.get(i));
            }
        
            for(int i=0; i< RailPurple1.size(); i++){
                p1RailYard.remove(RailPurple1.get(i));
            }
            RailPurple1.clear();
            for(int i=0; i<railyard.getPurple().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(420,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getPurple().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailPurple1.add(i, rCard);
                p1RailYard.add(RailPurple1.get(i));
            }
            for(int i=0; i< RailWhite1.size(); i++){
               p1RailYard.remove(RailWhite1.get(i));
            }
            RailWhite1.clear();
            for(int i=0; i<railyard.getWhite().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(490,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getWhite().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailWhite1.add(i, rCard);
                p1RailYard.add(RailWhite1.get(i));
            }
            
            this.repaint();
        
        }
        if(player.getID()==2){
            for(int i=0; i< RailBlue2.size(); i++){
                p2RailYard.remove(RailBlue2.get(i));
            }
            RailBlue2.clear();
            
            for(int i=0; i<railyard.getBlue().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(5,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getBlue().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailBlue2.add(i, rCard);
                p2RailYard.add(RailBlue2.get(i));
            }
            for(int i=0; i< RailBlack2.size(); i++){
                p2RailYard.remove(RailBlack2.get(i));
            }
            RailBlack2.clear();
            
            for(int i=0; i<railyard.getBlack().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(70,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getBlack().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailBlack2.add(i, rCard);
                p2RailYard.add(RailBlack2.get(i));
            }
        
            for(int i=0; i< RailRed2.size(); i++){
                p2RailYard.remove(RailRed2.get(i));
            }
            RailRed2.clear();
            for(int i=0; i<railyard.getRed().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(140,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getRed().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailRed2.add(i, rCard);
                p2RailYard.add(RailRed2.get(i));
            }
            for(int i=0; i< RailYellow2.size(); i++){
                p2RailYard.remove(RailYellow2.get(i));
            }
            RailYellow2.clear();
            for(int i=0; i<railyard.getYellow().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(210,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getYellow().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailYellow2.add(i, rCard);
                p2RailYard.add(RailYellow2.get(i));
            }
        
            for(int i=0; i< RailOrange2.size(); i++){
                p2RailYard.remove(RailOrange2.get(i));
            }
            RailOrange2.clear();
            for(int i=0; i<railyard.getOrange().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(280,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getOrange().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailOrange2.add(i, rCard);
                p2RailYard.add(RailOrange2.get(i));
            }
            for(int i=0; i< RailGreen2.size(); i++){
                p2RailYard.remove(RailGreen2.get(i));
            }
            RailGreen2.clear();
            for(int i=0; i<railyard.getGreen().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(350,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getGreen().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailGreen2.add(i, rCard);
                p2RailYard.add(RailGreen2.get(i));
            }
        
            for(int i=0; i< RailPurple2.size(); i++){
                p2RailYard.remove(RailPurple2.get(i));
            }
            RailPurple2.clear();
            for(int i=0; i<railyard.getPurple().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(420,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getPurple().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailPurple2.add(i, rCard);
                p2RailYard.add(RailPurple2.get(i));
            }
            for(int i=0; i< RailWhite2.size(); i++){
               p2RailYard.remove(RailWhite2.get(i));
            }
            RailWhite2.clear();
            for(int i=0; i<railyard.getWhite().size(); i++){
                JButton rCard = new JButton();
                rCard.setName(Integer.toString(i));
                rCard.setBounds(490,10+i*15, 40, 60);
                URL ur = cldr.getResource(railyard.getWhite().get(i).getImage());
                Image image2 = new ImageIcon(ur).getImage();
                image2 = image2.getScaledInstance(40,60, java.awt.Image.SCALE_SMOOTH);
                rCard.setIcon(new ImageIcon(image2));
                RailWhite2.add(i, rCard);
                p2RailYard.add(RailWhite2.get(i));
            }
            
            this.repaint();
        }
    }

    /**
     * Transformer:
     * PostConditon:updates info on the screen
     * @param player1
     * @param player2
     * @param turn
     * @param deck
     */
    public void updateInfo(Player player1,Player player2,int turn,Deck deck){
        this.turn.setText("Turn : Player " + turn);
        TcardCollection.setText("Train Deck : " + deck.getTcardCollection().size());
        DstCardCollection.setText("Destination Deck : "+ deck.getdstCardsCollection().size());
        score1.setText("Player1 Score: " + player1.getScore());
        score2.setText("Player2 Score: " + player2.getScore());
        blue1info.setText("blue : " + player1.getPlayerOnTheTrack().getBlue().size());
        black1info.setText("black : " + player1.getPlayerOnTheTrack().getBlack().size());
        red1info.setText("red : " + player1.getPlayerOnTheTrack().getRed().size());
        green1info.setText("green : " + player1.getPlayerOnTheTrack().getGreen().size());
        yellow1info.setText("yellow : " + player1.getPlayerOnTheTrack().getYellow().size());
        orange1info.setText("orange : " + player1.getPlayerOnTheTrack().getOrange().size());
        purple1info.setText("purple : " + player1.getPlayerOnTheTrack().getPurple().size());
        white1info.setText("white : " + player1.getPlayerOnTheTrack().getWhite().size());
        loco1info.setText("locomotive : " + player1.getPlayerOnTheTrack().getLocomotive().size());
        blue2info.setText("blue : " + player2.getPlayerOnTheTrack().getBlue().size());
        black2info.setText("black : " + player2.getPlayerOnTheTrack().getBlack().size());
        red2info.setText("red : " + player2.getPlayerOnTheTrack().getRed().size());
        green2info.setText("green : " + player2.getPlayerOnTheTrack().getGreen().size());
        yellow2info.setText("yellow : " + player2.getPlayerOnTheTrack().getYellow().size());
        orange2info.setText("orange : " + player2.getPlayerOnTheTrack().getOrange().size());
        purple2info.setText("purple : " + player2.getPlayerOnTheTrack().getPurple().size());
        white2info.setText("white : " + player2.getPlayerOnTheTrack().getWhite().size());
        loco2info.setText("locomotive : " + player2.getPlayerOnTheTrack().getLocomotive().size());
        chicago1info.setText("P1 Visits :" + deck.getChicago().getP1visits());
        chicago2info.setText("P2 Visits :" + deck.getChicago().getP2visits());
        dallas1info.setText("P1 Visits :" + deck.getDallas().getP1visits());
        dallas2info.setText("P2 Visits :" + deck.getDallas().getP2visits());
        losangeles1info.setText("P1 Visits :" + deck.getLosAngeles().getP1visits());
        losangeles2info.setText("P2 Visits :" + deck.getLosAngeles().getP2visits());
        miami1info.setText("P1 Visits :" + deck.getMiami().getP1visits());
        miami2info.setText("P2 Visits :" + deck.getMiami().getP2visits());
        newyork1info.setText("P1 Visits :" + deck.getNewYork().getP1visits());
        newyork2info.setText("P2 Visits :" + deck.getNewYork().getP2visits());
        seattle1info.setText("P1 Visits :" + deck.getSeattle().getP1visits());
        seattle2info.setText("P2 Visits :" + deck.getSeattle().getP2visits());
    }
    
    public void updateBoughtDst(ArrayList<DestinationCard> cards,Player player){
            if(player.getID() == 1){
                for(int i=0; i<=cards.size()-1; i++){
                    JButton c = new JButton();
                    c.setName(Integer.toString(i));
                    c.setBounds(1 + i * 55, 1, 120, 180);
                    URL ur = cldr.getResource(cards.get(i).getImage());
                    Image image2 = new ImageIcon(ur).getImage();
                    image2 = image2.getScaledInstance(120, 180, java.awt.Image.SCALE_SMOOTH);
                    c.setIcon(new ImageIcon(image2));
                    p1Bought.add(i,c);
                    dst1pane.add(p1Bought.get(i));
                }
            }
            else if(player.getID() == 2){
                for(int i=0; i<=cards.size()-1; i++){
                    JButton c = new JButton();
                    c.setName(Integer.toString(i));
                    c.setBounds(1 + i * 55, 1, 120, 180);
                    URL ur = cldr.getResource(cards.get(i).getImage());
                    Image image2 = new ImageIcon(ur).getImage();
                    image2 = image2.getScaledInstance(120, 180, java.awt.Image.SCALE_SMOOTH);
                    c.setIcon(new ImageIcon(image2));
                    p2Bought.add(i,c);
                    dst2pane.add(p2Bought.get(i));
                }
            }
            
        }
    public void UpdateBcCards(String city){
        URL chicagoURL = cldr.getResource("resources/images/bigCitiesCards/Chicago.jpg"); //image
        Image chicagoimage = new ImageIcon(chicagoURL).getImage();
        Image chicagogray = grayImage(chicagoimage.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH));
        URL dallasURL = cldr.getResource("resources/images/bigCitiesCards/Dallas.jpg"); //image
        Image dallasimage = new ImageIcon(dallasURL).getImage();
        Image dallasgray = grayImage(dallasimage.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH));
        URL laURL = cldr.getResource("resources/images/bigCitiesCards/LosAngeles.jpg"); //image
        Image laimage = new ImageIcon(laURL).getImage();
        Image lagray = grayImage(laimage.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH));
        URL miamiURL = cldr.getResource("resources/images/bigCitiesCards/Miami.jpg"); //image
        Image miamiimage = new ImageIcon(miamiURL).getImage();
        Image miamigray = grayImage(miamiimage.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH));
        URL newyorkURL = cldr.getResource("resources/images/bigCitiesCards/NewYork.jpg"); //image
        Image newyorkimage = new ImageIcon(newyorkURL).getImage();
        Image newyorkgray = grayImage(newyorkimage.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH));
        URL seattleURL = cldr.getResource("resources/images/bigCitiesCards/Seattle.jpg"); //image
        Image seattleimage = new ImageIcon(seattleURL).getImage();
        Image seattlegray = grayImage(seattleimage.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH));
        switch (city){
            case "Chicago" :
                chicago.setIcon(new ImageIcon(chicagogray));
                break;
            case "Dallas" :
                dallas.setIcon(new ImageIcon(dallasgray));
                break;
            case "Los Angeles" :
                losangeles.setIcon(new ImageIcon(lagray));
                break;
            case "Miami" :
                miami.setIcon(new ImageIcon(miamigray));
                break;
            case "New York":
                newyork.setIcon(new ImageIcon(newyorkgray));
                break;
            
            case "Seattle" :
                seattle.setIcon(new ImageIcon(seattlegray));
                break;
            }
            
            
        }        

    
    
    public void updateBCwindows(String city,Player player){
        URL chicagoURL = cldr.getResource("resources/images/bigCitiesCards/Chicago.jpg"); //image
        Image chicagoimage = new ImageIcon(chicagoURL).getImage();
        chicagoimage = chicagoimage.getScaledInstance(100, 200, java.awt.Image.SCALE_SMOOTH);
        URL dallasURL = cldr.getResource("resources/images/bigCitiesCards/Dallas.jpg"); //image
        Image dallasimage = new ImageIcon(dallasURL).getImage();
        dallasimage = dallasimage.getScaledInstance(100, 200, java.awt.Image.SCALE_SMOOTH);
        URL laURL = cldr.getResource("resources/images/bigCitiesCards/LosAngeles.jpg"); //image
        Image laimage = new ImageIcon(laURL).getImage();
        laimage = laimage.getScaledInstance(100, 200, java.awt.Image.SCALE_SMOOTH);
        URL miamiURL = cldr.getResource("resources/images/bigCitiesCards/Miami.jpg"); //image
        Image miamiimage = new ImageIcon(miamiURL).getImage();
        miamiimage = miamiimage.getScaledInstance(100, 200, java.awt.Image.SCALE_SMOOTH);
        URL newyorkURL = cldr.getResource("resources/images/bigCitiesCards/NewYork.jpg"); //image
        Image newyorkimage = new ImageIcon(newyorkURL).getImage();
        newyorkimage = newyorkimage.getScaledInstance(100, 200, java.awt.Image.SCALE_SMOOTH);
        URL seattleURL = cldr.getResource("resources/images/bigCitiesCards/Seattle.jpg"); //image
        Image seattleimage = new ImageIcon(seattleURL).getImage();
        seattleimage = seattleimage.getScaledInstance(100, 200, java.awt.Image.SCALE_SMOOTH);
        
        switch (city){
            case "Chicago" : if(player.getID()==1){
                chicago1.setIcon(new ImageIcon(chicagoimage));
                bc1window.repaint();
                break;
            } 
            else{
                chicago2.setIcon(new ImageIcon(chicagoimage));
                bc2window.repaint();
                break;
            }
            
            case "Dallas" : if(player.getID()==1){
                dallas1.setIcon(new ImageIcon(dallasimage));
                bc1window.repaint();
                break;
            } 
            else{
                dallas2.setIcon(new ImageIcon(dallasimage));
                bc2window.repaint();
                break;
            }
            
            case "Los Angeles" : if(player.getID()==1){
                losangeles1.setIcon(new ImageIcon(laimage));
                bc1window.repaint();
                break;
            } 
            else{
                losangeles2.setIcon(new ImageIcon(laimage));
                bc2window.repaint();
                break;
            }
            case "Miami" : if(player.getID()==1){
                miami1.setIcon(new ImageIcon(miamiimage));
                bc1window.repaint();
                break;
            } 
            else{
                miami2.setIcon(new ImageIcon(miamiimage));
                bc2window.repaint();
                break;
            }
            case "New York" : if(player.getID()==1){
                newyork1.setIcon(new ImageIcon(newyorkimage));
                bc1window.repaint();
                break;
            } 
            else{
                newyork2.setIcon(new ImageIcon(newyorkimage));
                bc2window.repaint();
                break;
            }
            
            case "Seattle" : if(player.getID()==1){
                seattle1.setIcon(new ImageIcon(seattleimage));
                bc1window.repaint();
                break;
            } 
            else{
                seattle2.setIcon(new ImageIcon(seattleimage));
                bc2window.repaint();
                break;
            }
            
            
        }
    }
    public void toggledst1window() {
        if (dst1window.isShowing()) {
            dst1window.setVisible(false);
        } else {
            dst1window.setVisible(true);
        }
    }
    
    public void toggledst2window() {
        if (dst2window.isShowing()) {
            dst2window.setVisible(false);
        } else {
            dst2window.setVisible(true);
        }
    }
    
    public void togglebc1window() {
        if (bc1window.isShowing()) {
            bc1window.setVisible(false);
        } else {
            bc1window.setVisible(true);
        }
    }
    
    public void togglebc2window() {
        if (bc2window.isShowing()) {
            bc2window.setVisible(false);
        } else {
            bc2window.setVisible(true);
        }
    }
    
    /**Transformer
     * Returns the grayed version of img 
     * @param img
     * @return 
     */
    public Image grayImage(Image img) {
        ImageFilter filter = new GrayFilter(true, 20);
        ImageProducer producer = new FilteredImageSource(img.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(producer);
    }

  /* a class which is used for putting a background image to a jdesktoppane*/  
   public class myDesktopPane extends JDesktopPane{
        private Image backImage = null;
 
        public myDesktopPane(){      
      
        }
 
        @Override
        public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
        }
    } 

}
