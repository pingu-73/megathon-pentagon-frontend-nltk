from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
import pickle

# Define a function for text preprocessing
def preprocess_text(text):
    # Tokenize the text
    words = word_tokenize(text)
    # Remove stopwords and punctuation
    words = [word.lower() for word in words if word.isalnum() and word.lower() not in stopwords.words('english')]
    return words

# Define a feature extraction function
def extract_features(text):
    return {word: True for word in text}

# Load the trained classifier
with open('classifier.pkl', 'rb') as f:
    classifier = pickle.load(f)

# Define a function for text classification
def classify_text(text):
    features = extract_features(preprocess_text(text))
    return classifier.classify(features)

# Example usage
text_to_classify = input()
result = classify_text(text_to_classify)
m = {0: "extraversion", 1: "neuroticism", 2:"agreeableness", 3:"conscientiousness", 4:"openness"}
for i, x in enumerate(result):
    print(f"{m[i]}: {x}")
