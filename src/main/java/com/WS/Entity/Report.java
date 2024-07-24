package com.WS.Entity;

import java.io.Serializable;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
public class Report {
    @Id
    Serializable group;
    Double sum;
    Long count;
    // No-argument constructor
    public Report() {
    }

    
    public Report(Serializable group, Double sum, Long count) {
		super();
		this.group = group;
		this.sum = sum;
		this.count = count;
	}


	// Getters and setters
    public Serializable getGroup() {
        return group;
    }

    public void setGroup(Serializable group) {
        this.group = group;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
