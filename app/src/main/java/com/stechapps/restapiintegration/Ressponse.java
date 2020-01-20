package com.stechapps.restapiintegration;

import com.google.gson.annotations.SerializedName;

public class Ressponse {
    @SerializedName("predict")
    private float predict;

    public float getPredict() {
        return predict;
    }

    public void setPredict(float predict) {
        this.predict = predict;
    }
}
