import cs1.Keyboard;
import terminalTxt.TerminalTxtProcessing;
import java.util.ArrayList;
import ui.UserInterface;
import helper.*;

public class Woo {
public static int _gold = 0;

public static int _additiveGoldPKP = 1;
public static double _multiGoldPKP = 1.0;
public static int _totalGoldPKP = (int)(_additiveGoldPKP * _multiGoldPKP);

public static int _additiveGoldPS = 0;
public static double _multiGoldPS = 1.0;
public static int _totalGoldPS = (int)(_additiveGoldPS * _multiGoldPS);

public static double _luck = 0.0005;

public static String keyPress;

public static String gameScreen;
public static boolean status = true;
public static boolean tutorialCompleted = false;
public static int inventoryType = 1;
public static boolean inventoryAscend = true;

public static long prevTime;
public static long currTime;

public static DataStorage data = new DataStorage();

public static void main(String[] args) {
        UserInterface.introUI();
        prevTime = System.currentTimeMillis();
        tapMech();

        UserInterface.firstGold();

        gameScreen = "main";

        while(status) {
                if(gameScreen.equals("main")) {
                        if(_gold == 30 && tutorialCompleted == false) {
                                UserInterface.tutorial();
                                tutorialCompleted = true;
                                tapMech();
                        }else if(_gold < 30 && tutorialCompleted == false) {
                                UserInterface.mainUIpreTut(_gold);
                                tapMech();
                        }else{
                                if ( Powerups.finishPowerUps() ) //if there are any powerups, then this will notify the user
                                        UserInterface.mainUIpostTutPow(_gold,_totalGoldPKP,_totalGoldPS);
                                else
                                        UserInterface.mainUIpostTut(_gold,_totalGoldPKP,_totalGoldPS);
                                Events.allLuck(_luck);
                                tapMech();
                        }
                }else if(gameScreen.equals("help")) {
                        UserInterface.helpUI();
                        tapMech();
                }else if(gameScreen.equals("store")) {
                        UserInterface.storeUI(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)));
                        tapMech();
                }else if(gameScreen.equals("inventory")) {
                        if(inventoryType == 1) {
                                System.out.println(UserInterface.inventoryUIM(inventoryType, data.minerList()));
                        }else if(inventoryType == 2) {
                                System.out.println(UserInterface.inventoryUIE(inventoryType, data.engineerList()));
                        }else{
                                System.out.println(UserInterface.inventoryUIG(inventoryType, data.gamblerList()));
                        }
                        tapMech();
                }
        }
}

