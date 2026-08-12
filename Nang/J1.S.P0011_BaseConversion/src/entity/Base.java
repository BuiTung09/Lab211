/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author thuha
 */
 
public enum Base {
    DEC(10), HEX(16), BIN(2);
    private int base;
   
    private Base(int base) {
        this.base = base;
    }
    
    public static Base getBase(int type){
        switch (type) {
            case 10:
                return DEC;
            case 16:
                return HEX;
            case 2:
                return BIN;
            default:
                throw new AssertionError();
        }
    }
    
    public int getValue(){
        return base;
    }
    
}
