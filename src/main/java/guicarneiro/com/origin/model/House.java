package guicarneiro.com.origin.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class House {

    @NotNull
    private final OwnershipStatus ownershipStatus;

    public House(@JsonProperty("ownership_status") OwnershipStatus ownershipStatus) {
        this.ownershipStatus = ownershipStatus;
    }

    public OwnershipStatus getOwnershipStatus() {
        return ownershipStatus;
    }
}
