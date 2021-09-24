package me.appz4.beacon.model.api.request.beacon;

import me.appz4.beacon.model.api.ApiRequestWithToken;
import me.appz4.beacon.model.exception.ValidationException;
import me.appz4.beacon.model.model.Position;
import me.appz4.beacon.model.validator.IRequestValidator;
import me.appz4.beacon.model.validator.ValidatorUtils;

public class GetNearBeaconsRequest extends ApiRequestWithToken implements IRequestValidator {
    private Position center;
    private Position northEast;
    private Position southWest;

    public Position getCenter() {
        return this.center;
    }

    public void setCenter(Position center) {
        this.center = center;
    }

    public Position getNorthEast() {
        return this.northEast;
    }

    public void setNorthEast(Position northEast) {
        this.northEast = northEast;
    }

    public Position getSouthWest() {
        return this.southWest;
    }

    public void setSouthWest(Position southWest) {
        this.southWest = southWest;
    }

    public String toString() {
        return "GetNearBeaconsRequest [center=" + this.center + ", northEast=" + this.northEast + ", southWest=" + this.southWest + "]";
    }

    public boolean onValidate() throws ValidationException {
        ValidatorUtils.isNull(this.center, "center");
        ValidatorUtils.isNull(this.southWest, "southWest");
        ValidatorUtils.isNull(this.northEast, "northEast");
        return true;
    }
}