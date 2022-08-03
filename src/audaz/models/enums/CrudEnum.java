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
public enum CrudEnum {
    ERROR(-1),
    EXIT(0),
    CREATE(1),
    UPDATE(2),
    DELETE(3),
    LIST(4);
    
    
    private final int value;
    CrudEnum(int value){
        this.value = value;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public static CrudEnum setValue(int value) {
        switch(value){
            case 0: return CrudEnum.EXIT;
            case 1: return CrudEnum.CREATE;
            case 2: return CrudEnum.UPDATE;
            case 3: return CrudEnum.DELETE;
            case 4: return CrudEnum.LIST;
            default: return CrudEnum.ERROR;
        }
    }
}
