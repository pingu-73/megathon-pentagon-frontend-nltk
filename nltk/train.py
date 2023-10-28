import pandas as pd
import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
from nltk.classify import NaiveBayesClassifier
from nltk.classify.util import apply_features
#from sklearn.model_selection import train_test_split

import pickle
import csv


# Load your CSV data
data = pd.read_csv('essays.csv', encoding='latin-1', sep=',')

nltk.download('stopwords')
nltk.download('punkt')


# Define a function for text preprocessing
def preprocess_text(text):
    # Tokenize the text
    words = word_tokenize(text)
    # Remove stopwords and punctuation
    words = [word.lower() for word in words if word.isalnum() and word.lower() not in stopwords.words('english')]
    return words

# Preprocess the 'TEXT' column and convert 'yes' and 'no' to binary labels
data['TEXT'] = data['TEXT'].apply(preprocess_text)
data['cEXT'] = (data['cEXT'] == 'y').astype(int)
data['cNEU'] = (data['cNEU'] == 'y').astype(int)
data['cAGR'] = (data['cAGR'] == 'y').astype(int)
data['cCON'] = (data['cCON'] == 'y').astype(int)
data['cOPN'] = (data['cOPN'] == 'y').astype(int)

#train_data, test_data = train_test_split(data, test_size=0.2, random_state=42)

# Define a feature extraction function
def extract_features(text):
    return {word: True for word in text}

# Create a feature set
train_features = [(extract_features(text), (attrs[0], attrs[1], attrs[2], attrs[3], attrs[4])) for (text, attrs) in zip(data['TEXT'], data[['cEXT', 'cNEU', 'cAGR', 'cCON', 'cOPN']].values)]

# Train the classifier
classifier = NaiveBayesClassifier.train(train_features)

data['cEXT'] = data['cEXT'].astype(str)
data['cNEU'] = data['cNEU'].astype(str)
data['cAGR'] = data['cAGR'].astype(str)
data['cCON'] = data['cCON'].astype(str)
data['cOPN'] = data['cOPN'].astype(str)


# put it in pickle 

with open('classifier.pkl', 'wb') as f:
    pickle.dump(classifier, f)
