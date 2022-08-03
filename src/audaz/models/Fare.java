package audaz.models;

import java.time.LocalDateTime;
import java.util.UUID;


public class Fare extends BaseModel{
    private UUID id;
    private float value;
    private int Status;
    private LocalDateTime updatedAt;
    private Operator operator;

    public int getStatus() {
        return Status;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Fare{" + "value=" + value + ", Status=" + Status + ", updatedAt=" + updatedAt + ", operator=" + operator.getCode() + '}';
    }

    
    
}
