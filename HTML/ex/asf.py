import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.metrics import roc_auc_socore
from sklearn.model_selection import GridSearchCV
from xgboost import XGBClassfier

xfb = XGBClassfier(n_jobs=-1,random_state=20)
grid = GridSearchCV(xgb, param_grid={'n_estimator':[400],'max_depth':[2],'learning_rate':[0.01]},n_jobs=-1,cv=3)

grid.fit(x,y)
best_grid = grid.best_estimator_
