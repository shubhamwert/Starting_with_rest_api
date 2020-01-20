import pandas as pd
from sklearn.linear_model import LogisticRegression
import numpy as np
import matplotlib.pyplot as plt
import pickle
if __name__ == "__main__":
    headers = ['times_pregnant', 'glucose', 'blood_pressure', 'skin_fold_thick', 'serum_insuling', 'mass_index', 'diabetes_pedigree', 'age','result']
    sample_data=pd.read_csv("sample_data.csv",names=headers)
    sample_data.dropna()
    x=sample_data.loc[:,headers[0]:headers[-2]]
    y=sample_data[headers[-1]]
    print(x[headers[1]])
    #basic analysis
    model=LogisticRegression(max_iter=1000)
    model.fit(x,y)
    p=model.predict(x)
    score=sum(p-y)

    # model.to_csv("trainedModel.csv")
    
    print(type(model)) 
    pickle.dump(model,open('final_prediction.pickle','wb'))
    


