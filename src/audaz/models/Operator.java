package audaz.models;

import java.util.List;
import java.util.UUID;

public class Operator extends BaseModel{
    private UUID id;
    private String Code;
    private List<Fare> Fares;

    

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public List<Fare> getFares() {
        return Fares;
    }

    public void setFares(List<Fare> Fares) {
        this.Fares = Fares;
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Operator{" + "id=" + id + ", Code=" + Code + ", Fares=" + Fares + '}';
    }
}
