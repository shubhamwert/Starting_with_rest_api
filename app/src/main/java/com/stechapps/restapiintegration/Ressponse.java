package com.stechapps.restapiintegration;

import com.google.gson.annotations.SerializedName;

public class Ressponse {
    @SerializedName("prediction")
    private float predict=9;

    public float getPredict() {
        return predict;
    }

    public void setPredict(float predict) {
        this.predict = predict;
    }
}
