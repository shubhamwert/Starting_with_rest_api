from app import app
from flask import render_template, flash, redirect,url_for,request,jsonify
from flask_cors import CORS, cross_origin
import pandas as pd
import pickle

CORS(app)
@app.route('/api',methods=['GET','POST'])
def index():
    payload=request.json["data"]
    print(payload)
    values = [float(i) for i in payload.split(',')]
    headers = ['times_pregnant', 'glucose', 'blood_pressure', 'skin_fold_thick', 'serum_insuling', 'mass_index', 'diabetes_pedigree', 'age']
    
    input_variables = pd.DataFrame([values],
                                columns=headers, 
                                dtype=float,
                                index=['input'])

    with open(f'final_prediction.pickle', 'rb') as f:
        model = pickle.load(f)
    prediction_proba = model.predict_proba(input_variables)
    prediction = (prediction_proba[0])[1]
    
    ret = '{"prediction":' + str(float(prediction)) + '}'
    print(ret)
    return 100*ret

