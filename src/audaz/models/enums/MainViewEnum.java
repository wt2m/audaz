/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audaz.models.enums;

/**
 *
 * @author migue
 */
public enum MainViewEnum {
    ERROR(-1),
    EXIT(0),
    FARE(1),
    OPERATOR(2);
    
    
    private final int value;
    MainViewEnum(int value){
        this.value = value;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public static MainViewEnum setValue(int value) {
        switch(value){
            case 0: return MainViewEnum.EXIT;
            case 1: return MainViewEnum.FARE;
            case 2: return MainViewEnum.OPERATOR;
            default: return MainViewEnum.ERROR;
        }
    }
}