public static void tapMech(){

        _additiveGoldPKP += data.goldProductionUpdate().get(2);
        _multiGoldPKP += data.goldProductionUpdate().get(3);

        _additiveGoldPS += data.goldProductionUpdate().get(0);
        _multiGoldPS += data.goldProductionUpdate().get(1);

        _luck += data.goldProductionUpdate().get(4);

        _totalGoldPKP = (int)(_additiveGoldPKP * _multiGoldPKP);
        _totalGoldPS = (int)(_additiveGoldPS * _multiGoldPS);
        keyPress = Keyboard.readString();
        if (keyPress.equals(" ")) {
                currTime = System.currentTimeMillis();
                _gold += _totalGoldPKP + (int)((currTime - prevTime) / 1000) * _totalGoldPS;
                prevTime = currTime;
        }else if (keyPress.equals("Q") || keyPress.equals("q")) {
                status = false;
                System.exit(0);
        }else if (keyPress.equals("H") || keyPress.equals("h")) {
                gameScreen = "help";
        }else if (keyPress.equals("R") || keyPress.equals("r")) {
                gameScreen = "main";
        }else if (keyPress.equals("S") || keyPress.equals("s")) {
                gameScreen = "store";
        }else if (keyPress.equals("I") || keyPress.equals("i")) {
                gameScreen = "inventory";

        }else if (keyPress.equals("N") || keyPress.equals("n")) { //name
                data.minerEdit(DataStorage.sortListM(data.minerList(), 0));
                data.engineerEdit(DataStorage.sortListE(data.engineerList(), 0));
                data.gamblerEdit(DataStorage.sortListG(data.gamblerList(), 0));
        }else if (keyPress.equals("V") || keyPress.equals("v")) { //value
                data.minerEdit(DataStorage.sortListM(data.minerList(), 2));
                data.engineerEdit(DataStorage.sortListE(data.engineerList(), 2));
                data.gamblerEdit(DataStorage.sortListG(data.gamblerList(), 2));
        }else if (keyPress.equals("L") || keyPress.equals("l")) { //level
                data.minerEdit(DataStorage.sortListM(data.minerList(), 1));
                data.engineerEdit(DataStorage.sortListE(data.engineerList(), 1));
                data.gamblerEdit(DataStorage.sortListG(data.gamblerList(), 1));
        }else if (keyPress.equals("U") || keyPress.equals("u")) { //upgrade tier
                data.minerEdit(DataStorage.sortListM(data.minerList(), 3));
                data.engineerEdit(DataStorage.sortListE(data.engineerList(), 3));
                data.gamblerEdit(DataStorage.sortListG(data.gamblerList(), 3));


        }else if (keyPress.equals("E") || keyPress.equals("e")) { //display engineers
                inventoryType = 2;
        }else if (keyPress.equals("M") || keyPress.equals("m")) { //display miners
                inventoryType = 1;
        }else if (keyPress.equals("G") || keyPress.equals("g")) { //display gamblers
                inventoryType = 3;
        }else if (keyPress.equals("1")) {
                if(data.firstUnboughtCost(1) > _gold) {
                        UserInterface.noGold(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)));
                        tapMech();
                }else if(data.firstUnboughtCost(1) < 0) {
                        UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "You have bought all the Miners");
                }else{
                        _gold = _gold - data.buy(1);
                }
        }else if (keyPress.equals("2")) {
                if(data.firstUnboughtCost(2) > _gold) {
                        UserInterface.noGold(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)));
                        tapMech();
                }else if(data.firstUnboughtCost(2) < 0) {
                        UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "You have bought all the Engineers");
                }else{
                        _gold = _gold - data.buy(2);
                }
        }else if (keyPress.equals("3")) {
                if(data.firstUnboughtCost(3) > _gold) {
                        UserInterface.noGold(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)));
                        tapMech();
                }else if(data.firstUnboughtCost(3) < 0) {
                        UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "You have bought all the Gamblers");
                }else{
                        _gold = _gold - data.buy(3);
                }
        }else if (keyPress.equals("4")) {
                if ( Powerups.isActive("D") ) {
                        UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "Your selected Powerup is still active!");
                        tapMech();
                }else{
                        if ( Powerups.isCoolingDown("D") ) {
                                UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "Your selected Powerup is on cooldown!");
                                tapMech();
                        }else{
                                if ( 400 > _gold) { //if not enough gold
                                        UserInterface.noGold(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)));
                                        tapMech();
                                }else{
                                        Powerups.activateDynamite();
                                        _gold -= 400;
                                        UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "Powerup activated!");
                                        tapMech();
                                }
                        }
                }
        }else if (keyPress.equals("5")) { //power surge
                if ( Powerups.isActive("Pow") ) {
                        UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "Your selected Powerup is still active!");
                        tapMech();
                } else{
                        if ( Powerups.isCoolingDown("Pow") ) {
                                UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "Your selected Powerup is on cooldown!");
                                tapMech();
                        }else{
                                if ( 400 > _gold) { //if not enough gold
                                        UserInterface.noGold(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)));
                                        tapMech();
                                }else{
                                        Powerups.activatePower();
                                        _gold -= 400;
                                        UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "Powerup activated!");
                                        tapMech();
                                }
                        }
                }
        }else if (keyPress.equals("6")) { //Extra Chips
                if ( Powerups.isActive("EC") ) {
                        UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "Your selected Powerup is still active!");
                        tapMech();
                }else{
                        if ( Powerups.isCoolingDown("EC") ) {
                                UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "Your selected Powerup is on cooldown!");
                                tapMech();
                        }else{
                                if ( 400 > _gold) { //if not enough gold
                                        UserInterface.noGold(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)));
                                        tapMech();
                                }else{
                                        Powerups.activateExtra();
                                        _gold -= 400;
                                        UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "Powerup activated!");
                                        tapMech();
                                }
                        }
                }
        }else if (keyPress.equals("7")) {
                if ( Powerups.isActive("QAF") ) {
                        UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "Your selected Powerup is still active!");
                        tapMech();
                }else{
                        if ( Powerups.isCoolingDown("QAF") ) {
                                UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "Your selected Powerup is on cooldown!");
                                tapMech();
                        }else{
                                if ( 2500 > _gold) { //if not enough gold
                                        UserInterface.noGold(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)));
                                        tapMech();
                                }else{
                                        Powerups.activateQAF();
                                        _gold -= 2500;
                                        UserInterface.storeUIMsg(DataStorage.strCreate(1, data.firstUnbought(1)), DataStorage.strCreate(2, data.firstUnbought(2)), DataStorage.strCreate(3, data.firstUnbought(3)), "Powerup activated!");
                                        tapMech();
                                }
                        }
                }
        }
// call another function if need to upgrade
        else if (keyPress.equals("8")) {
                System.out.println( UserInterface.improveUIM(data.minerList()) );
                improveMech();
        }
        _additiveGoldPKP = 1;
        _additiveGoldPS = 0;
        _luck = 0.0005;

}

public static void improveMech() {
        keyPress = Keyboard.readString();
        //for gamblers
        if ( keyPress.equals("G") || keyPress.equals("g") ) {
                System.out.println( UserInterface.improveUIG(data.gamblerList()) );
        }
        //for miners
        else if ( keyPress.equals("M") || keyPress.equals("m") ) {
                System.out.println( UserInterface.improveUIM(data.minerList()) );
        }
        //for engineers
        else if ( keyPress.equals("E") || keyPress.equals("e") ) {
                System.out.println( UserInterface.improveUIE(data.engineerList()) );
        }
        // return to main screen
        else if ( keyPress.equals("R") || keyPress.equals("r") ) {
                gameScreen = "main";
                tapMech();
        }
        else if ( keyPress.equals("0") ) {

        }
        else if ( keyPress.equals("1") ) {

        }
        else if ( keyPress.equals("2") ) {

        }
        else if ( keyPress.equals("3") ) {

        }
        else if ( keyPress.equals("4")) {

        }
        else if ( keyPress.equals("5")) {

        }
        else if ( keyPress.equals("6")) {

        }
        else if ( keyPress.equals("7")) {

        }
        else if ( keyPress.equals("8")) {

        }
        else if ( keyPress.equals("9")) {

        }
        else{
                improveMech(); //idiot-proof the method
        }

}     //end improveMech
}
